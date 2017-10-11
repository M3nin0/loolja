package br.edu.Trabalho1;

import javax.swing.JOptionPane;

public class Venda {

	// Gera log com as vendas
	public static void salvaVenda(int id, int quantidade) {

		for (Produto produto : CadastroDeProduto.getProdutos()) {
			if (produto.getId() == id) {

				CadastroDeProduto.getVendasRealizadas().append("\n");
				CadastroDeProduto.getVendasRealizadas().append("Venda realizada com sucesso: \n");
				CadastroDeProduto.getVendasRealizadas().append("Produto: ");
				CadastroDeProduto.getVendasRealizadas().append(produto.getNome());
				CadastroDeProduto.getVendasRealizadas().append("\n");
				CadastroDeProduto.getVendasRealizadas().append("No valor de: ");
				CadastroDeProduto.getVendasRealizadas().append(produto.getValorPorUnidade() * quantidade);

				produto.setQuantidade(produto.getQuantidade() - quantidade);
				produto.setQuantidadeVendida(produto.getQuantidadeVendida() + 1);

				JOptionPane.showMessageDialog(null, "Compra realizada com sucesso!");
			}
		}

	}

	// Adiciona ponto ao tipo comprado, para gerar as recomendações
	public static void adicionaVenda(Usuario usuario, int id) {

		for (Produto produto : CadastroDeProduto.getProdutos()) {

			if (produto.getId() == id) {

				usuario.setTipoComprado(produto.getTipo());

			}

		}

	}

}
