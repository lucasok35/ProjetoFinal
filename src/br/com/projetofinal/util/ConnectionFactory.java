package br.com.projetofinal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static java.sql.Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = null;
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bdbiblioteca", "root", "logatti");
			return con;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
