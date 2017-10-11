package br.edu.Trabalho1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class TelaRanking extends JFrame {

	private JPanel contentPane;

	public TelaRanking() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRanking = new JLabel("Ranking");
		lblRanking.setFont(new Font("Sawasdee", Font.BOLD, 14));
		lblRanking.setHorizontalAlignment(SwingConstants.CENTER);
		lblRanking.setBounds(260, 12, 70, 15);
		contentPane.add(lblRanking);

		JLabel lblRanking2 = new JLabel("Os 5 produtos mais vendidos");
		lblRanking2.setFont(new Font("Sawasdee", Font.BOLD, 14));
		lblRanking2.setBounds(190, 39, 231, 35);
		contentPane.add(lblRanking2);

		JLabel lblproduto1 = new JLabel("");
		lblproduto1.setFont(new Font("Sawasdee", Font.BOLD, 14));
		lblproduto1.setHorizontalAlignment(SwingConstants.CENTER);
		lblproduto1.setBounds(226, 116, 137, 29);
		contentPane.add(lblproduto1);

		JLabel lblproduto2 = new JLabel("");
		lblproduto2.setFont(new Font("Sawasdee", Font.BOLD, 14));
		lblproduto2.setHorizontalAlignment(SwingConstants.CENTER);
		lblproduto2.setBounds(260, 164, 70, 15);
		contentPane.add(lblproduto2);

		JLabel lblproduto3 = new JLabel("");
		lblproduto3.setFont(new Font("Sawasdee", Font.BOLD, 14));
		lblproduto3.setHorizontalAlignment(SwingConstants.CENTER);
		lblproduto3.setBounds(260, 210, 70, 15);
		contentPane.add(lblproduto3);

		JLabel lblproduto4 = new JLabel("");
		lblproduto4.setFont(new Font("Sawasdee", Font.BOLD, 14));
		lblproduto4.setHorizontalAlignment(SwingConstants.CENTER);
		lblproduto4.setBounds(260, 258, 70, 15);
		contentPane.add(lblproduto4);

		JLabel lblproduto5 = new JLabel("");
		lblproduto5.setFont(new Font("Sawasdee", Font.BOLD, 14));
		lblproduto5.setHorizontalAlignment(SwingConstants.CENTER);
		lblproduto5.setBounds(260, 303, 70, 15);
		contentPane.add(lblproduto5);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Sawasdee", Font.BOLD, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnVoltar.setBounds(451, 463, 117, 25);
		contentPane.add(btnVoltar);

		JButton btnAtualizarRanking = new JButton("Atualizar ranking");
		btnAtualizarRanking.setFont(new Font("Sawasdee", Font.BOLD, 14));
		btnAtualizarRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				List<String> maiores = new ArrayList<>();

				Ranking rank = new Ranking();
				maiores = rank.getMaior();

				if (maiores.size() < 5) {
					JOptionPane.showMessageDialog(null, "O ranking ainda está sendo atualizado");
				} else {

					lblproduto1.setText(maiores.get(4));
					lblproduto2.setText(maiores.get(3));
					lblproduto3.setText(maiores.get(2));
					lblproduto4.setText(maiores.get(1));
					lblproduto5.setText(maiores.get(0));
				}

			}
		});
		btnAtualizarRanking.setBounds(12, 463, 190, 25);
		contentPane.add(btnAtualizarRanking);
	}
}
