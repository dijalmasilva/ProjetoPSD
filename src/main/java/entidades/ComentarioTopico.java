package entidades;

public class ComentarioTopico {

    private int id;
    private int idTopico;
    private String comentario;
    
    public ComentarioTopico(){
        
    }

    public ComentarioTopico(int idTopico, String comentario) {
        this.idTopico = idTopico;
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
    
    
}
