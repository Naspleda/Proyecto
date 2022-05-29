package com.portfolio.CEN.Repository;

import com.portfolio.CEN.Entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SkillRepo extends JpaRepository<Skill, Long>{
    
}
