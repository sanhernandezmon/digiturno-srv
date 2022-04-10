package com.example.digiturnosrv.Service;

import com.example.digiturnosrv.Model.FreeStands;

public interface FreeStandService {

    FreeStands enqueStand(Integer standNumber);

    FreeStands firstStand();

    void deleteByStandNumber(Integer standNumber);

    void deleteAll();
}
