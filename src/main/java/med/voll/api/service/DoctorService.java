package med.voll.api.service;

import med.voll.api.dto.DoctorDTO;
import med.voll.api.mapper.DoctorMapper;
import med.voll.api.model.Doctor;
import med.voll.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
  private final DoctorRepository doctorRepository;

  private final DoctorMapper doctorMapper;

  @Autowired
  public DoctorService(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
    this.doctorRepository = doctorRepository;
    this.doctorMapper = doctorMapper;
  }

  public Doctor save(DoctorDTO doctor) {
    Doctor doctorModel = doctorMapper.toModel(doctor);
    return doctorRepository.save(doctorModel);
  }
}

