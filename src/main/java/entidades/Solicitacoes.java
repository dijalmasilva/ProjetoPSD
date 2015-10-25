package entidades;

/**
 *
 * @author dijalma
 */
public class Solicitacoes {
    
    private int     id;
    private int     idDoUsuario; //quem recebe a solicitacao
    private int     idDoQuaseAmigo; //quem envia a solicitacao
    private Usuario quaseAmigo; 
    private boolean pendente;
    private boolean resposta;
    
    public Solicitacoes(){
        
    }

    public Solicitacoes(int idDoUsuario, Usuario quaseAmigo) {
        this.idDoUsuario = idDoUsuario;
        this.quaseAmigo = quaseAmigo;
        this.idDoQuaseAmigo = quaseAmigo.getId();
        this.pendente = false;
        this.resposta = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getQuaseAmigo() {
        return quaseAmigo;
    }

    public void setQuaseAmigo(Usuario quaseAmigo) {
        this.quaseAmigo = quaseAmigo;
    }

    public int getIdDoQuaseAmigo() {
        return idDoQuaseAmigo;
    }

    public void setIdDoQuaseAmigo(int idDoQuaseAmigo) {
        this.idDoQuaseAmigo = idDoQuaseAmigo;
    }

    public boolean isPendente() {
        return pendente;
    }

    public void setPendente(boolean pendente) {
        this.pendente = pendente;
    }

    public boolean isResposta() {
        return resposta;
    }

    public void setResposta(boolean resposta) {
        this.resposta = resposta;
    }

    public int getIdDoUsuario() {
        return idDoUsuario;
    }

    public void setIdDoUsuario(int idDoUsuario) {
        this.idDoUsuario = idDoUsuario;
    }
    
}
