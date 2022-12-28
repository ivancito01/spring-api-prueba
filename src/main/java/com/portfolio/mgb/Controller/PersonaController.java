
package com.portfolio.mgb.Controller;

import com.portfolio.mgb.Entity.Persona;
import com.portfolio.mgb.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    @Autowired
    IPersonaService personaService;
    @GetMapping("/hola")
    public String hola(){
        return"hola";
    }
    
    @GetMapping ("/personas/traer")
    public List<Persona> getpersonas(){
        return personaService.getPersonas();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping( "/personas/crear")
    public String crearPersona (@RequestBody Persona persona){
        personaService.savePersonas(persona);
        return "Los datos se guardaron con exito";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/persona/borrar/{id}")
    public String borrarPersona (@PathVariable Long id){
        personaService.deletePersonaById(id);
        return "el usuario fue eliminado con exito";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/persona/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoapellido,
                               @RequestParam("img") String nuevoimagen
                                ){
        Persona persona=personaService.findPersonaById(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoapellido);
        persona.setImg(nuevoimagen);
        
        personaService.savePersonas(persona);
        return persona;
    }
}
