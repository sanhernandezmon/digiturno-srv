package com.example.digiturnosrv.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.UUID;

import javax.transaction.Transactional;
import com.example.digiturnosrv.Model.FreeStands;
import com.example.digiturnosrv.Model.LastTurnAttended;
import com.example.digiturnosrv.Model.LastTurnGiven;
import com.example.digiturnosrv.Model.Turn;
import com.example.digiturnosrv.Repository.TurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnServiceImpl implements TurnService {

    @Autowired
    private TurnRepository repository;

    @Autowired
    private FreeStandService standsService;

    @Autowired
    private LastTurnGivenService lastTurnGivenService;

    @Autowired
    private LastTurnAttendedService lastTurnAttendedService;

    @Autowired
    private RabbitMQSender rabbitMQSender;
    @Override
    public List<Turn> findTurns() {
        List<Turn> allTurns = repository.findByOrderByCreationDateDesc();
        return allTurns;
    }

    @Override
    public Turn createTurn() {
        //Obtener el primer stand en fila
        FreeStands free = standsService.firstStand();

        //Obtener el ultimo turno atendido
        LastTurnAttended lastTurnAttended = lastTurnAttendedService.findLast();
        System.out.println("last attended " + lastTurnAttended);

        //Obtener el ultimo turno a atender
        LastTurnGiven lastTurnGiven = lastTurnGivenService.findLast();
        System.out.println("last given " + lastTurnGiven);

        if (free != null && (lastTurnAttended.getLastTurnAttended()<lastTurnGiven.getTurnId())) {
            Turn turn = new Turn( UUID.randomUUID(), free.getStandNumber(), (lastTurnAttended.getLastTurnAttended()%99)+1,  Date.from(Instant.now()));
            repository.save(turn);
            standsService.deleteByStandNumber(free.getStandNumber());
            lastTurnAttendedService.update();
            rabbitMQSender.send(turn);
            return turn;
        }
        return null;
    }


    @Transactional
    public void restartData(){
        standsService.deleteAll();
        lastTurnAttendedService.deleteAll();
        lastTurnGivenService.deleteAll();
    }

}
