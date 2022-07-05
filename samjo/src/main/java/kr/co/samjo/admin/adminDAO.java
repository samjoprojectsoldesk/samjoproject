package kr.co.samjo.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import kr.co.samjo.bbs.notice.noticeDTO;
import kr.co.samjo.board2.boardDTO;
import kr.co.samjo.product.sookso.SooksoDTO;
import kr.co.samjo.product.packagetour.packagetourDTO;
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
	
	public ArrayList<TourDTO> list(int start, int end, String word){
        ArrayList<TourDTO> list=null;
        try {
            con=dbopen.getConnection();
            sql=new StringBuilder();
            
            word = word.trim();
           
            sql.append(" SELECT AA.* ");
            sql.append(" FROM ( ");
            sql.append("        SELECT ROWNUM as RNUM, BB.* ");
            sql.append("        FROM ( ");
            sql.append("               SELECT t_cn, t_name, t_addr, t_dividecn, t_tel, t_link, t_sche, t_car, t_img, t_cont, t_rdate ");
            sql.append("               FROM tb_tour ");
            sql.append(" 			   WHERE t_dividecn = 1 ");
            
            if(word.length()!=0) {
				String search="";
	            search += " AND t_name LIKE '%" + word + "%' ";
	            sql.append(search);   
			}
            
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
    
    public ArrayList<TourDTO> list2(int start, int end, String word) {
		ArrayList<TourDTO> list=null;
        try {
            con=dbopen.getConnection();
            sql=new StringBuilder();
            
            word = word.trim();
           
            sql.append(" SELECT AA.* ");
            sql.append(" FROM ( ");
            sql.append("        SELECT ROWNUM as RNUM, BB.* ");
            sql.append("        FROM ( ");
            sql.append("               SELECT t_cn, t_name, t_addr, t_dividecn, t_tel, t_link, t_sche, t_car, t_img, t_cont, t_rdate ");
            sql.append("               FROM tb_tour ");
            sql.append(" 			   WHERE t_dividecn = 2 ");
            
            if(word.length()!=0) {
				String search="";
	            search += " AND t_name LIKE '%" + word + "%' ";
	            sql.append(search);   
			}
            
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
    
    public ArrayList<SooksoDTO> sooksolist(int start, int end){
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
    
    
    public int sooksototalRowCount() {
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
    
    public SooksoDTO sooksoread(String s_cn) {
		SooksoDTO dto = null;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" select * ");
			sql.append(" from tb_sookso left join tb_room ");
			sql.append(" on tb_sookso.s_cn = tb_room.s_cn ");
			sql.append(" WHERE tb_sookso.s_cn = ? ");
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
				dto.setRoom_cn(rs.getString("room_cn"));
				dto.setRoom_img(rs.getString("room_img"));
				dto.setRoom_name(rs.getString("room_name"));
				dto.setRoom_mp(rs.getInt("room_mp"));
				dto.setRoom_dp(rs.getInt("room_dp"));
				dto.setRoom_ep(rs.getInt("room_ep"));
			} // if end

		} catch (Exception e) {
			System.out.println("상세보기실패" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		} // end
		return dto;
	}// read() end
    
    public ArrayList<SooksoDTO> roomlist(int start, int end, String s_cn){
	    ArrayList<SooksoDTO> list=null;
	    try {
	        con=dbopen.getConnection();
	        sql=new StringBuilder();
	       
	        sql.append(" SELECT AA.* ");
	        sql.append(" FROM ( ");
	        sql.append("        SELECT ROWNUM as RNUM, BB.* ");
	        sql.append("        FROM ( ");
	        sql.append("               SELECT room_cn, s_cn ,room_name, room_mp, room_dp, room_ep, room_img ");
	        sql.append("               FROM tb_room ");
	        sql.append("               where s_cn = ? ");
	        sql.append("               ORDER BY room_cn DESC ");
	        sql.append("             )BB ");
	        sql.append("      ) AA ");
	        sql.append(" WHERE AA.RNUM >=? AND AA.RNUM<=? ");           
	       
	        pstmt=con.prepareStatement(sql.toString());
	        pstmt.setInt(2, start);
	        pstmt.setString(1, s_cn);
	        pstmt.setInt(3, end);
	       
	        rs=pstmt.executeQuery();
	        if(rs.next()) {
	            list=new ArrayList<SooksoDTO>();
	            do{
	            	SooksoDTO dto=new SooksoDTO();
	            	dto.setRoom_cn(rs.getString("room_cn"));
					dto.setS_cn(rs.getString("s_cn"));
					dto.setRoom_name(rs.getString("room_name"));
					dto.setRoom_mp(rs.getInt("room_mp"));
					dto.setRoom_dp(rs.getInt("room_dp"));
					dto.setRoom_ep(rs.getInt("room_ep"));
					dto.setRoom_img(rs.getString("room_img"));
	                list.add(dto);
	            }while(rs.next());
	        }//if end
	       
	    }catch(Exception e) {
	        System.out.println("방 페이징 목록 실패: "+e);
	    }finally{
	        DBClose.close(con, pstmt, rs);
	    }//end   
	    return list;
	}//list() end
    
    
    
    /*공지사항*/
    public ArrayList<noticeDTO> bbsList(int start, int end){
        ArrayList<noticeDTO> list=null;
        try {
            con=dbopen.getConnection();
            sql=new StringBuilder();
           
            sql.append(" SELECT AA.* ");
            sql.append(" FROM ( ");
            sql.append("        SELECT ROWNUM as RNUM, BB.* ");
            sql.append("        FROM ( ");
            sql.append("               SELECT board_no, board_title, board_content, board_date, board_readcnt ");
            sql.append("               FROM tb_board ");
            sql.append("               ORDER BY board_no DESC ");
            sql.append("             )BB ");
            sql.append("      ) AA ");
            sql.append(" WHERE AA.RNUM >=? AND AA.RNUM<=? ");           
           
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, start);
            pstmt.setInt(2, end);
           
            rs=pstmt.executeQuery();
            if(rs.next()) {
                list=new ArrayList<noticeDTO>();
                do{
                	noticeDTO dto=new noticeDTO();
                    dto.setBoard_no(rs.getInt("board_no"));
                    dto.setBoard_title(rs.getString("board_title"));
                    dto.setBoard_content(rs.getString("board_content"));
                    dto.setBoard_date(rs.getString("board_date"));
                    dto.setBoard_readcnt(rs.getInt("board_readcnt"));
                    list.add(dto);
                }while(rs.next());
            }//if end
           
        }catch(Exception e) {
            System.out.println("공지사항 페이징 목록 실패: "+e);
        }finally{
            DBClose.close(con, pstmt, rs);
        }//end   
        return list;
    }//bbsList() end
    

    //totalRowCount 
    public int bbstotalRowCount() {
        int cnt=0;
        try {
            con=dbopen.getConnection();
            sql=new StringBuilder();
            sql.append(" SELECT COUNT(*) FROM tb_board ");
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
    }//bbstotalRowCount() end

	public ArrayList<packagetourDTO> list4(int start, int end){
        ArrayList<packagetourDTO> list=null;
        try {
            con=dbopen.getConnection();
            sql=new StringBuilder();
           
            sql.append(" SELECT AA.* ");
            sql.append(" FROM ( ");
            sql.append("        SELECT ROWNUM as RNUM, BB.* ");
            sql.append("        FROM ( ");
            sql.append("               SELECT pack_no, pack_name, pack_cose, pack_plan_start, pack_plan_end, pack_price, pack_people, pack_cont, pack_img ");
            sql.append("               FROM tb_package ");
            sql.append("               ORDER BY pack_no DESC ");
            sql.append("             )BB ");
            sql.append("      ) AA ");
            sql.append(" WHERE AA.RNUM >=? AND AA.RNUM<=? ");           
           
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, start);
            pstmt.setInt(2, end);
           
            rs=pstmt.executeQuery();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy. MM. dd. a HH:mm:ss");
            if(rs.next()) {
                list=new ArrayList<packagetourDTO>();
                do{
                	packagetourDTO dto=new packagetourDTO();
                	dto.setPack_no(rs.getString("pack_no"));
                	dto.setPack_name(rs.getString("pack_name"));
                	dto.setPack_cose(rs.getString("pack_cose"));
                	dto.setPack_plan_start(sdf.parse(rs.getString("pack_plan_start")));
                	dto.setPack_plan_end(sdf.parse(rs.getString("pack_plan_end")));
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
    
    
    public ArrayList<boardDTO> boardlist(int start, int end, String col, String word){
        ArrayList<boardDTO> list=null;
        try {
            con=dbopen.getConnection();
            sql=new StringBuilder();
            
            word = word.trim();
           
            sql.append(" SELECT AA.* ");
            sql.append(" FROM ( ");
            sql.append("        SELECT ROWNUM as RNUM, BB.* ");
            sql.append("        FROM ( ");
            sql.append("               SELECT bbs_idx, bbs_img, bbs_id, bbs_title, bbs_content, bbs_count, bbs_date ");
            sql.append("               FROM tb_bbs2 ");
            
            if(word.length()!=0) {
				String search="";
				if(col.equals("subject")) {
	                search += " WHERE bbs_title LIKE '%" + word + "%' ";
	            }else if(col.equals("content")) {
	                search += " WHERE bbs_content LIKE '%" + word + "%' ";
	            }else if(col.equals("wname")) {
	                search += " WHERE bbs_id LIKE '%" + word + "%' ";
	            }else if(col.equals("subject_content")) {
	                search += " WHERE bbs_title LIKE '%" + word + "%' ";
	                search += " OR bbs_content LIKE '%" + word + "%' ";
	            }//if end
	            sql.append(search);   
			}
            sql.append("               ORDER BY bbs_date DESC ");
            sql.append("             )BB ");
            sql.append("      ) AA ");
            sql.append(" WHERE AA.RNUM >=? AND AA.RNUM<=? ");           
           
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, start);
            pstmt.setInt(2, end);
           
            rs=pstmt.executeQuery();
            if(rs.next()) {
                list=new ArrayList<boardDTO>();
                do{
                	boardDTO dto=new boardDTO();
                	dto.setBbs_idx(rs.getInt("bbs_idx"));
					dto.setBbs_img(rs.getString("bbs_img"));
					dto.setBbs_id(rs.getString("bbs_id"));
					dto.setBbs_title(rs.getString("bbs_title"));
					dto.setBbs_content(rs.getString("bbs_content"));
					dto.setBbs_count(rs.getInt("bbs_count"));
					dto.setBbs_date(rs.getString("bbs_date"));
                    list.add(dto); 
                }while(rs.next());
            }//if end
           
        }catch(Exception e) {
            System.out.println("게시판 페이징 목록 실패: "+e);
        }finally{
            DBClose.close(con, pstmt, rs);
        }//end   
        return list;
    }//boardlist() end
    
    
    public int boardtotalRowCount() {
        int cnt=0;
        try {
            con=dbopen.getConnection();
            sql=new StringBuilder();
            sql.append(" SELECT COUNT(*) FROM tb_bbs2 ");
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
    }//boardtotalRowCount() end
}