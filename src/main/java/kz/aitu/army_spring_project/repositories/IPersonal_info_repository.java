package kz.aitu.army_spring_project.repositories;

import kz.aitu.army_spring_project.models.Personal_info;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IPersonal_info_repository extends JpaRepository<Personal_info,Integer>{

}
