package com.poc.democrud.modules.users.services;

import com.poc.democrud.modules.users.enums.LiaisonType;
import com.poc.democrud.modules.users.infra.orm.entities.Liaisons;
import com.poc.democrud.modules.users.infra.orm.entities.Users;
import com.poc.democrud.modules.users.repositories.IUsersRepository;
import com.poc.democrud.modules.users.services.error.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UsersServiceImpl {

    @Autowired
    private IUsersRepository usersRepository;

    public List<Users> findAll() {
        return (List<Users>) usersRepository.findAll();
    }

    public void delete(Users value) {
        this.usersRepository.delete(value);
    }

    public Optional<Users> findById(Integer id) {
        return this.usersRepository.findById(id);
    }

    public Users save(Users user) throws ResponseStatusException {
        boolean email = user.getLiaison().stream().anyMatch((liaison ->
                liaison.getLiaisonType().name().equals(LiaisonType.EMAIL.name())
        ));
        boolean phone = user.getLiaison().stream().anyMatch((liaison ->
                liaison.getLiaisonType().name().equals(LiaisonType.PHONE.name())
        ));
        if (!phone) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Bad request. User must have one phone.");
        }
        if (!email ) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bad request. User must have one email.");
        }
        return this.usersRepository.save(user);
    }

    public Users findByUsernameAndPassword(String username, String password) throws Exception {
        return this.usersRepository.findByUsernameAndPassword(username, password).orElseThrow(() -> new Exception("User not found: " + username));
    }
}
