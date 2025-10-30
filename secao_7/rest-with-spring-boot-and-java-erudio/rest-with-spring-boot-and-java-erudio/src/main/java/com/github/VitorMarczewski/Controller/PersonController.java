package com.github.VitorMarczewski.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.VitorMarczewski.Model.Person;
import com.github.VitorMarczewski.PersonServices;

@RestController //irá receber requisições https e retorna json
@RequestMapping("/person") //define o caminho
public class PersonController {

    @Autowired //criar e fornecer automaticamente um objeto do tipo PersonService
    private PersonServices service;

    @RequestMapping(
        value = "/{id}",
        method= RequestMethod.GET,// Define que o método responde a requisições HTTP GET
        produces= MediaType.APPLICATION_JSON_VALUE // Define que a resposta será no formato JSON

        ) 
    public Person findById(
        @PathVariable("id") String id //pega um valor da URL
    ){
        return service.findById(id);
    }

    @RequestMapping(
        
        method= RequestMethod.GET,
        produces= MediaType.APPLICATION_JSON_VALUE
    )
    public List<Person> findAll(){
        return service.findAll();
    }

    @RequestMapping(
        method=RequestMethod.POST,
        consumes=MediaType.APPLICATION_JSON_VALUE,
        produces=MediaType.APPLICATION_JSON_VALUE
    )
    public Person create(@RequestBody Person person){
        return service.create(person);
    }

    @RequestMapping(
        method=RequestMethod.PUT,
        consumes=MediaType.APPLICATION_JSON_VALUE,
        produces=MediaType.APPLICATION_JSON_VALUE
    )
    public Person update(@RequestBody Person person){
        return service.update(person);
    }

    
    @RequestMapping(
        value = "/{id}"

        ) 
    public void delete(
        @PathVariable("id") String id //pega um valor da URL
    ){
        service.delete(id);
    }

}
