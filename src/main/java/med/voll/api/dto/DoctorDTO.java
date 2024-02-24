package med.voll.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.enums.Specialty;

public record DoctorDTO(
        @NotBlank
        @JsonProperty("name")
        String name,
        @NotBlank
        @Email
        @JsonProperty("email")
        String email,
        @NotBlank
        @JsonProperty("phone")
        String phone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        @JsonProperty("crm")
        String crm,
        @NotNull
        @JsonProperty("specialty")
        Specialty specialty,
        @NotNull
        @Valid
        AddressDTO address
) {
}
