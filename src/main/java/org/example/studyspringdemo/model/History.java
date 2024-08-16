/**
 * 实体类，历史内容模型
 */

package org.example.studyspringdemo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "history")
@Data
public class History {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer  index;
    private String  id;
    private String  name;
    private String  day;

}
