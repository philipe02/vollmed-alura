package med.voll.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ApprovedDoctorDTO(
        @NotNull
        DoctorDTO doctor,
        @NotNull
        Date registrationDate,
        @NotNull
        Date expirationDate
) {
}
