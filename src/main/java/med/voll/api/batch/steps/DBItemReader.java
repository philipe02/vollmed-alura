package med.voll.api.batch.steps;

import med.voll.api.model.Doctor;
import med.voll.api.repository.DoctorRepository;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import java.rmi.UnexpectedException;
import java.util.List;

public class DBItemReader implements ItemReader<List<Doctor>> {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> read() throws Exception, UnexpectedException, ParseException, NonTransientResourceException {
        System.out.println("Reading from DB");
        // Read from DB
        List<Doctor> items = doctorRepository.findAllNotApprovedDoctors();

        if (items.isEmpty()) {
            return null;
        }

        return items;
    }
}
