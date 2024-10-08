package unifood.projetounifoodbackend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginDTO {

    @Email(message = "Email inválido.")
    @NotNull
    private String email;

    @Size(min = 6, max = 14, message = "A senha deve ter entre 6-14 caracteres")
    @NotNull
    private String senha;


}
