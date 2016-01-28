package gr.hua.springmvc.controller.models;

import java.util.List;

public interface EmailDao {

	public List<Email> getAll();
	
	public void save(Email eml);
	
	public void deleteById(int id);
}
