
package com.portfolio.mgb.Entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 1, max=70, message = "ingrese su nombre correctamente" )
    private String nombre;
    @NotNull
    @Size(min = 1, max=70, message = "ingrese su nombre correctamente" )
    private String apellido;
    
    @Size(min = 1, max=100, message = "ingrese su nombre correctamente" )
    private String img;
    
    
}
