package kz.aitu.army_spring_project.services;

import kz.aitu.army_spring_project.models.Medical_info;
import kz.aitu.army_spring_project.repositories.IMedical_info_repository;
import kz.aitu.army_spring_project.services.interfaces.IMedical_info_service;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Medical_info_service implements IMedical_info_service {
    private final IMedical_info_repository repo;

    public Medical_info_service(IMedical_info_repository repo) {
        this.repo = repo;
    }

    @Override
    public Medical_info createMedical_info(Medical_info med) {
        return repo.save(med);
    }

    @Override
    public Medical_info getMedical_info(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Medical_info> getAllmedical_info() {
        return repo.findAll();
    }
}
