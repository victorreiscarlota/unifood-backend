package unifood.projetounifoodbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unifood.projetounifoodbackend.entity.Cantina;

@Repository
public interface CantinaRepository extends JpaRepository<Cantina, Integer> {

}
