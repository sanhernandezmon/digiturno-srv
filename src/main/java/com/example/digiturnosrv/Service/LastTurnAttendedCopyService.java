package com.example.digiturnosrv.Service;

import com.example.digiturnosrv.Model.LastTurnAttendedCopy;

public interface LastTurnAttendedCopyService {
    LastTurnAttendedCopy update();

    LastTurnAttendedCopy findLast();

    void deleteAll();
}
