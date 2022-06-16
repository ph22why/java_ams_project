package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDAO {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public BaseDAO() {
		conn = DBConnection.getConnection();
	}
	
	public boolean checkbnum(int basenum) {
		try {
			String sql = "select * from base where basenum = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, basenum);
			
			rs = ps.executeQuery();
			
			return rs.next();
		} catch (SQLException e) {
		}
		return false;
	}
}
