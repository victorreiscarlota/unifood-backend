package unifood.projetounifoodbackend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@DiscriminatorValue("CANTINA")
@Data
public class Cantina extends User {

    @Column (unique = true)
    public String cnpj;

    public String local;

    @Lob
    @Column
    private String image;

    @OneToMany(mappedBy = "cantina", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Produto> produtos; // List of products associated with the cantina
}
