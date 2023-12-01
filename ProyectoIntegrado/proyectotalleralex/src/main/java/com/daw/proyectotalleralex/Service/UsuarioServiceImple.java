package com.daw.proyectotalleralex.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.proyectotalleralex.DAO.UsuarioDAO;
import com.daw.proyectotalleralex.DTO.Usuario;

@Service
public class UsuarioServiceImple implements UsuarioService{
	@Autowired
	UsuarioDAO usuariodao;
	
	
	@Override
	public List<Usuario> FindAll() {
		return (List<Usuario>) usuariodao.findAll();
	}

	@Override
	public Usuario FindById(String clave) {
		Optional<Usuario> usu=usuariodao.findById(clave);
        if(!usu.isEmpty()) {
            Usuario usu2=usu.get();
            return usu2;
        }else {
            return null;
        }
	}

	@Override
	public void save(Usuario usuario) {
		usuariodao.save(usuario);
		
	}

	@Override
	public void edit(Usuario usuario) {
		usuariodao.save(usuario);
		
	}

	@Override
	public void delete(String indice) {
		usuariodao.deleteById(indice);
		
	}

	@Override
	public Usuario encuentraEmailUsu(String email) {
		
		return usuariodao.encuentraEmailUsu(email);
	}

	@Override
	public Usuario encuentradniUsu(String dniusu) {
		return usuariodao.encuentradniUsu(dniusu);
	}
	
	
}
