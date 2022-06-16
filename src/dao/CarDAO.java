package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.PreparableStatement;

import dto.CarDTO;

public class CarDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public CarDAO() {
		conn = DBConnection.getConnection();
	}
	
	// 차량 정보 검색 기능 추가(뒷자리로 검색, 차량명으로 검색)
	// 폐기하면 폐기물로 이동
	
	public boolean addCar(CarDTO newcar) {
		try {
			String sql = "insert into car (carnum, carname, caruse) values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, newcar.carnum);
			ps.setString(2, newcar.carname);
			ps.setBoolean(3, newcar.caruse);
			return ps.executeUpdate() == 1;
		}catch(SQLException e) {
		}return false;
	}
	
	public boolean checkCar() {
		try {
			String sql = "select * from ams.car";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			return rs.next();
		}catch(SQLException e) {
		}return false;
	}
	
	public ArrayList<CarDTO> getList(){
		ArrayList<CarDTO> result = new ArrayList<CarDTO>();
		try {
			String sql = "select * from ams.car";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				CarDTO c = new CarDTO();
				c.carnum = rs.getString("carnum");
				c.carname = rs.getString("carname");
				c.caruse = rs.getBoolean("caruse");
				
				result.add(c);
			}
		}catch(SQLException e) {
		}return result;
	}
	
	public boolean modifyCarname(String carname, String carnum) {
		try {
			String sql = "update car set carname = ? where carnum = "+carnum;
			ps = conn.prepareStatement(sql);
			ps.setString(1, carname);
			if(ps.executeUpdate() == 1) {
				sql = "select * from car where carnum = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, carnum);
				rs = ps.executeQuery();
				if(rs.next()) {
					CarDTO c = new CarDTO();
					c.carname = rs.getString("carname");
					c.carnum = rs.getString("carnum");
					c.caruse = rs.getBoolean("caruse");
					Session.setData("c", c);
				}
			}return true;
		}catch(SQLException e) {
		}return false;
	}
	
	public boolean checkCaruse(String carnum) {
		try {
			String sql = "select caruse from car where carnum = ? and caruse is true"; // 차량번호로 해당차량이 true(사용가능한지)확인
			ps = conn.prepareStatement(sql);
			ps.setString(1, carnum);
			rs = ps.executeQuery();
			return rs.next();
		}catch(SQLException e) {
		}return false;
	}
	
	public boolean modifyCaruse(Boolean caruse, String carnum) {
		try {
			String sql = "update car set caruse = ? where carnum = ?";
			ps = conn.prepareStatement(sql);
			ps.setBoolean(1, caruse);
			ps.setString(2, carnum);
			if(ps.executeUpdate() == 1) {
				sql = "select * from car where carnum = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, carnum);
				rs = ps.executeQuery();
				if(rs.next()) {
					CarDTO c = new CarDTO();
					c.carname = rs.getString("carname");
					c.carnum = rs.getString("carnum");
					c.caruse = rs.getBoolean("caruse");
					Session.setData("c", c);
				}
			}return true;
		}catch(SQLException e) {
		}return false;
	}
	
	public boolean cardel(String carnum) {
		try {
			String sql = "delete from car where carnum = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, carnum);
			if(ps.executeUpdate() == 1) {
				Session.setData("c", null);	// 챠랑이 폐차된후 나가지도록 null로 바꿈
				return true;
			}
		}catch(SQLException e) {
		}return false;
	}
	
}
