package com.desafioGitHub.entity.response;

import java.io.Serializable;
import java.util.List;

import com.desafioGitHub.entity.Repositorios;

public class RepositoriosResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	private String codigo;
	private String mensaje;
	private List<Repositorios> listaRepositorios;
	
	public RepositoriosResponse() {
		super();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<Repositorios> getListaRepositorios() {
		return listaRepositorios;
	}

	public void setListaRepositorios(List<Repositorios> listaRepositorios) {
		this.listaRepositorios = listaRepositorios;
	}

	@Override
	public String toString() {
		return "RepositoriosResponse [codigo=" + codigo + ", mensaje=" + mensaje + ", listaRepositorios="
				+ listaRepositorios + "]";
	}

}