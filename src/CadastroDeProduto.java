package br.edu.Trabalho1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class CadastroDeProduto implements Salvar {

	private static List<Produto> produtos = new ArrayList<>();
	private static StringBuffer vendasRealizadas = new StringBuffer();
	private static int index = 0;

	public static List<Produto> getProdutos() {
		return produtos;
	}

	public static void setProdutos(List<Produto> produtos) {
		CadastroDeProduto.produtos = produtos;
	}

	public static StringBuffer getVendasRealizadas() {
		return vendasRealizadas;
	}

	public static void setVendasRealizadas(StringBuffer vendasRealizadas) {
		CadastroDeProduto.vendasRealizadas = vendasRealizadas;
	}

	public void cadastraProduto(Usuario usuario, String nome, double quantidade, String marca, String tipo,
			String descricao, double valorPorUnidade) {

		produtos.add(new Produto(nome, quantidade, marca, tipo, descricao, valorPorUnidade, index));

		CadastroDeProduto.index++;

		System.out.println(index);

		persisteId(1);

	}

	public String listaProduto(String tipo) {

		if (tipo.equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione um tipo de produto");
		}

		StringBuffer sb = new StringBuffer();

		for (Produto produto : produtos) {

			if (produto.getTipo().equals(tipo)) {
				sb.append("\n");
				sb.append("ID: ");
				sb.append(produto.getId());
				sb.append("\n");
				sb.append("Nome: ");
				sb.append(produto.getNome());
				sb.append("\n");
				sb.append("Marca: ");
				sb.append(produto.getMarca());
				sb.append("\n");
				sb.append("Valor (Por unidade): ");
				sb.append(produto.getValorPorUnidade());
				sb.append("\n");
				sb.append("Descrição: ");
				sb.append("\n");
				sb.append(produto.getDescricao());
				sb.append("\n");
			}

		}

		return sb.toString();

	}

	public static String listaNomeProduto() {

		StringBuffer sb = new StringBuffer();

		for (Produto produto : produtos) {

			sb.append("\n");
			sb.append("Nome: ");
			sb.append(produto.getNome());
			sb.append("\n");
			sb.append("ID: ");
			sb.append(produto.getId());
			sb.append("\n");

		}

		// JOptionPane.showMessageDialog(null, sb.toString());

		return sb.toString();

	}

	public static String listaProdutoEspecifico(String tipo) {

		StringBuffer sb = new StringBuffer();

		for (Produto produto : produtos) {

			if (produto.getTipo().equals(tipo)) {

				sb.append("\n");
				sb.append("Nome: ");
				sb.append(produto.getNome());
				sb.append("\n");
				sb.append("ID: ");
				sb.append(produto.getId());
				sb.append("\n");
			}
		}

		return sb.toString();
	}

	@Override
	// Método para manter os ids salvos
	public void persisteId(int opt) {

		// 1 - Salva
		// 2 - Recupera

		if (opt == 1) {

			File file = new File("./ids.txt");
			StringBuilder sb = new StringBuilder();

			try {
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);

				sb.append("\n");
				sb.append(CadastroDeProduto.index);

				bw.write(sb.toString());

				bw.close();
				fw.close();

			} catch (IOException e) {

				JOptionPane.showMessageDialog(null, e.getMessage());

			}

		} else if (opt == 2) {

			File file = new File("./ids.txt");

			try {
				FileReader reader = new FileReader(file);
				BufferedReader br = new BufferedReader(reader);

				while ((br.readLine()) != null) {

					CadastroDeProduto.index = Integer.parseInt(br.readLine());

				}

				br.close();
				reader.close();

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

		}

	}

	@Override
	// Método para criar os arquivos, e
	// evitar que erros sejam exibidos ao usuários
	public void criaArquivos() {

		File file = new File("./ids.txt");

		if (!file.exists()) {

			try {

				FileWriter fw = new FileWriter(file);
				BufferedWriter gera = new BufferedWriter(fw);

				gera.write("\n");
				gera.write("0");

				gera.close();
				fw.close();

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

		}

	}

	public double pesquisaValor(int id) {

		for (Produto produto : produtos) {
			if (produto.getId() == id) {
				return produto.getValorPorUnidade();
			}
		}

		return 0.00;

	}

	public double pesquisaQuantidade(int id) {

		for (Produto produto : produtos) {
			if (produto.getId() == id) {
				return produto.getQuantidade();
			}
		}
		return 0.00;
	}

	// Gera produtos String tratada com produtos que estão no estoque
	public String consultaEstoque() {

		StringBuffer consultaEstoque = new StringBuffer();

		for (Produto produto : produtos) {

			if (produto.getQuantidade() > 0) {

				consultaEstoque.append("\n");
				consultaEstoque.append("Produto: ");
				consultaEstoque.append(produto.getNome());
				consultaEstoque.append("\n");
				consultaEstoque.append("Quantidade: ");
				consultaEstoque.append("\n");
				consultaEstoque.append(produto.getQuantidade());
				consultaEstoque.append("\n");

			}

		}

		return consultaEstoque.toString();

	}

	// Mostra Informações sobre os produtos (Para relatório)
	public String geraInformacoes() {

		StringBuffer toReport = new StringBuffer();

		toReport.append("Itens em estoque: \n");
		toReport.append(consultaEstoque());
		toReport.append("\n");
		toReport.append("Vendas realizadas");
		toReport.append(vendasRealizadas.toString());
		toReport.append("\n");

		return toReport.toString();

	}

	public String infosVendas() {

		return vendasRealizadas.toString();

	}

	public static void salvaProdutos() {

		try {

			FileOutputStream fos = new FileOutputStream("./produtos.db");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(getProdutos());

			oos.close();
			fos.close();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	public static void recuperaProdutos() {

		File file = new File("./produtos.db");

		try {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		try {
			FileInputStream fis = new FileInputStream("./produtos.db");
			ObjectInputStream ois = new ObjectInputStream(fis);

			List<Produto> produtos = (List<Produto>) ois.readObject();

			CadastroDeProduto.setProdutos(produtos);

			ois.close();
			fis.close();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());

		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

}
