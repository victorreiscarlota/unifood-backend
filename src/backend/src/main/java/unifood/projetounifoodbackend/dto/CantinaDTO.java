package unifood.projetounifoodbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CantinaDTO extends UserDTO {

    @NotNull
    @Size(max = 14, min = 14, message = "CNPJ invalido")
    private String cnpj;

    @NotBlank
    private String local;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String image;
}
