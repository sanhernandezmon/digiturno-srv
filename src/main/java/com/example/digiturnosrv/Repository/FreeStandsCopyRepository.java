package com.example.digiturnosrv.Repository;

import com.example.digiturnosrv.Model.FreeStands;
import com.example.digiturnosrv.Model.FreeStandsCopy;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreeStandsCopyRepository extends CrudRepository<FreeStandsCopy, Integer> {
    @Modifying
    @Query(
            value = "truncate table free_stands_copy",
            nativeQuery = true
    )
    void truncateFreeStandsCopy();

    void deleteByStandNumber(Integer standNumber);
}
