package com.example.digiturnosrv.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import com.example.digiturnosrv.Model.FreeStands;
import com.example.digiturnosrv.Repository.FreeStandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreeStandServiceImpl implements FreeStandService{

    @Autowired
    private FreeStandsRepository repository;

    @Autowired
    private TurnService turnService;

    @Autowired TurnCopyService turnCopyService;

    @Override
    public FreeStands enqueStand(Integer standNumber) {
        List<FreeStands> freeStands = (List<FreeStands>) repository.findAll();

        if (!VerifyStandInList(standNumber, freeStands)){
            FreeStands freeStand = new FreeStands(standNumber, Date.from(Instant.now()));
            repository.save(freeStand);
            turnService.createTurn();
            turnCopyService.createTurn();
            return freeStand;
        }
        return null;
    }

    private boolean VerifyStandInList(Integer standNumber, List<FreeStands> freeStands){
        boolean alreadyInQueue = false;
        for (FreeStands freeStand : freeStands) {
            alreadyInQueue = alreadyInQueue || (freeStand.getStandNumber() == standNumber);
        }
        return alreadyInQueue;
    }

    @Override
    public FreeStands firstStand() {

        List<FreeStands> freeStands = (List<FreeStands>) repository.findAll();
        if (freeStands.isEmpty()){
            return null;
        }else{
            FreeStands free = freeStands.get(freeStands.size()-1);
            return free;
        }
    }

    @Transactional
    @Override
    public void deleteByStandNumber(Integer standNumber) {
        repository.deleteByStandNumber(standNumber);
    }

    @Override
    @Transactional
    public void deleteAll() {
        List<FreeStands> freeStandsList = (List<FreeStands>) repository.findAll();
        for (FreeStands freeStands : freeStandsList) {
            Integer standNumber = freeStands.getStandNumber();
            repository.deleteByStandNumber(standNumber);
        }
    }
}
