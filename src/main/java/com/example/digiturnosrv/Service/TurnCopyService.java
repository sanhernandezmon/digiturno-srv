package com.example.digiturnosrv.Service;

import java.util.List;

import com.example.digiturnosrv.Model.Turn;
import com.example.digiturnosrv.Model.TurnCopy;

public interface TurnCopyService {
    List<TurnCopy> findTurns();

    TurnCopy createTurn();

    void restartData();
}
