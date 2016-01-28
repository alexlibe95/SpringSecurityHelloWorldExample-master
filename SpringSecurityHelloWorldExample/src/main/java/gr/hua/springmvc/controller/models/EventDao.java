package gr.hua.springmvc.controller.models;

import java.util.List;


public interface EventDao {
	
	 public List<Event> getAll();
	 
	 public void save(Event evt);
	 
	 public Event getById(int id);
	 
	 public void deleteById(int id);
	 
	 public void update(Event evt);
}
