package med.voll.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HospitalDTO(
        @NotBlank
        String name,
        @NotBlank @Email
        String email,
        @NotBlank
        String phone,
        @NotNull
        @Valid
        AddressDTO address
) {

}
