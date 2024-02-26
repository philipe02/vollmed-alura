package med.voll.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Table(name = "hospital")
@Entity(name = "Hospital")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Hospital {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
  private String phone;
  @Embedded
  private Address address;
  @ManyToMany
  @JoinTable(
          name = "hospital_doctor",
          joinColumns = @JoinColumn(name = "hospital_id"),
          inverseJoinColumns = @JoinColumn(name = "doctor_id")
  )
  @JsonIgnore
  private Set<Doctor> doctors;
}
