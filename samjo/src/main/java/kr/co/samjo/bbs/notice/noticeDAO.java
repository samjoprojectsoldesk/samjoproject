package kr.co.samjo.bbs.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
            System.out.println("추가실패:"+e);
        }finally {
            DBClose.close(con, pstmt);
        }//end
        return cnt;
    }//create() end
    
    
    
    public ArrayList<noticeDTO> list(){
        ArrayList<noticeDTO> list=null;
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" SELECT board_no, board_title, board_content, board_date, board_readcnt ");
            sql.append(" FROM tb_board ");
            
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
            }//end
            
        }catch (Exception e) {
            System.out.println("전체목록실패:"+e);
        }finally {
            DBClose.close(con, pstmt, rs);
        }//end
        return list;
    }//list() end
    
    
    
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
    
    
    
    public void incrementCnt(int board_no) {
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" UPDATE tb_board ");
            sql.append(" SET board_readcnt = board_readcnt+1 "); //모딩
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
    
    
    public int delete(noticeDTO dto) {
    	int cnt=0;
        try {
            con=dbopen.getConnection();
            sql=new StringBuilder();
            sql.append(" DELETE FROM tb_board ");
            sql.append(" WHERE board_no=? "); //관리자 권한 넣기
            
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, dto.getBoard_no());
            cnt=pstmt.executeUpdate();
            
        }catch (Exception e) {
            System.out.println("삭제 실패:"+e);
        }finally {
            DBClose.close(con, pstmt);
        }//end
        return cnt;
    }//delete() end

    
    
    public int updateproc(noticeDTO dto) {
    	int cnt=0;
    	try {
    		con=dbopen.getConnection();
    		sql=new StringBuilder();
    		sql.append(" UPDATE tb_board ");
    		sql.append(" SET board_title=? ");
    		sql.append(" , board_content=? ");
    		sql.append(" WHERE board_no=? AND passwd=? "); //유저 아이디가 같으면 삭제 or id의 권한을 관리자 권한인지 (컨트롤러)
    		
    		pstmt=con.prepareStatement(sql.toString());
    		pstmt.setInt(1, dto.getBoard_no());
    		pstmt.setString(2, dto.getBoard_title());
    		pstmt.setString(3, dto.getBoard_content());
    		//pstmt.setString(4, dto.getPasswd());//관리자 권한 넣기 
    		//pstmt.setInt(5, dto.getBbsno());
    		//pstmt.setString(6, dto.getPasswd());
    		
    		cnt=pstmt.executeUpdate();
    		
    	}catch (Exception e) {
            System.out.println("답변쓰기 실패:"+e);
        }finally {
            DBClose.close(con, pstmt, rs);
        }//end
        return cnt;
    }//updateproc() end
    		
    
    public int count() {
    	int cnt=0;
    	try {
    		con=dbopen.getConnection();
    		
    		sql=new StringBuilder();
    		sql.append(" SELECT COUNT(*) as cnt ");
    		sql.append(" FROM tb_board ");
    		
    		pstmt=con.prepareStatement(sql.toString());
    		rs=pstmt.executeQuery();
    		if(rs.next())	{
    			cnt=rs.getInt("cnt");
    		}//if end
    		
    	}catch (Exception e) {
            System.out.println("글갯수실패:"+e);
        }finally {
            DBClose.close(con, pstmt, rs);
        }//end
        return cnt;
    }//count() end
    
    
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
            }//end
            
    		
    	}catch (Exception e) {
            System.out.println("글갯수실패:"+e);
        }finally {
            DBClose.close(con, pstmt, rs);
        }//end
        return list;
    }//count() end
    
    public int count2(String col, String word) {
    	int cnt=0;
    	try {
    		con=dbopen.getConnection();
    		
    		sql=new StringBuilder();
    		sql.append(" SELECT COUNT(*) as cnt ");
    		sql.append(" FROM tb_board ");
    		
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

    		pstmt=con.prepareStatement(sql.toString());
            rs=pstmt.executeQuery();    		
    		if(rs.next())	{
    			cnt=rs.getInt("cnt");
    		}//if end
    		
    	}catch (Exception e) {
            System.out.println("글갯수실패:"+e);
        }finally {
            DBClose.close(con, pstmt, rs);
        }//end
        return cnt;
    }//count2() end
    
    public ArrayList<noticeDTO> list3(String col, String word, int nowPage, int recordPerPage){
        ArrayList<noticeDTO> list=null;
        
        // 페이지당 출력할 레코드 갯수 (10개를 기준)
        // 1 page : WHERE r>=1 AND r<=10
        // 2 page : WHERE r>=11 AND r<=20
        // 3 page : WHERE r>=21 AND r<=30
        int startRow = ((nowPage-1) * recordPerPage) + 1 ;
        int endRow   = nowPage * recordPerPage;
        
        try{
          con=dbopen.getConnection();
          sql=new StringBuilder();
          
          word = word.trim(); //검색어의 좌우 공백 제거
          
          if(word.length()==0) { //검색을 하지 않는 경우
            sql.append(" SELECT board_no, board_title,board_readcnt, r ");
            sql.append(" FROM( SELECT board_no, board_title, rownum as r");
            sql.append("       FROM ( SELECT board_no, board_title,board_readcnt ");
            sql.append("              FROM tb_board");
            sql.append(" WHERE r>=" + startRow + " AND r<=" + endRow) ;
            
          } else {
            
            //검색을 하는 경우
        	  sql.append(" SELECT board_no, board_title,board_readcnt, r ");
              sql.append(" FROM( SELECT board_no,subject, board_title,indent, rownum as r");
              sql.append("       FROM ( SELECT board_no, board_title,board_readcnt ");
              sql.append("              FROM tb_board");
            
            String search="";
            if(col.equals("board_content")) {
				search+=" WHERE subject LIKE '%" + word + "%' ";
				search+=" or content LIKE '%" + word + "%' ";   			
			}else if(col.equals("board_title"))	{
				search+=" WHERE subject LIKE '%" + word + "%' ";
			}//if end
            sql.append(search);                
   
            
            
          pstmt=con.prepareStatement(sql.toString());
          rs=pstmt.executeQuery();
          if(rs.next()){
            list=new ArrayList<>();
            	do{
            		noticeDTO dto=new noticeDTO();
            		dto.setBoard_no(rs.getInt("board_no"));
            		dto.setBoard_title(rs.getString("board_title"));
            		dto.setBoard_content(rs.getString("board_content"));
            		dto.setBoard_date(rs.getString("board_date"));
            		dto.setBoard_readcnt(rs.getInt("board_readcnt"));
            		list.add(dto); //list에 모으기
            	}while(rs.next());
            }
          }//if end
          
        }catch(Exception e) {
          System.out.println("목록 페이징 실패: "+e);
        }finally {
          DBClose.close(con, pstmt, rs);
        }   
        return list;              
              
    }//list3() end    


	public int bbsInsProc(noticeDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}
    
}//class end   
