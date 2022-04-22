package com.example.digiturnosrv.Service;

import java.util.List;

import com.example.digiturnosrv.Model.Turn;
import com.example.digiturnosrv.Model.TurnCopy;

public interface TurnService {
    List<Turn> findTurns();

    Turn createTurn();


    void restartData();
}
