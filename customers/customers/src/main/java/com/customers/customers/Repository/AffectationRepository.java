package com.customers.customers.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customers.customers.Entity.Affectation;

@Repository
public interface AffectationRepository extends JpaRepository<Affectation, Long> {
}
