package com.desafioGitHub.services;

import com.desafioGitHub.entity.response.RepositoriosResponse;
import com.desafioGitHub.entity.response.UsuarioResponse;

public interface BuscarUsuarioServices {

	public UsuarioResponse buscarUsuario(String username);

	public RepositoriosResponse listarRepositorios(String username);
}