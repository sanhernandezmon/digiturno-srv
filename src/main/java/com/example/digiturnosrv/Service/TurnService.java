package com.example.digiturnosrv.Service;

import java.util.List;

import com.example.digiturnosrv.Model.Turn;

public interface TurnService {
    List<Turn> findTurns();

    Turn createTurn();

    void restartData();
}
