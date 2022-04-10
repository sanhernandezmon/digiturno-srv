package com.example.digiturnosrv.Repository;

import java.util.List;

import com.example.digiturnosrv.Model.LastTurnGiven;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LastTurnGivenRepository extends CrudRepository<LastTurnGiven, Integer> {

    void deleteByTurnId(Integer turnId);
}
