package br.edu.Trabalho1;

import java.io.Serializable;

public class Produto implements Comparable<Produto>, Serializable {

	private String nome;
	private double quantidade;
	private String marca;
	private String tipo;
	private String descricao;
	private double valorPorUnidade;
	private int id;
	private int quantidadeVendida;

	public Produto(String nome, double quantidade, String marca, String tipo, String descricao, double valorPorUnidade,
			int id) {

		this.nome = nome;
		this.quantidade = quantidade;
		this.marca = marca;
		this.tipo = tipo;
		this.descricao = descricao;
		this.valorPorUnidade = valorPorUnidade;
		this.id = id;

	}

	public double getValorTotal() {

		return quantidade * valorPorUnidade;

	}

	public String getTipo() {
		return tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValorPorUnidade() {
		return valorPorUnidade;
	}

	public void setValorPorUnidade(double valorPorUnidade) {
		this.valorPorUnidade = valorPorUnidade;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public void setQuantidadeVendida(int quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}

	@Override
	public int compareTo(Produto o) {

		if (this.getQuantidadeVendida() > o.getQuantidadeVendida()) {
			return 1;
		} else if (this.getQuantidadeVendida() < o.getQuantidadeVendida()) {
			return -1;
		} else {
			return 0;
		}

	}

}
