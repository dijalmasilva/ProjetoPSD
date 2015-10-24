package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Usuario;
import interfaces.InterfaceUsuarioDAO;
import conexao.Conexao;

public class UsuarioDAO implements InterfaceUsuarioDAO {

    boolean result = false;
    
    @Override
	public boolean adicionar(Usuario usuario) {
		Connection conn = null;
		PreparedStatement stm = null;
		String sql = "INSERT INTO USUARIO(foto, email, senha, nomecompleto, apelido, datanascimento, cidade, estado)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		//md5

		try {
			
			conn = Conexao.abrirConexao();
			stm = Conexao.abrirStatement(sql);
                        stm.setString(1, usuario.getFoto());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getSenha());
			stm.setString(4, usuario.getNome());
			stm.setString(5, usuario.getApelido());
			stm.setDate(6, usuario.getDataNAsc());
			stm.setString(7, usuario.getCidade());
			stm.setString(8, usuario.getEstado());
			stm.executeUpdate();
                        
                        result = true;
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			Conexao.fecharStatment(stm);
			Conexao.fecharConexao(conn);
		}

		return result;
	}

	@Override
	public boolean remover(String s) {
            
            boolean result = false;
		Connection conn = null;
		try {
			conn = Conexao.abrirConexao();
			String sql = "DELETE FROM Usuario WHERE nome = ?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, s);
			stm.executeUpdate();

                        result = true;
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println("Erro " + e.getMessage());
			e.printStackTrace();
		} finally {

			Conexao.fecharConexao(conn);
		}

		return result;
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
			Conexao.fecharConexao(conn);
		}
		return false;
	}

	@Override
	public List<Usuario> consultar() {
		Connection conn = null;
		PreparedStatement stm;
		List<Usuario> list = new ArrayList<>();
		try {
			String sql = "SELECT * FROM Usuario";
			conn = Conexao.abrirConexao();
			stm = conn.prepareStatement(sql);
			ResultSet result = stm.executeQuery();

			
			while (result.next()) {
				Usuario u = new Usuario();
				u.setId(result.getInt("id"));
				u.setNome(result.getString("nomeCompleto"));
				u.setApelido(result.getString("apelido"));
				u.setCidade(result.getString("cidade"));
				u.setEstado(result.getString("estado"));
                                u.setFoto(result.getString("foto"));
                                u.setDataNAsc(result.getDate("dataNascimento"));
                                u.setTipo(result.getBoolean("tipo"));
                                u.setEmail(result.getString("email"));
                                u.setSenha(result.getString("senha"));
				list.add(u);

			}
			

		} catch (ClassNotFoundException | SQLException e) {
			System.err.println("Erro " + e.getMessage());
			e.getStackTrace();
		} finally {
			Conexao.fecharConexao(conn);
		}
		return list;
	}
        
        @Override
	public Usuario login(String email, String senha) {
		Connection conn = null;
		PreparedStatement stm;
		Usuario us = null;
                
		try {
			String sql = "SELECT * FROM Usuario where email = '"+email+"' and senha = '"+senha+"'";
			conn = Conexao.abrirConexao();
			stm = conn.prepareStatement(sql);
			ResultSet result = stm.executeQuery();

			
			if (result.next()) {
				us = new Usuario();
				us.setId(result.getInt("id"));
				us.setNome(result.getString("nomeCompleto"));
				us.setApelido(result.getString("apelido"));
				us.setCidade(result.getString("cidade"));
				us.setEstado(result.getString("estado"));
                                us.setFoto(result.getString("foto"));
                                us.setDataNAsc(result.getDate("dataNascimento"));
                                us.setTipo(result.getBoolean("tipo"));
                                us.setEmail(result.getString("email"));
                                us.setSenha(result.getString("senha"));

			}
			

		} catch (ClassNotFoundException | SQLException e) {
			System.err.println("Erro " + e.getMessage());
			e.getStackTrace();
		} finally {
			Conexao.fecharConexao(conn);
		}
		return us;
	}

}
