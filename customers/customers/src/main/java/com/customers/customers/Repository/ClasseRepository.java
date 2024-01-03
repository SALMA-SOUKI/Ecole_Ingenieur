package com.customers.customers.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customers.customers.Dto.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {
}
