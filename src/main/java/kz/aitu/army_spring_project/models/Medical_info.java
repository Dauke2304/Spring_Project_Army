package kz.aitu.army_spring_project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kz.aitu.army_spring_project.models.interfaces.IMedical_info;
import lombok.Data;

@Data
@Entity
@Table(name = "medical_info")

public class Medical_info implements IMedical_info {
    @Id
    private int id;
    private double height;
    private double weight;
    private double vision;
    private boolean fit_to_army=define_fit_to_army(height,weight,vision) ;


    @Override
    public boolean define_fit_to_army(double height, double weight, double vision) {
        double average_ratio_of_height_and_weight = height/weight;
        boolean y = (vision >= -2 && vision <= 2);
        boolean x =(average_ratio_of_height_and_weight>=0.3);
        return (x&&y);
    }
    @Override
    public String toString() {
        String res;
        if(fit_to_army){
            res = "Fit for duty!";
        }
        else {
            res = "Unfit for service(";
        }
        return "Candidate №" +id+
                " Height: " + height +"cm"+
                " Weight: " + weight +"kg"+
                " Vision: " + vision+
                " RESULT: " + res;
    }


}