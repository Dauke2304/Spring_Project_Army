package kz.aitu.army_spring_project.controllers;

import kz.aitu.army_spring_project.models.Medical_info;
import kz.aitu.army_spring_project.models.Personal_info;
import kz.aitu.army_spring_project.services.Medical_info_service;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/medical_info")
public class Medical_info_controller {
    private final Medical_info_service service;

    public Medical_info_controller(Medical_info_service service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Medical_info> getAllMedical_info(){
        return service.getAllmedical_info();
    }

    @GetMapping("/{person_id}")
    public ResponseEntity<Medical_info> getMedicalById(@PathVariable("person_id") int id){
        Medical_info med = service.getMedical_info(id);
        if (med == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);//404
        }
        return new ResponseEntity<>(med, HttpStatus.OK);//200
    }

    @PostMapping("/{person_id}")
    public ResponseEntity<Medical_info> createPerson(@RequestBody Medical_info med,@PathVariable("person_id") int id){

        try {
            med.setId(id);
            Medical_info createdMed = service.createMedical_info(med);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdMed);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }
}