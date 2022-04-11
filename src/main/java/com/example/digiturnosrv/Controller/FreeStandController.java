package com.example.digiturnosrv.Controller;

import com.example.digiturnosrv.Model.FreeStands;
import com.example.digiturnosrv.Service.FreeStandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FreeStandController {

    @Autowired
    private FreeStandService freeStandService;


    @PostMapping("api/v1/stand/{standNumber}")
    @CrossOrigin(origins = "*")
    public FreeStands EnqueueStand(@PathVariable Integer standNumber){
        return freeStandService.enqueStand(standNumber);
    }


}
