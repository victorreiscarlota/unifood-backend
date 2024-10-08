package unifood.projetounifoodbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unifood.projetounifoodbackend.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    boolean existsByCpf(String cpf);
    boolean existsByTelefone(String telefone);
    boolean existsByEmail(String email);
    boolean existsByEmailAndSenha(String email, String senha);
    Aluno findOneByEmail(String email);
}
