package com.portfolio.CEN.Service;

import com.portfolio.CEN.Entity.Skill;
import com.portfolio.CEN.Repository.SkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class SkillService {
    private final SkillRepo skillRepo;

    @Autowired
    public SkillService(SkillRepo skillRepo) {
        this.skillRepo = skillRepo;
    }
    public Skill agregarSkill(Skill skill ){
        return skillRepo.save(skill);
    }
    public List<Skill> buscarSkill(){
        return skillRepo.findAll();
    }

    public Skill editarSkill(Skill skill){
        return skillRepo.save(skill);
    }

    public void borrarSkill(Long id){
        skillRepo.deleteById(id);
    }

}