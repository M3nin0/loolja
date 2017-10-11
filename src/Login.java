package br.edu.Trabalho1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField cmpPassword;

	static Login login = new Login();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public boolean verificaLogin(String usuario, String cs) {

		List<Usuario> usuarios = new ArrayList<>();
		usuarios = CadastroDeUsuario.getUsuarios();

		for (Usuario user : usuarios) {

			if (user.getNick().equals(usuario)) {

				CadastroDeProduto.recuperaProdutos();

				if (user.getPassword().equals(cs)) {
					return true;
				}
			}

		}
		return false;

	}

	public Usuario criaSessao(String nick) {

		List<Usuario> usuarios = new ArrayList<>();
		usuarios = CadastroDeUsuario.getUsuarios();

		for (Usuario user : usuarios) {
			if (user.getNick().equals(nick)) {
				return user;
			}
		}
		return new Usuario(null);
	}

	public Login() {
		setBackground(UIManager.getColor("controlDkShadow"));

		CadastroDeUsuario cadastro = new CadastroDeUsuario();

		cadastro.criaArquivos();
		cadastro.persisteId(2);
		cadastro.persisteUsuario(2);

		setForeground(UIManager.getColor("Button.darkShadow"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 572);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("controlDkShadow"));
		contentPane.setForeground(UIManager.getColor("Button.darkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Sawasdee", Font.BOLD, 14));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(175, 496, 80, 25);
		contentPane.add(btnSair);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(
				"./assents/rsz_48e42fba70becce83a35fd88be6d589f--cone-do-servi-o-rodada-de-compras-by-vexels.png"));
		lblNewLabel.setBounds(116, 30, 207, 145);
		contentPane.add(lblNewLabel);

		JLabel lblUsurio = new JLabel("Usuário");
		lblUsurio.setFont(new Font("Sawasdee", Font.BOLD, 14));
		lblUsurio.setBounds(79, 210, 117, 49);
		contentPane.add(lblUsurio);

		JTextPane cmpLogin = new JTextPane();
		cmpLogin.setBounds(149, 222, 174, 29);
		contentPane.add(cmpLogin);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Sawasdee", Font.BOLD, 14));
		lblSenha.setBounds(79, 271, 70, 49);
		contentPane.add(lblSenha);

		cmpPassword = new JPasswordField();
		cmpPassword.setBounds(149, 281, 174, 29);
		contentPane.add(cmpPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Sawasdee", Font.BOLD, 14));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (verificaLogin(cmpLogin.getText(), cmpPassword.getText())) {
					setVisible(false);
					Menu frame = new Menu(criaSessao(cmpLogin.getText()));
					frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Login ou senha incorreto");
				}

			}
		});
		btnLogin.setBounds(159, 379, 117, 25);
		contentPane.add(btnLogin);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Sawasdee", Font.BOLD, 14));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastro.cadastraUsuario();
			}
		});
		btnCadastrar.setBounds(159, 416, 117, 25);
		contentPane.add(btnCadastrar);

	}
}
