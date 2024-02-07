package com.cosimo.test.repository;

import com.cosimo.test.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
