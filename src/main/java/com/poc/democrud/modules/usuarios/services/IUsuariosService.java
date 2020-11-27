package com.poc.democrud.modules.usuarios.services;

import com.poc.democrud.modules.usuarios.infra.orm.entities.Usuarios;

import java.util.List;
import java.util.Optional;

public interface IUsuariosService {
    List<Usuarios> findAll();

    void delete(Usuarios value);

    Optional<Usuarios> findById(long id);

    Usuarios save(Usuarios usuarios);

    Usuarios findByUsername(String email);
}
