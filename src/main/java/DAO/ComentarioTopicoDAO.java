package DAO;

import conexao.Conexao;
import entidades.ComentarioTopico;
import interfaces.InterfaceComentarioTopicoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ComentarioTopicoDAO implements InterfaceComentarioTopicoDAO{

    @Override
    public boolean adicionar(ComentarioTopico c) {
        boolean result = false;
        
        Connection con = null;
        PreparedStatement stmt;
        String sql = "insert into topico (idtopico, comentario) values (?, ?)";
        
        try{
            con = Conexao.abrirConexao();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, c.getIdTopico());
            stmt.setString(2, c.getComentario());
            
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
    public List<ComentarioTopico> consultar() {
        List<ComentarioTopico> comentarios = null;
        
        return comentarios;
    }

    @Override
    public boolean remover(int idTopico) {
        boolean result = false;
        
        return result;  
    }
    
}
