package com.example.digiturnosrv.Repository;

import com.example.digiturnosrv.Model.LastTurnAttendedCopy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LastTurnAttendedRepositoryCopy extends CrudRepository<LastTurnAttendedCopy, Integer> {

}
