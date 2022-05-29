package com.portfolio.CEN.Controller;

import com.portfolio.CEN.Entity.Skill;

import java.util.List;

import com.portfolio.CEN.Service.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill")

public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService){
        this.skillService = skillService;
    }
    @GetMapping ("/all")
    public ResponseEntity<List<Skill>> obtenerSkill(){
        List <Skill> skills = skillService.buscarSkill();
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Skill> editarSkill(@RequestBody Skill skill){
        Skill updateSkill = skillService.editarSkill(skill);
        return new ResponseEntity<>(updateSkill, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Skill> crearSkill(@RequestBody Skill skill){
        Skill nuevaSkill=skillService.agregarSkill(skill);
        return new ResponseEntity<>(nuevaSkill, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> borrarSkill(@PathVariable("id") Long id){
        skillService.borrarSkill(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
