package kz.aitu.army_spring_project.repositories;

import kz.aitu.army_spring_project.models.Medical_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedical_info_repository extends JpaRepository<Medical_info,Integer> {
}