package com.example.digiturnosrv.Service;

import java.util.List;

import javax.transaction.Transactional;
import com.example.digiturnosrv.Model.LastTurnAttendedCopy;
import com.example.digiturnosrv.Repository.LastTurnAttendedRepositoryCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LastTurnAttendedCopyServiceImpl implements LastTurnAttendedCopyService{

    @Autowired LastTurnAttendedRepositoryCopy repository;

    @Override
    @Transactional
    public LastTurnAttendedCopy update() {
        LastTurnAttendedCopy last = findLast();
        LastTurnAttendedCopy next = new LastTurnAttendedCopy(last.getLastTurnAttended()+1);
        repository.save(next);
        repository.deleteById(last.getLastTurnAttended());
        return next;
    }

    @Override
    public LastTurnAttendedCopy findLast() {
        List<LastTurnAttendedCopy> lastTurnAttendedList = (List<LastTurnAttendedCopy>)repository.findAll();
        if (lastTurnAttendedList.isEmpty()){
            repository.save(new LastTurnAttendedCopy(0));
            return new LastTurnAttendedCopy(0);
        }else{
            LastTurnAttendedCopy lastTurnAttended = lastTurnAttendedList.get(0);
            return lastTurnAttended;
        }
    }

    @Override
    @Transactional
    public void deleteAll() {
        repository.deleteById(findLast().getLastTurnAttended());
    }
}
