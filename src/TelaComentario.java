package br.edu.Trabalho1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class TelaComentario extends JFrame {

	private JPanel contentPane;

	public TelaComentario() {
		setBackground(UIManager.getColor("controlDkShadow"));
		setResizable(false);
		setBounds(100, 100, 567, 615);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("controlDkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAssunto = new JLabel("Assunto");
		lblAssunto.setFont(new Font("Sawasdee", Font.BOLD, 14));
		lblAssunto.setBounds(40, 46, 110, 24);
		contentPane.add(lblAssunto);

		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setFont(new Font("Sawasdee", Font.BOLD, 14));
		lblProduto.setBounds(40, 149, 70, 15);
		contentPane.add(lblProduto);

		JLabel lblComentario = new JLabel("Comentário");
		lblComentario.setFont(new Font("Sawasdee", Font.BOLD, 14));
		lblComentario.setBounds(40, 254, 82, 15);
		contentPane.add(lblComentario);

		JTextPane txtAssunto = new JTextPane();
		txtAssunto.setBounds(128, 39, 206, 33);
		contentPane.add(txtAssunto);

		JTextPane txtProduto = new JTextPane();
		txtProduto.setBounds(128, 139, 206, 33);
		contentPane.add(txtProduto);

		JTextPane txtComentario = new JTextPane();
		txtComentario.setBounds(42, 280, 463, 206);
		contentPane.add(txtComentario);

		JButton btnFazerComentario = new JButton("Fazer comentário");
		btnFazerComentario.setFont(new Font("Sawasdee", Font.BOLD, 14));
		btnFazerComentario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Comentario comment = new Comentario();

				String assunto = txtAssunto.getText();
				int produto = Integer.parseInt(txtProduto.getText());
				String comentario = txtComentario.getText();

				comment.registraComentario(assunto, produto, comentario);
				
				JOptionPane.showMessageDialog(null, "Comentário feito com sucesso!");

			}
		});
		btnFazerComentario.setBounds(375, 550, 180, 25);
		contentPane.add(btnFazerComentario);

		JButton btnVerificarId = new JButton("Verificar ID de produto");
		btnVerificarId.setFont(new Font("Sawasdee", Font.BOLD, 14));
		btnVerificarId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, CadastroDeProduto.listaNomeProduto());

			}
		});
		btnVerificarId.setBounds(12, 550, 211, 25);
		contentPane.add(btnVerificarId);
	}
}
