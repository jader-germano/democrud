package com.poc.democrud.modules.usuarios.repositories;

import com.poc.democrud.modules.usuarios.infra.orm.entities.Usuarios;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuariosRepository extends PagingAndSortingRepository<Usuarios, Long> {

    @Query("SELECT u FROM Usuarios u WHERE u.username = ?1")
    Usuarios findByUsername(String username);
}
