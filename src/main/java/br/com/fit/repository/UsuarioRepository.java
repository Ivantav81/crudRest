package br.com.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fit.models.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Usuario findById(long id);

}
