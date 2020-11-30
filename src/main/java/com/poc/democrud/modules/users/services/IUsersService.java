package com.poc.democrud.modules.users.services;

import com.poc.democrud.modules.users.infra.orm.entities.Users;

import java.util.List;
import java.util.Optional;

public interface IUsersService {
    List<Users> findAll();

    void delete(Users value);

    Optional<Users> findById(long id);

    Users save(Users users);

    Users findByUsername(String email) throws Exception;
}
