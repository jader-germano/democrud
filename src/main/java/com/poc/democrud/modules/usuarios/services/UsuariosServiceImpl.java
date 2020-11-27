package com.poc.democrud.modules.usuarios.services;

import com.poc.democrud.modules.usuarios.infra.orm.entities.Usuarios;
import com.poc.democrud.modules.usuarios.repositories.IUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceImpl implements IUsuariosService {

    @Autowired
    private IUsuariosRepository usuariosRepository;

    @Override
    public List<Usuarios> findAll() {
        return (List<Usuarios>) usuariosRepository.findAll();
    }

    @Override
    public void delete(Usuarios value) {
        this.usuariosRepository.delete(value);
    }

    @Override
    public Optional<Usuarios> findById(long id) {
        return this.usuariosRepository.findById(id);
    }

    @Override
    public Usuarios save(Usuarios usuario) {
        return this.usuariosRepository.save(usuario);
    }

    @Override
    public Usuarios findByUsername(String email) {
        return this.usuariosRepository.findByUsername(email);
    }
}
