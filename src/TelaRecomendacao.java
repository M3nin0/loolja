package br.edu.Trabalho1;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class TelaRecomendacao extends JFrame {

	private JPanel contentPane;

	public TelaRecomendacao(Usuario usuario) {
		setBackground(UIManager.getColor("controlDkShadow"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 483, 564);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("controlDkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTendoEmVista = new JLabel("Tendo em vista suas compras recomendo para você os produtos");
		lblTendoEmVista.setFont(new Font("Sawasdee", Font.BOLD, 14));
		lblTendoEmVista.setHorizontalAlignment(SwingConstants.CENTER);
		lblTendoEmVista.setBounds(12, 43, 455, 21);
		contentPane.add(lblTendoEmVista);

		JLabel lblSetTipo = new JLabel("");
		lblSetTipo.setFont(new Font("Sawasdee", Font.BOLD, 14));
		lblSetTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetTipo.setBounds(165, 105, 151, 36);
		contentPane.add(lblSetTipo);

		JTextPane txtComentarios = new JTextPane();
		txtComentarios.setEditable(false);
		txtComentarios.setBounds(36, 153, 415, 356);
		contentPane.add(txtComentarios);

		Recomendacao recommend = new Recomendacao();

		lblSetTipo.setText(recommend.fazRecomendacao(usuario));
		txtComentarios.setText(CadastroDeProduto.listaProdutoEspecifico(recommend.fazRecomendacao(usuario)));

	}

}
