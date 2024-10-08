package unifood.projetounifoodbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import unifood.projetounifoodbackend.entity.Produto;

import java.util.List;
import java.util.Set;


@Data
public class CantinaListagemDTO extends UserDTO {

    @NotNull
    @Size(max = 14, min = 14, message = "CNPJ invalido")
    private String cnpj;

    @NotBlank
    private String local;

    private List<ProdutoDTO> produtos;

    private String image;
}
