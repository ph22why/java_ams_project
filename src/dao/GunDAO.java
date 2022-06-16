package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.GunDTO;
import dto.ManagerDTO;;

public class GunDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public GunDAO() {
		conn = DBConnection.getConnection();
	}
	
	public boolean checkgnum(int gunnum) {
		try {
			String sql = "select * from gun where gunnum = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, gunnum);
			
			rs = ps.executeQuery();
			
			return !rs.next();
		} catch (SQLException e) {
		}
		return false;
	}

	public boolean gjoin(GunDTO newGun) {
		try {
			String sql = "insert into gun (gunnum,gunname) values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, newGun.gunnum);
			ps.setString(2, newGun.gunname);
			
			return ps.executeUpdate() == 1;
			
		} catch (SQLException e) {
		}
		return false;
	}
	
	public boolean removeAll(String Marmycode) {
		String sql = "delete from gun where Marmycode = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, Marmycode);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
		}
		return false;
	}

	public boolean removeSAll(String sac) {
		String sql = "delete from gun where Sarmycode = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, sac);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
		}
		return false;
	}
	
	public ArrayList<GunDTO> getList() {
	      ArrayList<GunDTO> result = new ArrayList<GunDTO>();
	      String sql = "select * from gun";

	      try {
	         ps = conn.prepareStatement(sql);
	         rs = ps.executeQuery();
	         
	         while(rs.next()) {
	            GunDTO g = new GunDTO();
	            g.gunnum = rs.getInt("gunnum");
	            g.gunname = rs.getString("gunname" );
	         
	            result.add(g);
	         }
	      } catch (SQLException e) {   
	      }
	      
	      return result;
	   }

	public boolean removeGun(int gunnum) {
		String sql = "delete from gun where gunnum = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, gunnum);
			Session.setData("loginManager", null);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
		}
		return false;
	}

	public boolean modifyGun(int gunnum, int choice, String newData) {
		String sql = "";
		String[] cols = {"","gunnum","gunname"};
		try {
			switch(choice) {
			case 1:
				sql = "update gun set gunnum = ? where gunnum = "+gunnum;
				ps = conn.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(newData));
				break;
			case 2:
				sql = "update gun set gunname = ? where gunnum = "+gunnum;
				ps = conn.prepareStatement(sql);
				ps.setString(1, newData);
				break;
			}
			return ps.executeUpdate() == 1;
		} catch (NumberFormatException e) {
		} catch (SQLException e) {
		}
		return false;
	}

	public boolean addGun(GunDTO newGun) {
		String sql = "insert into gun (gunnum,gunname) values(?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, newGun.gunnum);
			ps.setString(2, newGun.gunname);
			
			
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
		}
		return false;
	}

	public ArrayList<GunDTO> search(String gunname) {
	      ArrayList<GunDTO> result = new ArrayList<GunDTO>();
	      String sql = "select * from gun where gunname = ?";
	      
	      try {
	         ps = conn.prepareStatement(sql);
	         ps.setString(1, gunname);
	         rs = ps.executeQuery();
	            
	         while(rs.next()) {
	            GunDTO g = new GunDTO();
	            g.gunnum = rs.getInt("gunnum");
	            g.gunname = rs.getString("gunname" );
	            
	            result.add(g);
	         }
	      } catch (SQLException e) {   
	      }
	         
	      return result;
	   }	
}
