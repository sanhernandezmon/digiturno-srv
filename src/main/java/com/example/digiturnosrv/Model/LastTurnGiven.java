package com.example.digiturnosrv.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
@Table(name = "LastTurnGiven")
public class LastTurnGiven {

    @Id
    private Integer turnId;

    public LastTurnGiven() {

    }

    public Integer getTurnId() {
        return turnId;
    }

    public void setTurnId(Integer turnId) {
        this.turnId = turnId;
    }

    @Override public String toString() {
        return "LastTurnGiven{" +
                "turnId=" + turnId +
                '}';
    }
}
