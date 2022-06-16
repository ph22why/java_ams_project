package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransDAO {
		
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public TransDAO() {
		conn = DBConnection.getConnection();
	}
	// 넘기는 기능 - ex) food, 
	public boolean send(int gbnum, String gbname, int amount) {
		try {
			String sql = "insert into garbage (gbnum,gbname,gbamount) values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, gbnum);
			ps.setString(2, gbname);
			ps.setInt(3, amount);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	// 쓰레기통에서 폐기 기능
	public int checknum() {
		try {
			String sql = "select sum(gbamount) from garbage";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				int amount = rs.getInt(1);
				return amount;
			}
		}catch(SQLException e) {
		}return 0;
	}
	
	public boolean empty() {
		try {
			String sql = "delete from garbage";
			ps = conn.prepareStatement(sql);
			return ps.executeUpdate() == 1;
		}catch(SQLException e) {
			System.out.println(e);
		}return false;
	}
}
