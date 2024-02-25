package kz.aitu.army_spring_project.services;

import kz.aitu.army_spring_project.models.Personal_info;
import kz.aitu.army_spring_project.repositories.IPersonal_info_repository;
import kz.aitu.army_spring_project.services.interfaces.IPersonal_info_service;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Personal_info_service implements IPersonal_info_service {
    private final IPersonal_info_repository repo;

    public Personal_info_service(IPersonal_info_repository repo) {
        this.repo = repo;
    }

    @Override
    public Personal_info createPerson(Personal_info person) {
        return repo.save(person);
    }

    @Override
    public Personal_info getPerson(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Personal_info> getAllpersons() {
        return repo.findAll();
    }
}

