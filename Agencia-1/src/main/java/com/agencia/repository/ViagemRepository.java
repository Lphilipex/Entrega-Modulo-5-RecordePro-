package com.agencia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agencia.model.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {
    List<Viagem> findByDestino(String destino);
}
