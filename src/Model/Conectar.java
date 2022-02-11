package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class Conectar {

	public static Connection getConnection(){
		
		try {
			
			return DriverManager.getConnection("jdbc:postgresql://192.168.254.13/Atendimento", "postgres", "admin");
		
		} catch (SQLException e) {
		
			throw new RuntimeException(e);
		}
	}

	public Object executeSQL;
	public ResultSet resultset;

	public void executeSQL(String string) {
		// TODO Auto-generated method stub
		
	}
}
