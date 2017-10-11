package br.edu.Trabalho1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {

	private String nome;
	private String nick;
	private String password;
	private String email;
	private int id;
	private List<String> tipoComprado = new ArrayList<>();

	public Usuario() {

	}

	public Usuario(String nick) {
		this.nick = nick;
	}

	public Usuario(String nome, String nick, String password, String email, int id) {

		this.nome = nome;
		this.nick = nick;
		this.password = password;
		this.email = email;
		this.id = id;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<String> getTipoComprado() {
		return tipoComprado;
	}

	public void setTipoComprado(String tipoComprado) {
		this.tipoComprado.add(tipoComprado);
	}

}
