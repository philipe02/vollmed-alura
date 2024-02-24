package med.voll.api.dto;

import med.voll.api.enums.Specialty;

public record DoctorListDTO(
        String name,
        String email,
        String crm,
        Specialty specialty
) {
}
