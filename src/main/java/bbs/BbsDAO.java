package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BbsDAO {

	private Connection conn;
	private ResultSet rs;
	
	public BbsDAO() {
		try {
			String dbURL = "jdbc:mariadb://rladmstjs120.cafe24.com:3306/rladmstjs120";
			String dbID = "rladmstjs120";
			String dbPassword = "";
			Class.forName("org.mariadb.jdbc.Driver");
			
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getDate() {// 데이터베이스에서 현재시간 가져오기
		String SQL = "SELECT NOW()";
		try {
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getString(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";//빈문자열이 리턴된다면 데이터베이스오류
	}
	
	public int getNext() {//게시물 순서
		String SQL = "SELECT bbsID FROM BBSPRABBS ORDER BY bbsID DESC;";
		try {
			PreparedStatement pstmt;
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1)+1;
			}
			return 1;//첫 번째 게시물인 경우
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;//데이터베이스오류
	}
	
	public int write(String bbsTitle, String userID, String bbsContent) {
		String SQL = "INSERT INTO BBSPRABBS VALUES(?, ?, ?, ?, ?, ?);";
		try {
			PreparedStatement pstmt;
			int next = getNext();
			String date = getDate();
			
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setInt(1, next);
			pstmt.setString(2, bbsTitle);
			pstmt.setString(3, userID);
			pstmt.setString(4, date);
			pstmt.setString(5, bbsContent);
			pstmt.setInt(6, 1);
			
			
			return pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;//데이터베이스오류
	}
}
