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

	public ArrayList<cartDTO> list(){
		ArrayList<cartDTO> list=null;
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" SELECT c_no, user_id, s_code, cnt, p_cnt, sdate, fdate ");
            sql.append(" FROM cart ");
            sql.append(" ORDER BY c_no DESC ");
            
            pstmt=con.prepareStatement(sql.toString());
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
            System.out.println("카드 전체목록 실패:"+e);
        }finally {
            DBClose.close(con, pstmt, rs);
        }//end		
		return list;
	}//list() end
	
}
