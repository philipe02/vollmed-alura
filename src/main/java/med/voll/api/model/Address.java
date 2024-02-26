package med.voll.api.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Basic
    private String street;
    @Basic
    private String number;
    @Basic
    private String complement;
    @Basic
    private String neighborhood;
    @Basic
    private String city;
    @Basic
    private String state;
    @Basic
    private String zipcode;
}
