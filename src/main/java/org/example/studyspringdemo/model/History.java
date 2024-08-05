package org.example.studyspringdemo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "history")
@Data
public class History {

    private String  id;
    private String  name;
    @Id
    private String  day;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
