package com.github.VitorMarczewski.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.VitorMarczewski.Model.Person;

public interface PersonRepository extends JpaRepository<Person,Long >{

}
