package com.empresa.cadastrousuarios.domain.repository;

import com.empresa.cadastrousuarios.domain.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
