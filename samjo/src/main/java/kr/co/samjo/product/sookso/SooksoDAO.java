package kr.co.samjo.product.sookso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.utility.DBClose;
import net.utility.DBOpen;

public class SooksoDAO {

	private DBOpen dbopen = null;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private StringBuilder sql = null;

	public SooksoDAO() {
		dbopen = new DBOpen();
	}// end

	public int create(SooksoDTO dto) {
		int cnt = 0;
		try {
			con = dbopen.getConnection(); // DB연결

			sql = new StringBuilder();
			sql.append(" INSERT INTO tb_sookso(s_cn, s_name, s_addr, s_tel, s_link, s_cont, s_img) ");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?) ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getS_cn());
			pstmt.setString(2, dto.getS_name());
			pstmt.setString(3, dto.getS_addr());
			pstmt.setString(4, dto.getS_tel());
			pstmt.setString(5, dto.getS_link());
			pstmt.setString(6, dto.getS_cont());
			pstmt.setString(7, dto.getS_img());
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("여행지 등록 실패: " + e);
		} finally {
			DBClose.close(con, pstmt);
		} // end
		return cnt;
	}// create() end
	
	
	public ArrayList<SooksoDTO> list(int start, int end){
        ArrayList<SooksoDTO> list=null;
        try {
            con=dbopen.getConnection();
            sql=new StringBuilder();
           
            sql.append(" SELECT AA.* ");
            sql.append(" FROM ( ");
            sql.append("        SELECT ROWNUM as RNUM, BB.* ");
            sql.append("        FROM ( ");
            sql.append("               SELECT s_cn, s_name, s_addr, s_tel, s_link, s_cont, s_img ");
            sql.append("               FROM tb_sookso ");
            sql.append("               ORDER BY s_cn DESC ");
            sql.append("             )BB ");
            sql.append("      ) AA ");
            sql.append(" WHERE AA.RNUM >=? AND AA.RNUM<=? ");           
           
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, start);
            pstmt.setInt(2, end);
           
            rs=pstmt.executeQuery();
            if(rs.next()) {
                list=new ArrayList<SooksoDTO>();
                do{
                	SooksoDTO dto=new SooksoDTO();
                	dto.setS_cn(rs.getString("s_cn"));
					dto.setS_name(rs.getString("s_name"));
					dto.setS_addr(rs.getString("s_addr"));
					dto.setS_tel(rs.getString("s_tel"));
					dto.setS_link(rs.getString("s_link"));
					dto.setS_cont(rs.getString("s_cont"));
					dto.setS_img(rs.getString("s_img"));
                    list.add(dto);
                }while(rs.next());
            }//if end
           
        }catch(Exception e) {
            System.out.println("숙소 페이징 목록 실패: "+e);
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
            sql.append(" SELECT COUNT(*) FROM tb_sookso ");
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
    
	public SooksoDTO read(String s_cn) {
		SooksoDTO dto = null;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT s_cn, s_name, s_addr, s_tel, s_link, s_cont, s_img ");
			sql.append(" FROM tb_sookso ");
			sql.append(" WHERE tb_tour.s_cn = ? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, s_cn);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new SooksoDTO();
				dto.setS_cn(rs.getString("s_cn"));
				dto.setS_name(rs.getString("s_name"));
				dto.setS_addr(rs.getString("s_addr"));
				dto.setS_tel(rs.getString("s_tel"));
				dto.setS_link(rs.getString("s_link"));
				dto.setS_cont(rs.getString("s_cont"));
				dto.setS_img(rs.getString("s_img"));
			} // if end

		} catch (Exception e) {
			System.out.println("상세보기실패" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		} // end
		return dto;
	}// read() end
	
	
	public int update(SooksoDTO dto) {
		int cnt = 0;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" UPDATE tb_sookso ");
			sql.append(" SET s_name=?, s_addr=?, s_tel=?, s_link=?, s_cont0=?, s_img=? ");
			sql.append(" WHERE s_cn=? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getS_name());
			pstmt.setString(2, dto.getS_addr());
			pstmt.setString(3, dto.getS_tel());
			pstmt.setString(4, dto.getS_link());
			pstmt.setString(5, dto.getS_cont());
			pstmt.setString(6, dto.getS_img());
			pstmt.setString(7, dto.getS_cn());

			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("숙소 수정 실패" + e);
		} finally {
			DBClose.close(con, pstmt);
		} // end
		return cnt;
	}// update() end
	
	public int delete(String s_cn) {
		int cnt = 0;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" DELETE FROM tb_sookso");
			sql.append(" WHERE t_cn=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, s_cn);
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("삭제 실패" + e);
		} finally {
			DBClose.close(con, pstmt);
		} // end
		return cnt;
	}// delete() end
}
