package com.ejemplo.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.demo.models.UsuarioModel;
import com.ejemplo.demo.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
//	Instancia que realiza la Inyección de la dependencia (pomp)
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public ArrayList<UsuarioModel> obtenerUsuario(){
		return (ArrayList<UsuarioModel>)usuarioRepository.findAll();
	}
	
	public UsuarioModel guardarUsuario(UsuarioModel usuario) {
		return usuarioRepository.save(usuario);
	}
	
//	cuando tratamos con id => clase Optional
	public Optional<UsuarioModel> obtenerPorId (Long id){
		return usuarioRepository.findById(id);
	}
	
	public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer priodidad){
		return usuarioRepository.findByPrioridad(priodidad);
	}
	
	public boolean eliminarUsuario(Long id ) {
		try {
			usuarioRepository.deleteById(id);
			return true;
		} catch(Exception err) {
			return false;
		}
	}

}
