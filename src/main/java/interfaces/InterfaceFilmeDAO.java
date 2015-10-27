package interfaces;

import java.util.List;

import entidades.Filme;

public interface InterfaceFilmeDAO {
	
	public boolean add(Filme f);
	
	public boolean delete(Filme f);
	
	public boolean update();
	
	public List<Filme> buscarCincofilmesRecentes();

}
