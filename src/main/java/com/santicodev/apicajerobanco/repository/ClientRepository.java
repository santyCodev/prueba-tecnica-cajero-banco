package com.santicodev.apicajerobanco.repository;

import com.santicodev.apicajerobanco.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
