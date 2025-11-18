package com.github.VitorMarczewski.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.VitorMarczewski.Model.Person;
import com.github.VitorMarczewski.data.dto.PersonDTO;
import com.github.VitorMarczewski.services.PersonServices;

@RestController //irá receber requisições https e retorna json
@RequestMapping("/person") //define o caminho
public class PersonController {

    @Autowired //criar e fornecer automaticamente um objeto do tipo PersonService
    private PersonServices service;

    @GetMapping(
        value = "/{id}",
        produces= MediaType.APPLICATION_JSON_VALUE // Define que a resposta será no formato JSON

        ) 
    public PersonDTO findById(
        @PathVariable("id") Long id //pega um valor da URL
    ){
        return service.findById(id);
    }

    @GetMapping(
        produces= MediaType.APPLICATION_JSON_VALUE
    )
    public List<PersonDTO> findAll(){
        return service.findAll();
    }

    @PostMapping(
        consumes=MediaType.APPLICATION_JSON_VALUE,
        produces=MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO create(@RequestBody PersonDTO person){
        return service.create(person);
    }

    @PutMapping(
        consumes=MediaType.APPLICATION_JSON_VALUE,
        produces=MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO update(@RequestBody PersonDTO person){
        return service.update(person);
    }

    
    @DeleteMapping(
        value = "/{id}"

        ) 
    public ResponseEntity<?> delete(
        @PathVariable("id") Long id //pega um valor da URL
    ){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
