package com.example.digiturnosrv.Service;

import com.example.digiturnosrv.Model.FreeStands;
import com.example.digiturnosrv.Model.FreeStandsCopy;

public interface FreeStandCopyService {

    FreeStandsCopy enqueStand(Integer standNumber);

    FreeStandsCopy firstStand();

    void deleteByStandNumber(Integer standNumber);

    void deleteAll();
}
