
package com.portfolio.mgb.Service;

import com.portfolio.mgb.Entity.Persona;
import com.portfolio.mgb.Interface.IPersonaService;
import com.portfolio.mgb.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    @Autowired 
    IPersonaRepository personaRepo;
    
    @Override
    public void savePersonas(Persona persona) {
        personaRepo.save(persona);
    }

    @Override
    public Persona findPersonaById(Long id) {
        return personaRepo.findById(id).orElse(null);
    }

    @Override
    public List<Persona> getPersonas() {
        return personaRepo.findAll();
    }

    @Override
    public void deletePersonaById(Long id) {
        personaRepo.deleteById(id);
    }

    @Override
    public void deletePersona(Persona persona) {
        personaRepo.delete(persona);
    }
    
}
