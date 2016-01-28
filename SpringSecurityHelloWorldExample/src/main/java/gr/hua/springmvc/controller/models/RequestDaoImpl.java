	package gr.hua.springmvc.controller.models;

	import javax.sql.DataSource;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
	import com.mysql.jdbc.Connection;
	import com.mysql.jdbc.PreparedStatement;


	public class RequestDaoImpl implements RequestDao {
		
		private DataSource dataSource;
		 
	    public void setDataSource(DataSource dataSource) {
	        this.dataSource = dataSource;
	    }
	    
	    public List<Request> getAll() {
	        String query = "select id, amka, name, surname, tameio ,email , approve from request_user";
	        List<Request> userList = new ArrayList<Request>();
	        Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        try{
	            con = (Connection) dataSource.getConnection();
	            ps = (PreparedStatement) con.prepareStatement(query);
	            rs = ps.executeQuery();
	            while(rs.next()){
	            	Request user = new Request();
	            	user.setId(rs.getInt("id"));
	                user.setAmka(rs.getInt("amka"));
	                user.setName(rs.getString("name"));
	                user.setSurname(rs.getString("surname"));
	                user.setTameio(rs.getString("tameio"));
	                user.setEmail(rs.getString("email"));
	                user.setApprove(rs.getString("approve"));
	                userList.add(user);
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
	        return userList;
	    }

	    public void deleteByAmka(int amka) {
	        String query = "delete from request_user where amka=?";
	        Connection con = null;
	        PreparedStatement ps = null;
	        try{
	            con = (Connection) dataSource.getConnection();
	            ps = (PreparedStatement) con.prepareStatement(query);
	            ps.setInt(1, amka);
	            int out = ps.executeUpdate();
	            if(out !=0){
	                System.out.println("User_Request deleted with amka="+amka);
	            }else System.out.println("No User_Request found with amka="+amka);
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
	    
	    public Request getByAmka(int amka){
	    	String query = "select name, surname, tameio, email , approve from request_user where amka = ?";
	    	Request req = null;
	        Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        try{
	            con = (Connection) dataSource.getConnection();
	            ps = (PreparedStatement) con.prepareStatement(query);
	            ps.setInt(1, amka);
	            rs = ps.executeQuery();
	            if(rs.next()){
	            	req = new Request();
	            	req.setAmka(amka);
	            	req.setName(rs.getString("name"));
	            	req.setSurname(rs.getString("surname"));
	            	req.setTameio(rs.getString("tameio"));
	            	req.setEmail(rs.getString("email"));
	            	req.setApprove(rs.getString("approve"));
	                
	                System.out.println("Request Found::"+req);
	            }else{
	                System.out.println("No Request found with amka="+amka);
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
	        return req;
	    }
	    
	    
	    public void save(Request req){
	    	String query = "insert into request_user (amka, name, surname, tameio, email, approve) values (?,?,?,?,?)";
	    	Connection con = null;
	        PreparedStatement ps = null;
	        try{
	            con = (Connection) dataSource.getConnection();
	            ps = (PreparedStatement) con.prepareStatement(query);
	            ps.setInt(1, req.getAmka());
	            ps.setString(2, req.getName());
	            ps.setString(3, req.getSurname());
	            ps.setString(4,req.getTameio());
	            ps.setString(5, req.getEmail());
	            ps.setString(6, req.getApprove());

	            int out = ps.executeUpdate();
	            if(out !=0){
	                System.out.println("Request saved with amka="+req.getAmka());
	            }else System.out.println("Request save failed with amka="+req.getAmka());
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
	    
	    public void update(Request req){
	    	String query = "update request_user set name = ?, surname = ?, tameio = ?, email = ?, approve=? where amka = ?";
	        Connection con = null;
	        PreparedStatement ps = null;
	        try{
	            con = (Connection) dataSource.getConnection();
	            ps = (PreparedStatement) con.prepareStatement(query);
	            ps.setString(1, req.getName());
	            ps.setString(2, req.getSurname());
	            ps.setString(3,req.getTameio());
	            ps.setString(4, req.getEmail());
	            ps.setString(5, req.getApprove());
	            ps.setInt(6, req.getAmka());
	            int out = ps.executeUpdate();
	            if(out !=0){
	                System.out.println("Appointment updated with amka="+req.getAmka());
	            }else System.out.println("No Appointment found with amka="+req.getAmka());
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
