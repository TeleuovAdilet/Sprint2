package kz.bitlab.JavaSpring.Sprint2.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Sprint2")
@Data
@Getter
@Setter
public class ApplicationModel {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    @Column(name = "ID") // column name
    private long ID;

    @Column(name = "userName") // column name
    private String name;

    @Column(name = "courseName") // column name
    private String courseName;

    @Column(name ="commentary")
    private String commentary;

    @Column(name = "phone")
    private String phone;

    @Column(name ="handled")
    private boolean handled;
}
