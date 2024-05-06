package co.empresa.test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
	private PreparedStatement preparedStatement;

	private static final String url = "jdbc:mysql://localhost:3306/sistema";
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String userName = "root";
	private static final String password = "";

	private Connection con = null;
	private static Conexion db;

	public Conexion() {
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

	public static Conexion getConexion() {
		if (db == null) {
			db = new Conexion();
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
