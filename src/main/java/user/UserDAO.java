package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {
		try{
			Class.forName("org.sqlite.JDBC");
			String dbFile ="D:\\jsp\\projects\\BBS\\BBS.db";
			//String dbFile ="..\\../../../../BBS.db"; 상대경로를 해보고 싶었던 것
			conn = DriverManager.getConnection("jdbc:sqlite:"+dbFile);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
