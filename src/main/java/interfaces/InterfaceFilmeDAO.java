package interfaces;

import java.util.List;

import entidades.Filme;

public interface InterfaceFilmeDAO {
	
	public boolean add();
	
	public boolean delete();
	
	public boolean update();
	
	public List<Filme> buscar();

}
