package entidades;

public class Avaliacao{

    private int id;
    private int idUsuario;
    private int idFilme;
    private int rating;
    private String comentario;
    
    public Avaliacao(){
        
    }

    public Avaliacao(int idUsuario, int idFilme, int rating, String comentario) {
        this.idUsuario = idUsuario;
        this.idFilme = idFilme;
        this.rating = rating;
        this.comentario = comentario;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }
    
}
