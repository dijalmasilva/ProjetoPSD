package entidades;

import java.io.Serializable;

public class Grupo implements Serializable{

    private int id;
    private int idUsuario;
    private String nomeDoGrupo;
    private String descricao;

    public Grupo(int idUsuario, String nomeDoGrupo, String descricao) {
        this.idUsuario = idUsuario;
        this.nomeDoGrupo = nomeDoGrupo;
        this.descricao = descricao;
    }
    
    public Grupo(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeDoGrupo() {
        return nomeDoGrupo;
    }

    public void setNomeDoGrupo(String nomeDoGrupo) {
        this.nomeDoGrupo = nomeDoGrupo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
