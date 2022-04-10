package com.example.digiturnosrv.Service;

import com.example.digiturnosrv.Model.LastTurnGiven;

public interface LastTurnGivenService {

    LastTurnGiven IncrementTurn();

    LastTurnGiven findLast();

    void deleteAll();
}
