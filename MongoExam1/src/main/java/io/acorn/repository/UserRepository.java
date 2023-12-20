package io.acorn.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import io.acorn.model.User;

public interface UserRepository extends MongoRepository<User, String>{

}
