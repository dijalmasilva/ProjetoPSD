package entidades;

public class ComentarioAvaliacao {
    
    private int id;
    private int idAvaliação;
    private String comentario;
    
    public ComentarioAvaliacao(){
        
    }

    public ComentarioAvaliacao(int idAvaliação, String comentario) {
        this.idAvaliação = idAvaliação;
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAvaliação() {
        return idAvaliação;
    }

    public void setIdAvaliação(int idAvaliação) {
        this.idAvaliação = idAvaliação;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
}
