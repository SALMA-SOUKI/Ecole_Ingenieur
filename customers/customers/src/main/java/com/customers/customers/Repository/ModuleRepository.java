package com.customers.customers.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customers.customers.Dto.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
}
