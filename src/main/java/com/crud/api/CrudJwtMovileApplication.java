package com.crud.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// TODO 1: Anotar con @SpringBootApplication (ya está)
// TODO 2: Verificar que el package base sea correcto para el component scan
@SpringBootApplication
public class CrudJwtMovileApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudJwtMovileApplication.class, args);
    }
}
