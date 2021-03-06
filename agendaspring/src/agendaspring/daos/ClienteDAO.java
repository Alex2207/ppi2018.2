package agendaspring.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import agendaspring.models.Cliente;

public class ClienteDAO {

	private Connection connection;

	public ClienteDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Cliente contato) {

		String sql = "insert into contatos (nome, email, endereco, dataNascimento) values (?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());

			stmt.setDate(4, new java.sql.Date(contato.getDataNascimento().getTimeInMillis()));

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Cliente> getLista() {
		List<Cliente> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Cliente contato = new Cliente();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				result.add(contato);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean alterar(Cliente contato) {
		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new java.sql.Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remover(Cliente contato) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from contatos where id=?;");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Cliente getById(Long id) {
		Cliente result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where id = ?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {

				result = new Cliente();
				result.setId(rs.getLong("id"));
				result.setNome(rs.getString("nome"));
				result.setEmail(rs.getString("email"));
				result.setEndereco(rs.getString("endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				result.setDataNascimento(data);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	

}
