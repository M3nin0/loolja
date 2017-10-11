package br.edu.Trabalho1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.UIManager;

public class TelaCompraProduto extends JFrame {

	private JPanel contentPane;

	public TelaCompraProduto(Usuario usuario) {
		setBackground(UIManager.getColor("controlDkShadow"));
		setResizable(false);

		CadastroDeProduto cadastroProduto = new CadastroDeProduto();

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 505, 317);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("controlDkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JRadioButton rdbtnEletrnica = new JRadioButton("Eletrônicos");
		rdbtnEletrnica.setBackground(UIManager.getColor("controlDkShadow"));
		rdbtnEletrnica.setFont(new Font("Sawasdee", Font.BOLD, 14));
		rdbtnEletrnica.setBounds(45, 108, 123, 23);
		contentPane.add(rdbtnEletrnica);

		JRadioButton rdbtnRoupas = new JRadioButton("Roupas");
		rdbtnRoupas.setBackground(UIManager.getColor("controlDkShadow"));
		rdbtnRoupas.setFont(new Font("Sawasdee", Font.BOLD, 14));
		rdbtnRoupas.setBounds(229, 108, 102, 23);
		contentPane.add(rdbtnRoupas);

		JRadioButton rdbtnPets = new JRadioButton("Pets");
		rdbtnPets.setBackground(UIManager.getColor("controlDkShadow"));
		rdbtnPets.setFont(new Font("Sawasdee", Font.BOLD, 14));
		rdbtnPets.setBounds(415, 108, 92, 23);
		contentPane.add(rdbtnPets);

		JLabel lblEscolhaOTipo = new JLabel("Escolha o tipo de item que deseja comprar");
		lblEscolhaOTipo.setFont(new Font("Sawasdee", Font.BOLD, 14));
		lblEscolhaOTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscolhaOTipo.setBounds(90, 35, 323, 40);
		contentPane.add(lblEscolhaOTipo);

		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setFont(new Font("Sawasdee", Font.BOLD, 14));
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String tipo = "";

				if (rdbtnEletrnica.isSelected()) {
					tipo = rdbtnEletrnica.getText();
				} else if (rdbtnRoupas.isSelected()) {
					tipo = rdbtnRoupas.getText();
				} else if (rdbtnPets.isSelected()) {
					tipo = rdbtnPets.getText();
				}

				String produtos = cadastroProduto.listaProduto(tipo);

				int id = Integer
						.parseInt(JOptionPane.showInputDialog("Escolha o id do item a ser comprado\n" + produtos));

				int quantidade = Integer.parseInt(JOptionPane.showInputDialog("O produto escolhido custa "
						+ cadastroProduto.pesquisaValor(id) + " cada únidade, e estão disponiveis para compra "
						+ cadastroProduto.pesquisaQuantidade(id)
						+ " unidades. \nQuantas únidades você deseja comprar ?"));

				if (quantidade > cadastroProduto.pesquisaQuantidade(id)) {
					JOptionPane.showMessageDialog(null,
							"A compra não pode ser efetuada, quantidade acima do disponível");
					return;
				}

				Venda.adicionaVenda(usuario, id);
				Venda.salvaVenda(id, quantidade);

			}
		});
		btnSelecionar.setBounds(195, 190, 117, 25);
		contentPane.add(btnSelecionar);

		ButtonGroup btGroup = new ButtonGroup();
		btGroup.add(rdbtnEletrnica);
		btGroup.add(rdbtnRoupas);
		btGroup.add(rdbtnPets);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Sawasdee", Font.BOLD, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnVoltar.setBounds(195, 220, 117, 25);
		contentPane.add(btnVoltar);
	}
}
