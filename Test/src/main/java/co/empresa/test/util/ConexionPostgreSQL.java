package co.empresa.test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionPostgreSQL {
	
	private PreparedStatement preparedStatement;

	private static final String url = "jdbc:postgresql://localhost:5432/sistema";
	private static final String driver = "org.postgresql.Driver";
	private static final String userName = "postgres";
	private static final String password = "postgres";

	private Connection con = null;
	private static ConexionPostgreSQL db;
	
	public ConexionPostgreSQL() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userName, password);
			System.out.println("Conexión exitosa");
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println("Error al conectar con la base de datos");
			e.printStackTrace();
		}
	}

	public void cerrarConexion() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ConexionPostgreSQL getConexion() {
		if (db == null) {
			db = new ConexionPostgreSQL();
		}
		return db;
	}

	public ResultSet query() throws SQLException {
		ResultSet res = preparedStatement.executeQuery();
		return res;
	}

	public int execute() throws SQLException {
		int result = preparedStatement.executeUpdate();
		return result;
	}

	public Connection getCon() {
		return this.con;
	}

	public PreparedStatement setPreparedStatement(String sql) throws SQLException {
		this.preparedStatement = con.prepareStatement(sql);
		return this.preparedStatement;
	}
	
}
