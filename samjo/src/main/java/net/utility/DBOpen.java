package net.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBOpen {
<<<<<<< HEAD
	
	//오라클 DB 연결 메소드
	public Connection getConnection() {
		
		Connection con = null;
		
		try {
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "1234";
			String driver = "oracle.jdbc.driver.OracleDriver";//ojdbc8.jar
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			
		}catch(Exception e) {
				System.out.println("오라클 DB 연결 실패: " + e);
		}//end
		
		return con;
	}//getConnection() end
}//cladd end
=======
	//오라클 DB 연결 메소드
	public Connection getConnection() {
		Connection con=null;
		try {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="system";
			String password="1234";
			String driver="oracle.jdbc.driver.OracleDriver"; //ojdbc8.jar
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			System.out.println("오라클DB연결실패:" + e);
		}
		
		return con;
	}
}
>>>>>>> 0e885f2360e516d5663ab3e7a3d3b1eefa40f3a5
