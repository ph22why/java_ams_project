package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.LetterDTO;

public class LetterDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public LetterDAO() {
		conn = DBConnection.getConnection();
	}

	public boolean post(LetterDTO letter) {
		//받은 정보를 테이블에 삽입 
		String sql = "insert into letter (soldier_milinum,letter_title,letter_content,timedata) values(?,?,?,now())";
		
		try {
			//(다리에서 택배차를 준비시킴) sql명령문을  ps에 넣기 
			ps = conn.prepareStatement(sql);
			//몇번째 물음표에 간부의 정보를 넣어줘라.
			ps.setString(1,letter.soldier_milinum);
			ps.setString(2,letter.letter_title);
			ps.setString(3,letter.letter_content );
		
			//insert는 executeUpdate수행
			//간부의 정보가 행 1개가 추가 되면 트루!
			return ps.executeUpdate() == 1;
			
		} catch (SQLException e) {
			
		}
		
		return false;
	}

	public ArrayList<LetterDTO> search() {
		ArrayList<LetterDTO> result = new ArrayList<LetterDTO>();
		String sql ="select * from letter";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				LetterDTO Letterdto = new LetterDTO();
				Letterdto.letternum= rs.getInt("letternum");
				Letterdto.soldier_milinum = rs.getString("soldier_milinum");
				Letterdto.letter_title = rs.getString("letter_title");
				Letterdto.letter_content = rs.getString("letter_content");
				result.add(Letterdto);
				
			}
		} catch (SQLException e) {
		
		
		}
		
		return result;
	}

	public boolean delete(int choice) {
		String sql = "delete from letter where letternum = ?";
		
		try {
			ps= conn.prepareStatement(sql);
			ps.setInt(1, choice);
			return ps.executeUpdate() ==1;
		} catch (SQLException e) {
		
	
		}
		return false;
	}

}
