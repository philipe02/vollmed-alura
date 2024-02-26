package med.voll.api.repository;

import med.voll.api.model.ApprovedDoctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovedDoctorRepository extends JpaRepository<ApprovedDoctor, Long> {
}
