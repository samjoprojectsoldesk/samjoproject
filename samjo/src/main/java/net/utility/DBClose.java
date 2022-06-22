package net.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBClose {
<<<<<<< HEAD
	//DB연결 자원 반납
	
	public static void close(Connection con) {
		try {
			if(con!=null) {con.close();}
		}catch(Exception e) {}
	}//end
=======

	//DB연결 자원 반납
	public static void close(Connection con) {
		try {
			if(con!=null) {con.close();}
		} catch (Exception e) {}
	}
>>>>>>> 0e885f2360e516d5663ab3e7a3d3b1eefa40f3a5
	
	public static void close(Connection con, PreparedStatement pstmt) {
		try {
			if(pstmt!=null) {pstmt.close();}
<<<<<<< HEAD
		}catch(Exception e) {}
		
		try {
			if(con!=null) {con.close();}
		}catch(Exception e) {}
	}//end
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs!=null) {rs.close();}
		}catch(Exception e) {}
		
		try {
			if(pstmt!=null) {pstmt.close();}
		}catch(Exception e) {}
		
		try {
			if(con!=null) {con.close();}
		}catch(Exception e) {}
	}//end
	
}//class end
=======
		} catch (Exception e) {}
		try {
			if(con!=null) {con.close();}
		} catch (Exception e) {}
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try{
			if(rs!=null) {rs.close();}
		}catch (Exception e){}
		try {
			if(pstmt!=null) {pstmt.close();}
		} catch (Exception e) {}
		try {
			if(con!=null) {con.close();}
		} catch (Exception e) {}
	}
}
>>>>>>> 0e885f2360e516d5663ab3e7a3d3b1eefa40f3a5
