package med.voll.api.service;

import med.voll.api.dto.ApprovedDoctorDTO;
import med.voll.api.dto.DoctorDTO;
import med.voll.api.mapper.ApprovedDoctorMapper;
import med.voll.api.mapper.DoctorMapper;
import med.voll.api.model.ApprovedDoctor;
import med.voll.api.model.Doctor;
import med.voll.api.repository.ApprovedDoctorRepository;
import med.voll.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final ApprovedDoctorRepository approvedDoctorRepository;

    private final DoctorMapper doctorMapper;
    private final ApprovedDoctorMapper approvedDoctorMapper;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, ApprovedDoctorRepository approvedDoctorRepository, DoctorMapper doctorMapper,
                         ApprovedDoctorMapper approvedDoctorMapper) {
        this.doctorRepository = doctorRepository;
        this.approvedDoctorRepository = approvedDoctorRepository;
        this.doctorMapper = doctorMapper;
        this.approvedDoctorMapper = approvedDoctorMapper;
    }

    public Doctor save(DoctorDTO doctor) {
        Doctor doctorModel = doctorMapper.toModel(doctor);
        return doctorRepository.save(doctorModel);
    }

    public List<DoctorDTO> saveAll(List<DoctorDTO> doctors) {
        List<Doctor> doctorModels = doctors.stream()
                                           .map(doctorMapper::toModel)
                                           .toList();
        return doctorRepository.saveAll(doctorModels)
                               .stream()
                               .map(doctorMapper::toDTO)
                               .toList();
    }

    public List<DoctorDTO> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return doctorRepository.findAll(pageable)
                               .stream()
                               .map(doctorMapper::toDTO)
                               .toList();
    }

    public ApprovedDoctorDTO approveRegistration(DoctorDTO doctor) {
        Doctor doctorModel = doctorRepository.findByEmail(doctor.email());

        Calendar calendar = Calendar.getInstance();
        Date registrationDate = calendar.getTime();
        calendar.add(Calendar.YEAR, 1);
        Date expirationDate = calendar.getTime();

        ApprovedDoctor approvedDoctor = approvedDoctorRepository.save(new ApprovedDoctor(doctorModel, registrationDate, expirationDate));
        return approvedDoctorMapper.toDTO(approvedDoctor);
    }

    public List<ApprovedDoctorDTO> bulkApproveRegistration(List<DoctorDTO> doctors) {
        //Check if the doctors exist
        List<Doctor> existingDoctors = doctors.stream()
                                              .map(doctorMapper::toModel)
                                              .map(Doctor::getEmail)
                                              .map(doctorRepository::findByEmail)
                                              .filter(Objects::nonNull)
                                              .toList();

        // Save the approved doctors
        Calendar calendar = Calendar.getInstance();
        Date registrationDate = calendar.getTime();
        calendar.add(Calendar.YEAR, 1);
        Date expirationDate = calendar.getTime();

        List<ApprovedDoctor> approvedDoctors = existingDoctors.stream()
                                                              .map(doctor -> new ApprovedDoctor(
                                                                      doctor,
                                                                      registrationDate,
                                                                      expirationDate))
                                                              .map(approvedDoctorRepository::save)
                                                              .toList();

        // Return the approved doctors
        return approvedDoctors.stream()
                              .map(approvedDoctorMapper::toDTO)
                              .toList();
    }
}

