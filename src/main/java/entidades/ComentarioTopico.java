package entidades;

public class ComentarioTopico {

    private int id;
    private int idUsuario;
    private int idTopico;
    private String comentario;
    
    public ComentarioTopico(){
        
    }

    public ComentarioTopico(int idTopico, String comentario, int idUsuario  ) {
        this.idTopico = idTopico;
        this.idUsuario = idUsuario;
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTopico() {
        return idTopico;
    }

    public void setIdTopico(int idTopico) {
        this.idTopico = idTopico;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
