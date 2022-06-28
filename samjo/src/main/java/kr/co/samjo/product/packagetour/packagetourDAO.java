package kr.co.samjo.product.packagetour;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.samjo.tour.TourDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

public class packagetourDAO {
	private DBOpen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private StringBuilder sql=null;
	
	public packagetourDAO() {
		dbopen=new DBOpen();
	}//end
	

//create
	public int create(packagetourDTO dto) {
		int cnt = 0;
		try {
			con = dbopen.getConnection(); // DB연결

			sql = new StringBuilder();
			sql.append(" INSERT INTO tb_tour(pack_no, pack_name, pack_cose, pack_plan, pack_price, pack_people, pack_cont, pack_img) ");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, sysdate) ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getPack_no());
			pstmt.setString(2, dto.getPack_name());
			pstmt.setString(3, dto.getPack_cose());		
			pstmt.setString(4, dto.getPack_plan());	
			pstmt.setInt(5, dto.getPack_price());
			pstmt.setInt(6, dto.getPack_people());
			pstmt.setString(7, dto.getPack_img());
			pstmt.setString(8, dto.getPack_cont());
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("패키지 여행 등록 실패: " + e);
		} finally {
			DBClose.close(con, pstmt);
		} // end
		return cnt;
	}//create() end
	
	
//list	
	public ArrayList<packagetourDTO> list(int start, int end){
        ArrayList<packagetourDTO> list=null;
        try {
            con=dbopen.getConnection();
            sql=new StringBuilder();
           
            sql.append(" SELECT AA.* ");
            sql.append(" FROM ( ");
            sql.append("        SELECT ROWNUM as RNUM, BB.* ");
            sql.append("        FROM ( ");
            sql.append("               SELECT pack_no, pack_name, pack_cose, pack_plan, pack_price, pack_people, pack_cont, pack_img ");
            sql.append("               FROM tb_package ");
            sql.append("               ORDER BY pack_no DESC ");
            sql.append("             )BB ");
            sql.append("      ) AA ");
            sql.append(" WHERE AA.RNUM >=? AND AA.RNUM<=? ");           
           
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, start);
            pstmt.setInt(2, end);
           
            rs=pstmt.executeQuery();
            if(rs.next()) {
                list=new ArrayList<packagetourDTO>();
                do{
                	packagetourDTO dto=new packagetourDTO();
                	dto.setPack_no(rs.getString("pack_no"));
                	dto.setPack_name(rs.getString("pack_name"));
                	dto.setPack_cose(rs.getString("pack_cose"));
                	dto.setPack_plan(rs.getString("pack_plan"));
                	dto.setPack_price(rs.getInt("pack_price"));
                	dto.setPack_people(rs.getInt("pack_people"));
                	dto.setPack_cont(rs.getString("pack_cont"));
                	dto.setPack_img(rs.getString("pack_img"));
                    list.add(dto);
                }while(rs.next());
            }//if end
           
        }catch(Exception e) {
            System.out.println("패키지 여행 페이징 목록 실패: "+e);
        }finally{
            DBClose.close(con, pstmt, rs);
        }//end   
        return list;
    }//list() end
	
	
	
//totalRowCount	
	public int totalRowCount() {
        int cnt=0;
        try {
            con=dbopen.getConnection();
            sql=new StringBuilder();
            sql.append(" SELECT COUNT(*) FROM tb_package ");
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
	
	

//read	
	public packagetourDTO read(String pack_no) {
		packagetourDTO dto = null;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT pack_no, pack_name, pack_cose, pack_plan, pack_price, pack_people, pack_cont, pack_img ");
			sql.append(" FROM tb_package ");
			sql.append(" WHERE tb_package.pack_no = ? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, pack_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new packagetourDTO();
				dto.setPack_no(rs.getString("pack_no"));
            	dto.setPack_name(rs.getString("pack_name"));
            	dto.setPack_cose(rs.getString("pack_cose"));
            	dto.setPack_plan(rs.getString("pack_plan"));
            	dto.setPack_price(rs.getInt("pack_price"));
            	dto.setPack_people(rs.getInt("pack_people"));
            	dto.setPack_cont(rs.getString("pack_cont"));
            	dto.setPack_img(rs.getString("pack_img"));
			} // if end

		} catch (Exception e) {
			System.out.println("상세보기실패" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		} // end
		return dto;
	}// read() end
	
	
	
//update	
	public int update(packagetourDTO dto) {
		int cnt = 0;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" UPDATE tb_package ");
			sql.append(" SET pack_no=?, pack_name=?, pack_cose=?, pack_plan=?, pack_price=?, pack_people=?, pack_cont=?, pack_img=? ");
			sql.append(" WHERE pack_no=? ");
			
			pstmt = con.prepareStatement(sql.toString());
			dto.setPack_no(rs.getString("pack_no"));
        	dto.setPack_name(rs.getString("pack_name"));
        	dto.setPack_cose(rs.getString("pack_cose"));
        	dto.setPack_plan(rs.getString("pack_plan"));
        	dto.setPack_price(rs.getInt("pack_price"));
        	dto.setPack_people(rs.getInt("pack_people"));
        	dto.setPack_cont(rs.getString("pack_cont"));
        	dto.setPack_img(rs.getString("pack_img"));
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("패키지 여행 수정 실패" + e);
		} finally {
			DBClose.close(con, pstmt);
		} // end
		return cnt;
	}// update() end
	
	
	
//delete	
	public int delete(String pack_no) {
		int cnt = 0;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" DELETE FROM tb_package");
			sql.append(" WHERE pack_no=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, pack_no);
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("삭제 실패" + e);
		} finally {
			DBClose.close(con, pstmt);
		} // end
		return cnt;
	}// delete() end
	
}
