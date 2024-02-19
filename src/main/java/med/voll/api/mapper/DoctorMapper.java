package med.voll.api.mapper;

import med.voll.api.dto.DoctorDTO;
import med.voll.api.model.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DoctorMapper {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    Doctor toModel(DoctorDTO doctorDTO);

    Doctor toModel(DoctorDTO doctorDTO, Doctor doctor);

    DoctorDTO toDTO(Doctor doctor);
}
