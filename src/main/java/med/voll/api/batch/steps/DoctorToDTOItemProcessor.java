package med.voll.api.batch.steps;

import med.voll.api.dto.DoctorDTO;
import med.voll.api.mapper.DoctorMapper;
import med.voll.api.model.Doctor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DoctorToDTOItemProcessor implements ItemProcessor<List<Doctor>, List<DoctorDTO>> {

    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    public List<DoctorDTO> process(List<Doctor> item) throws Exception {
        System.out.println("Processing data");
        // Process data
        return item.stream()
                   .map(doctorMapper::toDTO)
                   .toList();
    }
}
