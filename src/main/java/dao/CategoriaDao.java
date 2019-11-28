package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.Categoria;
import jdbc.ConnectionFactory;

public class CategoriaDao {
	private Connection connection;

	public CategoriaDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Categoria categoria) throws SQLException {
		String sql = "INSERT INTO categorias" + " (categoria)" + " values (?)";

		PreparedStatement stmt;

		stmt = this.connection.prepareStatement(sql);
		stmt.setString(1, categoria.getNome());
		stmt.execute();
		stmt.close();
	}

	public void remove(Categoria categoria) {
		String sql = "DELETE FROM categorias " + " WHERE id = ? ";

		try {
			PreparedStatement stmt;

			stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, categoria.getIdCategoria());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void altera(Categoria categoria) {
		String sql = "UPDATE Categorias SET " + " (categoria) = (?) " + " WHERE id = ? ";

		try {
			PreparedStatement stmt = null;
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, categoria.getNome());
			stmt.setLong(2, categoria.getIdCategoria());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public List<Categoria> getLista() {
		List<Categoria> categorias = new ArrayList<Categoria>();

		try {
			String sql = "SELECT id, categoria" + " FROM categorias " + " ORDER BY id";

			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();

			while (resultado.next()) {
				int idCategoria = resultado.getInt("id");
				String nome = resultado.getString("categoria");

				Categoria categoria = new Categoria();
				categoria.setIdCategoria(idCategoria);
				categoria.setNome(nome);

				categorias.add(categoria);
			}

			resultado.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

		return categorias;
	}

	public Categoria getById(Integer id) {
		Categoria categoria = new Categoria();

		String sql = "SELECT id, nome " + " FROM categorias " + " WHERE id = ?";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet resultado = stmt.executeQuery();

			while (resultado.next()) {
				categoria.setIdCategoria(resultado.getInt("id"));
				categoria.setNome(resultado.getString("nome"));
			}

			resultado.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

		return categoria;
	}
}
