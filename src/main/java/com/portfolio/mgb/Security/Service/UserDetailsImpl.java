
package com.portfolio.mgb.Security.Service;

import com.portfolio.mgb.Security.Entity.Usuario;
import com.portfolio.mgb.Security.Entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImpl implements UserDetailsService{
    @Autowired
    UsuarioService usuarioSevice;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
      Usuario usuario = usuarioSevice.getByNombreUsuario(nombreUsuario).get();
      return UsuarioPrincipal.build(usuario);
    }
    
    
}
