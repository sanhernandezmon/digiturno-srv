package com.example.digiturnosrv.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LastTurnAttendedCopy")
public class LastTurnAttendedCopy {
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
