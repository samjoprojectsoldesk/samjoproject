package kr.co.samjo.res;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.samjo.cart.cartDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

public class resDAO {

	private DBOpen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private StringBuilder sql=null;
	
	public resDAO() {
		dbopen = new DBOpen();
	}
	
	public int add(resDTO dto) {
		int cnt = 0;
		try {
			con=dbopen.getConnection(); //DB연결
			
			sql=new StringBuilder();

			sql.append(" INSERT INTO tb_reserve(res_no, user_id, amount, pay, p_cnt, result) ");
			sql.append(" VALUES( systimestamp, ?, ?, ?, ?, ?) ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getUser_id());
			pstmt.setLong(2, dto.getAmount());
			pstmt.setString(3, dto.getPay());
			pstmt.setInt(4, dto.getP_cnt());
			pstmt.setString(5, dto.getResult());
			
			cnt=pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("예약등록실패" + e);
		}finally {
			DBClose.close(con,pstmt);
		}
		
		return cnt;
	}

	public ArrayList<resDTO> list(String user_id) {
		ArrayList<resDTO> list = null;
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" SELECT res_no, user_id, amount, pay, p_cnt, result ");
            sql.append(" FROM tb_reserve ");
            sql.append(" WHERE user_id=? ");
            sql.append(" ORDER BY res_no DESC ");
            
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setString(1, user_id);
            
            rs=pstmt.executeQuery();
            
            if(rs.next()) {
                list=new ArrayList<resDTO>();
                do {
                	
                	resDTO dto=new resDTO(); //한줄담기
                	dto.setRes_no(rs.getString("res_no"));
                	dto.setUser_id(rs.getString("user_id"));
                	dto.setAmount(rs.getInt("amount"));
                	dto.setPay(rs.getString("pay"));
                	dto.setP_cnt(rs.getInt("p_cnt"));
                	dto.setResult(rs.getString("result"));
                    list.add(dto); //list에 모으기
                }while(rs.next());
            }
            
        }catch (Exception e) {
            System.out.println("예약 전체 목록 실패:"+e);
        }finally {
            DBClose.close(con, pstmt, rs);
        }//end		
		return list;
	}

}
