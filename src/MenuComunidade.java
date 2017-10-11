package br.edu.Trabalho1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class MenuComunidade extends JFrame {

	private JPanel contentPane;

	public MenuComunidade() {
		setResizable(false);
		setBackground(UIManager.getColor("controlDkShadow"));
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("controlDkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnFazerComentario = new JButton("Fazer Comentario");
		btnFazerComentario.setFont(new Font("Sawasdee", Font.BOLD, 14));
		btnFazerComentario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaComentario tc = new TelaComentario();
				tc.setVisible(true);
			}
		});
		btnFazerComentario.setBounds(105, 116, 205, 25);
		contentPane.add(btnFazerComentario);

		JButton btnLerComentarios = new JButton("Ler comentarios");
		btnLerComentarios.setFont(new Font("Sawasdee", Font.BOLD, 14));
		btnLerComentarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaVerificaComentario tvc = new TelaVerificaComentario();
				tvc.setVisible(true);

			}
		});
		btnLerComentarios.setBounds(128, 140, 171, 25);
		contentPane.add(btnLerComentarios);

		JLabel lblComunidade = new JLabel("Comunidade");
		lblComunidade.setFont(new Font("Sawasdee", Font.BOLD, 14));
		lblComunidade.setBounds(169, 12, 196, 56);
		contentPane.add(lblComunidade);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnVoltar.setFont(new Font("Sawasdee", Font.BOLD, 14));
		btnVoltar.setBounds(321, 234, 117, 25);
		contentPane.add(btnVoltar);
	}
}
