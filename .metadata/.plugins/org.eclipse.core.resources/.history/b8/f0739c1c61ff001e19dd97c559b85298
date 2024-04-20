package co.empresa.test.dao;

import co.empresa.test.util.Conexion;

public class UsuarioDao {
	private Conexion conexion;
	private static final String INSERT_USUARIO_SQL = "INSERT INTO usuario (nombre, email, pais) VALUES (?, ?, ?)";
	private static final String DELETE_USUARIO_SQL = "DELETE FROM usuario WHERE id = ?";
	private static final String UPDATE_USUARIO_SQL = "UPDATE usuario SET nombre = ?, email = ?, pais = ?";
	private static final String SELECT_USUARIO_BY_ID = "SELECT * FROM usuario WHERE id = ?";
	private static final String SELECT_ALL_USUARIOS = "SELECT * FROM usuario";
	
	
	public UsuarioDao() {
		this.conexion = conexion.getConexion();
	}
	
}
