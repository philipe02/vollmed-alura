package med.voll.api.mapper;

import med.voll.api.dto.AddressDTO;
import med.voll.api.model.Address;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface AddressMapper {

  Address toModel(AddressDTO addressDTO);

  AddressDTO toDTO(Address address);
}
