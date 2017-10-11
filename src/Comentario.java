package br.edu.Trabalho1;

import java.util.ArrayList;
import java.util.List;

public class Comentario {

	private String assunto;
	private int idProduto;
	private String comentario;
	private static List<String> comentarios = new ArrayList<>();
	private static StringBuilder sb = new StringBuilder();

	public void registraComentario(String assunto, int idProduto, String comentario) {

		String nome = "";

		List<Produto> produtos = new ArrayList<>();
		

		produtos = CadastroDeProduto.getProdutos();

		for (Produto produto : produtos) {

			if (produto.getId() == idProduto) {
				nome = produto.getNome();
			}

		}
		
		sb.append("\n");
		sb.append("Assunto: ");
		sb.append(assunto);
		sb.append("\n");
		sb.append("Nome do produto: ");
		sb.append(nome);
		sb.append("\n");
		sb.append("Comentário: ");
		sb.append("\n");
		sb.append(comentario);
		sb.append("\n");
		sb.append("\n");
		
		comentarios.add(sb.toString());

	}
	
	public String getComentarios() {
		
		return sb.toString();
		
	}

}
