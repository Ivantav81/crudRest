package br.com.fit.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fit.models.Usuario;
import br.com.fit.repository.UsuarioRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class UsuarioResource {

	@Autowired
	UsuarioRepository usuarioRepository;

	@GetMapping("/usuarios") // http://localhost:8080/api/usuarios
	public List<Usuario> listaUsuarios() {
		return usuarioRepository.findAll();
	}

	@GetMapping("/usuario/{id}") // http://localhost:8080/api/usuario/1
	public Usuario listaUsuarioUnico(@PathVariable(value = "id") long id) {
		return usuarioRepository.findById(id);
	}

	@PostMapping("/usuario")
	public Usuario salvaUsuario(@RequestBody @Valid Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@DeleteMapping("/usuario")
	public void deletaUsuario(@RequestBody @Valid Usuario usuario) {
		usuarioRepository.delete(usuario);
	}

	@PutMapping("/usuario")
	public Usuario atualizaUsuario(@RequestBody @Valid Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}
