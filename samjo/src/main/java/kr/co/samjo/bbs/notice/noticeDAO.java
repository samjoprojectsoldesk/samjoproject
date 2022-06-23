package kr.co.samjo.bbs.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.samjo.tour.TourDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

public class noticeDAO {//데이터베이스 관련 작업
    
    private DBOpen dbopen=null;
    private Connection con=null;
    private PreparedStatement pstmt=null;
    private ResultSet rs=null;
    private StringBuilder sql=null;
    
    public noticeDAO() {
        dbopen=new DBOpen();    
    }//end

    
//create 
    public int create(noticeDTO dto) {
        int cnt=0;
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" INSERT INTO tb_board(board_no, board_title, board_content, board_date, board_readcnt) ");
            sql.append(" VALUES (bbs_seq.nextval, ?, ?, ?, ?, ?, (SELECT NVL(MAX(board_no), 0)+1 FROM tb_board)) ");

            pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, dto.getBoard_no());
            pstmt.setString(2, dto.getBoard_title());
            pstmt.setString(3, dto.getBoard_content());
            pstmt.setString(4, dto.getBoard_date());
            pstmt.setInt(5, dto.getBoard_readcnt());
            
            cnt=pstmt.executeUpdate();
            
        }catch (Exception e) {
            System.out.println("공지사항 등록 실패:"+e);
        }finally {
            DBClose.close(con, pstmt);
        }//end
        return cnt;
    }//create() end
    
    
//list
    public ArrayList<noticeDTO> list(int start, int end){
        ArrayList<noticeDTO> list=null;
        try {
            con=dbopen.getConnection();
            sql=new StringBuilder();
           
            sql.append(" SELECT AA.* ");
            sql.append(" FROM ( ");
            sql.append("        SELECT ROWNUM as RNUM, BB.* ");
            sql.append("        FROM ( ");
            sql.append("               SELECT board_no, board_title, board_content, board_date, board_readcnt ");
            sql.append("               FROM tb_tb_board ");
            sql.append(" 			   WHERE t_dividecn = 1 ");
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
    }//list() end
    
   
    
    
//read  
    public noticeDTO read(int board_no) {
    	noticeDTO dto=null;
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" SELECT board_no, board_title, board_content, board_date, board_readcnt ");
            sql.append(" FROM tb_board ");
            sql.append(" WHERE board_no=? ");
            
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, board_no);
            
            rs=pstmt.executeQuery();
            if(rs.next()) {
                dto=new noticeDTO();
                dto.setBoard_no(rs.getInt("board_no"));
                dto.setBoard_title(rs.getString("board_title"));
                dto.setBoard_content(rs.getString("board_content"));
                dto.setBoard_date(rs.getString("board_date"));
                dto.setBoard_readcnt(rs.getInt("board_readcnt"));
            }//end
            
        }catch (Exception e) {
            System.out.println("상세보기실패:"+e);
        }finally {
            DBClose.close(con, pstmt, rs);
        }//end
        return dto;
    }//read() end
    
    
    
  //delete
    public int delete(int board_no) {
    	int cnt=0;
        try {
            con=dbopen.getConnection();
            sql=new StringBuilder();
            sql.append(" DELETE FROM tb_board ");
            sql.append(" WHERE board_no=? "); //관리자 권한 넣기
            
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, board_no);
            cnt=pstmt.executeUpdate();
            
        }catch (Exception e) {
            System.out.println("삭제 실패:"+e);
        }finally {
            DBClose.close(con, pstmt);
        }//end
        return cnt;
    }//delete() end
    
    
    
//incrementCnt(조회수증가)
    public void incrementCnt(int board_no) {
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" UPDATE tb_board ");
            sql.append(" SET board_readcnt = board_readcnt+1 "); 
            sql.append(" WHERE board_no=? ");
            
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, board_no);
            pstmt.executeUpdate();
            
        }catch (Exception e) {
            System.out.println("조회수 증가 실패:"+e);
        }finally {
            DBClose.close(con, pstmt);
        }//end
    }//incrementCnt() end

    		
    
//totalRowCount 
    public int totalRowCount() {
        int cnt=0;
        try {
            con=dbopen.getConnection();
            sql=new StringBuilder();
            sql.append(" SELECT COUNT(*) FROM tb_board WHERE t_dividecn = 1 ");
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
    
    
    
//count
    public ArrayList<noticeDTO> list2(String col, String word){
    	ArrayList<noticeDTO> list=null;
    	try {
    		con=dbopen.getConnection();
    		
    		sql=new StringBuilder();
    		sql.append(" SELECT board_no, board_title, board_content");
    		sql.append(" FROM tb_board ");
    		
    		//검색어가 존재한다면 ------------읭ㅇㅇㅇㅇㅇ모르게뜸
    		if(word.length()>=1) {
    			String search="";
    			if(col.equals("board_content")) {
    				search+=" WHERE subject LIKE '%" + word + "%' ";
    				search+=" or content LIKE '%" + word + "%' ";   			
    			}else if(col.equals("board_title"))	{
    				search+=" WHERE subject LIKE '%" + word + "%' ";
    			}//if end
    			sql.append(search);
       		}//if end
    		
    		//-------------------
			pstmt=con.prepareStatement(sql.toString());
            rs=pstmt.executeQuery();
            if(rs.next()) {
                list=new ArrayList<noticeDTO>();
                do {
                	noticeDTO dto=new noticeDTO(); //한줄담기
                    dto.setBoard_no(rs.getInt("board_no"));
                    dto.setBoard_title(rs.getString("board_title"));
                    dto.setBoard_content(rs.getString("board_content"));
                    dto.setBoard_date(rs.getString("board_date"));
                    dto.setBoard_readcnt(rs.getInt("board_readcnt"));
                    list.add(dto); //list에 모으기
                }while(rs.next());
            }//list2() end
            
    		
    	}catch (Exception e) {
            System.out.println("글갯수실패:"+e);
        }finally {
            DBClose.close(con, pstmt, rs);
        }//end
        return list;
    }//count() end
    


	public int bbsInsProc(noticeDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}
    
}//class end   