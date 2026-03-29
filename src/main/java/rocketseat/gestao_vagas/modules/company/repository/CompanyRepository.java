package rocketseat.gestao_vagas.modules.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rocketseat.gestao_vagas.modules.company.entity.CompanyEntity;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {

    Optional<CompanyEntity> findByUsernameOrEmail(String username, String email);

    Optional<CompanyEntity> findByUsername(String username);
}
