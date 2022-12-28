
package com.portfolio.mgb.Interface;

import com.portfolio.mgb.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    
    //guardar un objeto de tipo persona
    public void savePersonas(Persona persona);
    
    //obtener persona por id
    public Persona findPersonaById(Long id);
    
    //obtener una lisa de personas 
    public List<Persona> getPersonas();
      
    //Eliminar una persona por id
    public void deletePersonaById(Long id);
    
    //eliminar una persona por persona
    public void deletePersona(Persona persona);
    
    
    
}
