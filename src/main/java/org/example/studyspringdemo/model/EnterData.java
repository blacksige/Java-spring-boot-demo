/**
 * 实体类，录入内容模型
 */

package org.example.studyspringdemo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "enterdata")
@Data
public class EnterData {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer  index;
    private String  id;
    private String  textarea;

}

