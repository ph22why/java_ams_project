package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

import dto.ManagerDTO;

public class ManagerDao {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public ManagerDao() {
		conn = DBConnection.getConnection();
	}
	
	public boolean checkId(String Marmycode) {
		try {
			String sql = "select * from Muser where Marmycode = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, Marmycode);
			
			rs = ps.executeQuery();
			
			return !rs.next();			
		} catch (SQLException e) {
		}
		return false;
	}
	
	public boolean join(ManagerDTO newManager) {
		try {
			String sql = "insert into Muser(Marmycode, Mpassword, Mgrade, Mjob, Mname, Mbirth, Mgunnum, basenum) values(?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, newManager.MarmyCode);
			ps.setString(2, newManager.Mpassword);
			ps.setString(3, newManager.Mgrade);
			ps.setString(4, newManager.Mjob);
			ps.setString(5, newManager.Mname);
			ps.setString(6, newManager.Mbirth);
			ps.setInt(7, newManager.Mgunnum);
			ps.setInt(8, newManager.basenum);
			
			return ps.executeUpdate() == 1;
		}catch (SQLException e) {
		}
		
		return false;
	}	

	public int getListG(String mac){
		int result = 0;
		try {
			String sql = "select Mgunnum from Muser where Marmycode = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mac);
			rs = ps.executeQuery();
			while(rs.next()) {
				result = rs.getInt("Mgunnum");
				return result;
			}
		}catch (SQLException e) {
		}
		return result;
	}
	
	public boolean login(String Mamrycode, String Mpassword) {
		try {
			String sql = "select * from Muser where Marmycode = ? and Mpassword = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, Mamrycode);
			ps.setString(2, Mpassword);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				ManagerDTO loginManager = new ManagerDTO();
				loginManager.MarmyCode = rs.getString("MarmyCode");
				loginManager.Mpassword = rs.getString("Mpassword");
				loginManager.basenum = rs.getInt("basenum");
				loginManager.Mbirth = rs.getString("Mbirth");
				loginManager.Mgrade = rs.getString("Mgrade");
				loginManager.Mgunnum = rs.getInt("Mgunnum");
				loginManager.Mjob = rs.getString("Mjob");
				loginManager.Mname = rs.getString("Mname");
				
				Session.setData("loginManager", loginManager);
				return true;
			}
		}catch (SQLException e) {
		}return false;
	}
	
	public boolean leaveID(String Marmycode) {
		try {
			String sql = "delete from Muser where Marmycode = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, Marmycode);
			if(ps.executeUpdate() == 1) {
//				Session.setData("loginManager", null);
				return true;
			}
		}catch(SQLException e) {
		}
		return false;
	}
	
	public boolean checkPW(String Mpassword) {
		try {
			String sql = "select * from Muser where Mpassword = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, Mpassword);
			
			rs = ps.executeQuery();
			return true;
		}catch(SQLException e) {
		}return false;
	}
	
	// 간부정보변경 시작
	public boolean modifytPW(String Npw, String Marmycode) {
		// 암호변경
		try {
			String sql = "update Muser set Mpassword = ? where Marmycode = " + Marmycode;
			ps = conn.prepareStatement(sql);
			ps.setString(1, Npw);
			return ps.executeUpdate() == 1;
		}catch (SQLException e) {
		}
		return false;
	}
	public boolean modifyGrade(String Ngrade, String Marmycode) {
		// 계급변경
		try {
			String sql = "update Muser set Mgrade = ? where Marmycode = " + Marmycode;
			ps = conn.prepareStatement(sql);
			ps.setString(1, Ngrade);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
		}
		return false;
	}
	public boolean modifyJob(String Njob, String Marmycode) {
		// 직책변경
		try {
			String sql = "update Muser set Mjob = ? where Marmycode = " + Marmycode;
			ps = conn.prepareStatement(sql);
			ps.setString(1, Njob);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
		}
		return false;
	}
	public boolean modifyName(String Nname, String Marmycode) {
		// 이름변경
		try {
			String sql = "update Muser set Mname = ? where Marmycode = " + Marmycode;
			ps = conn.prepareStatement(sql);
			ps.setString(1, Nname);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
		}
		return false;
	}
	public boolean modifyBelong(String basenum, String Marmycode) {
		// 사단변경
		try {
			String sql = "update Muser set basenum = ? where Marmycode = " + Marmycode;
			ps = conn.prepareStatement(sql);
			ps.setString(1, basenum);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
		}
		return false;
	}
	// 간부정보변경 끝
	
}
