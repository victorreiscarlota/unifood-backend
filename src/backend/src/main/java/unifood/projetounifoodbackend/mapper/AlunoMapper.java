package unifood.projetounifoodbackend.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import unifood.projetounifoodbackend.dto.AlunoDTO;
import unifood.projetounifoodbackend.entity.Aluno;

@Mapper(componentModel = "spring")
@Component
public interface AlunoMapper {
    Aluno toEntity(AlunoDTO dto);

    AlunoDTO toDTO(Aluno entity);
}
