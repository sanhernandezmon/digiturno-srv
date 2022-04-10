package com.example.digiturnosrv.Repository;

import com.example.digiturnosrv.Model.LastTurnAttended;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LastTurnAttendedRepository extends CrudRepository<LastTurnAttended, Integer> {

}
