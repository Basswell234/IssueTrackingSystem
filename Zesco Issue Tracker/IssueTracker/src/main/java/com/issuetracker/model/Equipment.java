package com.issuetracker.model;

import javax.persistence.*;

@Entity
@Table(name = "equipment")
public class Equipment {
    
    @Id
    @GeneratedValue
    private long id;

    
    private String equipmentname;

    
    private String equipmentdescription;

    
    private String location;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEquipmentname() {
        return equipmentname;
    }

    public void setEquipmentname(String equipmentname) {
        this.equipmentname = equipmentname;
    }

    public String getEquipmentdescription() {
        return equipmentdescription;
    }

    public void setEquipmentdescription(String equipmentdescription) {
        this.equipmentdescription = equipmentdescription;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    

}
