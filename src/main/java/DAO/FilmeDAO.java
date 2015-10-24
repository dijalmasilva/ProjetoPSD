package DAO;

import conexao.Conexao;
import java.util.List;

import entidades.Filme;
import interfaces.InterfaceFilmeDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FilmeDAO implements InterfaceFilmeDAO {

    @Override
    public boolean add(Filme f) {

        Connection con = null;
        PreparedStatement stmt;
        String sql = "insert into filme (idUser, titulo, ano, sinopse, foto, generos, atoresprincipais, diretores) values"
                + "(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = Conexao.abrirConexao();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, f.getIdUser());
            stmt.setString(2, f.getTitulo());
            stmt.setInt(3, f.getAno());
            stmt.setString(4, f.getSinopse());
            stmt.setString(5, f.getFoto());
            stmt.setString(6, f.getGeneros());
            stmt.setString(7, f.getAtoresPrincipais());
            stmt.setString(8, f.getDiretores());

            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(con);
        }

        return false;
    }

    @Override
    public boolean delete(Filme f) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Filme> buscar() {
        // TODO Auto-generated method stub
        return null;
    }

}
