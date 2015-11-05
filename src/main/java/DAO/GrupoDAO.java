package DAO;

import entidades.Grupo;
import conexao.Conexao;
import interfaces.InterfaceGrupoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GrupoDAO implements InterfaceGrupoDAO{

    @Override
    public boolean adicionar(Grupo grupo) {
        boolean result = false;
        Connection con = null;
        PreparedStatement stm;
        String sql = "insert into grupo (idUsuario, nome, descricao) values (?, ?, ?)";
        try{
            con = Conexao.abrirConexao();
            stm = con.prepareStatement(sql);
            stm.setInt(1, grupo.getIdUsuario());
            stm.setString(2, grupo.getNomeDoGrupo());
            stm.setString(3, grupo.getDescricao());
            
            stm.executeUpdate();
            result = true;
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }finally{
            Conexao.fecharConexao(con);
        }
        
        return result;
    }

    @Override
    public boolean remover(String s) {
        
        return false;
    }

    @Override
    public boolean atualizar(Grupo grupo) {
        return false;
    }

    @Override
    public Grupo consultarPorId(int idGrupo) {
        Grupo g = null;
        
        Connection con = null;
        String sql = "select * from grupo where id = "+idGrupo+"";
        
        try {
            con = Conexao.abrirConexao();
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            
            if (rs.next()){
                g = new Grupo();
                g.setId(idGrupo);
                g.setIdUsuario(rs.getInt("idusuario"));
                g.setNomeDoGrupo(rs.getString("nome"));
                g.setDescricao(rs.getString("descricao"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(con);
        }
        
        return g;
    }
 
    @Override
    public int retornaMaximo(){
        int i = 0;
        
       Connection con = null;
        String sql = "select max(id) from grupo";
        
        try {
            con = Conexao.abrirConexao();
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            
            if (rs.next()){
                i = rs.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(con);
        }
        
        return i;
    }
    
   
}
