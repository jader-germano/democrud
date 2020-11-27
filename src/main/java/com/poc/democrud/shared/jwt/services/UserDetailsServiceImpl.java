package com.poc.democrud.shared.jwt.services;

import com.poc.democrud.modules.usuarios.infra.orm.entities.Usuarios;
import com.poc.democrud.modules.usuarios.services.UsuariosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements IUserDetailsService {

    @Autowired
    private UsuariosServiceImpl usuariosService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios usuario = usuariosService.findByUsername(username);
        if (usuario != null) {
            return User.withUsername(usuario.getEmail() ).password(usuario.getSenha()).roles("CLIENT").build();
        } else {
            throw new UsernameNotFoundException("Não foi possível encontrar o usuário " + username);
        }
    }
}