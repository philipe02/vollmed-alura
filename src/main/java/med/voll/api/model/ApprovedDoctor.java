package med.voll.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "approved_doctors")
@Entity(name = "ApprovedDoctor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ApprovedDoctor {

    public ApprovedDoctor(Doctor doctor, Date registrationDate, Date expirationDate) {
        this.doctor = doctor;
        this.registrationDate = registrationDate;
        this.expirationDate = expirationDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    @Temporal(TemporalType.DATE)
    private Date expirationDate;
}
