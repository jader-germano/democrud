package com.poc.democrud.modules.users.infra.controllers;

import com.poc.democrud.modules.users.infra.orm.entities.Users;
import com.poc.democrud.modules.users.services.UsersServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    private UsersServiceImpl usersService;

    public LoginController(UsersServiceImpl usersService) {
        this.usersService = usersService;
    }
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Users login(@RequestBody Users user) throws Exception {
        return usersService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
