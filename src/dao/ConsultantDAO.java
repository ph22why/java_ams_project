package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.ConsultantDTO;

public class ConsultantDAO {
	
	private Connection conn;
	private	PreparedStatement ps;
	private	ResultSet rs;
	
	//다리를 통해서 데이터베이스를 연결
	//Consultant 생성자가 호출되었다면 DB연결
	public ConsultantDAO() {
		conn = DBConnection.getConnection();
	}

	public boolean checkid(String id) {
		
				//받은 아이디로로 가입된 게 있다면 모든정보를 검색.
				String sql = "select * from consultant where id = ?";
				try {
					//(다리에서 택배차를 준비시킴) sql명령문을  ps에 넣기 
					ps = conn.prepareStatement(sql);
					//첫번째 물음표에 간부의 군번을 넣어줘라.
					ps.setString(1,id);
					// select문은 executeQuery를 함.
					// sql문 수행하기 위해서 executeQuery문을 써주고 그 결과를 rs에 담아준다.
					rs = ps.executeQuery();
					//행을 바꿔서 검색해보고 없으면 true!
					return !rs.next();
				} catch (SQLException e) {
					
				}
				
				return false;
			}

	public boolean join(ConsultantDTO newConsultant) {
		
		//받은 정보를 테이블에 삽입 
		String sql = "insert into consultant (id,pw,name,birdate,addr) values(?,?,?,?,?)";
		
		try {
			//(다리에서 택배차를 준비시킴) sql명령문을  ps에 넣기 
			ps = conn.prepareStatement(sql);
			//몇번째 물음표에 간부의 정보를 넣어줘라.
			ps.setString(1,newConsultant.id);
			ps.setString(2,newConsultant.pw );
			ps.setString(3,newConsultant.name );
			ps.setString(4,newConsultant.birdate );
			ps.setString(5,newConsultant.addr );
		
			//insert는 executeUpdate수행
			//상담사의 정보가 행 1개가 추가 되면 트루!
			return ps.executeUpdate() == 1;
			
		} catch (SQLException e) {
			
		}
		
		return false;
	
	}

	public boolean login(String id, String pw) {
		//받은 아이디로로 가입된 게 있다면 모든정보를 검색.
		String sql = "select * from consultant where id = ? and pw = ?";
		try {
			//(다리에서 택배차를 준비시킴) sql명령문을  ps에 넣기 
			ps = conn.prepareStatement(sql);
			//첫번째 물음표에 간부의 군번을 넣어줘라.
			ps.setString(1,id);
			ps.setString(2,pw);
			// select문은 executeQuery를 함.
			// sql문 수행하기 위해서 executeQuery문을 써주고 그 결과를 rs에 담아준다.
			rs = ps.executeQuery();
			//행을 바꿔서 검색해보고 없으면 true!
			if(rs.next()) {
				ConsultantDTO Consultantuser = new ConsultantDTO();
				Consultantuser.id = rs.getString("id");
				Consultantuser.pw = rs.getString("pw");
				Consultantuser.name = rs.getString("name");
				Consultantuser.birdate = rs.getString("birdate");
				Consultantuser.addr = rs.getString("addr");
				
				Session.setData("Consultantuser", Consultantuser);
				return true;
			}
		} catch (SQLException e) {
			
		}
		return false;
	}
	
	
}