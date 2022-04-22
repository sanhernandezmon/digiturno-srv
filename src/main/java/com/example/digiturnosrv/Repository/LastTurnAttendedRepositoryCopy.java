package com.example.digiturnosrv.Repository;

import com.example.digiturnosrv.Model.LastTurnAttendedCopy;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LastTurnAttendedRepositoryCopy extends CrudRepository<LastTurnAttendedCopy, Integer> {
    @Modifying
    @Query(
            value = "truncate table last_turn_attended_copy",
            nativeQuery = true
    )
    void truncateLastTurnAttended();
}
