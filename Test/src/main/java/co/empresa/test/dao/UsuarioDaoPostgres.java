package co.empresa.test.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.empresa.test.modelo.Usuario;
import co.empresa.test.util.ConexionPostgreSQL;

public class UsuarioDaoPostgres implements UsuarioDao {
	
	private ConexionPostgreSQL conexion;
	
	private static final String INSERT_USUARIO_SQL = "INSERT INTO usuario (nombre, email, pais) VALUES (?, ?, ?)";
	private static final String DELETE_USUARIO_SQL = "DELETE FROM usuario WHERE id = ?";
	private static final String UPDATE_USUARIO_SQL = "UPDATE usuario SET nombre = ?, email = ?, pais = ?";
	private static final String SELECT_USUARIO_BY_ID = "SELECT * FROM usuario WHERE id = ?";
	private static final String SELECT_ALL_USUARIOS = "SELECT * FROM usuario";

	
	public UsuarioDaoPostgres() {
		this.conexion = ConexionPostgreSQL.getConexion();
	}

	public void insert(Usuario usuario) throws SQLException {
		try {

			PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERT_USUARIO_SQL);
			preparedStatement.setString(1, usuario.getNombre());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getPais());
			conexion.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) throws SQLException {
		try {

			PreparedStatement preparedStatement = conexion.setPreparedStatement(DELETE_USUARIO_SQL);
			preparedStatement.setInt(1, id);

			conexion.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Usuario usuario) throws SQLException {
		try {

			PreparedStatement preparedStatement = conexion.setPreparedStatement(UPDATE_USUARIO_SQL);
			preparedStatement.setString(1, usuario.getNombre());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getPais());
			preparedStatement.setInt(4, usuario.getId());
			conexion.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Usuario> selectAll() {

		List<Usuario> usuarios = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_ALL_USUARIOS);
			ResultSet rs = conexion.query();

			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String pais = rs.getString("pais");

				usuarios.add(new Usuario(id, nombre, email, pais));
			}
			rs.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public Usuario select(int id) {

		Usuario usuario = null;
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_USUARIO_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs = conexion.query();

			if (rs.next()) {
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String pais = rs.getString("pais");

				usuario = new Usuario(id, nombre, email, pais);
			}
			rs.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}

}
