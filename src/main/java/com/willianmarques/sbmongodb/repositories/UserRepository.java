package com.willianmarques.sbmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.willianmarques.sbmongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {}