package com.portfolio.CEN.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity

public class Experiencia implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long idExp;
    private String tituloExp;
    private int fechaExp;
    private String descripcionExp;
    private String imagenExp;

    public Experiencia() {
    }

    public Experiencia(long idExp, String tituloExp, int fechaExp, String descripcionEXP, String imagenExp) {
        this.idExp = idExp;
        this.tituloExp = tituloExp;
        this.fechaExp = fechaExp;
        this.descripcionExp = descripcionExp;
        this.imagenExp = imagenExp;
    }
    

    public long getIdExp() {
        return idExp;
    }

    public void setIdExp(long idExp) {
        this.idExp = idExp;
    }

    public String getTituloExp() {
        return tituloExp;
    }

    public void setTituloExp(String tituloExp) {
        this.tituloExp = tituloExp;
    }

    public int getfechaExp() {
        return fechaExp;
    }

    public void setfechaExp(int fechaExp) {
        this.fechaExp = fechaExp;
    }

    public String getdescripcionExp() {
        return descripcionExp;
    }

    public void setdescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }

    public String getImagenExp() {
        return imagenExp;
    }

    public void setImagenExp(String imagenExp) {
        this.imagenExp = imagenExp;
    }

    
   
}
