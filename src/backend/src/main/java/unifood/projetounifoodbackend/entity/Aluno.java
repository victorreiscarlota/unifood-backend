package unifood.projetounifoodbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@DiscriminatorValue("ALUNO")
@Data
public class Aluno extends User {

    @Column(unique = true)
    private String cpf;
}


