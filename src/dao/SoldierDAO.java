package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.PreparableStatement;

import dto.SoldierDTO;

public class SoldierDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public SoldierDAO() {
		conn = DBConnection.getConnection();
	}
	
	public boolean addSoldier(SoldierDTO newSoldier) {
		try {
			String sql = "insert into soldier (Sarmycode, Sgrade, Sname, Sbirth, Sstate, gunnum, Scamp) values(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, newSoldier.sarmycode);
			ps.setString(2, newSoldier.sgrade);
			ps.setString(3, newSoldier.sname);
			ps.setString(4, newSoldier.sbirth);
			ps.setString(5, newSoldier.sstate);
			ps.setInt(6, newSoldier.gunnum);
			ps.setInt(7, newSoldier.scamp);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
		}return false;
	}
	
	public boolean removeSoldier(String sac) {
		try {
			String sql = "delete from soldier where Sarmycode = "+sac;
			ps = conn.prepareStatement(sql);
			return ps.executeUpdate() == 1;
		}catch(SQLException e) {
		}return false;
	}
	
	public ArrayList<SoldierDTO> getList(int scamp){
		ArrayList<SoldierDTO> result = new ArrayList<SoldierDTO>();
		try {
			String sql = "select * from soldier where Scamp = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, scamp);
			rs = ps.executeQuery();
			while(rs.next()) {
				SoldierDTO s = new SoldierDTO();
				s.sarmycode = rs.getString("Sarmycode");
				s.sname = rs.getString("Sname");
				s.sgrade = rs.getString("Sgrade");
				result.add(s);
			}
		}catch (SQLException e) {
		}
		return result;
	}
	
	public int getListG(String sac){
		int result = 0;
		try {
			String sql = "select gunnum from soldier where Sarmycode = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sac);
			rs = ps.executeQuery();
			while(rs.next()) {
				result = rs.getInt("gunnum");
				return result;
			}
		}catch (SQLException e) {
		}
		return result;
	}
	
	// 병사 정보 수정 시작
	public boolean modifyGrade(String Sgrade, String Sarmycode) {
		try {
			String sql = "update soldier set Sgrade = ? where Sarmycode = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, Sgrade);
			ps.setString(2, Sarmycode);
			return ps.executeUpdate() == 1;
		}catch(SQLException e) {
		}return false;
	}
	public boolean modifyState(String Sstate, String Sarmycode) {
		try {
			String sql = "update soldier set Sstate = ? where Sarmycode = " + Sarmycode;
			ps = conn.prepareStatement(sql);
			ps.setString(1, Sstate);
			return ps.executeUpdate() == 1;
		}catch(SQLException e) {
		}return false;
	}
	public boolean modifyBelong(String Scamp, String Sarmycode) {
		// 사단변경
		try {
			String sql = "update Soldier set Scamp = ? where Sarmycode = " + Sarmycode;
			ps = conn.prepareStatement(sql);
			ps.setString(1, Scamp);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
		}
		return false;
	}
	// 병사 정보 수정 끝
	
	public boolean certification(String milinum, String pw) {
		String sql = "select * from soldierlog where sarmycode = ? and pw = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, milinum);
			ps.setString(2, pw);
			
			rs = ps.executeQuery();
			
			return rs.next();
			}
		catch (SQLException e) {
			}
		return false;
			
	}
	
	public ArrayList<SoldierDTO> search2(String milinum){
		 ArrayList<SoldierDTO> result = new ArrayList<SoldierDTO>();
		String sql = "select * from soldier where sarmycode = ?";
		 try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, milinum);
			 rs = ps.executeQuery();
			 while(rs.next()) {
				 SoldierDTO Soldierdto = new SoldierDTO();
				 Soldierdto.sarmycode = rs.getString("sarmycode");
				 Soldierdto.sgrade = rs.getString("sgrade");
				 Soldierdto.sname = rs.getString("ssname");
				 Soldierdto.sbirth = rs.getString("sbirth");
				 Soldierdto.sstate = rs.getString("sstate");
				 Soldierdto.gunnum = rs.getInt("gunnum");
				 Soldierdto.scamp = rs.getInt("scamp");
				 
				 result.add(Soldierdto);
				
			 	}
		 } 
		 catch (SQLException e) {}
		 return result;
	}
	
	public boolean inspect(String milinum) {
		
		String sql = "select * from soldierlog where sarmycode = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, milinum);
			
			rs = ps.executeQuery();
			
			return !rs.next();
			}
		catch (SQLException e) {
			}
		return false;
	}
	
	public boolean Join(SoldierDTO Soldierdto) {
		String sql = "insert into soldierlog (sarmycode,pw) values(?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,Soldierdto.sarmycode);
			ps.setString(2,Soldierdto.pw);
			
			return ps.executeUpdate() == 1;
			
		} catch (SQLException e) {	
		}
		return false;
	}

	public boolean checkId(String Sarmycode) {
		try {
			String sql = "select * from soldier where Sarmycode = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, Sarmycode);
			
			rs = ps.executeQuery();
			
			return rs.next();			
		} catch (SQLException e) {
		}
		return false;
	}
	
}
