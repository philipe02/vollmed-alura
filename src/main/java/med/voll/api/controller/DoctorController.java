package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.dto.DoctorDTO;
import med.voll.api.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
