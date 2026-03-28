package rocketseat.gestao_vagas.modules.company.useCase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rocketseat.gestao_vagas.exceptions.UserAlreadyExistsException;
import rocketseat.gestao_vagas.modules.company.entity.CompanyEntity;
import rocketseat.gestao_vagas.modules.company.repository.CompanyRepository;

@Service
@RequiredArgsConstructor
public class CreateCompanyUseCase {

    private final CompanyRepository companyRepository;

    public CompanyEntity execute(CompanyEntity companyEntity){
        companyRepository
        .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
        .ifPresent((user) ->{
            throw new UserAlreadyExistsException();
        });

        return companyRepository.save(companyEntity);
    }
}
