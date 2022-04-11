package com.example.digiturnosrv.Controller;

import com.example.digiturnosrv.Model.LastTurnGiven;
import com.example.digiturnosrv.Service.LastTurnGivenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LastTurnGivenController {
    @Autowired
    private LastTurnGivenService lastTurnGivenService;

    @PostMapping("api/v1/turn/ask")
    @CrossOrigin(origins = "*")
    public LastTurnGiven RequestTurn(){
        return lastTurnGivenService.IncrementTurn();
    }
}
