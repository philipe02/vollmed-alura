package med.voll.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDTO(
        @NotBlank
        @JsonProperty("street")
        String street,
        @JsonProperty("number")
        String number,
        @JsonProperty("complement")
        String complement,
        @NotBlank
        @JsonProperty("neighborhood")
        String neighborhood,
        @NotBlank
        @JsonProperty("city")
        String city,
        @NotBlank
        @JsonProperty("state")
        String state,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        @JsonProperty("zipcode")
        String zipcode
) {
}
