package unifood.projetounifoodbackend.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import unifood.projetounifoodbackend.dto.ProdutoDTO;
import unifood.projetounifoodbackend.dto.ProdutoListagemDTO;
import unifood.projetounifoodbackend.entity.Cantina;
import unifood.projetounifoodbackend.entity.Produto;
import unifood.projetounifoodbackend.exception.BadRequestException;
import unifood.projetounifoodbackend.mapper.ProdutoMapper;
import unifood.projetounifoodbackend.repository.CantinaRepository;
import unifood.projetounifoodbackend.repository.ProdutoRepository;
import unifood.projetounifoodbackend.utils.ImageUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CantinaRepository cantinaRepository;
    private final ProdutoMapper produtoMapper;

    @Transactional
    public Integer createProduto(ProdutoDTO produtoDTO) {
        Cantina cantina = cantinaRepository.findById(produtoDTO.getCantinaId()).orElseThrow(() -> new BadRequestException("Cantina não encontrada."));

        Produto produto = produtoMapper.toEntity(produtoDTO);
        produto.setCantina(cantina);

        produto = produtoRepository.save(produto);
        return produto.getId();
    }
    public ProdutoDTO buscarProdutosPorID(Integer id){
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new BadRequestException("Produto não encontrado com o ID: " + id));
        ProdutoDTO produtoDTO = produtoMapper.toDTO(produto);
        produtoDTO.setCantinaId(produto.getCantina().getId());
        return produtoDTO;
    }
    public String deletarProdutosPorID(Integer id){
        produtoRepository.deleteById(id);
        return "Deletado Produto com o id: " + id;
    }

    public List <ProdutoListagemDTO> buscarProdutos() {
        List<Produto> listaProdutos = produtoRepository.findAll();
        List <ProdutoListagemDTO> listaProdutosDTO = new ArrayList<>();
        for (Produto produto:listaProdutos) {
            ProdutoListagemDTO produtoDTO = produtoMapper.toListagemDTO(produto);
            produtoDTO.setCantinaId(produto.getCantina().getId());
            listaProdutosDTO.add(produtoDTO);
        }
        return listaProdutosDTO;
    }

    public List <ProdutoDTO> buscarProdutosDaCantina(Integer cantinaId) {
        List<Produto> listaProdutos = produtoRepository.findAllByCantinaId(cantinaId);

        List <ProdutoDTO> listaProdutosDTO = new ArrayList<>();
        for (Produto produto:listaProdutos) {
            ProdutoDTO produtoDTO = produtoMapper.toDTO(produto);
            produtoDTO.setCantinaId(produto.getCantina().getId());
            listaProdutosDTO.add(produtoDTO);
        }
        return listaProdutosDTO;
    }

    public String uploadImagemProduto(Integer id, MultipartFile image) throws IOException {
        String encodedBase64 = ImageUtil.encodedImageToBase64Binary(image);
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new BadRequestException("Produto não encontrado com o ID: " + id));
        produto.setImage(encodedBase64);

        produtoRepository.save(produto);
        return "Imagem foi adicionada à cantina com sucesso!";
    }
}
