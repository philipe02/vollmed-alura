package med.voll.api.batch.writers;

import med.voll.api.dto.DoctorDTO;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ApproveDoctorAPIItemWriter implements ItemWriter<List<DoctorDTO>> {

  RestTemplate restTemplate;
  @Value("${api.baseurl}")
  private String apiBaseUrl;

  public ApproveDoctorAPIItemWriter() {
    this.restTemplate = new RestTemplate();
  }

  @Override
  public void write(Chunk<? extends List<DoctorDTO>> chunk) throws Exception {
    System.out.println("Sending approved doctors to API ");

    // Get doctors from chunk a
    for (List<DoctorDTO> doctors : chunk.getItems()) {
      // Send approved doctors to API
      for (DoctorDTO doctor : doctors) {
        ResponseEntity<String> response = restTemplate.postForEntity(apiBaseUrl + "/medicos/approve-registration", doctor, String.class);
        System.out.println(doctor.name() + ": " + response.getBody());
      }
    }
  }
}
