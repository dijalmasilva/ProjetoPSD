package DAO;

import conexao.Conexao;
import entidades.Solicitacoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dijalma
 */
public class SolicitacoesDAO {

    public boolean cadastrar(Solicitacoes s) {

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
}
