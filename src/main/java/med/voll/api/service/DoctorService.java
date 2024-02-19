package med.voll.api.service;

import med.voll.api.dto.DoctorDTO;
import med.voll.api.mapper.DoctorMapper;
import med.voll.api.model.Doctor;
import med.voll.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor save(DoctorDTO doctor) {
        return doctorRepository.save(DoctorMapper.INSTANCE.toModel(doctor));
    }

    public Doctor update(DoctorDTO doctor) {
        Doctor doctorModel = doctorRepository.findByEmail(doctor.email());
        return doctorRepository.save(DoctorMapper.INSTANCE.toModel(doctor, doctorModel));
    }

    public void delete(Long id) {
        doctorRepository.findById(id).ifPresent(doctorRepository::delete);
    }

    public List<DoctorDTO> list() {
        return doctorRepository.findAll().stream().map(DoctorMapper.INSTANCE::toDTO).toList();
    }

    public DoctorDTO findById(Long id) {
        return doctorRepository.findById(id).map(DoctorMapper.INSTANCE::toDTO).orElse(null);
    }
}

