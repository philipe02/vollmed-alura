package med.voll.api.repository;

import med.voll.api.model.Doctor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    public Doctor findByEmail(String email);

    @Query("SELECT d FROM Doctor d LEFT JOIN d.approved_doctor a WHERE a.doctor IS NULL AND d.id > :lastId ORDER BY d.id ASC")
    public List<Doctor> findNotApprovedDoctorsGreaterThanIdTop10(Pageable pageable, @Param("lastId") Long lastId);
}
