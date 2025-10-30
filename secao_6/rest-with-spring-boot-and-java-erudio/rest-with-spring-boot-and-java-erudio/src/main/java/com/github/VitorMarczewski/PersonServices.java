package com.github.VitorMarczewski;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.github.VitorMarczewski.Model.Person;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){
        logger.info("Find one Person");

        Person person = new Person();
        
        person.setId(counter.incrementAndGet());
        person.setFirstName("João Vitor");
        person.setLastName("Marczewski");
        person.setAddress("Guarapuava - Paraná - Brasil");
        person.setGender("Male");

        return person;

    }

    public List<Person> findAll(){
        List<Person> persons = new ArrayList<>();
        
        for(int i=0; i<8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        
        person.setId(counter.incrementAndGet());
        person.setFirstName("firstname " + i);
        person.setLastName("lastname "+ i);
        person.setAddress("some address in Brazil");
        person.setGender("Male");

        return person;
    }


    public Person create(Person person){
        logger.info("Creating a person");

        return person;
    }

    public Person update(Person person){
        logger.info("Updating a person");

        return person;
    }

    public void delete(String id){
        logger.info("Deleting a person");
    }
}
