package com.desafioGitHub;

public abstract class Constantes {

	//Usuario
	public static final String MENSAJE_USUARIO_OK = "USUARIO ENCONTRADO";
	public static final String MENSAJE_USUARIO_NOK = "NOK";
	public static final String ENDPOINT_GITHUB_USERS = "https://api.github.com/users/";
	//Repositorios
	public static final String MENSAJE_REPOS_OK = "REPOSITORIOS ENCONTRADSO";
	public static final String MENSAJE_REPOS_NOK = "NOK";
	public static final String ENDPOINT_GITHUB_REPOS = "https://api.github.com/users/?/repos";
	//Generico
	public static final String RESULTADO_OK = "200";
	public static final String RESULTADO_NOK = "400";
	public static final String RESULTADO_ERROR = "500";
	public static final String MENSAJE_ERROR = "ERROR INTERNO";

}