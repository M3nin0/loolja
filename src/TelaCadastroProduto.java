package br.edu.Trabalho1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class TelaCadastroProduto extends JFrame {

	private JPanel contentPane;
	private CadastroDeProduto cadastro = new CadastroDeProduto();

	public TelaCadastroProduto(Usuario usuario) {
		setResizable(false);

		cadastro.criaArquivos();
		cadastro.persisteId(2);

		setBounds(100, 100, 486, 653);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("controlDkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEscolhaOTipo = new JLabel("Escolha o tipo de produto que deseja cadastrar");
		lblEscolhaOTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscolhaOTipo.setFont(new Font("Sawasdee", Font.BOLD, 14));
		lblEscolhaOTipo.setBounds(65, 33, 360, 46);
		contentPane.add(lblEscolhaOTipo);

		JRadioButton rdbtnEletrnicos = new JRadioButton("Eletrônicos");
		rdbtnEletrnicos.setBackground(UIManager.getColor("controlDkShadow"));
		rdbtnEletrnicos.setFont(new Font("Sawasdee", Font.BOLD, 14));
		rdbtnEletrnicos.setBounds(38, 125, 149, 23);
		contentPane.add(rdbtnEletrnicos);

		JRadioButton rdbtnRoupas = new JRadioButton("Roupas");
		rdbtnRoupas.setBackground(UIManager.getColor("controlDkShadow"));
		rdbtnRoupas.setFont(new Font("Sawasdee", Font.BOLD, 14));
		rdbtnRoupas.setBounds(202, 125, 133, 23);
		contentPane.add(rdbtnRoupas);

		JRadioButton rdbtnPets = new JRadioButton("Pets");
		rdbtnPets.setBackground(UIManager.getColor("controlDkShadow"));
		rdbtnPets.setFont(new Font("Sawasdee", Font.BOLD, 14));
		rdbtnPets.setBounds(360, 125, 133, 23);
		contentPane.add(rdbtnPets);

		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnPets);
		radioGroup.add(rdbtnRoupas);
		radioGroup.add(rdbtnEletrnicos);

		JLabel lblNomeDoProduto = new JLabel("Nome do produto");
		lblNomeDoProduto.setFont(new Font("Sawasdee", Font.BOLD, 14));
		lblNomeDoProduto.setBounds(68, 209, 149, 25);
		contentPane.add(lblNomeDoProduto);

		JTextPane txtNomeProduto = new JTextPane();
		txtNomeProduto.setBounds(202, 209, 187, 25);
		contentPane.add(txtNomeProduto);

		JLabel lblMarcaDoProduto = new JLabel("Marca do produto");
		lblMarcaDoProduto.setFont(new Font("Sawasdee", Font.BOLD, 14));
		lblMarcaDoProduto.setBounds(68, 267, 131, 15);
		contentPane.add(lblMarcaDoProduto);

		JTextPane txtMarcaProduto = new JTextPane();
		txtMarcaProduto.setBounds(202, 261, 187, 25);
		contentPane.add(txtMarcaProduto);

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Sawasdee", Font.BOLD, 14));
		lblQuantidade.setBounds(86, 319, 95, 15);
		contentPane.add(lblQuantidade);

		JTextPane txtQuantidade = new JTextPane();
		txtQuantidade.setBounds(168, 313, 45, 24);
		contentPane.add(txtQuantidade);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Sawasdee", Font.BOLD, 14));
		lblValor.setBounds(257, 315, 70, 20);
		contentPane.add(lblValor);

		JTextPane txtValor = new JTextPane();
		txtValor.setBounds(300, 313, 45, 24);
		contentPane.add(txtValor);

		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setFont(new Font("Sawasdee", Font.BOLD, 14));
		lblDescrio.setBounds(40, 456, 70, 15);
		contentPane.add(lblDescrio);

		JTextPane txtDescricao = new JTextPane();
		txtDescricao.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtDescricao.setBounds(129, 375, 289, 188);
		contentPane.add(txtDescricao);

		JLabel lblSession = new JLabel("Session");
		lblSession.setFont(new Font("Sawasdee", Font.BOLD, 14));
		lblSession.setBounds(12, 12, 299, 15);
		contentPane.add(lblSession);
		lblSession.setText("Session: " + usuario.getNome());

		JButton btnEscolher = new JButton("Cadastrar");
		btnEscolher.setFont(new Font("Sawasdee", Font.BOLD, 14));
		btnEscolher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String tipo = "";

				if (rdbtnEletrnicos.isSelected()) {
					tipo = rdbtnEletrnicos.getText();
				} else if (rdbtnRoupas.isSelected()) {
					tipo = rdbtnRoupas.getText();
				} else if (rdbtnPets.isSelected()) {
					tipo = rdbtnPets.getText();
				}

				cadastro.cadastraProduto(usuario, txtNomeProduto.getText(), Double.parseDouble(txtQuantidade.getText()),
						txtMarcaProduto.getText(), tipo, txtDescricao.getText(),
						Double.parseDouble(txtValor.getText()));
				cadastro.salvaProdutos();
				
				int escolha = JOptionPane.showConfirmDialog(null,
						"Cadastro feito com sucesso!\nDeseja cadastrar outro produto ?", "Questão",
						JOptionPane.YES_NO_OPTION);

				if (escolha == JOptionPane.YES_OPTION) {
					txtNomeProduto.setText("");
					txtQuantidade.setText("");
					txtMarcaProduto.setText("");
					tipo = "";
					txtDescricao.setText("");
					txtValor.setText("");
				} else if (escolha == JOptionPane.NO_OPTION) {
					setVisible(false);
				}

			}
		});

		btnEscolher.setBounds(191, 575, 117, 25);
		contentPane.add(btnEscolher);

	}

}
