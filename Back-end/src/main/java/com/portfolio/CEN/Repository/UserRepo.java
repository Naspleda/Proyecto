package com.portfolio.CEN.Repository;

import com.portfolio.CEN.Entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;




public interface UserRepo extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}