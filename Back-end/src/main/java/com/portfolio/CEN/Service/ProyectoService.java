package com.portfolio.CEN.Service;

import com.portfolio.CEN.Entity.Proyecto;


import com.portfolio.CEN.Repository.ProyectoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional

public class ProyectoService {
    private final ProyectoRepo proyectoRepo;

    @Autowired
    public ProyectoService(ProyectoRepo proyectoRepo) {
        this.proyectoRepo = proyectoRepo;
    }
    public Proyecto agregarProyecto(Proyecto proyecto ){
        return proyectoRepo.save(proyecto);
    }
    public List<Proyecto> buscarProyecto(){
        return proyectoRepo.findAll();
    }

    public Proyecto editarProyecto(Proyecto proyecto){
        return proyectoRepo.save(proyecto);
    }

    public void borrarProyecto(Long id){
        proyectoRepo.deleteById(id);
    }

}