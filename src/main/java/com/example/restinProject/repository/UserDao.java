package com.example.restinProject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.restinProject.entity.Users;

@Repository
public interface UserDao extends MongoRepository<Users, String> {

    Users findByUserName(String userName);

}
