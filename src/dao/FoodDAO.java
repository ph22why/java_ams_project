package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.FoodDTO;
import dto.ManagerDTO;

public class FoodDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public FoodDAO() {
		conn = DBConnection.getConnection();
	}

	public boolean addFood(FoodDTO newFood) {
		String sql = "insert into food (foodname,foodamount,foodexpdate) values(?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, newFood.foodname);
			ps.setInt(2, newFood.foodamount);
			ps.setString(3, newFood.foodexpdate);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
		}return false;
	}

	public ArrayList<FoodDTO> getList() {
		ArrayList<FoodDTO> result = new ArrayList<FoodDTO>();
		String sql = "select * from food";

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				FoodDTO f = new FoodDTO();
				f.foodname = rs.getString("foodname" );
				f.foodamount = rs.getInt("foodamount" );
				f.foodexpdate = rs.getString("foodexpdate");
			
				result.add(f);
			}
		} catch (SQLException e) {
		}
		
		return result;
	}

	public boolean updateFood(String foodname, int newamount) {
		try {
			String sql = "update food set foodamount = (foodamount - ?) where foodname = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, newamount);
			ps.setString(2, foodname);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
		}return false;
	}
	
	public int checkfoodamount(String foodname) {
		try {
			String sql = "select foodamount from food where foodname = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, foodname);	
			rs = ps.executeQuery();
			if(rs.next()) {
				int amount = rs.getInt(1);
				return amount;
			}
		}catch(SQLException e) {
		}return 0;
	}
	
	public boolean removeFood(String foodname) {
		try {
			String sql = "delete from food where foodname = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, foodname);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}

	public boolean modifyFood(String foodname, int choice, String newData) {
	      String sql = "";
	      try {
	         switch(choice) {
	         case 1: 
	            sql = "update food set foodexpdate = ? where foodname = ?";
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, newData);
	            ps.setString(2, foodname);
	            break;
	         case 2:
	            sql = "update food set foodamount = ? where foodname = ?";
	            ps = conn.prepareStatement(sql);
	            ps.setInt(1, Integer.parseInt(newData));
	            ps.setString(2, foodname);
	            break;
	         }
	         return ps.executeUpdate() == 1;
	      } catch (NumberFormatException e) {
	         System.out.println("number이쎕션");
	      } catch (SQLException e) {
	         System.out.println(e);
	      }
	      return false;
	   }


	public ArrayList<FoodDTO> search(String keyword) {
		ArrayList<FoodDTO> result = new ArrayList<FoodDTO>();
		String sql = "select * from food where foodname like('%"+keyword+"%')";
		try {
			ps = conn.prepareStatement(sql);		
			rs = ps.executeQuery();
			while(rs.next()) {
				FoodDTO f = new FoodDTO();
				f.foodname = rs.getString("foodname" );
				f.foodamount = rs.getInt("foodamount" );
				f.foodexpdate = rs.getString("foodexpdate");
			
				result.add(f);
			}
		} catch (SQLException e) {
		}
		
		return result;
	}
	
}


