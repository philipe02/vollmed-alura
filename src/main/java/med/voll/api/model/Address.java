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
  @Column
  private String street;
  @Basic
  @Column
  private String number;
  @Basic
  @Column
  private String complement;
  @Basic
  @Column
  private String neighborhood;
  @Basic
  @Column
  private String city;
  @Basic
  @Column
  private String state;
  @Basic
  @Column
  private String zipcode;
}
