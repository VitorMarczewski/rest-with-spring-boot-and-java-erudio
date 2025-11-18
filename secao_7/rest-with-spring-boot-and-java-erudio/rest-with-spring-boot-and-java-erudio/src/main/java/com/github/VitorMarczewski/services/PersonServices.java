package com.github.VitorMarczewski.services;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.VitorMarczewski.Exception.ResourceNotFoundException;
import com.github.VitorMarczewski.Model.Person;
import com.github.VitorMarczewski.repository.PersonRepository;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    
    public Person findById(Long id){
        logger.info("Find one Person");

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found this id"));

    }

    public List<Person> findAll(){
       logger.info("finding all people");

       return repository.findAll();
    }



    public Person create(Person person){
        logger.info("Creating a person");

        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating a person");
        Person entity = repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this id"));

        
        entity.setFirstName("firstname " + person.getFirstName());
        entity.setLastName("lastname "+ person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id){
        logger.info("Deleting a person");
        Person entity = repository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("No records found for this id"));

        repository.delete(entity);
    }
}
