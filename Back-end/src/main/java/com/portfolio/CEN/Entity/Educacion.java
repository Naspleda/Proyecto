package com.portfolio.CEN.Entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter

public class Educacion implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long idEdu;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String tituloEdu;
    
    @NotNull
    // @Size(min = 4, max = 4, message = "no cumple con la longitud , ingrese un año de 4 digitos")
    private int fechaEdu;
    
    @Size(min = 1, max = 500, message = "no cumple con la longitud")
    private String descripcionEdu;

    private String imagenEdu;

    public Educacion() {
    }

    public Educacion(long idEdu, String tituloEdu, int fechaEdu, String descripcionEdu, String imagenEdu) {
        this.idEdu = idEdu;
        this.tituloEdu = tituloEdu;
        this.fechaEdu = fechaEdu;
        this.descripcionEdu = descripcionEdu;
        this.imagenEdu = imagenEdu;
    }

}
