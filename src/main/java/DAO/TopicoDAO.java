package DAO;

import conexao.Conexao;
import entidades.Topico;
import interfaces.InterfaceTopicoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TopicoDAO implements InterfaceTopicoDAO{

    @Override
    public boolean adicionar(Topico t) {
        boolean result = false;
        
        Connection con = null;
        PreparedStatement stm;
        String sql = "insert into topico (idusuario, idfilme, idgrupo, nomedotopico) values (?, ?, ?, ?)";
        
        try{
            con = Conexao.abrirConexao();
            stm = con.prepareStatement(sql);
            stm.setInt(1, t.getIdUsuario());
            stm.setInt(2, t.getIdFilme());
            stm.setInt(3, t.getIdGrupo());
            stm.setString(4, t.getNomeDoTopico());
            
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean atualizar(Topico t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Topico> consultarIdDoGrupo(int idDoGrupo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
