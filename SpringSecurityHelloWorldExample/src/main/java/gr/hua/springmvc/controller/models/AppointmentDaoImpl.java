package gr.hua.springmvc.controller.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
public class AppointmentDaoImpl implements AppointmentDao {

	private DataSource dataSource;
	 
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public void save(Appointment appoint){
    	String query = "insert into appointment (amka, name, surname, tameio, ejetash, emergency, date, time) values (?,?,?,?,?,?,?,?)";
    	Connection con = null;
        PreparedStatement ps = null;
        try{
            con = (Connection) dataSource.getConnection();
            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, appoint.getAmka());
            ps.setString(2, appoint.getName());
            ps.setString(3, appoint.getSurname());
            ps.setString(4,appoint.getTameio());
            ps.setString(5, appoint.getEjetash());
            ps.setInt(6, appoint.getEmergency());
            ps.setString(7, appoint.getDate());
            ps.setString(8, appoint.getTime());
            int out = ps.executeUpdate();
            if(out !=0){
                System.out.println("Appointment saved with amka="+appoint.getAmka());
            }else System.out.println("Appointment save failed with amka="+appoint.getAmka());
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
    
    public Appointment getByAmka(int amka){
    	String query = "select name, surname, tameio, ejetash, emergency, date, time from appointment where amka = ?";
        Appointment appoint = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = (Connection) dataSource.getConnection();
            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, amka);
            rs = ps.executeQuery();
            if(rs.next()){
                appoint = new Appointment();
                appoint.setAmka(amka);
                appoint.setName(rs.getString("name"));
                appoint.setSurname(rs.getString("surname"));
                appoint.setTameio(rs.getString("tameio"));
                appoint.setEjetash(rs.getString("ejetash"));
                appoint.setEmergency(rs.getInt("emergency"));
                appoint.setDate(rs.getString("date"));
                appoint.setTime(rs.getString("time"));
                System.out.println("Appointment Found::"+appoint);
            }else{
                System.out.println("No Appointment found with amka="+amka);
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
        return appoint;
    }
    
    public void update(Appointment appoint){
    	String query = "update appointment set name = ?, surname = ?, tameio = ?, ejetash = ?, emergency = ?, date = ?, time = ? where amka = ?";
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = (Connection) dataSource.getConnection();
            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setString(1, appoint.getName());
            ps.setString(2, appoint.getSurname());
            ps.setString(3,appoint.getTameio());
            ps.setString(4, appoint.getEjetash());
            ps.setInt(5, appoint.getEmergency());
            ps.setString(6, appoint.getDate());
            ps.setString(7, appoint.getTime());
            ps.setInt(8, appoint.getAmka());
            int out = ps.executeUpdate();
            if(out !=0){
                System.out.println("Appointment updated with amka="+appoint.getAmka());
            }else System.out.println("No Appointment found with amka="+appoint.getAmka());
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
    
    public void deleteById(int amka) {
        String query = "delete from appointment where amka=?";
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = (Connection) dataSource.getConnection();
            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, amka);
            int out = ps.executeUpdate();
            if(out !=0){
                System.out.println("Appointment deleted with amka="+amka);
            }else System.out.println("No Appointment found with amka="+amka);
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
	
	public List<Appointment> getAll() {
        String query = "select amka, name, surname, tameio, ejetash, emergency, date, time from appointment";
        List<Appointment> appointList = new ArrayList<Appointment>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = (Connection) dataSource.getConnection();
            ps = (PreparedStatement) con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                Appointment appoint = new Appointment();
                appoint.setAmka(rs.getInt("amka"));
                appoint.setName(rs.getString("name"));
                appoint.setSurname(rs.getString("surname"));
                appoint.setTameio(rs.getString("tameio"));
                appoint.setEjetash(rs.getString("ejetash"));
                appoint.setEmergency(rs.getInt("emergency"));
                appoint.setDate(rs.getString("date"));
                appoint.setTime(rs.getString("time"));
                appointList.add(appoint);
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
        return appointList;
    }
}
