package DAO;

import conexao.Conexao;
import entidades.Solicitacoes;
import interfaces.InterfaceSolicitacoesDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dijalma
 */
public class SolicitacoesDAO implements InterfaceSolicitacoesDAO{

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Solicitacoes> consultarPorIdDoUsuario(int idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
