package com.github.VitorMarczewski.services;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.VitorMarczewski.Exception.ResourceNotFoundException;
import com.github.VitorMarczewski.Model.Person;
import com.github.VitorMarczewski.data.dto.PersonDTO;
import static com.github.VitorMarczewski.mapper.ObjectMapper.parseListObjects;
import static com.github.VitorMarczewski.mapper.ObjectMapper.parseObject;
import com.github.VitorMarczewski.repository.PersonRepository;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    
    public PersonDTO findById(Long id){
        logger.info("Find one Person");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found this id"));

        return parseObject(entity,PersonDTO.class);
    }

    public List<PersonDTO> findAll(){
       logger.info("finding all people");

       return parseListObjects(repository.findAll(),PersonDTO.class);
    }



    public PersonDTO create(PersonDTO person){
        logger.info("Creating a person");

        var entity = parseObject(person,Person.class);
        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public PersonDTO update(PersonDTO person){
        logger.info("Updating a person");
        Person entity = repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this id"));

        
        entity.setFirstName("firstname " + person.getFirstName());
        entity.setLastName("lastname "+ person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(repository.save(entity), PersonDTO.class) ;
    }

    public void delete(Long id){
        logger.info("Deleting a person");
        Person entity = repository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("No records found for this id"));

        repository.delete(entity);
    }
}
