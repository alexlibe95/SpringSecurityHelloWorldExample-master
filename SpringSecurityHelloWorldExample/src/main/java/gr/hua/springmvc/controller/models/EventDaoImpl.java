package gr.hua.springmvc.controller.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;



public class EventDaoImpl implements EventDao {

	private DataSource dataSource;
	 
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public List<Event> getAll() {
        String query = "select id, name, date from event";
        List<Event> eventList = new ArrayList<Event>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = (Connection) dataSource.getConnection();
            ps = (PreparedStatement) con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                Event evt = new Event();

                evt.setId(rs.getInt("id"));
                evt.setName(rs.getString("name"));
                evt.setDate(rs.getString("date"));

                eventList.add(evt);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return eventList;
    }

    public void save(Event evt){
    	String query = "insert into event (id, name, date) values (?,?,?)";
    	Connection con = null;
        PreparedStatement ps = null;
        try{
            con = (Connection) dataSource.getConnection();
            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, evt.getId());
            ps.setString(2, evt.getName());
            ps.setString(3, evt.getDate());
            int out = ps.executeUpdate();
            if(out !=0){
                System.out.println("Event saved with id="+evt.getId());
            }else System.out.println("Event save failed with id="+evt.getId());
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public Event getById(int id){
    	String query = "select name, date from event where id = ?";
        Event evt = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = (Connection) dataSource.getConnection();
            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
            	evt = new Event();
            	evt.setId(id);
            	evt.setName(rs.getString("name"));
                evt.setDate(rs.getString("date"));
                System.out.println("Event Found::"+evt);
            }else{
                System.out.println("No Event found with id="+id);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return evt;
    }
    
    public void deleteById(int id) {
        String query = "delete from event where id=?";
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = (Connection) dataSource.getConnection();
            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, id);
            int out = ps.executeUpdate();
            if(out !=0){
                System.out.println("Event deleted with id="+id);
            }else System.out.println("No Event found with id="+id);
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void update(Event evt){
    	String query = "update event set name = ?, date = ? where id = ?";
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = (Connection) dataSource.getConnection();
            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setString(1, evt.getName());
            ps.setString(6, evt.getDate());
         
            ps.setInt(8, evt.getId());
            int out = ps.executeUpdate();
            if(out !=0){
                System.out.println("Appointment updated with amka="+evt.getId());
            }else System.out.println("No Appointment found with amka="+evt.getId());
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}