package DAO;

import conexao.Conexao;
import java.util.List;

import entidades.Filme;
import interfaces.InterfaceFilmeDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FilmeDAO implements InterfaceFilmeDAO {

    @Override
    public boolean add(Filme f) {
        boolean result = false;

        Connection con = null;
        PreparedStatement stmt;
        String sql = "insert into filme (idUser, titulo, ano, sinopse, foto, generos, atoresprincipais, diretores, dataDeCadastro) values"
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            stmt.setDate(9, Date.valueOf(f.getDataDeCadastro()));
            stmt.executeUpdate();

            result = true;
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(con);
        }

        return result;
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
    public List<Filme> buscarCincoFilmesRecentes() {
        List<Filme> filmes = new ArrayList<>();

        String sql = "select * from filme order by dataDeCadastro desc limit 10";

        Connection conn = null;

        try {
            conn = Conexao.abrirConexao();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                Filme f = new Filme();
                f.setId(rs.getInt("id"));
                f.setIdUser(rs.getInt("iduser"));
                f.setTitulo(rs.getString("titulo"));
                f.setAno(rs.getInt("ano"));
                f.setSinopse(rs.getString("sinopse"));
                f.setFoto(rs.getString("foto"));
                f.setGeneros(rs.getString("generos"));
                f.setAtoresPrincipais(rs.getString("atoresprincipais"));
                f.setDiretores(rs.getString("diretores"));
                f.setDataDeCadastro(rs.getDate("dataDeCadastro").toLocalDate());

                filmes.add(f);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(conn);
        }

        return filmes;
    }

    @Override
    public List<Filme> buscarFilmesPorGeneros(String genero) {
        List<Filme> filmes = new ArrayList<>();

        String sql = "select * from filme where generos like '%" + genero + "%' order by ano desc";

        Connection conn = null;

        try {
            conn = Conexao.abrirConexao();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                Filme f = new Filme();
                f.setId(rs.getInt("id"));
                f.setIdUser(rs.getInt("iduser"));
                f.setTitulo(rs.getString("titulo"));
                f.setAno(rs.getInt("ano"));
                f.setSinopse(rs.getString("sinopse"));
                f.setFoto(rs.getString("foto"));
                f.setGeneros(rs.getString("generos"));
                f.setAtoresPrincipais(rs.getString("atoresprincipais"));
                f.setDiretores(rs.getString("diretores"));
                f.setDataDeCadastro(rs.getDate("dataDeCadastro").toLocalDate());

                filmes.add(f);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(conn);
        }

        return filmes;
    }

    @Override
    public List<Filme> buscarFilmesPorAtoresPrincipais(String atorPrincipal) {
        List<Filme> filmes = new ArrayList<>();

        String sql = "select * from filme where atoresPrincipais ilike '%" + atorPrincipal + "%' order by ano desc";

        Connection conn = null;

        try {
            conn = Conexao.abrirConexao();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                Filme f = new Filme();
                f.setId(rs.getInt("id"));
                f.setIdUser(rs.getInt("iduser"));
                f.setTitulo(rs.getString("titulo"));
                f.setAno(rs.getInt("ano"));
                f.setSinopse(rs.getString("sinopse"));
                f.setFoto(rs.getString("foto"));
                f.setGeneros(rs.getString("generos"));
                f.setAtoresPrincipais(rs.getString("atoresprincipais"));
                f.setDiretores(rs.getString("diretores"));
                f.setDataDeCadastro(rs.getDate("dataDeCadastro").toLocalDate());

                filmes.add(f);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(conn);
        }

        return filmes;
    }

    @Override
    public List<Filme> buscarFilmesPorDiretores(String diretor) {
        List<Filme> filmes = new ArrayList<>();

        String sql = "select * from filme where diretores ilike '%" + diretor + "%' order by ano desc";

        Connection conn = null;

        try {
            conn = Conexao.abrirConexao();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                Filme f = new Filme();
                f.setId(rs.getInt("id"));
                f.setIdUser(rs.getInt("iduser"));
                f.setTitulo(rs.getString("titulo"));
                f.setAno(rs.getInt("ano"));
                f.setSinopse(rs.getString("sinopse"));
                f.setFoto(rs.getString("foto"));
                f.setGeneros(rs.getString("generos"));
                f.setAtoresPrincipais(rs.getString("atoresprincipais"));
                f.setDiretores(rs.getString("diretores"));
                f.setDataDeCadastro(rs.getDate("dataDeCadastro").toLocalDate());

                filmes.add(f);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(conn);
        }

        return filmes;
    }

    @Override
    public Filme buscarFilmePorId(int id) {
        Filme filme = null;

        String sql = "select * from filme where id = " + id + "";

        Connection conn = null;

        try {
            
            conn = Conexao.abrirConexao();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            if (rs.next()) {
                filme = new Filme();
                filme.setId(rs.getInt("id"));
                filme.setIdUser(rs.getInt("iduser"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setAno(rs.getInt("ano"));
                filme.setSinopse(rs.getString("sinopse"));
                filme.setFoto(rs.getString("foto"));
                filme.setGeneros(rs.getString("generos"));
                filme.setAtoresPrincipais(rs.getString("atoresprincipais"));
                filme.setDiretores(rs.getString("diretores"));
                filme.setDataDeCadastro(rs.getDate("dataDeCadastro").toLocalDate());
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.fecharConexao(conn);
        }

        return filme;
    }

}
