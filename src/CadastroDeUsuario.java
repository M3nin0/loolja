package br.edu.Trabalho1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class CadastroDeUsuario implements Salvar {

	Date data = new Date();

	private static List<Usuario> usuarios = new ArrayList<>();
	private static int ids;

	public void criaArquivos() {

		File fIds = new File("./id.key");
		File usersps = new File("./user.passwd");
		File log = new File("./log_" + data.getTime() + ".log");

		if (!fIds.exists()) {

			try {

				FileWriter fw = new FileWriter(fIds);
				BufferedWriter bw = new BufferedWriter(fw);

				bw.write("\n");
				bw.write("1");

				bw.close();
				fw.close();

			} catch (IOException e) {

				try {
					FileWriter fw = new FileWriter(log);
					BufferedWriter bw = new BufferedWriter(fw);

					bw.write(e.getMessage());

					fw.close();
					bw.close();

				} catch (Exception er) {
					JOptionPane.showMessageDialog(null, "Falha ao criar os arquivos utilizados pelo sistema");
				}

			}
		}
		if (!usersps.exists()) {

			try {
				usersps.createNewFile();

			} catch (IOException e) {

				try {
					FileWriter fw = new FileWriter(log);
					BufferedWriter bw = new BufferedWriter(fw);

					bw.write(e.getMessage());

					fw.close();
					bw.close();

				} catch (Exception er) {
					JOptionPane.showMessageDialog(null, "Falha ao criar os arquivos utilizados pelo sistema");
				}

			}

		}

	}

	public void persisteId(int opt) {

		// opt 1 == Salva
		// opt 2 == Recupera

		if (opt == 1) {

			File file = new File("./id.key");
			StringBuffer sb = new StringBuffer();

			try {
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);

				sb.append("\n");
				sb.append(ids);

				bw.write(sb.toString());

				bw.close();
				fw.close();

			} catch (IOException e) {

			}

		} else if (opt == 2) {

			File file = new File("./id.key");

			try {

				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);

				while ((br.readLine()) != null) {
					CadastroDeUsuario.ids = Integer.parseInt(br.readLine());
				}

				br.close();
				fr.close();

			} catch (IOException e) {

			}

		}

	}

	@SuppressWarnings("unchecked")
	public void persisteUsuario(int opt) {

		// opt 1 == Salva
		// opt 2 == Recupera
		
		if (opt == 1) {

			try {
				FileOutputStream fos = new FileOutputStream("./user.passwd");
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(usuarios);

				fos.close();
				oos.close();

			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			} catch (ObjectStreamException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

		} else if (opt == 2) {

			try {
				FileInputStream fis = new FileInputStream("./user.passwd");
				ObjectInputStream ois = new ObjectInputStream(fis);

				usuarios = (List<Usuario>) ois.readObject();

				ois.close();
				fis.close();

				// Adição do root
				usuarios.add(new Usuario("root", "root", "toor", "admin@localhost", 000));

			} catch (IOException e) {
				usuarios.add(new Usuario("root", "root", "toor", "admin@localhost", 000));
				JOptionPane.showMessageDialog(null, e.getMessage());
			} catch (ClassNotFoundException e) {
				usuarios.add(new Usuario("root", "root", "toor", "admin@localhost", 000));
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
	}

	public void cadastraUsuario() {

		String nome = JOptionPane.showInputDialog("Insira seu nome completo");
		String nick = JOptionPane.showInputDialog("Insira seu nickname");
		String password = JOptionPane.showInputDialog("Insira sua senha");
		String email = JOptionPane.showInputDialog("Insira seu email");

		if (usuarios.size() != 0) {

			for (Usuario usuario : usuarios) {
				if (usuario.getNick().equals(nick)) {
					JOptionPane.showMessageDialog(null, "Nickname já cadastrado");
					return;
				}
				if (usuario.getEmail().equals(email)) {
					JOptionPane.showMessageDialog(null, "Email já cadastrado");
					return;
				}

			}
			usuarios.add(new Usuario(nome, nick, password, email, ids));
			ids++;
			this.persisteUsuario(1);
			this.persisteId(1);
		}

	}

	public static List<Usuario> getUsuarios() {
		return usuarios;
	}

	public static void setUsuarios(List<Usuario> usuarios) {
		CadastroDeUsuario.usuarios = usuarios;
	}

}
