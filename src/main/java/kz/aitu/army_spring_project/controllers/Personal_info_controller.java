package kz.aitu.army_spring_project.controllers;

import kz.aitu.army_spring_project.models.Personal_info;
import kz.aitu.army_spring_project.services.Personal_info_service;
import kz.aitu.army_spring_project.services.interfaces.IPersonal_info_service;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("personal_info")
public class Personal_info_controller {
    private final IPersonal_info_service service;

    public Personal_info_controller(IPersonal_info_service service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Personal_info> getAllPersonal_info(){
        return service.getAllpersons();
    }

    @GetMapping("/{person_id}")
    public ResponseEntity<Personal_info> getPersonById(@PathVariable("person_id") int id){
        Personal_info person = service.getPerson(id);
        if (person == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);//404
        }
        return new ResponseEntity<>(person, HttpStatus.OK);//200
    }
    @PostMapping("/")
    public ResponseEntity<Personal_info> createPerson(@RequestBody Personal_info person){
        Personal_info createdperson = service.createPerson(person);
        if(createdperson == null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(createdperson,HttpStatus.CREATED);

    }



}
