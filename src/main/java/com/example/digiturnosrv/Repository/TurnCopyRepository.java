package com.example.digiturnosrv.Repository;

import java.util.List;
import java.util.UUID;

import com.example.digiturnosrv.Model.Turn;
import com.example.digiturnosrv.Model.TurnCopy;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnCopyRepository extends CrudRepository<TurnCopy, UUID> {
    List<TurnCopy> findByOrderByCreationDateDesc();

    @Modifying
    @Query(
            value = "truncate table TurnCopy",
            nativeQuery = true
    )
    void truncateTurn();
}
