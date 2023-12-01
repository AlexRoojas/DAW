package com.daw.proyectotalleralex.Service;

import java.util.List;

import com.daw.proyectotalleralex.DTO.Usuario;

public interface UsuarioService {
	public List<Usuario> FindAll();
    public Usuario FindById(String clave);
    public void save(Usuario usuario);
    public void edit (Usuario usuario);
    public void delete(String indice);
    
    public Usuario encuentraEmailUsu(String email);
    
    public Usuario encuentradniUsu(String dniusu);
}
