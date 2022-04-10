package com.example.digiturnosrv.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LastTurnAttended {
    @Id
    private Integer lastTurnAttended;

    public Integer getLastTurnAttended() {
        return lastTurnAttended;
    }

    public void setLastTurnAttended(Integer lastTurnAttended) {
        this.lastTurnAttended = lastTurnAttended;
    }

    @Override public String toString() {
        return "LastTurnAttended{" +
                "lastTurnAttended=" + lastTurnAttended +
                '}';
    }
}
