/*package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.ItensPedido;
import jdbc.ConnectionFactory;

public class ItensPedidoDao {

	private Connection connection;

	public ItensPedidoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(ItensPedido itensPedido) throws SQLException {
		String sql = "INSERT INTO mesas" + " (id_pedido, id_produto, quantidade, valor_uni, valor_total, observacao)" + " values (?,?,?,?,?,?)";

		PreparedStatement stmt;

		stmt = this.connection.prepareStatement(sql);

		stmt.setDouble(1, itensPedido.getIdPedido());
		stmt.setString(2, itensPedido.getIdProduto());
		stmt.setInt(3, itensPedido.getQuantidade());
		stmt.setDouble(4, itensPedido.getValorUni());
		stmt.setDouble(5, itensPedido.getValorTotal());
		stmt.setString(6, itensPedido.getObservacao());
		stmt.execute();
		stmt.close();
	}

	public void altera(ItensPedido itensPedido) {
		String sql = "UPDATE itensPedido SET " + " (id_pedido, id_produto, quantidade, valor_uni, valor_total, observacao)" + " values (?,?,?,?,?,?)" + " WHERE id = ? ";

		try {
			PreparedStatement stmt = null;
			stmt = this.connection.prepareStatement(sql);
			stmt.setDouble(1, itensPedido.getIdPedido());
			stmt.setString(2, itensPedido.getIdProduto());
			stmt.setInt(3, itensPedido.getQuantidade());
			stmt.setDouble(4, itensPedido.getValorUni());
			stmt.setDouble(5, itensPedido.getValorTotal());
			stmt.setString(6, itensPedido.getObservacao());
			stmt.setLong(7,itensPedido.getIdItensPedido());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void remove(ItensPedido itensPedido) {
		String sql = "DELETE FROM itensPedido " + " WHERE id = ? ";

		try {
			PreparedStatement stmt;

			stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, itensPedido.getIdItensPedido());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public List<ItensPedido> getLista() {
		List<ItensPedido> itensPedidos = new ArrayList<ItensPedido>();

		try {
			String sql = "SELECT id, id_pedido, id_produto, quantidade, valor_uni, valor_total, observacao" + " FROM itensPedidos " + " ORDER BY id";

			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();

			while (resultado.next()) {
				int id = resultado.getInt("id");
				int idPedido = resultado.getInt("id_pedido");
				int idProduto = resultado.getInt("id_produto");
				int quantidade = resultado.getInt("quantidade");
				double valorUni = resultado.getDouble("valor_Uni");
				double valorTotal = resultado.getDouble("valor_total");
				String observacao = resultado.getString("observacao");

				ItensPedido itensPedido = new ItensPedido();
				itensPedido.setIdItensPedido(id);
				itensPedido.setIdPedido(idPedido);
				itensPedido.setIdProduto(idProduto);
				itensPedido.setQuantidade(quantidade);
				itensPedido.setValorUni(valorUni);
				itensPedido.setValorTotal(valorTotal);
				itensPedido.setObservacao(observacao);

				itensPedidos.add(itensPedido);
			}

			resultado.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

		return itensPedidos;
	}

	public ItensPedido getById(Integer id) {
		ItensPedido itensPedido = new ItensPedido();

		String sql = "SELECT id, id_pedido, id_produto, quantidade, valor_uni, valor_total, observacao" + " FROM itensPedidos " + " WHERE id = ?";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet resultado = stmt.executeQuery();

			while (resultado.next()) {
				itensPedido.setIdItensPedido(resultado.getInt("id"));
				itensPedido.setValorTotal(resultado.getDouble("valor_total"));
				itensPedido.setStatus(resultado.getString("status"));
				
			}

			resultado.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

		return itensPedido;
	}
}*/