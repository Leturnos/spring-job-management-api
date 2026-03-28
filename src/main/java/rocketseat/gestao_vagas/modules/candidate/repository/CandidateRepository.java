package rocketseat.gestao_vagas.modules.candidate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rocketseat.gestao_vagas.modules.candidate.entity.CandidateEntity;

import java.util.Optional; // habilita alguns comandos além do retorno/null
import java.util.UUID;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
    Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);
}
