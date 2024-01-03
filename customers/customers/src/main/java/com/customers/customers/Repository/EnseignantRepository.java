package com.customers.customers.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customers.customers.Entity.Enseignant;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
}
