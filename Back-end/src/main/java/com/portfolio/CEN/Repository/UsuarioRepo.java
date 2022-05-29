package com.portfolio.CEN.Repository;

import com.portfolio.CEN.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
    
}
