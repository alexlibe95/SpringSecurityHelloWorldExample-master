package gr.hua.springmvc.controller.models;

import java.util.List;

public interface ReqAppointDao {

	public void save(ReqAppoint appoint);
	
	public ReqAppoint getByAmka(int amka);
	
	public void update(ReqAppoint appoint);
	
	public void deleteById(int amka);
	
	public List<ReqAppoint> getAll();

	public void set(ReqAppoint appoint);
}
