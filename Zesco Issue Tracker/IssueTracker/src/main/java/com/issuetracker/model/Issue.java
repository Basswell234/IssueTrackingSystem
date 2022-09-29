package com.issuetracker.model;

import javax.persistence.*;

@Entity
@Table(name = "issues")
public class Issue {
    @Id
    @GeneratedValue
    private long id;

    private String equipment;
    private String description;
    private String location;
    private String status;
    private String dateofinspection;
    private String nameofinspector;
    private String comment;
    
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    //getter and setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public String getDateofinspection() {
        return dateofinspection;
    }

    public void setDateofinspection(String dateofinspection) {
        this.dateofinspection = dateofinspection;
    }

    public String getNameofinspector() {
        return nameofinspector;
    }
    public void setNameofinspector(String nameofinspector) {
        this.nameofinspector = nameofinspector;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    } 
}