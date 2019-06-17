package com.desafioGitHub.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.desafioGitHub.Constantes;
import com.desafioGitHub.entity.Repositorios;
import com.desafioGitHub.entity.Usuario;
import com.desafioGitHub.entity.response.RepositoriosResponse;
import com.desafioGitHub.entity.response.UsuarioResponse;
import com.desafioGitHub.services.BuscarUsuarioServices;
import com.desafioGitHub.utils.Utils;

@Service
public class BuscarUsuarioServicesImpl implements BuscarUsuarioServices{

	private static final Logger LOG = LoggerFactory.getLogger(BuscarUsuarioServicesImpl.class);
	
	@Override
	public UsuarioResponse buscarUsuario(String username) {
		LOG.info("[buscarUsuario] - Init");
		UsuarioResponse resultado = new UsuarioResponse();
		try {
			LOG.info("[buscarUsuario] - username: {}",username);
			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.add("Content-Type", "application/json");
			
			ResponseEntity<Usuario> responseEntity = null;
			HttpEntity<String> requestEntity = new HttpEntity<>(requestHeaders);
			
			RestTemplate restTemplate = Utils.getRestTemplate();
			responseEntity = restTemplate.exchange(Constantes.ENDPOINT_GITHUB_USERS + username, HttpMethod.GET, requestEntity, Usuario.class);
			
			if(responseEntity != null & responseEntity.getBody() != null) {
				LOG.info("[buscarUsuario] - responseEntity : {}",responseEntity.getBody());
				resultado.setCodigo(Constantes.RESULTADO_OK);
				resultado.setMensaje(Constantes.MENSAJE_USUARIO_OK);
				resultado.setUsuario(responseEntity.getBody());
			}else {
				LOG.info("[buscarUsuario] - responseEntity null");
				resultado.setCodigo(Constantes.RESULTADO_NOK);
				resultado.setMensaje(Constantes.MENSAJE_USUARIO_NOK);
			}			
		} catch (Exception e) {
			LOG.error("buscarUsuario - ERROR: ",e);
			resultado.setCodigo(Constantes.RESULTADO_ERROR);
			resultado.setMensaje(Constantes.MENSAJE_ERROR);
		}
		LOG.info("[buscarUsuario] - End");
		return resultado;
	}

	@Override
	public RepositoriosResponse listarRepositorios(String username) {
		LOG.info("[listarRepositorios] - Init");
		RepositoriosResponse repositoriosResponse = new RepositoriosResponse();
		try {
			LOG.info("[listarRepositorios] - username: {}",username);
			String endPoint = Constantes.ENDPOINT_GITHUB_REPOS;			
			endPoint = endPoint.replace("?", username);
			LOG.info("[listarRepositorios] - endPoint: {}",endPoint);
			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.add("Content-Type", "application/json");
			
			ResponseEntity<Repositorios[]> responseEntity = null;
			HttpEntity<String> requestEntity = new HttpEntity<>(requestHeaders);
			
			RestTemplate restTemplate = Utils.getRestTemplate();
			//responseEntity = restTemplate.exchange(endPoint, HttpMethod.GET, requestEntity, ArrayList<Repositorios>().class);
			responseEntity = restTemplate.exchange(endPoint, HttpMethod.GET, requestEntity, Repositorios[].class);
			if(responseEntity != null & responseEntity.getBody() != null) {
				List<Repositorios> listaRepositorios = new ArrayList<Repositorios>();
				LOG.info("[listarRepositorios] - responseEntity : {}",responseEntity.getBody());
				repositoriosResponse.setCodigo(Constantes.RESULTADO_OK);
				repositoriosResponse.setMensaje(Constantes.MENSAJE_REPOS_OK);
			 	for (Repositorios repositorios : responseEntity.getBody()) {
			 		LOG.info("[listarRepositorios] - repositorios : {}",repositorios.toString());
			 		listaRepositorios.add(repositorios);
				} 
				repositoriosResponse.setListaRepositorios(listaRepositorios);
			}else {
				LOG.info("[listarRepositorios] - responseEntity null");
				repositoriosResponse.setCodigo(Constantes.RESULTADO_NOK);
				repositoriosResponse.setMensaje(Constantes.MENSAJE_REPOS_NOK);
			}
		} catch (Exception e) {
			LOG.error("[listarRepositorios] - ERROR: ",e);
			repositoriosResponse.setCodigo(Constantes.RESULTADO_ERROR);
			repositoriosResponse.setMensaje(Constantes.MENSAJE_ERROR);
		}
		LOG.info("[listarRepositorios] - End");
		return repositoriosResponse;
	}
}