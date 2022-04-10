package com.example.digiturnosrv.Repository;

import java.util.List;

import com.example.digiturnosrv.Model.FreeStands;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreeStandsRepository extends CrudRepository<FreeStands, Integer> {

    void deleteByStandNumber(Integer standNumber);
}
