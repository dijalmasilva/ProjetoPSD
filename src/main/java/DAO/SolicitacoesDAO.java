package DAO;

import conexao.Conexao;
import entidades.Solicitacoes;
import interfaces.InterfaceSolicitacoesDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dijalma
 */
public class SolicitacoesDAO implements InterfaceSolicitacoesDAO {

    @Override
    public boolean adicionar(Solicitacoes s) {

        boolean result = false;
        Connection con = null;
        PreparedStatement stmt;
        String sql = "insert into solicitacoes(idUsuario, idQuaseAmigo) values (?, ?)";
        try {
            con = Conexao.abrirConexao();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, s.getIdDoUsuario());
            stmt.setInt(2, s.getIdDoQuaseAmigo());

            result = true;
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(con);
        }

        return result;
    }

    @Override
    public boolean atualizar(Solicitacoes s) {
        
        boolean result = false;
            Connection con = null;
        
        try {
            con = Conexao.abrirConexao();
            String sql = "update table set pendente = ?, resposta = ? where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setBoolean(1, s.isPendente());
            stmt.setBoolean(2, s.isResposta());
            stmt.setInt(3, s.getId());
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(con);
        }
        
        return result;
    }

    @Override
    public boolean remover(int id) {
        boolean result = false;
      
        return result;
    }

    @Override
    public List<Solicitacoes> consultarPorIdDoUsuario(int idUsuario) {
        String sql = "select * solicitacoes where idUsuario = " + idUsuario + " and pendente = true and resposta = false";
        List<Solicitacoes> s = new ArrayList<>();
        Connection con = null;
        Statement stat;

        try {
            con = Conexao.abrirConexao();
            stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            
            while(rs.next()){
                Solicitacoes so = new Solicitacoes();
                so.setId(rs.getInt("id"));
                so.setIdDoQuaseAmigo(rs.getInt("idquaseamigo"));
                so.setIdDoUsuario(idUsuario);
                so.setPendente(true);
                so.setResposta(false);
                so.setQuaseAmigo(null);
                
                s.add(so);
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(con);
        }
        
        return s;
    }
}
