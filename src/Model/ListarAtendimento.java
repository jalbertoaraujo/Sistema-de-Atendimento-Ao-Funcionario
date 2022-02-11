package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Controler.DadosDBCadastro;
import Controler.DadosDBCadastro2;
import View.Email;
import View.Principal;
import View.Principal2;
import View.Relacao;


public class ListarAtendimento {

	public static ArrayList<DadosDBCadastro> dados = new ArrayList<DadosDBCadastro>();

	private ArrayList<DadosDBCadastro> RelatorioBD = new ArrayList<>();

	public ArrayList<DadosDBCadastro> getRelatorioBD() {
		return RelatorioBD;
	}

	public void setRelatorioBD(ArrayList<DadosDBCadastro> relatorioBD) {
		RelatorioBD = relatorioBD;
	}

	public List<DadosDBCadastro> listar() {

		List<DadosDBCadastro> lista = new ArrayList<DadosDBCadastro>();

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://192.168.254.13/Atendimento", "postgres",
					"admin");
			java.sql.Statement st = con.createStatement();

			if (((String) Principal.tfdatabusca.getText()).equals("todos"))
				st.executeQuery("select * from atendimento");
			else
				st.executeQuery("Select * from atendimento where data = '"
						+ (String) Principal.tfdatabusca.getText() + "' and setoratendente = '"+ Principal.tfsetoratendente.getText()+"'");
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				lista.add(new DadosDBCadastro(rs.getInt(1), rs.getString(2), rs
						.getString(3), rs.getString(4), rs.getString(5), rs
						.getString(6), rs.getString(7), rs.getString(8), rs
						.getString(9), rs.getString(10), rs.getString(11), rs
						.getString(12), rs.getString(13), rs.getString(14)));
			}

			con.close();
			rs.close();

			return lista;

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block

			// e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"Erro ao Preencher a Tabela de Situação de Busca");
		}

		return lista;

	}

	public List<DadosDBCadastro> listaatendimento() {		
		
		Principal.tfdatabusca.setText((String) Principal.tfdatabusca.getText());

	    ArrayList<DadosDBCadastro> dados = new ArrayList<DadosDBCadastro>();

		DefaultTableModel model = (DefaultTableModel) Principal.table
				.getModel();		

		if (Principal.tfdatabusca.getText() != null) {
			if (!((String) Principal.tfdatabusca.getText()).equals("")) {
				try {
					Class.forName("org.postgresql.Driver");
					Connection con = DriverManager.getConnection(
							"jdbc:postgresql://192.168.254.13/Atendimento",
							"postgres", "admin");
					java.sql.Statement st = con.createStatement();

					if (((String) Principal.tfdatabusca.getText())
							.equals("todos"))
						st.executeQuery("select * from atendimento");
					else
						st.executeQuery("Select * from atendimento where data = '"
								+ Principal.tfdatabusca.getText()
								+ "'and setoratendente = '"+ Principal.tfsetoratendente.getText()+"'");
					ResultSet rs = st.getResultSet();
					while (rs.next()) {
						dados.add(new DadosDBCadastro(rs.getInt(1), rs
								.getString(2), rs.getString(3),
								rs.getString(4), rs.getString(5), rs
										.getString(6), rs.getString(7), rs
										.getString(8), rs.getString(9), rs
										.getString(10), rs.getString(11), rs
										.getString(12), rs.getString(13), rs.getString(14)));
					}
					con.close();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					JOptionPane.showMessageDialog(null,
							"Erro ao Preencher a Tabela de Situação de Busca");
				}
				
				for (; model.getRowCount() > 0;)
					model.removeRow(0);

				for (DadosDBCadastro temp : dados) {
					Object[] linha = { temp.getId_atendimento(),
							temp.getHora(), temp.getData(),
							temp.getAtendente(), temp.getNomecol(),
							temp.getMatricula(), temp.getCpf(),
							temp.getContrato(), temp.getFone(),
							temp.getFone2(), temp.getSetor(),
							temp.getPendencia(), temp.getSetoratendente(), temp.getEnviado() };
					model.addRow(linha);
				}
			} else {
				for (; model.getRowCount() > 0;)
					model.removeRow(0);
			}
			setRelatorioBD(dados);			
		}
		return dados;
		

	}

	public void listaatendimentopornome() {

		Principal.tfnomecol.setText((String) Principal.tfnomecol.getText());

		ArrayList<DadosDBCadastro> dados = new ArrayList();

		DefaultTableModel model = (DefaultTableModel) Principal.table
				.getModel();

		if (Principal.tfnomecol.getText() != null) {
			if (!((String) Principal.tfnomecol.getText()).equals("")) {
				try {
					Class.forName("org.postgresql.Driver");
					Connection con = DriverManager.getConnection(
							"jdbc:postgresql://192.168.254.13/Atendimento",
							"postgres", "admin");
					java.sql.Statement st = con.createStatement();

					if (((String) Principal.tfnomecol.getText())
							.equals("TODOS"))
						st.executeQuery("select * from atendimento");
					else
						st.executeQuery("select * from atendimento where nome like '%"
								+ (String) Principal.tfnomecol.getText() + "%' and setoratendente = '"+ Principal.tfsetoratendente.getText().toString()+"'");
					ResultSet rs = st.getResultSet();
					while (rs.next()) {
						dados.add(new DadosDBCadastro(rs.getInt(1), rs
								.getString(2), rs.getString(3),
								rs.getString(4), rs.getString(5), rs
										.getString(6), rs.getString(7), rs
										.getString(8), rs.getString(9), rs
										.getString(10), rs.getString(11), rs
										.getString(12), rs.getString(13), rs.getString(14)));
					}
					if (dados.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Não Existe Atendimento Para este Colaborador !");
					}
					con.close();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					JOptionPane.showMessageDialog(null,
							"Erro ao Preencher a Tabela de Situação de Busca");
				}

				for (; model.getRowCount() > 0;)
					model.removeRow(0);

				for (DadosDBCadastro temp : dados) {
					Object[] linha = { temp.getId_atendimento(),
							temp.getHora(), temp.getData(),
							temp.getAtendente(), temp.getNomecol(),
							temp.getMatricula(), temp.getCpf(),
							temp.getContrato(), temp.getFone(),
							temp.getFone2(), temp.getSetor(),
							temp.getPendencia(), temp.getSetoratendente(), temp.getEnviado() };
					model.addRow(linha);
				}

			} else {
				for (; model.getRowCount() > 0;)
					model.removeRow(0);
			}
			setRelatorioBD(dados);
		}

	}
	
	public void retornanumero() {
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/Atendimento", "postgres",
					"admin");
			java.sql.Statement st = con.createStatement();
			st.executeQuery("select id_email from email order by id_email desc limit 1");
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				int ult = rs.getInt("id_email") + 1;
				Email.tfnumeroemail.setText("" + ult);
			}
			con.close();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro");
		}
	
	}
	
	public void povoarlista(){
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.254.13/Atendimento", "postgres",
					"admin");
			java.sql.Statement st = con.createStatement();
			st.executeQuery("select (email) from email order by email");
			List <String>dados = new ArrayList <String>();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				
				dados.add(rs.getString("email"));
			}
			Relacao.listaemail.setListData(dados.toArray());			
			con.close();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro");
		}	
		
	}

}
