package com.example.digiturnosrv.Service;

import java.util.List;

import javax.transaction.Transactional;
import com.example.digiturnosrv.Model.LastTurnAttended;
import com.example.digiturnosrv.Model.LastTurnGiven;
import com.example.digiturnosrv.Repository.LastTurnGivenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LastTurnGivenServiceImpl implements LastTurnGivenService {

    @Autowired
    private LastTurnGivenRepository repository;

    @Autowired
    private TurnService turnService;
    @Override
    public LastTurnGiven IncrementTurn() {
        LastTurnGiven last = findLast();
        LastTurnGiven next = new LastTurnGiven(last.getTurnId()+1);
        LastTurnGiven ret = new LastTurnGiven((last.getTurnId()%99)+1);
        repository.save(next);
        repository.deleteById(last.getTurnId());
        turnService.createTurn();
        return ret;
    }

    @Override
    public LastTurnGiven findLast() {
        List<LastTurnGiven> lista = (List<LastTurnGiven>) repository.findAll();
        if (lista.isEmpty()){
            repository.save(new LastTurnGiven(0));
            return new LastTurnGiven(0);
        }else{
            LastTurnGiven currentTurn = lista.get(0);
            return currentTurn;
        }
    }

    @Override
    @Transactional
    public void deleteAll() {
        repository.deleteByTurnId(findLast().getTurnId());
    }
}
