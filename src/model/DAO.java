package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

	Connection conn = null;
	int cnt;
	PreparedStatement psmt = null;
	ResultSet rs;
	boolean result;
	String nick2;

	public String getNick2() {
		return nick2;
	}

	public int getRank(int sum, String a) {
		connect();

		try {
			String sql = "update mc_lanking set score = ?, lankdate = sysdate where nick = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sum);
			psmt.setString(2, a);

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SQL 작동 실패");
		}
		close();

		return cnt;
	}

	public boolean login(String id, String pw) {
		connect();

		try {
			String sql = "select nick from mc_member where id=? and pw=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			if (rs.next() == true) {
				nick2 = rs.getString("nick");
				result = true;
			} else {
				result = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return result;

	}

	public int insert(DTO dto) {
		connect();

		try {
			String id = dto.getId();
			String pw = dto.getPw();
			String nick = dto.getNick();

			String sql = "insert into mc_member values(?,?,?)";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, nick);

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return cnt;

	}

	public void insertranknick(DTO dto) {
		connect();
		try {
			String nick = dto.getNick();
			String sql2 = "insert into mc_lanking (nick) values (?) ";
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, nick);
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
		close();
	}

	public int update(DTO dto) {

		connect();
		try {
			String id = dto.getId();
			String pw = dto.getPw();
			String sql = "update mc_member set pw = ?  where id = ?";
			psmt = conn.prepareStatement(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		close();
		return cnt;
	}

	// 랭킹 확인
	public void selectAll() {
		connect();

		try {
			String sql = "select * from MC_LANKING order by score desc";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			int rank = 1;

			System.out.println("\t\t\tRank\tNICK\tSCORE\tRANKDATE\t\t");
			System.out.println("===================================================================================");
			while (rs.next()) {
				String nick = rs.getString(1);
				int score = rs.getInt(2);
				String Rankdate = rs.getString(3);
				System.out.printf("\t\t\t" + rank++ + "\t%s\t%s\t%s\t\t%n", nick, score, Rankdate);
			}

			close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		close();
	}

	// 회원 탈퇴
	public int delete(String id) {
		connect();

		try {
			String sql = "delete from mc_member where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		close();
		return cnt;
	}

	// close
	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// connect
	private void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_a_1123_1";
			String db_pw = "smhrd1";

			conn = DriverManager.getConnection(url, db_id, db_pw);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
