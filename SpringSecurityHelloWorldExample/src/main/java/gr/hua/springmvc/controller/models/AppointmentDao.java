package gr.hua.springmvc.controller.models;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
public interface AppointmentDao {


	public void save(Appointment appoint);
	
    public Appointment getByAmka(int id);

    public void update(Appointment appoint);
    
    public void deleteById(int amka);
    
    public List<Appointment> getAll();

}
