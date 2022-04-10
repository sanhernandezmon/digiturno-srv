package com.example.digiturnosrv.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class FreeStands {
    @Id
    private Integer standNumber;
    @Column
    private Date creationDate;

    public FreeStands() {

    }

    public Integer getStandNumber() {
        return standNumber;
    }

    public void setStandNumber(Integer standNumber) {
        this.standNumber = standNumber;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override public String toString() {
        return "FreeStands{" +
                "standNumber=" + standNumber +
                ", creationDate=" + creationDate +
                '}';
    }
}
