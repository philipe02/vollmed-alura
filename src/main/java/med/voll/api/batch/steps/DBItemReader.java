package med.voll.api.batch.steps;

import med.voll.api.model.Doctor;
import med.voll.api.repository.DoctorRepository;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.rmi.UnexpectedException;
import java.util.List;

public class DBItemReader implements ItemReader<List<Doctor>> {

    private Long lastId = 0L;

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> read() throws Exception, UnexpectedException, ParseException, NonTransientResourceException {
        System.out.println("Reading from DB");
        // Read from DB
        List<Doctor> items = doctorRepository.findNotApprovedDoctorsGreaterThanIdTop10(PageRequest.of(0, 10), lastId);

        if (items.isEmpty()) {
            return null;
        }

        lastId = items.get(items.size() - 1)
                      .getId();

        System.out.println("Last ID: " + lastId);

        return items;
    }
}
