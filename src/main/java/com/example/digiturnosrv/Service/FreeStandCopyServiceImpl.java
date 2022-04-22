package com.example.digiturnosrv.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import com.example.digiturnosrv.Model.FreeStands;
import com.example.digiturnosrv.Model.FreeStandsCopy;
import com.example.digiturnosrv.Repository.FreeStandsCopyRepository;
import com.example.digiturnosrv.Repository.FreeStandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreeStandCopyServiceImpl implements FreeStandCopyService{

    @Autowired
    private FreeStandsCopyRepository repository;

    @Autowired
    private TurnCopyService turnCopyService;

    @Override
    public FreeStandsCopy enqueStand(Integer standNumber) {
        FreeStandsCopy freeStand = new FreeStandsCopy(standNumber, Date.from(Instant.now()));
        repository.save(freeStand);
        turnCopyService.createTurn();
        return freeStand;
    }

    @Override
    public FreeStandsCopy firstStand() {
        List<FreeStandsCopy> freeStands = (List<FreeStandsCopy>) repository.findAll();
        if (freeStands.isEmpty()){
            return null;
        }else{
            FreeStandsCopy free = freeStands.get(freeStands.size()-1);
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
        repository.truncateFreeStandsCopy();
    }
}
