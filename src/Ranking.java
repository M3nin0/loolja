package br.edu.Trabalho1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ranking {

	private List<Produto> maiores = new ArrayList<>();
	private List<String> maioresNomes = new ArrayList<>();

	public List<String> getMaior() {

		maiores = CadastroDeProduto.getProdutos();

		Collections.sort(maiores);

		for (Produto produto : maiores) {

			maioresNomes.add(produto.getNome());
			
		}

		return maioresNomes;
		
	}

}
