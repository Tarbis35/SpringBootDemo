package com.home.SpringBootDemo.model.repositories;


import com.home.SpringBootDemo.model.entities.PTipoServicio;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TipoServicioRepository extends JpaRepository<PTipoServicio, Integer> {

}
