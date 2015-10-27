/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexao.Conexao;
import interfaces.InterfaceParticipaGrupoDAO;
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
public class ParticipaGrupoDAO implements InterfaceParticipaGrupoDAO{

    @Override
    public boolean adicionaRelacao(int idUser, int idGrupo) {
        boolean result = false;
        
        Connection con = null;
        
        String sql = "insert into participagrupo (idusuario, idgrupo) values (?, ?)";
        
        try {
            con = Conexao.abrirConexao();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idUser);
            stmt.setInt(2, idGrupo);
            
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
    public boolean adicionaRelacaoAdmin(int idUser, int idGrupo) {
        boolean result = false;
        
        Connection con = null;
        
        String sql = "insert into participagrupo (idusuario, idgrupo, useradmin) values (?, ?, ?)";
        
        try {
            con = Conexao.abrirConexao();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idUser);
            stmt.setInt(2, idGrupo);
            stmt.setBoolean(3, true);
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
    public List<Integer> retornaGrupos(int idUser){
        List<Integer> idGrupos = new ArrayList<>();
        
        Connection con = null;
        
        String sql = "select idgrupo from participagrupo where idusuario = "+idUser+"";
        
        try {
            con = Conexao.abrirConexao();
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            
            while(rs.next()){
                idGrupos.add(rs.getInt("idgrupo"));
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(con);
        }
        
        return idGrupos;
    }
}
