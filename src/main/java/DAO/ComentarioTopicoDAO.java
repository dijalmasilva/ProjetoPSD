package DAO;

import conexao.Conexao;
import entidades.ComentarioTopico;
import interfaces.InterfaceComentarioTopicoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ComentarioTopicoDAO implements InterfaceComentarioTopicoDAO{

    @Override
    public boolean adicionar(ComentarioTopico c) {
        boolean result = false;
        
        Connection con = null;
        PreparedStatement stmt;
        String sql = "insert into comentariotopico (idusuario, idtopico, comentario) values (?, ?, ?)";
        
        try{
            con = Conexao.abrirConexao();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, c.getIdUsuario());
            stmt.setInt(2, c.getIdTopico());
            stmt.setString(3, c.getComentario());
            
            stmt.executeUpdate();
            
            result = true;
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }finally{
            
        }
        
        return result;
    }

    @Override
    public boolean atualizar(ComentarioTopico c) {
        boolean result = false;
        
        return result;
    }

    @Override
    public List<ComentarioTopico> consultarPorIdTopico(int idTopico) {
        List<ComentarioTopico> comentarios = new ArrayList<>();
        
        Connection con = null;
        
        try{
            con = Conexao.abrirConexao();
            String sql = "select * from comentariotopico where idTopico = "+idTopico+"";
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            
            while(rs.next()){
                ComentarioTopico c = new ComentarioTopico();
                c.setComentario(rs.getString("comentario"));
                c.setId(rs.getInt("id"));
                c.setIdTopico(rs.getInt("idtopico"));
                c.setIdUsuario(rs.getInt("idusuario"));
                
                comentarios.add(c);
            }
            
        } catch (ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }finally{
            Conexao.fecharConexao(con);
        }
        
        return comentarios;
    }

    @Override
    public boolean remover(int idTopico) {
        boolean result = false;
        
        return result;  
    }
    
}
