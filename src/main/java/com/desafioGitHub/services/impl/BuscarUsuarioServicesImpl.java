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

import com.desafioGitHub.Utils;
import com.desafioGitHub.services.BuscarUsuarioServices;

@Service
public class BuscarUsuarioServicesImpl implements BuscarUsuarioServices{

	private static final Logger LOG = LoggerFactory.getLogger(BuscarUsuarioServicesImpl.class);
	
	private static final String endPointGitHub = "https://github.com/";

	@Override
	public String buscarUsuario(String username) {
		LOG.info("[buscarUsuario] - Init");
		try {
			LOG.info("[buscarUsuario] - username: {}",username);
			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.add("Content-Type", "application/json");
			
			ResponseEntity<String> responseEntity = null;
			HttpEntity<String> requestEntity = new HttpEntity<>(requestHeaders);
			
			RestTemplate restTemplate = Utils.getRestTemplate();
			responseEntity = restTemplate.exchange(endPointGitHub + username, HttpMethod.GET, requestEntity, String.class);
			
			if(responseEntity != null & responseEntity.getBody() != null) {
				LOG.info("[buscarUsuario] - responseEntity : {}",responseEntity.getBody());
			}else {
				LOG.info("[buscarUsuario] - responseEntity null");
			}			
		} catch (Exception e) {
			LOG.error("buscarUsuario - ERROR: ",e);
		}
		LOG.info("[buscarUsuario] - End");
		return username;
	}

	@Override
	public List<String> listarRepositorios(String username) {
		LOG.info("[listarRepositorios] - Init");
		List<String> listarRepositorios = new ArrayList<String>();
		try {
			LOG.info("[listarRepositorios] - username: {}",username);
			listarRepositorios.add(username);
		} catch (Exception e) {
			LOG.error("[listarRepositorios] - ERROR: ",e);
		}
		LOG.info("[listarRepositorios] - End");
		return listarRepositorios;
	}
}