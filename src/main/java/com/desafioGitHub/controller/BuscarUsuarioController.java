package com.desafioGitHub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.desafioGitHub.entity.response.RepositoriosResponse;
import com.desafioGitHub.entity.response.UsuarioResponse;
import com.desafioGitHub.services.BuscarUsuarioServices;

@Controller
public class BuscarUsuarioController {

	private static final Logger LOG = LoggerFactory.getLogger(BuscarUsuarioController.class);
	
	@Autowired
	private BuscarUsuarioServices buscarUsuarioServices;
	
	@GetMapping("/users/{username}")
	public @ResponseBody UsuarioResponse buscarUsuario(@PathVariable("username") String username) {
		LOG.info("buscarUsuario - Init");
		LOG.info("buscarUsuario - username: {}",username);
		UsuarioResponse resultado = new UsuarioResponse();
		try {
			resultado = buscarUsuarioServices.buscarUsuario(username);			
		}catch (Exception e) {
			LOG.error("buscarUsuario - ERROR: ",e);
		}
		LOG.info("buscarUsuario - end");
		return resultado;
	}
	
	@GetMapping("/users/{username}/repos")
	public @ResponseBody RepositoriosResponse buscarRepositorio(@PathVariable("username") String username) {
		LOG.info("buscarRepositorio - Init");
		LOG.info("buscarRepositorio - username: {}",username);
		RepositoriosResponse repositoriosResponse = new RepositoriosResponse();
		try {
			repositoriosResponse = buscarUsuarioServices.listarRepositorios(username);
		} catch (Exception e) {
			LOG.error("buscarRepositorio - ERROR: ",e);
		}		
		LOG.info("buscarRepositorio - end");
		return repositoriosResponse;
	}

}