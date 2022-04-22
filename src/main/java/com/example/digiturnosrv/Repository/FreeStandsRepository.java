package com.example.digiturnosrv.Repository;

import com.example.digiturnosrv.Model.FreeStands;
import com.example.digiturnosrv.Model.FreeStandsCopy;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreeStandsRepository extends CrudRepository<FreeStands, Integer> {
    @Modifying
    @Query(
            value = "truncate table free-stands",
            nativeQuery = true
    )
    void truncateFreeStands();

    void deleteByStandNumber(Integer standNumber);
}
