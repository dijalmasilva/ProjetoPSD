
package DAO;

import conexao.Conexao;
import interfaces.InterfaceAmizadeDAO;
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

public class AmizadeDAO implements InterfaceAmizadeDAO{
    
    @Override
    public List<Integer> retornaIdDeAmigos(int idUsuario){
        List<Integer> amigos = new ArrayList<>();
        
        String sql = "select idusuarior from amizade where idusuarioe = "+idUsuario+" and aceitou = true ";
        Connection con = null;
        
        try {
            con = Conexao.abrirConexao();
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            
            while (rs.next()){
                amigos.add(rs.getInt(1));
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(con);
        }
        
        return amigos;
    }
    
    @Override
    public List<Integer> retornaIdDeSolicitacoes(int idUsuario){
        List<Integer> amigos = new ArrayList<>();
        
        String sql = "select idusuarioe from amizade where idusuarior = "+idUsuario+" and aceitou = false";
        Connection con = null;
        
        try {
            con = Conexao.abrirConexao();
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            
            while (rs.next()){
                amigos.add(rs.getInt(1));
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(con);
        }
        
        return amigos;
    }
    
    @Override
    public boolean solicitaAmizade(int idUsuarioE, int idUsuarioR){
        boolean result = false;
        
        String sql = "insert into amizade (idUsuarioe, idUsuarior) values (?, ?)";
        Connection con = null;
        
        try {
            con = Conexao.abrirConexao();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idUsuarioE);
            stmt.setInt(2, idUsuarioR);
            stmt.executeUpdate();
            result = true;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(con);
        }
        
        return result;
    }
    
    @Override
    public boolean cancelaSolicitacao(int idUsuarioR, int idUsuarioE){
            boolean result = false;
        
        String sql = "delete from amizade where idusuarioe = "+idUsuarioE+" and idusuarior = "+idUsuarioR+"";
        Connection con = null;
        
        try {
            con = Conexao.abrirConexao();
            Statement stat = con.createStatement();
            stat.executeUpdate(sql);
            result = true;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(con);
        }
        
        return result;
    }
    
    @Override
    public boolean isFriend(int idUsuario, int idVisitante){
        boolean result = false;
        
        String sql = "select * from amizade where idusuarioe = "+idUsuario+" and idusuarior = "+idVisitante+" and aceitou = true";
        Connection con = null;
        
        try {
            con = Conexao.abrirConexao();
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            
            if (rs.next()){
                result = true;
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(con);
        }
        
        return result;
    }
    
    @Override
    public boolean isSolicitado(int idUsuario, int idVisitante){
        boolean result = false;
        
        String sql = "select * from amizade where (idusuarioe = "+idUsuario+" and idusuarior = "+idVisitante+") and aceitou = true";
        Connection con = null;
        
        try {
            con = Conexao.abrirConexao();
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            
            if (rs.next()){
                result = true;
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(con);
        }
        
        return result;
    }
    
    @Override
    public boolean aceitaSolicitacao(int idUsuarioR, int idUsuarioE){
        boolean result = false;
        Connection con = null;
        Statement stat;
        String sql = "update amizade set aceitou = true where idusuarior = "+idUsuarioR+" and idusuarioe = "+idUsuarioE+"";
        
        try{
            con = Conexao.abrirConexao();
            stat = con.createStatement();
            stat.executeUpdate(sql);
            sql = "insert into amizade(idusuarioe, idusuarior, aceitou) values ("+idUsuarioR+", "+idUsuarioE+", true)";
            stat.executeUpdate(sql);
            stat.close();
            result = true;
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(con);
        }
        
        return result;
    }
    
    @Override
    public boolean isPendente(int idUsuario, int idVisitante){
        boolean result = false;
        
        Connection con = null;
        
        String sql = "select * from amizade where idusuarioe = "+idUsuario+" and idusuarior = "+idVisitante+" and aceitou = false";
        
        try{
            con = Conexao.abrirConexao();
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            
            if (rs.next()){
                result = true;
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }finally{
            Conexao.fecharConexao(con);
        }
        
        return result;
    }
}
