package DAO;

import entidades.Grupo;
import conexao.Conexao;
import interfaces.InterfaceGrupoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public List<Grupo> consultar() {
        return new ArrayList<>();
    }
    
}
