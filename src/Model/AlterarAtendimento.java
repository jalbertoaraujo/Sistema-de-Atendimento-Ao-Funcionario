package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import View.Principal;
import View.Principal2;

public class AlterarAtendimento {
	
	public void alteraratendimento() {
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://192.168.254.13/Atendimento",
					"postgres", "admin");
			PreparedStatement stmt = con
					.prepareStatement("UPDATE atendimento set enviado = 'SIM' WHERE matricula = '"+ Principal2.tfmat.getText() +"' and data = '"+ Principal2.tfdata.getText() +"'");
			stmt.execute();
			stmt.close();
			con.close();
			JOptionPane.showMessageDialog(null,
					"Atendimento alterado com Sucesso");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			JOptionPane
					.showMessageDialog(null, "Erro Em Alterar o Atendimento" + e);
		}
	}	
}
