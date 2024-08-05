package org.example.studyspringdemo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "enterdata")
@Data
public class EnterData {

    @Id
    private String  id;
    private String  textarea;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTextarea() {
        return textarea;
    }

    public void setTextarea(String textarea) {
        this.textarea = textarea;
    }
}

