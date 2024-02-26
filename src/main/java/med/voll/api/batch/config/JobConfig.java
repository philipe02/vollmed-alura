package med.voll.api.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfig {

    @Bean
    public Job job(JobRepository jobRepository, Step getDoctorsProcessAndSendApprovedStep) {
        return new JobBuilder("job", jobRepository)
                .flow(getDoctorsProcessAndSendApprovedStep)
                .on("COMPLETED")
                .end()
                .end()
                .build();
    }
}