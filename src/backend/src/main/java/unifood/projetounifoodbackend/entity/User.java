package unifood.projetounifoodbackend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column (unique = true)
    private String email;

    private String senha;

    public String nome;

    @Column (unique = true)
    public String telefone;
}

