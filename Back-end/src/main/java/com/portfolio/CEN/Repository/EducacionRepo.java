package com.portfolio.CEN.Repository;

import com.portfolio.CEN.Entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EducacionRepo extends JpaRepository<Educacion , Long>{
    
}
