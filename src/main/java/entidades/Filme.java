package entidades;

import java.time.LocalDate;

public class Filme {
    
    private int id;
    private int idUser;
    private String titulo;
    private int ano;
    private String sinopse;
    private String foto;
    private String generos;
    private String atoresPrincipais;
    private String diretores;
    private LocalDate dataDeCadastro;
    
    public Filme(){
        
    }

    public Filme(int idUser, String titulo, int ano, String sinopse, String foto, String generos, String atoresPrincipais, String diretores, LocalDate dataDeCadastro) {
        this.idUser = idUser;
        this.titulo = titulo;
        this.ano = ano;
        this.sinopse = sinopse;
        this.foto = foto;
        this.generos = generos;
        this.atoresPrincipais = atoresPrincipais;
        this.diretores = diretores;
        this.dataDeCadastro = dataDeCadastro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getGeneros() {
        return generos;
    }

    public void setGeneros(String generos) {
        this.generos = generos;
    }

    public String getAtoresPrincipais() {
        return atoresPrincipais;
    }

    public void setAtoresPrincipais(String atoresPrincipais) {
        this.atoresPrincipais = atoresPrincipais;
    }

    public String getDiretores() {
        return diretores;
    }

    public void setDiretores(String diretores) {
        this.diretores = diretores;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public LocalDate getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(LocalDate dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }
    
}
