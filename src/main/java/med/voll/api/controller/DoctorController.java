package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dto.DoctorDTO;
import med.voll.api.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    @Transactional
    public void save(@RequestBody @Valid DoctorDTO doctor) {
        if (doctorService.save(doctor) != null)
            System.out.println("Médico cadastrado com sucesso!");
        else
            System.out.println("Erro ao cadastrar médico!");
    }

    @PostMapping("/all")
    @Transactional
    public void saveAll(@RequestBody @Valid List<DoctorDTO> doctors) {
        if (doctorService.saveAll(doctors) != null)
            System.out.println("Médicos cadastrados com sucesso!");
        else
            System.out.println("Erro ao cadastrar médicos!");
    }

    @GetMapping
    public List<DoctorDTO> findAll(@RequestParam(required = false, defaultValue = "0") int page, @RequestParam(required = false, defaultValue = "10") int size) {
        return doctorService.findAll(page, size);
    }

    @PostMapping("approve-registration")
    @Transactional
    public ResponseEntity<?> approveRegistration(@RequestBody @Valid DoctorDTO doctor) {
        if (doctorService.approveRegistration(doctor) != null)
            return ResponseEntity.ok("Médico aprovado com sucesso!");
        else
            return ResponseEntity.badRequest()
                                 .body("Erro ao aprovar médico!");
    }

    @PostMapping("bulk-approve-registration")
    @Transactional
    public ResponseEntity<?> bulkApproveRegistration(@RequestBody @Valid List<DoctorDTO> doctors) {
        if (doctorService.bulkApproveRegistration(doctors) != null)
            return ResponseEntity.ok("Médicos aprovados com sucesso!");
        else
            return ResponseEntity.badRequest()
                                 .body("Erro ao aprovar médicos!");
    }
}
