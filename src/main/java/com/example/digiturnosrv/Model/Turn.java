package com.example.digiturnosrv.Model;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Turn")
public class Turn {

    @Id
    private UUID id;

    @Column
    private Integer assignedStand;
    @Column
    private Integer assignedNumber;
    @Column
    private Date creationDate;

    @Override public String toString() {
        return "Turn{" +
                "id=" + id +
                ", assignedStand=" + assignedStand +
                ", assignedNumber=" + assignedNumber +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getAssignedStand() {
        return assignedStand;
    }

    public void setAssignedStand(Integer assignedStand) {
        this.assignedStand = assignedStand;
    }

    public Integer getAssignedNumber() {
        return assignedNumber;
    }

    public void setAssignedNumber(Integer assignedNumber) {
        this.assignedNumber = assignedNumber;
    }
}
