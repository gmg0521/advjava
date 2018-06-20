package Mini_Game_Heaven;

import java.sql.*;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class MemberDAO {
	
	private static final String DRIVER
		= "com.mysql.cj.jdbc.Driver";
	private static final String USER = "root";
	private static final String PASS = "admin";
	private static final String URL =  
			"jdbc:mysql://35.194.164.240:3306/member";
	
	public Connection getConn() {
		Connection con = null;
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASS);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public MemberDTO getMemberDTO(String id) {
		
		MemberDTO dto = new MemberDTO();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			con = getConn();
			String sql = "select * from tb_member where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setScore1(rs.getInt("score1"));
				dto.setScore2(rs.getInt("score2"));
				dto.setScore3(rs.getDouble("score3"));
				dto.setScore4(rs.getInt("score4"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public Vector getMemberList(String game) {
		
		Vector data = new Vector();
		
		Connection con = null;	//연결
		PreparedStatement ps = null;	//명령
		ResultSet rs = null;	//결과
		switch(game) {
		case "game1":
			try {
				con = getConn();
				String sql = "select * from tb_member order by Score1 desc";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					String id = rs.getString("id");
					int score1 = rs.getInt("score1");
					
					Vector row = new Vector();
					row.add(0, null);
					row.add(1, id);
					row.add(2, score1);
					row.add(3, null);
					
					data.add(row);
				}//while
			} catch(Exception e) {
				e.printStackTrace();
			}
			return data;
		case "game2":
			try {
				con = getConn();
				String sql = "select * from tb_member order by Score2 desc";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					String id = rs.getString("id");
					int score2 = rs.getInt("score2");
					
					Vector row = new Vector();
					row.add(0, null);
					row.add(1, id);
					row.add(2, score2);
					row.add(3, null);
					
					data.add(row);
				}//while
			} catch(Exception e) {
				e.printStackTrace();
			}
			return data;
		case "game3":
			try {
				con = getConn();
				String sql = "select * from tb_member order by Score3 asc";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					String id = rs.getString("id");
					Double Score3 = rs.getDouble("Score3");
					
					Vector row = new Vector();
					row.add(0, null);
					row.add(1, id);
					row.add(2, Score3);
					row.add(3, null);
					
					data.add(row);
				}//while
			} catch(Exception e) {
				e.printStackTrace();
			}
			return data;
		case "game4":
			try {
				con = getConn();
				String sql = "select * from tb_member order by Score4 desc";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					String id = rs.getString("id");
					int score4 = rs.getInt("score4");
					
					Vector row = new Vector();
					row.add(0, null);
					row.add(1, id);
					row.add(2, score4);
					row.add(3, null);
					
					data.add(row);
				}//while
			} catch(Exception e) {
				e.printStackTrace();
			}
			return data;
		}
		return data;
		
		
	}//getMemberList()
	
	public boolean insertMember(MemberDTO dto) {
		
		boolean ok = false;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			con = getConn();
			String sql = "insert into tb_member(" +
						"id, pw, score1, score2, score3, score4) "+
						"values(?,?,?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setInt(3, dto.getScore1());
			ps.setInt(4, dto.getScore2());
			ps.setDouble(5, dto.getScore3());
			ps.setInt(6, dto.getScore4());
			
			int r = ps.executeUpdate(); // 실행 저장
			
			if(r>0) {
				System.out.println("가입 성공");
				ok = true;
			}else
				System.out.println("가입 실패");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ok;
	}//insertMember
	
	public boolean deleteMember(String id, String pw) {

		boolean ok = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			
			con = getConn();
			String sql = "delete from tb_member where id=? and pw=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			int r = ps.executeUpdate();	// 실행 -> 삭제
			
			if (r>0) ok=true; // 삭제됨
			} catch (Exception e) {
				System.out.println(e + "-> 오류발생");
			}
		return ok;
	}
	
	public void userSelectAll(DefaultTableModel model) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		try {
			con = getConn();
			String sql = "select * from tb_member order by id asc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			// DefaultTableModel에 있는 데이터 지우기
			for (int i = 0; i < model.getRowCount();) {
				model.removeRow(0);
			}
			
			while (rs.next()) {
				Object data[] = { rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
				model.addRow(data);
			}
		}catch (SQLException e) {
			System.out.println(e + " => userSelectAll fail");
		} finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			if(ps!=null)
				try {
					ps.close();
				}catch (SQLException e1) {
					e1.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	public boolean chkIdPw(String id, String pw) {
		
			MemberDTO dto = getMemberDTO(id);
			return pw.equals(dto.getPw()) ? true : false;
	}
	
	public <Number> boolean setScore(String id, String game, Number score) {
		boolean flag = true;
		MemberDTO dto = getMemberDTO(id);
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConn();
			
			switch(game) {
			case "game1":
			if(dto.getScore1() < (int) score) {
					dto.setScore1((int) score);
					String sql = "update tb_member set Score1=? where id=?";
					ps = con.prepareStatement(sql);
					ps.setInt(1, dto.getScore1());
					ps.setString(2, id);
					int r = ps.executeUpdate();
					if(r < 0) flag = false;
				}
				break;
			case "game2":
				if(dto.getScore2() < (int) score) {
					dto.setScore2((int) score);
					String sql = "update tb_member SET Score2 = ? where id = ?";
					ps = con.prepareStatement(sql);
					ps.setInt(1, dto.getScore2());
					ps.setString(2, id);
					int r = ps.executeUpdate();
					if(r < 0) flag = true;
				}
				break;
			case "game3":
				if(dto.getScore3() > (double) score) {
					dto.setScore3((double) score);
					String sql = "UPDATE tb_member SET Score3 = ? where id = ?";
					ps = con.prepareStatement(sql);
					ps.setDouble(1, dto.getScore3());
					ps.setString(2, id);
					int r = ps.executeUpdate();
					if(r < 0) flag = true;
				}
				break;
			case "game4":
				if(dto.getScore4() < (int) score) {
					dto.setScore4((int) score);
					String sql = "update tb_member set Score4=? where id=?";
					ps = con.prepareStatement(sql);
					ps.setInt(1, dto.getScore4());
					ps.setString(2, id);
					int r = ps.executeUpdate();
					if(r < 0) flag = false;
				}
				break;
			}
			return flag;
		}catch(SQLException e) {
			System.out.println(e + " => setScore Fail");
		}
		return flag;
	}
}
