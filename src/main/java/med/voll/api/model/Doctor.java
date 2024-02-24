package med.voll.api.model;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.enums.Specialty;

@Table(name = "doctor")
@Entity(name = "Doctor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Long id;
  @Basic
  @Column
  private String name;
  @Basic
  @Column
  private String email;
  @Basic
  @Column
  private String phone;
  @Basic
  @Column
  private String crm;

  @Enumerated(EnumType.STRING)
  @Column
  private Specialty specialty;

  @Embedded
  private Address address;

}
