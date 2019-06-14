package com.desafioGitHub.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desafioGitHub.services.BuscarUsuarioServices;

@Controller
public class BuscarUsuarioController {

private static final Logger LOG = LoggerFactory.getLogger(BuscarUsuarioController.class);
	
	private static final String INDEX_VIEW = "index";
	private static final String DOS_VIEW = "paguinaDos";

	@Autowired
	private BuscarUsuarioServices buscarUsuarioServices;
	
	@RequestMapping(path = "/")
    public String index(Model model) {
		LOG.info("index - Init");
		model.addAttribute("nombre", "Pepe");
        return INDEX_VIEW;
    }
	
	@GetMapping("/users/{username}")
	public String buscarUsuario(@PathVariable("username") String username) {
		LOG.info("buscarUsuario - Init");
		LOG.info("buscarUsuario - username: {}",username);
		String result = "N/A";
		//result = buscarUsuarioServices.buscarUsuario(username);
		LOG.info("buscarUsuario - end");
		return DOS_VIEW;
	}
	
	@GetMapping("/prueba/{username}")
	public String prueba(@PathVariable("username") String username) { //
		LOG.info("prueba - Init");
		LOG.info("prueba - username: {}",username);
		String result = "N/A";
		//result = buscarUsuarioServices.buscarUsuario(username);
		LOG.info("prueba - end");
		return DOS_VIEW;
	}
	
	@GetMapping("/users/{username}/repos")
	public List<String> buscarRepositorio(@PathVariable("username") String username) {
		LOG.info("buscarRepositorio - Init");
		List<String> listarRepositorios = new ArrayList<String>();
		listarRepositorios = buscarUsuarioServices.listarRepositorios(username);
		LOG.info("buscarRepositorio - end");
		return listarRepositorios;
	}
}