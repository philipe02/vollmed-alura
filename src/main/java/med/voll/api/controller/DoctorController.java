package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dto.DoctorDTO;
import med.voll.api.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping
    public void update(@RequestBody @Valid DoctorDTO doctor) {
        if (doctorService.update(doctor) != null)
            System.out.println("Médico atualizado com sucesso!");
        else
            System.out.println("Erro ao atualizar médico!");
    }

    public void delete() {
        // TODO
    }

    public void list() {
        // TODO
    }

    public void findById() {
        // TODO
    }
}
