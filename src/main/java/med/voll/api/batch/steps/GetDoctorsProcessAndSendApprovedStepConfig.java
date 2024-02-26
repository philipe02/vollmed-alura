package med.voll.api.batch.steps;

import med.voll.api.batch.processors.DoctorToDTOItemProcessor;
import med.voll.api.batch.readers.NotApprovedDoctorsReader;
import med.voll.api.batch.writers.ApproveDoctorAPIItemWriter;
import med.voll.api.dto.DoctorDTO;
import med.voll.api.model.Doctor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

@Configuration
public class GetDoctorsProcessAndSendApprovedStepConfig {

  @Bean
  public NotApprovedDoctorsReader doctorReader() {
    return new NotApprovedDoctorsReader();
  }

  @Bean
  public DoctorToDTOItemProcessor processData() {
    return new DoctorToDTOItemProcessor();
  }

  @Bean
  public ApproveDoctorAPIItemWriter sendToAPI() {
    return new ApproveDoctorAPIItemWriter();
  }

  @Bean
  public Step getDoctorsProcessAndSendApprovedStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
    return new StepBuilder("getDoctorsProcessAndSendApprovedStep", jobRepository)
            .<List<Doctor>, List<DoctorDTO>>chunk(10, transactionManager)
            .reader(doctorReader())
            .processor(processData())
            .writer(sendToAPI())
            .build();
  }
}
