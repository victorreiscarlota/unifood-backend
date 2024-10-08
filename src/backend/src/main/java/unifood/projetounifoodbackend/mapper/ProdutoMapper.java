package unifood.projetounifoodbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import unifood.projetounifoodbackend.dto.ProdutoDTO;
import unifood.projetounifoodbackend.dto.ProdutoListagemDTO;
import unifood.projetounifoodbackend.entity.Produto;

@Mapper(componentModel = "spring")
@Component
public interface ProdutoMapper {

    @Mapping(source = "descricao", target = "desc")
    @Mapping(source = "cantina.id", target = "cantinaId")
    ProdutoDTO toDTO(Produto entity);

    @Mapping(source = "descricao", target = "desc")
    @Mapping(source = "cantina.id", target = "cantinaId")
    ProdutoListagemDTO toListagemDTO(Produto entity);

    @Mapping(source = "desc", target = "descricao")
    Produto toEntity(ProdutoDTO dto);
}
