package br.edu.Trabalho1;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	private JPanel contentPane;

	public Menu(Usuario usuario) {
		setBackground(UIManager.getColor("controlDkShadow"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 360);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Compra/Venda de produtos");
		mnNewMenu.setFont(new Font("Sawasdee", Font.BOLD, 14));
		menuBar.add(mnNewMenu);

		JMenuItem btnComprar = new JMenuItem("Comprar produto");
		btnComprar.setFont(new Font("Sawasdee", Font.BOLD, 14));
		mnNewMenu.add(btnComprar);

		JMenuItem btnCadastrarProduto = new JMenuItem("Cadastrar produto para venda");
		btnCadastrarProduto.setFont(new Font("Sawasdee", Font.BOLD, 14));

		if (usuario.getNick().equals("root")) {

			btnCadastrarProduto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto(usuario);
					telaCadastroProduto.setVisible(true);

				}
			});

		}
		mnNewMenu.add(btnCadastrarProduto);
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCompraProduto telaCompraProduto = new TelaCompraProduto(usuario);
				telaCompraProduto.setVisible(true);
			}
		});

		JMenu mnNewMenu_1 = new JMenu("Estatísticas");
		mnNewMenu_1.setFont(new Font("Sawasdee", Font.BOLD, 14));
		menuBar.add(mnNewMenu_1);

		JMenuItem btnProdutosVendidos = new JMenuItem("Produtos vendidos");
		btnProdutosVendidos.setFont(new Font("Sawasdee", Font.BOLD, 14));
		btnProdutosVendidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Relatorio.geraVendas();

				JOptionPane.showMessageDialog(null, "Log de vendas salvo com sucesso!");

			}
		});
		mnNewMenu_1.add(btnProdutosVendidos);

		JMenuItem btnGerarRelatorio = new JMenuItem("Gerar relatório");
		btnGerarRelatorio.setFont(new Font("Sawasdee", Font.BOLD, 14));
		btnGerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Relatorio.geraRelatorio();

				JOptionPane.showMessageDialog(null, "Relatório salvo com sucesso!");

			}
		});
		mnNewMenu_1.add(btnGerarRelatorio);

		JMenuItem mntmRanking = new JMenuItem("Ranking");
		mntmRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRanking tr = new TelaRanking();
				tr.setVisible(true);
			}
		});
		mntmRanking.setFont(new Font("Sawasdee", Font.BOLD, 14));
		mnNewMenu_1.add(mntmRanking);

		JMenu mnNewMenu_2 = new JMenu("Comunidade");
		mnNewMenu_2.setFont(new Font("Sawasdee", Font.BOLD, 14));
		menuBar.add(mnNewMenu_2);

		JMenuItem btnMenuComunidade = new JMenuItem("Comunidade");
		btnMenuComunidade.setFont(new Font("Sawasdee", Font.BOLD, 14));
		mnNewMenu_2.add(btnMenuComunidade);
		btnMenuComunidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuComunidade menuComunidade = new MenuComunidade();

				menuComunidade.setVisible(true);

			}
		});

		JMenuItem btnRecomendacoes = new JMenuItem("Recomendações");
		btnRecomendacoes.setFont(new Font("Sawasdee", Font.BOLD, 14));
		btnRecomendacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRecomendacao telaRecomend = new TelaRecomendacao(usuario);

				telaRecomend.setVisible(true);
			}
		});
		menuBar.add(btnRecomendacoes);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setFont(new Font("Sawasdee", Font.BOLD, 14));
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Login login = new Login();

				setVisible(false);

				login.setVisible(true);

			}

		});
		menuBar.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("controlDkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel label = new JLabel("");
		label.setBackground(UIManager.getColor("controlDkShadow"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(
				"./assents/rsz_48e42fba70becce83a35fd88be6d589f--cone-do-servi-o-rodada-de-compras-by-vexels.png"));
		contentPane.add(label, BorderLayout.CENTER);
	}

}
