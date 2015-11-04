package DAO;

import conexao.Conexao;
import entidades.Notificacoes;
import interfaces.InterfaceNotificacoesDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dijalma
 */
public class NotificacaoDAO implements InterfaceNotificacoesDAO{

    @Override
    public boolean adicionarRecomendacao(Notificacoes n) {
        boolean result = false;
        
        Connection con = null;
        String sql = "insert into notificacoes (idamigo, idfilme, idusuario) values (?, ?, ?)";
        try{
            con = Conexao.abrirConexao();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, n.getIdAmigo());
            stmt.setInt(2, n.getIdFilme());
            stmt.setInt(3, n.getIdUsuario());
            stmt.executeUpdate();
            
            result = true;
        }catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }finally{
            Conexao.fecharConexao(con);
        }
        
        return result;
    }

    @Override
    public boolean adicionarSolicitacaoAceita(Notificacoes n) {
        boolean result = false;
        
        Connection con = null;
        String sql = "insert into notificacoes (idamigo, idusuario, mensagem) values (?, ?, ?)";
        try{
            con = Conexao.abrirConexao();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, n.getIdAmigo());
            stmt.setInt(2, n.getIdUsuario());
            stmt.setString(3, n.getMensagem());
            stmt.executeUpdate();
            
            result = true;
        }catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }finally{
            Conexao.fecharConexao(con);
        }
        
        return result;
    }

    @Override
    public List<Notificacoes> recuperar20NotificacoesRecentes(int idUsuario) {
        List<Notificacoes> notificacoes = new ArrayList<>();
        
        Connection con = null;
        String sql = "select * from notificacoes where idusuario = "+idUsuario+" order by id desc";
        try{
            con = Conexao.abrirConexao();
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            
            while(rs.next()){
                Notificacoes n = new Notificacoes();
                n.setIdAmigo(rs.getInt("idamigo"));
                n.setIdFilme(rs.getInt("idfilme"));
                n.setIdUsuario(rs.getInt("idusuario"));
                n.setMensagem(rs.getString("mensagem"));
                
                notificacoes.add(n);
            }
            
        }catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }finally{
            Conexao.fecharConexao(con);
        }
        
        return notificacoes;
    }
    
}
