package org.example.studyspringdemo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "history")
@Data
public class History {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer  index;
    private String  id;
    private String  name;
    private String  day;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

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
