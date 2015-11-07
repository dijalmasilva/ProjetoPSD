package DAO;

import conexao.Conexao;
import entidades.Topico;
import interfaces.InterfaceTopicoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TopicoDAO implements InterfaceTopicoDAO {

    @Override
    public boolean adicionar(Topico t) {
        boolean result = false;

        Connection con = null;
        PreparedStatement stm;
        String sql = "insert into topico (idusuario, idfilme, idgrupo, nomedotopico) values (?, ?, ?, ?)";

        try {
            con = Conexao.abrirConexao();
            stm = con.prepareStatement(sql);
            stm.setInt(1, t.getIdUsuario());
            stm.setInt(2, t.getIdFilme());
            stm.setInt(3, t.getIdGrupo());
            stm.setString(4, t.getNomeDoTopico());

            stm.executeUpdate();

            result = true;
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(con);
        }

        return result;
    }

    @Override
    public boolean remover(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean atualizar(Topico t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Topico> consultarPorIdDoGrupo(int idDoGrupo) {
        List<Topico> topicos = new ArrayList<>();

        Connection con = null;

        String sql = "select * from topico where idgrupo = " + idDoGrupo + "";

        try {
            con = Conexao.abrirConexao();
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                Topico t = new Topico();
                t.setId(rs.getInt("id"));
                t.setIdFilme(rs.getInt("idFilme"));
                t.setIdGrupo(rs.getInt("idGrupo"));
                t.setIdUsuario(rs.getInt("idUsuario"));
                t.setNomeDoTopico(rs.getString("nomedotopico"));

                topicos.add(t);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(con);
        }

        return topicos;
    }

    @Override
    public Topico consultarPorId(int idTopico) {
        Topico t = null;

        Connection con = null;

        try {
            con = Conexao.abrirConexao();
            String sql = "select * from topico where id = "+idTopico+"";
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            
            if(rs.next()){
                t = new Topico();
                t.setId(rs.getInt("id"));
                t.setIdFilme(rs.getInt("idFilme"));
                t.setIdGrupo(rs.getInt("idGrupo"));
                t.setNomeDoTopico(rs.getString("nomedotopico"));
                t.setIdUsuario(rs.getInt("idusuario"));
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(con);
        }

        return t;
    }

}
