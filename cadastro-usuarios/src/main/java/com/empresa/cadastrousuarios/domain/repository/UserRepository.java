package com.empresa.cadastrousuarios.domain.repository;

import com.empresa.cadastrousuarios.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
