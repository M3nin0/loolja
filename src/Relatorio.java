package br.edu.Trabalho1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Relatorio implements Report {

	public static void geraRelatorio() {

		File report = new File("./Relatorio.txt");

		try {

			FileWriter fw = new FileWriter(report);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(cdp.geraInformacoes());

			bw.close();
			fw.close();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	public static void geraVendas() {

		File report = new File("./Vendas.txt");

		try {

			FileWriter fw = new FileWriter(report);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(cdp.infosVendas());

			bw.close();
			fw.close();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());

		}

	}

}
