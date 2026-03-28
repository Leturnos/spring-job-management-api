package rocketseat.gestao_vagas.modules.company.useCase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rocketseat.gestao_vagas.modules.company.entity.JobEntity;
import rocketseat.gestao_vagas.modules.company.repository.JobRepository;

@Service
@RequiredArgsConstructor
public class CreateJobUseCase {

    private final JobRepository jobRepository;

    public JobEntity execute(JobEntity jobEntity){
        return jobRepository.save(jobEntity);
    }
}
