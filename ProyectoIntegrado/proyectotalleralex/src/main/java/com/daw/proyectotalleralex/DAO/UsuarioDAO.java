package com.daw.proyectotalleralex.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.daw.proyectotalleralex.DTO.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, String>{
	@Query("select u from Usuario u where u.emailusu = ?1")
	Usuario encuentraEmailUsu(String emailUsu);
	
	@Query("select u from Usuario u where u.dniusu = ?1")
	Usuario encuentradniUsu(String dniusu);
}
