package com.desafioGitHub.entity.response;

import java.io.Serializable;

import com.desafioGitHub.entity.Usuario;

public class UsuarioResponse implements Serializable{

	private static final long serialVersionUID = 1L;

	private String codigo;
	private String mensaje;
	private Usuario usuario;
	
	public UsuarioResponse() {
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Resultado [codigo=" + codigo + ", mensaje=" + mensaje + ", usuario=" + usuario + "]";
	}
	
}