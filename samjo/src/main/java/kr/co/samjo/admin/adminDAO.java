package kr.co.samjo.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.samjo.tour.TourDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

public class adminDAO {
	private DBOpen dbopen = null;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private StringBuilder sql = null;

	public adminDAO() {
		dbopen = new DBOpen();
	}// end
	
	public ArrayList<TourDTO> list(int start, int end){
        ArrayList<TourDTO> list=null;
        try {
            con=dbopen.getConnection();
            sql=new StringBuilder();
           
            sql.append(" SELECT AA.* ");
            sql.append(" FROM ( ");
            sql.append("        SELECT ROWNUM as RNUM, BB.* ");
            sql.append("        FROM ( ");
            sql.append("               SELECT t_cn, t_name, t_addr, t_dividecn, t_tel, t_link, t_sche, t_car, t_img, t_cont, t_rdate ");
            sql.append("               FROM tb_tour ");
            sql.append(" 			   WHERE t_dividecn = 1 ");
            sql.append("               ORDER BY t_cn DESC ");
            sql.append("             )BB ");
            sql.append("      ) AA ");
            sql.append(" WHERE AA.RNUM >=? AND AA.RNUM<=? ");           
           
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, start);
            pstmt.setInt(2, end);
           
            rs=pstmt.executeQuery();
            if(rs.next()) {
                list=new ArrayList<TourDTO>();
                do{
                	TourDTO dto=new TourDTO();
                	dto.setT_cn(rs.getString("t_cn"));
					dto.setT_name(rs.getString("t_name"));
					dto.setT_addr(rs.getString("t_addr"));
					dto.setT_dividecn(rs.getInt("t_dividecn"));
					dto.setT_tel(rs.getString("t_tel"));
					dto.setT_link(rs.getString("t_link"));
					dto.setT_sche(rs.getString("t_sche"));
					dto.setT_car(rs.getString("t_car"));
					dto.setT_img(rs.getString("t_img"));
					dto.setT_cont(rs.getString("t_cont"));
					dto.setT_rdate(rs.getString("t_rdate"));
                    list.add(dto);
                }while(rs.next());
            }//if end
           
        }catch(Exception e) {
            System.out.println("여행지 페이징 목록 실패: "+e);
        }finally{
            DBClose.close(con, pstmt, rs);
        }//end   
        return list;
    }//list() end

 
    public int totalRowCount() {
        int cnt=0;
        try {
            con=dbopen.getConnection();
            sql=new StringBuilder();
            sql.append(" SELECT COUNT(*) FROM tb_tour WHERE t_dividecn = 1 ");
            pstmt=con.prepareStatement(sql.toString());
            rs=pstmt.executeQuery();
            if(rs.next()){
                cnt=rs.getInt(1);            
            }//if end          
        }catch(Exception e){
            System.out.println("전체 행 갯수:" + e);
        }finally{
            DBClose.close(con, pstmt);
        }
        return cnt;
    }//totalRowCount() end
    
    public ArrayList<TourDTO> list2(int start, int end) {
		ArrayList<TourDTO> list=null;
        try {
            con=dbopen.getConnection();
            sql=new StringBuilder();
           
            sql.append(" SELECT AA.* ");
            sql.append(" FROM ( ");
            sql.append("        SELECT ROWNUM as RNUM, BB.* ");
            sql.append("        FROM ( ");
            sql.append("               SELECT t_cn, t_name, t_addr, t_dividecn, t_tel, t_link, t_sche, t_car, t_img, t_cont, t_rdate ");
            sql.append("               FROM tb_tour ");
            sql.append(" 			   WHERE t_dividecn = 2 ");
            sql.append("               ORDER BY t_cn DESC ");
            sql.append("             )BB ");
            sql.append("      ) AA ");
            sql.append(" WHERE AA.RNUM >=? AND AA.RNUM<=? ");           
           
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, start);
            pstmt.setInt(2, end);
           
            rs=pstmt.executeQuery();
            if(rs.next()) {
                list=new ArrayList<TourDTO>();
                do{
                	TourDTO dto=new TourDTO();
                	dto.setT_cn(rs.getString("t_cn"));
					dto.setT_name(rs.getString("t_name"));
					dto.setT_addr(rs.getString("t_addr"));
					dto.setT_dividecn(rs.getInt("t_dividecn"));
					dto.setT_tel(rs.getString("t_tel"));
					dto.setT_link(rs.getString("t_link"));
					dto.setT_sche(rs.getString("t_sche"));
					dto.setT_car(rs.getString("t_car"));
					dto.setT_img(rs.getString("t_img"));
					dto.setT_cont(rs.getString("t_cont"));
					dto.setT_rdate(rs.getString("t_rdate"));
                    list.add(dto);
                }while(rs.next());
            }//if end

		} catch (Exception e) {
			System.out.println("문화행사 전체 목록 실패: " + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		} // end
		return list;
	}// list2() end
	
    public int totalRowCount2() {
        int cnt=0;
        try {
            con=dbopen.getConnection();
            sql=new StringBuilder();
            sql.append(" SELECT COUNT(*) FROM tb_tour WHERE t_dividecn = 2 ");
            pstmt=con.prepareStatement(sql.toString());
            rs=pstmt.executeQuery();
            if(rs.next()){
                cnt=rs.getInt(1);            
            }//if end          
        }catch(Exception e){
            System.out.println("전체 행 갯수:" + e);
        }finally{
            DBClose.close(con, pstmt);
        }
        return cnt;
    }//totalRowCoun2t() end

}
