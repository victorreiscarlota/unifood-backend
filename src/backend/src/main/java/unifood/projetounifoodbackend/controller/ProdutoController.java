package unifood.projetounifoodbackend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import unifood.projetounifoodbackend.dto.CantinaDTO;
import unifood.projetounifoodbackend.dto.ProdutoDTO;
import unifood.projetounifoodbackend.dto.ProdutoListagemDTO;
import unifood.projetounifoodbackend.service.ProdutoService;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
@Validated
@Slf4j
public class ProdutoController {
    private final ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public String registrarProduto(@Valid @RequestBody ProdutoDTO produtoDTO) {
        log.info("Chamada de endpoint de registrar produto");
        Integer id = produtoService.createProduto(produtoDTO);
        return "Produto registrado com sucesso. Id do produto criado: " + id;
    }

    @GetMapping("todos")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ProdutoListagemDTO> buscarTodosProdutos(){
        List<ProdutoListagemDTO> produtos = produtoService.buscarProdutos();
        return produtos;
    }

    @GetMapping("/cantina/{cantinaId}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ProdutoDTO> buscarProdutosDaCantina(@PathVariable Integer cantinaId){
        List<ProdutoDTO> produtos = produtoService.buscarProdutosDaCantina(cantinaId);
        return produtos;
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ProdutoDTO buscarProdutoPorID(@PathVariable Integer id){
        ProdutoDTO produtoDTO = produtoService.buscarProdutosPorID(id);
        return produtoDTO;

    }

    @DeleteMapping("/{id}")
    @ResponseStatus (code = HttpStatus.OK)
    public String deletarProdutoPorID(@PathVariable Integer id){
        String message = produtoService.deletarProdutosPorID(id);
        return message;

    }

    @PostMapping("/{id}/image")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public String uploadImagemCantina(@PathVariable Integer id, @RequestBody MultipartFile image) throws IOException {
        String message = produtoService.uploadImagemProduto(id, image);
        return message;
    }

}