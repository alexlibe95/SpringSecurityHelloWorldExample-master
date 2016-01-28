package gr.hua.springmvc.controller.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class ReqAppointDaoImpl implements ReqAppointDao {

	private DataSource dataSource;
	 
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(ReqAppoint appoint){
    	String query = "insert into request_appointment (amka, name, surname, tameio, ejetash, emergency) values (?,?,?,?,?,?)";
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
    
    public ReqAppoint getByAmka(int amka){
    	String query = "select name, surname, tameio, ejetash, emergency, date, time from request_appointment where amka = ?";
    	ReqAppoint appoint = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = (Connection) dataSource.getConnection();
            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, amka);
            rs = ps.executeQuery();
            if(rs.next()){
                appoint = new ReqAppoint();
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
    
    public void update(ReqAppoint appoint){
    	String query = "update request_appointment set name = ?, surname = ?, tameio = ?, ejetash = ?, emergency = ? where amka = ?";
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
            ps.setInt(6, appoint.getAmka());
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
        String query = "delete from request_appointment where amka=?";
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
    
    public List<ReqAppoint> getAll() {
        String query = "select amka, name, surname, tameio, ejetash, emergency, date, time from request_appointment";
        List<ReqAppoint> appointList = new ArrayList<ReqAppoint>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = (Connection) dataSource.getConnection();
            ps = (PreparedStatement) con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                ReqAppoint appoint = new ReqAppoint();
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
    
    public void set(ReqAppoint appoint){
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
    
}