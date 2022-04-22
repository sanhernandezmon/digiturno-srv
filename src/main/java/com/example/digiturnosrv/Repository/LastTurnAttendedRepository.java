package com.example.digiturnosrv.Repository;

import com.example.digiturnosrv.Model.LastTurnAttended;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LastTurnAttendedRepository extends CrudRepository<LastTurnAttended, Integer> {
    @Modifying
    @Query(
            value = "truncate table last_turn-attended",
            nativeQuery = true
    )
    void truncateLastTurnAttended();
}
