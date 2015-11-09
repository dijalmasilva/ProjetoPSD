package gerenciador;

import entidades.ImagemDeRequisicao;
import java.io.IOException;
import org.apache.commons.fileupload.FileItem;

/**
 *
 * @author dijalma
 */
public class GerenciadorImagem {
    
    /*
        Manda uma imagem, onde ele irá guardar em caminho local,
        e depois retorna este caminho.
    */
    public void inserirImagemPerfil(FileItem item, String realPath, String nomeDaImagem) throws IOException{
        
        ImagemDeRequisicao.inserirImagem(item, realPath, nomeDaImagem);
    }
}
