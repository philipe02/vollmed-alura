package med.voll.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import med.voll.api.enums.Specialty;

import java.util.Set;

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
  private Long id;
  private String name;
  private String email;
  private String phone;
  private String crm;
  @Enumerated(EnumType.STRING)
  private Specialty specialty;
  @Embedded
  private Address address;
  @OneToOne(mappedBy = "doctor")
//  @JsonIgnore
  private ApprovedDoctor approved_doctor;
//  @ManyToMany(mappedBy = "doctors")
//  @JsonIgnore
//  private Set<Hospital> hospitals;

}
