package DAO;

import conexao.Conexao;
import entidades.Avaliacao;
import interfaces.InterfaceAvaliacaoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoDAO implements InterfaceAvaliacaoDAO {

    @Override
    public boolean adicionar(Avaliacao a) {
        boolean result = false;

        Connection con = null;
        PreparedStatement stmt;
        String sql = "insert into avaliacao(idUsuario, idFilme, rating, comentario) values (?, ?, ?, ?)";

        try {
            con = Conexao.abrirConexao();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, a.getIdUsuario());
            stmt.setInt(2, a.getIdFilme());
            stmt.setInt(3, a.getRating());
            stmt.setString(4, a.getComentario());

            stmt.executeUpdate();
            result = true;
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(con);
        }

        return result;
    }

    @Override
    public boolean atualizar(Avaliacao a) {
        return true;
    }

    @Override
    public List<Avaliacao> consultarPorIdDeFilme(int idFilme) {
        List<Avaliacao> avaliacoes = new ArrayList<>();

        Connection con = null;
        PreparedStatement stmt;
        String sql = "select * from avaliacao where idFilme = " + idFilme + " order by id desc";

        try {
            con = Conexao.abrirConexao();
            stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Avaliacao a = new Avaliacao();
                a.setId(rs.getInt("id"));
                a.setComentario(rs.getString("comentario"));
                a.setIdFilme(rs.getInt("idFilme"));
                a.setIdUsuario(rs.getInt("idUsuario"));
                a.setRating(rs.getInt("rating"));
                
                avaliacoes.add(a);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(con);
        }

        return avaliacoes;
    }
}
