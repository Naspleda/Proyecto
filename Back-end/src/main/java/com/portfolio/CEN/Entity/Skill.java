package com.portfolio.CEN.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class Skill implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long idSkill;

        private String fotoSkill;
        private int porcentaje;

    public Skill() {
    }

    public Skill(long idSkill, String nombreSkill, String fotoSkill, int porcentaje) {
        this.idSkill = idSkill;
        this.fotoSkill = fotoSkill;
        this.porcentaje = porcentaje;
    }

    public long getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(long idSkill) {
        this.idSkill = idSkill;
    }

    public String getFotoSkill() {
        return fotoSkill;
    }

    public void setFotoSkill(String fotoSKill) {
        this.fotoSkill = fotoSkill;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
        
    
}
