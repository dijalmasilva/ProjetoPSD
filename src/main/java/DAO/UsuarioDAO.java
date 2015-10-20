package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entidades.Usuario;
import interfaces.InterfaceUsuarioDAO;
import conexao.Conexao;

public class UsuarioDAO implements InterfaceUsuarioDAO {

	public boolean adicionar(Usuario usuario) {
		Connection conn = null;
		PreparedStatement stm = null;
		String sql = "INSERT INTO USUARIO(email, senha, nome, apelido, dataNascimento, cidade, estado)"
				+ " VALUES (?, md5(?), ?, ?, ?, ?, ?)";
		

		try {
			
			conn = Conexao.abrirConexao();
			stm = Conexao.abrirStatement(sql);
			stm = Conexao.abrirStatement(sql);
			stm.setString(1, usuario.getEmail());
			stm.setString(2, usuario.getSenha());
			stm.setString(3, usuario.getNome());
			stm.setString(4, usuario.getApelido());
			stm.setDate(5, usuario.getDataNAsc());
			stm.setString(6, usuario.getCidade());
			stm.setString(7, usuario.getEstado());
			stm.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			Conexao.fecharStatment(stm);
			Conexao.fecharConecxao(conn);
		}

		return true;
	}

	@Override
	public boolean remover(String s) {
		Connection conn = null;
		try {
			conn = Conexao.abrirConexao();
			String sql = "DELETE FROM Usuario WHERE nome = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, s);
			stm.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			System.err.println("Erro " + e.getMessage());
			e.printStackTrace();
		} finally {

			Conexao.fecharConecxao(conn);
		}

		return false;
	}

	// @Override
	public boolean removerPeloApelido(String s) {
		Connection conn = null;
		try {
			conn = Conexao.abrirConexao();
			String sql = "DELETE FROM Usuario WHERE apelido = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, s);
			stm.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean atualizar(Usuario usuario) {
		Connection conn = null;

		try {
			conn = Conexao.abrirConexao();
			String sql = "UPDATE Usuario SET nome = ?, email = ?, apelido = ?, cidade = ?, estado = ?"
					+ "WHERE id = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getApelido());
			pst.setString(4, usuario.getCidade());
			pst.setString(5, usuario.getEstado());
			pst.setInt(6, usuario.getId());
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println("Erro " + e.getMessage());
			e.printStackTrace();

		} finally {
			Conexao.fecharConecxao(conn);
		}
		return false;
	}

	@Override
	public List<Usuario> consultar() {
		Connection conn = null;
		PreparedStatement stm;
		List<Usuario> list = new ArrayList<Usuario>();
		try {
			String sql = "SELECT * FROM Usuario";
			conn = Conexao.abrirConexao();
			stm = conn.prepareStatement(sql);
			ResultSet result = stm.executeQuery();

			
			while (result.next()) {
				Usuario u = new Usuario();
				u.setId(result.getInt("id"));
				u.setNome(result.getString("nome"));
				u.setApelido(result.getString("apelido"));
				u.setCidade(result.getString("cidade"));
				u.setEstado(result.getString("estado"));
				list.add(u);

			}
			

		} catch (ClassNotFoundException | SQLException e) {
			System.err.println("Erro " + e.getMessage());
			e.getStackTrace();
		} finally {
			Conexao.fecharConecxao(conn);
		}
		return list;
	}

}
