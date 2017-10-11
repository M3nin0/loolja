package br.edu.Trabalho1;

import java.util.ArrayList;
import java.util.List;

public class Recomendacao {

	public String fazRecomendacao(Usuario usuario) {

		List<String> tiposComprados = new ArrayList<>();

		tiposComprados = usuario.getTipoComprado();

		int eletronico = 0;
		int roupas = 0;
		int pets = 0;

		for (String tipos : tiposComprados) {

			if (tipos.equals("Eletrônicos")) {
				eletronico++;
			} else if (tipos.equals("Roupas")) {
				roupas++;
			} else if (tipos.equals("pets")) {
				pets++;
			}

		}
		
		if(eletronico > roupas && eletronico > pets) {
			return "Eletrônicos";
		} else if (roupas > eletronico && roupas > pets) {
			return "Roupas";
		} else if (pets > eletronico && pets > roupas) {
			return "Pets";
		} else {
			return "";
		}

	}

}
