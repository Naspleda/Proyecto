package com.portfolio.CEN.Repository;

import com.portfolio.CEN.Entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface ProyectoRepo extends JpaRepository<Proyecto, Long>{

}