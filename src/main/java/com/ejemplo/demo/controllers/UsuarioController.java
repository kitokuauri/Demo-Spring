package com.ejemplo.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.demo.models.UsuarioModel;
import com.ejemplo.demo.services.UsuarioService;

//RestService
@RestController
// Para hacer el mapeo con la tabla
@RequestMapping("/usuario")
public class UsuarioController {
	
//	Instancia que realiza la Inyección de la dependencia (pomp)
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping()
	public ArrayList<UsuarioModel> obtenerUsuarios(){
		return usuarioService.obtenerUsuario();
	}
	
	@PostMapping()
//							@ReguestBody para obtener el cuerpo de la respuesta
	public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
		return this.usuarioService.guardarUsuario(usuario);
	}
	
	@GetMapping(path="/{id}")
//	clase Optional: se utiliza para tratar con ids al haber opciones impredecibles
	public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
		return this.usuarioService.obtenerPorId(id);
	}
	
//	usuario/query?prioridad=1 (por ejemplo)
	@GetMapping(path="/query")
	public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
		return this.usuarioService.obtenerPorPrioridad(prioridad);
	}
	
	@DeleteMapping(path="/{id}")
	public String eliminarPorId(@PathVariable("id") Long id) {
		boolean ok = this.usuarioService.eliminarUsuario(id);
		if(ok) {
			return "Se eliminó el usuario con id" + id;
		} else {
			return "No se pudo eliminar el usuario con ed" + id;
		}
	}
	
	
	

}
