package unifood.projetounifoodbackend.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import unifood.projetounifoodbackend.dto.CantinaDTO;
import unifood.projetounifoodbackend.dto.CantinaListagemDTO;
import unifood.projetounifoodbackend.entity.Cantina;
import unifood.projetounifoodbackend.entity.Produto;
import unifood.projetounifoodbackend.exception.BadRequestException;
import unifood.projetounifoodbackend.mapper.CantinaMapper;
import unifood.projetounifoodbackend.repository.CantinaRepository;
import unifood.projetounifoodbackend.repository.ProdutoRepository;
import unifood.projetounifoodbackend.utils.ImageUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class CantinaService {

    private final CantinaRepository cantinaRepository;
    private final ProdutoRepository produtoRepository;
    private final CantinaMapper cantinaMapper;

    @Transactional
    public Integer createCantina(CantinaDTO cantinaDTO) {
        Cantina cantina = cantinaMapper.toEntity(cantinaDTO);
        cantina = cantinaRepository.save(cantina);
        return cantina.getId();
    }
    public List <CantinaDTO> buscarCantinas() {
        List<Cantina> listaCantinas = cantinaRepository.findAll();
        List <CantinaDTO> listaCantinasDTO = new ArrayList<>();
        for (Cantina cantina:listaCantinas) {
            CantinaDTO cantinaDTO = cantinaMapper.toDTO(cantina);
            listaCantinasDTO.add(cantinaDTO);
        }
        return listaCantinasDTO;
    }

    @Transactional
    public CantinaListagemDTO buscarCantinasPorID(Integer id){
        Cantina cantina = cantinaRepository.findById(id).orElseThrow(() -> new BadRequestException("Cantina não encontrada com o ID: " + id));
        CantinaListagemDTO cantinaListagemDTO = cantinaMapper.toResponseDTO(cantina);
        return cantinaListagemDTO;
    }
    public String deletarCantinasPorID(Integer id){
        cantinaRepository.deleteById(id);
        return "Deletada cantina com o id: " + id;
    }

    public String uploadImagemCantina(Integer id, MultipartFile image) throws IOException {
        String encodedBase64 = ImageUtil.encodedImageToBase64Binary(image);
        Cantina cantina = cantinaRepository.findById(id).orElseThrow(() -> new BadRequestException("Cantina não encontrada com o ID: " + id));
        cantina.setImage(encodedBase64);

        cantinaRepository.save(cantina);
        return "Imagem foi adicionada à cantina com sucesso!";
    }
}
