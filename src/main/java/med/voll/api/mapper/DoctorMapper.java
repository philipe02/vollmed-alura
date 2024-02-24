package med.voll.api.mapper;

import med.voll.api.dto.DoctorDTO;
import med.voll.api.model.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = {AddressMapper.class}
)
public interface DoctorMapper {
  @Mapping(target = "id", ignore = true)
  Doctor toModel(DoctorDTO doctorDTO);

  DoctorDTO toDTO(Doctor doctor);
}
