package co.empresa.test.dao;

import java.sql.SQLException;

public class UsuarioDaoFactory {
	public static UsuarioDao getUusarioDao(String type) throws SQLException {
		switch (type) {
		case "mysql":
			return new UsuarioDaoMySQL();
		case "postgresql":
			return new UsuarioDaoPostgres();
		default:
			return new UsuarioDaoMySQL();
		}
	}
}
