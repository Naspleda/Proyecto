package com.portfolio.CEN.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity

public class Proyecto implements Serializable{

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long idPro;

    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String tituloPro;


    @Size(min = 1, max = 1000, message = "no cumple con la longitud")
    private String descripcionPro;

    private String imagenPro;

    public Proyecto() {
    }

    public Proyecto(long idPro, String tituloPro, String descripcionPro, String imagenPro) {
        this.idPro = idPro;
        this.tituloPro = tituloPro;
        this.descripcionPro = descripcionPro;
        this.imagenPro = imagenPro;
    }

    public long getIdPro() {
        return idPro;
    }

    public void setIdPro(long idPro) {
        this.idPro = idPro;
    }

    public String getTituloPro() {
        return tituloPro;
    }

    public void setTituloPro(String tituloPro) {
        this.tituloPro = tituloPro;
    }

    public String getDescripcionPro() {
        return descripcionPro;
    }

    public void setDescripcionPro(String descripcionPro) {
        this.descripcionPro = descripcionPro;
    }

    public String getImagenPro() {
        return imagenPro;
    }

    public void setImagenPro(String imagenPro) {
        this.imagenPro = imagenPro;
    }

}