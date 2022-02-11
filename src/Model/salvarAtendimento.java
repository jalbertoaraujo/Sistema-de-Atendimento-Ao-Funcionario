package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import View.Email;
import View.Principal;

public class salvarAtendimento {
	
	public void salvaatendimento() {
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://192.168.254.13/Atendimento",
					"postgres", "admin");
			PreparedStatement stmt = con
					.prepareStatement("INSERT INTO atendimento (hora,data,atendente,nome,matricula,cpf,contrato,fone,fone2,setor,pendencia,setoratendente,enviado) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
									
			stmt.setString(1, (String) Principal.tfhora.getText());
			stmt.setString(2, (String) Principal.tfdata.getText());
			stmt.setString(3, (String) Principal.tfatendente.getText());
			stmt.setString(4, (String) Principal.tfnomecol.getText());
			stmt.setString(5, (String) Principal.tfmat.getText());
			stmt.setString(6, (String) Principal.tfcpf.getText());
			stmt.setString(7, (String) Principal.tfcontrato.getText());
			stmt.setString(8, (String) Principal.tffone.getText());
			stmt.setString(9, (String) Principal.tffone2.getText());
			stmt.setString(10, (String) Principal.tfsetor.getText());
			stmt.setString(11, (String) Principal.textArea.getText());
			stmt.setString(12, (String) Principal.tfsetoratendente.getText().toString());
			stmt.setString(13, (String) Principal.tfenviado.getText());
			stmt.execute();
			stmt.close();
			con.close();
			JOptionPane.showMessageDialog(null,
					"Atendimento cadastrado com Sucesso");						
			Principal.tfnomecol.setText("");
			Principal.tfmat.setText("");
			Principal.tfcpf.setText("");
			Principal.tfcontrato.setText("");
			Principal.tffone.setText("");
			Principal.tffone2.setText("");
			Principal.tfsetor.setText("");
			Principal.textArea.setText("");
			Principal.tfatendente.requestFocus();
			Principal.tfhora.setText(new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis())));

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			JOptionPane
					.showMessageDialog(null, "Erro ao Cadastrar o Atendimento" + e);
		}
	}
		
		public void salvaemail() {
			
			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection(
						"jdbc:postgresql://192.168.254.13/Atendimento",
						"postgres", "admin");
				PreparedStatement stmt = con
						.prepareStatement("INSERT INTO email (id_email,email) VALUES(?,?)");
										
				stmt.setInt(1, Integer.parseInt( Email.tfnumeroemail.getText()));
				stmt.setString(2, (String) Email.tfemail.getText());			
				stmt.execute();
				stmt.close();
				con.close();
				JOptionPane.showMessageDialog(null,
						"Novo E-mail cadastrado com Sucesso");						
				Email.tfemail.setText("");


			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				JOptionPane
						.showMessageDialog(null, "Erro ao Cadastrar o Novo E-mail" + e);
			}		
	
	}

}
