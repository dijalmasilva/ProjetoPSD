package interfaces;

import java.util.List;

import entidades.Filme;

public interface InterfaceFilmeDAO {
	
	public boolean add(Filme f);
	
	public boolean delete(Filme f);
	
	public boolean update();
	
	public List<Filme> buscarDezFilmesRecentes();

        public List<Filme> buscarFilmesPorGeneros(String genero);
        
        public List<Filme> buscarFilmesPorAtoresPrincipais(String atoresPrincipal);
        
        public List<Filme> buscarFilmesPorDiretores(String diretor);
        
        public Filme buscarFilmePorId(int id);
        
        public String buscarTituloDoFilmePorId(int id);
        
        public List<String> retornaTodosOsFilmes();
        
        public int retornaIdDoFilmePeloNome(String nomeDoFilme);
}
