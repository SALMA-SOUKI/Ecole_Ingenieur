package com.fsts.Feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "etudiant-service", url = "http://localhost:8080/etudiants")
public interface EtudiantFeignClient {
    @GetMapping("find/{id}")
    EtudiantDTO getEtudiantById(@PathVariable Long id);
}
