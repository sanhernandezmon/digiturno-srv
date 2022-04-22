package com.example.digiturnosrv.Controller;

import java.util.List;


import com.example.digiturnosrv.Model.TurnCopy;
import com.example.digiturnosrv.Service.TurnCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TurnAuxController {

    @Autowired
    private TurnCopyService turnService;

    @GetMapping("/api/v1/turns2")
    public List<TurnCopy> getTurns() {
        List<TurnCopy> turns = turnService.findTurns();
        return turns;
    }

    @DeleteMapping("api/v1/restart2")
    @CrossOrigin(origins = "*")
    public void restartData(){
        turnService.restartData();
    }
}
