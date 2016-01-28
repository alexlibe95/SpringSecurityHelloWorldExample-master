package gr.hua.springmvc.controller.models;

import java.util.List;

public interface RequestDao {

	public List<Request> getAll();
	
	public void deleteByAmka(int amka);
	
	public Request getByAmka(int amka);
	
	public void save(Request req);
	
	public void update(Request req);

}