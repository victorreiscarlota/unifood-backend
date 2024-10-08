package unifood.projetounifoodbackend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AlunoDTO extends UserDTO {

    @NotNull
    @Size(max = 11, min = 11, message = "CPF invalido")
    private String cpf;
}
