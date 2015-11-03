package gerenciador;

import entidades.Comentarios;
import entidades.Avaliacao;
import entidades.Topico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dijalma
 */
public class GerenciadorDeComentarios {
    
    
    public List<Comentarios> retornaComentariosDeAvaliacao(List<Avaliacao> avaliacoes){
        List<Comentarios> comentarios = new ArrayList<>();
        
        for(Avaliacao a: avaliacoes){
            Comentarios c = new Comentarios();
            c.setApelido(new GerenciadorUsuario().retornaApelidoPeloId(a.getIdUsuario()));
            c.setComentario(a.getComentario());
            c.setIdUsuario(a.getIdUsuario());
            c.setFoto(new GerenciadorUsuario().retornaFotoPeloId(a.getIdUsuario()));
            comentarios.add(c);
        }
        
        if(comentarios.isEmpty()){
            return null;
        }
        
        return comentarios;
    }
    
    public List<Comentarios> retornaComentariosDeTopico(List<Topico> topicos){
        List<Comentarios> comentarios = new ArrayList<>();
        
        if(comentarios.isEmpty())
            return null;
        
        return comentarios;
    }
}
