package br.edu.Trabalho1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class TelaVerificaComentario extends JFrame {

	private JPanel contentPane;

	public TelaVerificaComentario() {
		setResizable(false);
		setBounds(100, 100, 591, 609);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("controlDkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextPane lblComentarios = new JTextPane();
		lblComentarios.setEditable(false);
		lblComentarios.setBounds(54, 55, 483, 451);
		contentPane.add(lblComentarios);

		JLabel lblUltimosComentrios = new JLabel("Ultimos comentários");
		lblUltimosComentrios.setFont(new Font("Sawasdee", Font.BOLD, 14));
		lblUltimosComentrios.setBounds(229, 28, 160, 15);
		contentPane.add(lblUltimosComentrios);

		Comentario comentario = new Comentario();

		lblComentarios.setText(comentario.getComentarios());

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnVoltar.setBounds(462, 543, 117, 25);
		contentPane.add(btnVoltar);

	}
}
