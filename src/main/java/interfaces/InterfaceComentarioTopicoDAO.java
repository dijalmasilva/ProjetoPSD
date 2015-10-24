package interfaces;

import entidades.ComentarioTopico;
import java.util.List;


public interface InterfaceComentarioTopicoDAO {
	
	public boolean adicionar(ComentarioTopico c);

	public boolean remover(int idTopico);

	public boolean atualizar(ComentarioTopico c);

	public List<ComentarioTopico> consultar();

}
