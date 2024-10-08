package unifood.projetounifoodbackend.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@MappedSuperclass
public class UserDTO {

    private Integer id;

    @NotNull
    @Email
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min = 6, max = 14, message = "A senha deve ter entre 6-14 caracteres")
    @NotNull
    private String senha;

    @NotBlank
    public String nome;

    @NotNull
    @Digits(integer = 14, fraction = 0, message = "Telefone apenas composto por numeros")
    public String telefone;
}