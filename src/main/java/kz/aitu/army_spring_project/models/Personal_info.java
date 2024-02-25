package kz.aitu.army_spring_project.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "personal_info")
public class Personal_info extends ID{
    private String name;
    private String surname;
    private int age;

    @Override
    public String toString() {
        return "Candidate №" +getId()+
                " Name: " + name +
                " Surname: " + surname  +
                " Age: " + age;
    }

}
