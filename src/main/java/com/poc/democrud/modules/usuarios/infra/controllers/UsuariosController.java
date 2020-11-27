package com.poc.democrud.modules.usuarios.infra.controllers;

import com.poc.democrud.modules.usuarios.infra.orm.entities.Usuarios;
import com.poc.democrud.modules.usuarios.services.UsuariosServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    private UsuariosServiceImpl usuarioService;

    public UsuariosController(UsuariosServiceImpl usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Usuarios> getUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuarios getUsuario(@PathVariable long id) {
        return (Usuarios) usuarioService.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid user id %s", id)));
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuarios CreateUsuario(@Valid @RequestBody Usuarios usuarios) {
        return usuarioService.save(usuarios);
    }

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteUsuario(@PathVariable long id) {
        Optional user =  Optional.ofNullable(usuarioService.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid user id %s", id))));
        user.ifPresent(value -> usuarioService.delete((Usuarios) value));
    }
}
