package com.example.digiturnosrv.Service;

import com.example.digiturnosrv.Model.LastTurnAttended;

public interface LastTurnAttendedService {
    LastTurnAttended update();

    LastTurnAttended findLast();

    void deleteAll();
}
