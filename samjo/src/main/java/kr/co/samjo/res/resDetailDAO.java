package kr.co.samjo.res;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.samjo.cart.cartDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

public class resDetailDAO {

	private DBOpen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private StringBuilder sql=null;
	
	public resDetailDAO() {
		dbopen = new DBOpen();
	}

	public int create(cartDTO dto, String res_no) {
		int cnt=0;
		try {
			con=dbopen.getConnection(); //DB연결
			
			sql=new StringBuilder();

			sql.append(" INSERT INTO tb_resdetail(res_no, s_code, p_cnt, sdate, fdate) ");
			sql.append(" VALUES( ?, ?, ?, ?, ? ) ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, res_no);
			pstmt.setString(2, dto.getS_code());
			pstmt.setInt(3, dto.getP_cnt());
			pstmt.setString(4, dto.getSdate().toLocaleString());
        	if(dto.getFdate()!=null) {
			pstmt.setString(5, dto.getFdate().toLocaleString());}
        	else {pstmt.setString(5, "NULL");}
			
			cnt=pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("예약상세등록실패" + e);
		}finally {
			DBClose.close(con,pstmt);
		}
		return cnt;
	}
	
	public ArrayList<resDetailDTO> list(String res_no){
		ArrayList<resDetailDTO> list=null;
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" SELECT res_no, s_code, sdate, fdate ");
            sql.append(" FROM tb_resdetail ");
            sql.append(" WHERE res_no=? ");
            sql.append(" ORDER BY res_no DESC ");
            
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setString(1, res_no);
            
            rs=pstmt.executeQuery();
            
            if(rs.next()) {
                list=new ArrayList<resDetailDTO>();
                do {
                	
                	resDetailDTO dto=new resDetailDTO(); //한줄담기
                	dto.setRes_no(rs.getString("res_no"));
                	dto.setS_code(rs.getString("s_code"));
                	dto.setSdate(rs.getString("sdate"));
                	dto.setFdate(rs.getString("fdate"));
                    list.add(dto); //list에 모으기
                }while(rs.next());
            }
            
        }catch (Exception e) {
            System.out.println("예약상세 전체목록 실패:"+e);
        }finally {
            DBClose.close(con, pstmt, rs);
        }//end		
		return list;
	}

}
