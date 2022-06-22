package kr.co.samjo.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.utility.DBClose;
import net.utility.DBOpen;

public class cartDAO {
	private DBOpen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private StringBuilder sql=null;

	public ArrayList<cartDTO> list(String user_id){
		ArrayList<cartDTO> list=null;
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" SELECT c_no, user_id, s_code, cnt, p_cnt, sdate, fdate ");
            sql.append(" FROM tb_cart ");
            sql.append(" WHERE user_id=? ");
            sql.append(" ORDER BY c_no DESC ");
            
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setString(1, user_id);
            
            rs=pstmt.executeQuery();
            if(rs.next()) {
                list=new ArrayList<cartDTO>();
                do {
                	cartDTO dto=new cartDTO(); //한줄담기
                	dto.setC_no(rs.getInt("c_no"));
                	dto.setUser_id(rs.getString("user_id"));
                	dto.setS_code(rs.getString("s_code"));
                	dto.setCnt(rs.getInt("cnt"));
                	dto.setP_cnt(rs.getInt("p_cnt"));
                	dto.setSdate(rs.getString("sdate"));
                	dto.setFdate(rs.getString("fdate"));
                    list.add(dto); //list에 모으기
                }while(rs.next());
            }//end
            
        }catch (Exception e) {
            System.out.println("카트 전체목록 실패:"+e);
        }finally {
            DBClose.close(con, pstmt, rs);
        }//end		
		return list;
	}//list() end

	public int create(cartDTO dto) {
		int cnt=0;
		try {
			con=dbopen.getConnection(); //DB연결
			
			sql=new StringBuilder();

			sql.append(" INSERT INTO tb_cart(c_no, user_id, s_code, cnt, p_cnt, sdate, fdate) ");
			sql.append(" VALUES( cart_seq.nextval, ?, ?, ?, ?, ?, ?) ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getUser_id());
			pstmt.setString(2, dto.getS_code());
			pstmt.setInt(3, dto.getCnt());
			pstmt.setInt(4, dto.getP_cnt());
			pstmt.setString(5, dto.getSdate());
			pstmt.setString(6, dto.getFdate());
			
			cnt=pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("장바구니등록실패" + e);
		}finally {
			DBClose.close(con,pstmt);
		}
		return cnt;
	}

	public int delete(int c_no) {
		int cnt=0;
		try {			
			con=dbopen.getConnection(); //DB연결
			sql=new StringBuilder();
			sql.append(" DELETE FROM tb_cart ");
			sql.append(" WHERE c_no=? ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, c_no);
			cnt=pstmt.executeUpdate();
						
		} catch (Exception e) {
            System.out.println("장바구니 목록 삭제 실패:"+e);
        } finally {
            DBClose.close(con, pstmt);
        }//end
		
		return cnt;
	}	
}
