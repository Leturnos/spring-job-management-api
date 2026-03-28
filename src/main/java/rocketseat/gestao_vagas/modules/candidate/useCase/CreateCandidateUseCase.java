package rocketseat.gestao_vagas.modules.candidate.useCase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rocketseat.gestao_vagas.exceptions.UserAlreadyExistsException;
import rocketseat.gestao_vagas.modules.candidate.entity.CandidateEntity;
import rocketseat.gestao_vagas.modules.candidate.repository.CandidateRepository;

@Service
@RequiredArgsConstructor
public class CreateCandidateUseCase {

    private final CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity){
        candidateRepository
        .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent((user) ->{
            throw new UserAlreadyExistsException();
        });

        return candidateRepository.save(candidateEntity);
    }
}
