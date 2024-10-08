package unifood.projetounifoodbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProdutoDTO {

    private Integer id;

    @NotBlank
    private String nome;

    @NotBlank
    private String desc;

    @NotBlank
    private String preco;

    @NotNull
    private Integer cantinaId;

    private String image;
}
