package com.example.assignment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.util.Calendar;



@MappedSuperclass
public class BaseEntity{

    @Column(name = "created_on", nullable = false)
    private Long createdOn = Calendar.getInstance().getTimeInMillis();

    @Column(name = "modified_on")
    private Long modifiedOn;


    // Getters And Setters
    public Long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public Long getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Long modifiedOn) {
        this.modifiedOn = modifiedOn;
    }


    //    toString
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseEntity{");
        sb.append("createdOn=").append(createdOn);
        sb.append(", modifiedOn=").append(modifiedOn);
        sb.append('}');
        return sb.toString();
    }

}
