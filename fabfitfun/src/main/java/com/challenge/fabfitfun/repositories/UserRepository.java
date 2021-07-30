package com.challenge.fabfitfun.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.fabfitfun.domain.User;

public interface UserRepository extends JpaRepository<User,Long>
{
    List<User> findByFirstName(String firstName); 
    List<User> findByMiddleName(String middleName);
    List<User> findByLastName(String lastName);
    List<User> findByFirstNameOrMiddleNameOrLastName(String firstName, String middleName, String lastName);
}
