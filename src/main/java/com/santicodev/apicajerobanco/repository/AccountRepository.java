package com.santicodev.apicajerobanco.repository;

import com.santicodev.apicajerobanco.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
