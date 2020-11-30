package com.poc.democrud.modules.users.repositories;

import com.poc.democrud.modules.users.infra.orm.entities.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsersRepository extends PagingAndSortingRepository<Users, Long> {

    @Query("SELECT u FROM Users u WHERE u.username = ?1 and u.password = ?2")
    Optional<Users> findByUsernameAndPassword(String username, String password);

    @Query("SELECT u FROM Users u WHERE u.id = ?1 ")
    Optional<Users> findById(Integer id);
}
