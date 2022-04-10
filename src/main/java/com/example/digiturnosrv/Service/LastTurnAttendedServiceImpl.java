package com.example.digiturnosrv.Service;

import java.util.List;

import javax.transaction.Transactional;
import com.example.digiturnosrv.Model.LastTurnAttended;
import com.example.digiturnosrv.Repository.LastTurnAttendedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LastTurnAttendedServiceImpl implements LastTurnAttendedService{

    @Autowired LastTurnAttendedRepository repository;

    @Override
    @Transactional
    public LastTurnAttended update() {
        LastTurnAttended last = findLast();
        LastTurnAttended next = new LastTurnAttended(last.getLastTurnAttended()+1);
        repository.save(next);
        repository.deleteById(last.getLastTurnAttended());
        return next;
    }

    @Override
    public LastTurnAttended findLast() {
        List<LastTurnAttended> lastTurnAttendedList = (List<LastTurnAttended>)repository.findAll();
        if (lastTurnAttendedList.isEmpty()){
            repository.save(new LastTurnAttended(0));
            return new LastTurnAttended(0);
        }else{
            LastTurnAttended lastTurnAttended = lastTurnAttendedList.get(0);
            return lastTurnAttended;
        }
    }

    @Override
    @Transactional
    public void deleteAll() {
        repository.deleteById(findLast().getLastTurnAttended());
    }
}
