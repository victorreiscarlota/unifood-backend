package unifood.projetounifoodbackend.mapper;

import org.mapstruct.*;
import org.springframework.stereotype.Component;
import unifood.projetounifoodbackend.dto.CantinaDTO;
import unifood.projetounifoodbackend.dto.CantinaListagemDTO;
import unifood.projetounifoodbackend.entity.Cantina;


@Mapper(componentModel = "spring", uses = { ProdutoMapper.class })
@Component
public interface CantinaMapper {
    CantinaDTO toDTO(Cantina entity);

    Cantina toEntity(CantinaDTO dto);


    @Mapping(target = "produtos", source = "entity.produtos")
    CantinaListagemDTO toResponseDTO(Cantina entity);

}
