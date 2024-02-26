package med.voll.api.mapper;

import med.voll.api.dto.ApprovedDoctorDTO;
import med.voll.api.model.ApprovedDoctor;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface ApprovedDoctorMapper {

    ApprovedDoctor toModel(ApprovedDoctorDTO approvedDoctorDTO);

    ApprovedDoctorDTO toDTO(ApprovedDoctor approvedDoctor);
}
