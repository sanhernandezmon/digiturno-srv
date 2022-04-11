package com.example.digiturnosrv.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;
import com.example.digiturnosrv.Model.*;
import com.example.digiturnosrv.Repository.TurnCopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnCopyServiceImpl implements TurnCopyService{

    @Autowired
    private TurnCopyRepository repository;

    @Autowired
    private FreeStandService standsService;


    @Autowired
    private LastTurnAttendedCopyService lastTurnAttendedService;

    @Override
    public List<TurnCopy> findTurns() {
        List<TurnCopy> allTurns = repository.findByOrderByCreationDateDesc();
        return allTurns;
    }

    @Override
    public TurnCopy createTurn() {
        //Obtener el primer stand en fila
        FreeStands free = standsService.firstStand();

        //Obtener el ultimo turno atendido
        LastTurnAttendedCopy lastTurnAttendedCopy = lastTurnAttendedService.findLast();
        System.out.println("last attended " + lastTurnAttendedCopy);

        if (free != null) {
            TurnCopy turn = new TurnCopy( UUID.randomUUID(), free.getStandNumber(), (lastTurnAttendedCopy.getLastTurnAttended()%99)+1,  Date.from(
                    Instant.now()));
            repository.save(turn);
            //standsService.deleteByStandNumber(free.getStandNumber());
            lastTurnAttendedService.update();
            return turn;
        }
        return null;
    }


    @Transactional
    public void restartData(){
        standsService.deleteAll();
        repository.truncateTurn();
    }
}
