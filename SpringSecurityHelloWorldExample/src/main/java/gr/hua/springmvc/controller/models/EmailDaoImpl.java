package gr.hua.springmvc.controller.models;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class EmailDaoImpl implements EmailDao {

	private DataSource dataSource;
	 
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
	
	public List<Email> getAll() {
        String query = "select id, name, email from email";
        List<Email> emailList = new ArrayList<Email>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = (Connection) dataSource.getConnection();
            ps = (PreparedStatement) con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
            	Email eml = new Email();
            	eml.setId(rs.getInt("id"));
            	eml.setName(rs.getString("name"));
            	eml.setEmail(rs.getString("email"));
                emailList.add(eml);
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
        return emailList;
    }
	
	 public void save(Email eml){
	    	String query = "insert into email (id, name, email) values (?,?,?)";
	    	Connection con = null;
	        PreparedStatement ps = null;
	        try{
	            con = (Connection) dataSource.getConnection();
	            ps = (PreparedStatement) con.prepareStatement(query);
	            ps.setInt(1, eml.getId());
	            ps.setString(2, eml.getName());
	            ps.setString(3, eml.getEmail());
	            int out = ps.executeUpdate();
	            if(out !=0){
	                System.out.println("email saved with id="+eml.getId());
	            }else System.out.println("email save failed with id="+eml.getId());
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
	 
	 public void deleteById(int id) {
	        String query = "delete from email where id=?";
	        Connection con = null;
	        PreparedStatement ps = null;
	        try{
	            con = (Connection) dataSource.getConnection();
	            ps = (PreparedStatement) con.prepareStatement(query);
	            ps.setInt(1, id);
	            int out = ps.executeUpdate();
	            if(out !=0){
	                System.out.println("Email deleted with id="+id);
	            }else System.out.println("No Email found with id="+id);
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
