package entidades;

public class Topico {
    
    private int id;
    private int idUsuario;
    private int idFilme;
    private int idGrupo;
    private String nomeDoTopico;
    
    public Topico(){
        
    }

    public Topico(int idUsuario, int idFilme, int idGrupo, String nomeDoTopico) {
        this.idUsuario = idUsuario;
        this.idFilme = idFilme;
        this.idGrupo = idGrupo;
        this.nomeDoTopico = nomeDoTopico;
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

    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNomeDoTopico() {
        return nomeDoTopico;
    }

    public void setNomeDoTopico(String nomeDoTopico) {
        this.nomeDoTopico = nomeDoTopico;
    }
    
    
    
}
