package com.desafioGitHub.services;

import java.util.List;

public interface BuscarUsuarioServices {

	public String buscarUsuario(String username);

	public List<String> listarRepositorios(String username);
}