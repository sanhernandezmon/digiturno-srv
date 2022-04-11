package com.example.digiturnosrv.Controller;

import java.util.List;

import com.example.digiturnosrv.Model.Turn;
import com.example.digiturnosrv.Service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class TurnController {
    @Autowired
    private TurnService turnService;

    @GetMapping("/api/v1/turns")
    public List<Turn> getTurns() {
        List<Turn> turns = turnService.findTurns();
        return turns;
    }

    @DeleteMapping("api/v1/restart")
    @CrossOrigin(origins = "*")
    public void restartData(){
        turnService.restartData();
    }

}
