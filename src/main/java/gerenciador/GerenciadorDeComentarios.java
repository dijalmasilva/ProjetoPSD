package gerenciador;

import entidades.Comentarios;
import entidades.Avaliacao;
import entidades.ComentarioTopico;
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
        
        return comentarios;
    }
    
    public List<Comentarios> retornaComentariosDeTopico(List<ComentarioTopico> ct){
        List<Comentarios> comentarios = new ArrayList<>();
        
        for(ComentarioTopico c: ct){
            Comentarios coment = new Comentarios();
            coment.setApelido(new GerenciadorUsuario().retornaApelidoPeloId(c.getIdUsuario()));
            coment.setComentario(c.getComentario());
            coment.setIdUsuario(c.getIdUsuario());
            coment.setFoto(new GerenciadorUsuario().retornaFotoPeloId(c.getIdUsuario()));
            
            comentarios.add(coment);
        }
        
        return comentarios;
    }
}
