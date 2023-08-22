package com.empresa.cadastrousuarios.domain.repository;

import com.empresa.cadastrousuarios.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE LOWER(u.nome) LIKE LOWER(concat('%', :nome, '%'))")
    User getUserByNome(String nome);

}
