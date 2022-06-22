package kr.co.samjo.bbs.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.utility.DBClose;
import net.utility.DBOpen;

public class boardDAO {//데이터베이스 관련 작업
    
    private DBOpen dbopen=null;
    private Connection con=null;
    private PreparedStatement pstmt=null;
    private ResultSet rs=null;
    private StringBuilder sql=null;
    
    public boardDAO() {
        dbopen=new DBOpen();    
    }//end

    
    public int create(boardDTO dto) {
        int cnt=0;
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" INSERT INTO tb_bbs(bbs_idx, bbs_id, bbs_title, bbs_content, bbs_userip) ");
            sql.append(" VALUES (bbs_seq2.nextval, ?, ?, ?, ?)) ");

            pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, dto.getBbs_idx());
            pstmt.setString(2, dto.getBbs_title());
            pstmt.setString(3, dto.getBbs_content());
            pstmt.setString(4, dto.getBbs_userip());
            
            cnt=pstmt.executeUpdate();
            
        }catch (Exception e) {
            System.out.println("추가실패:"+e);
        }finally {
            DBClose.close(con, pstmt);
        }//end
        return cnt;
    }//create() end
    
    
    
    public ArrayList<boardDTO> list(){
        ArrayList<boardDTO> list=null;
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" SELECT bbs_idx, bbs_id, bbs_title, bbs_count, bbs_date ");
            sql.append(" FROM tb_bbs2 ");
            sql.append(" ORDER BY bbs_date ");
            
            pstmt=con.prepareStatement(sql.toString());
            rs=pstmt.executeQuery();
            if(rs.next()) {
                list=new ArrayList<boardDTO>();
                do {
                    boardDTO dto=new boardDTO(); //한줄담기
                    dto.setBbs_idx(rs.getInt("bbs_idx"));
                    dto.setBbs_id(rs.getString("bbs_id"));
                    dto.setBbs_title(rs.getString("bbs_title"));
                    dto.setBbs_count(rs.getInt("bbs_count"));
                    dto.setBbs_date(rs.getString("bbs_date"));
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
    
    
    
    public boardDTO read(int bbs_idx) {
        boardDTO dto=null;
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" SELECT bbs_idx, bbs_id, bbs_title, bbs_content, bbs_count, bbs_date, bbs_userip ");
            sql.append(" FROM tb_bbs ");
            sql.append(" WHERE bbs_idx=? ");
            
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, bbs_idx);
            
            rs=pstmt.executeQuery();
            if(rs.next()) {
                dto=new boardDTO();
                dto.setBbs_content(rs.getString("bbs_content")); 
                dto.setBbs_userip(rs.getString("bbs_userip"));
                dto.setBbs_idx(rs.getInt("bbs_idx"));
                dto.setBbs_id(rs.getString("bbs_id"));
                dto.setBbs_title(rs.getString("bbs_title"));
                dto.setBbs_count(rs.getInt("bbs_count"));
                dto.setBbs_date(rs.getString("bbs_date"));
            }//end
            
        }catch (Exception e) {
            System.out.println("상세보기실패:"+e);
        }finally {
            DBClose.close(con, pstmt, rs);
        }//end
        return dto;
    }//read() end
    
    
    
    public void incrementCnt(int bbs_idx) {
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" UPDATE tb_bbs ");
            sql.append(" SET bbs_count=bbs_count+1 ");
            sql.append(" WHERE bbs_idx=? ");
            
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, bbs_idx);
            pstmt.executeUpdate();
            
        }catch (Exception e) {
            System.out.println("조회수 증가 실패:"+e);
        }finally {
            DBClose.close(con, pstmt);
        }//end
    }//incrementCnt() end
    
    
    public int delete(boardDTO dto) {
        int cnt=0;
        try {
            
            con=dbopen.getConnection();
            sql=new StringBuilder();
            sql.append(" DELETE FROM tb_bbs ");
            sql.append(" WHERE bbs_idx=? ");
            
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, dto.getBbs_idx());
            cnt=pstmt.executeUpdate();
            
        }catch (Exception e) {
            System.out.println("삭제 실패:"+e);
        }finally {
            DBClose.close(con, pstmt);
        }//end
        return cnt;
    }//delete() end
    
    
   
            
            
            
    

    public int updateproc(boardDTO dto) {
        int cnt=0;
        try {
            con=dbopen.getConnection();
            sql=new StringBuilder();
            sql.append(" UPDATE tb_bbs ");
            sql.append(" SET bbs_id=? ");
            sql.append(" , bbs_title=? ");
            sql.append(" , bbs_content=? ");
            sql.append(" , bbs_userip=? ");
            sql.append(" WHERE bbs_idx=? ");
            
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setString(1, dto.getBbs_id());
            pstmt.setString(2, dto.getBbs_title());
            pstmt.setString(3, dto.getBbs_content());
            pstmt.setString(4, dto.getBbs_userip());
            pstmt.setInt(5, dto.getBbs_idx());
            
            cnt=pstmt.executeUpdate();
            
        }catch (Exception e) {
            System.out.println("수정 실패:"+e);
        }finally {
            DBClose.close(con, pstmt);
        }//end
        return cnt;
    }//updateproc() end
    
    
    
    public int count() {
        int cnt=0;
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" SELECT COUNT(*) as cnt ");
            sql.append(" FROM tb_bbs ");
            
            pstmt=con.prepareStatement(sql.toString());
            rs=pstmt.executeQuery();
            if(rs.next()) {
                cnt=rs.getInt("cnt");
            }//if end
            
        }catch (Exception e) {
            System.out.println("글갯수실패:"+e);
        }finally {
            DBClose.close(con, pstmt, rs);
        }//end
        return cnt;
    }//count() end
    
    
    
    public ArrayList<boardDTO> list2(String col, String word){
        ArrayList<boardDTO> list=null;
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" SELECT bbs_idx, bbs_id, bbs_title, bbs_count, bbs_date ");
            sql.append(" FROM tb_bbs ");
            
            //검색어가 존재한다면
            if(word.length()>=1) {
                String search="";
                if(col.equals("subject_content")) {
                    search+=" WHERE bbs_title LIKE '%" + word + "%' ";
                    search+=" OR bbs_content LIKE '%" + word + "%'";
                }else if(col.equals("subject")) {
                    search+=" WHERE bbs_title LIKE '%" + word + "%' ";
                }else if(col.equals("content")) {
                    search+=" WHERE bbs_content LIKE '%" + word + "%' ";
                }else if(col.equals("wname")) {
                    search+=" WHERE bbs_id LIKE '%" + word + "%' ";
                }//if end
                sql.append(search);
            }//if end
            
            sql.append(" ORDER BY bbs_date ");
            
            pstmt=con.prepareStatement(sql.toString());
            rs=pstmt.executeQuery();
            if(rs.next()) {
                list=new ArrayList<boardDTO>();
                do {
                    boardDTO dto=new boardDTO(); //한줄담기
                    dto.setBbs_idx(rs.getInt("bbs_idx"));
                    dto.setBbs_id(rs.getString("bbs_id"));
                    dto.setBbs_title(rs.getString("bbs_title"));
                    dto.setBbs_count(rs.getInt("bbs_count"));
                    dto.setBbs_date(rs.getString("bbs_date"));
                    list.add(dto); //list에 모으기
                }while(rs.next());
            }//end
            
        }catch (Exception e) {
            System.out.println("글갯수실패:"+e);
        }finally {
            DBClose.close(con, pstmt, rs);
        }//end
        return list;
    }//list2() end
    
    
    
    public int count2(String col, String word) {
        int cnt=0;
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" SELECT COUNT(*) as cnt ");
            sql.append(" FROM tb_bbs ");
            
            if(word.length()>=1) {//검색어가 존재한다면
                String search="";
                if(col.equals("subject_content")) {
                    search+=" WHERE bbs_title LIKE '%" + word + "%' ";
                    search+=" OR bbs_content LIKE '%" + word + "%'";
                }else if(col.equals("subject")) {
                    search+=" WHERE bbs_title LIKE '%" + word + "%' ";
                }else if(col.equals("content")) {
                    search+=" WHERE bbs_content LIKE '%" + word + "%' ";
                }else if(col.equals("wname")) {
                    search+=" WHERE bbs_id LIKE '%" + word + "%' ";
                }//if end
                sql.append(search);
            }//if end
            
            pstmt=con.prepareStatement(sql.toString());
            rs=pstmt.executeQuery();
            if(rs.next()) {
                cnt=rs.getInt("cnt");
            }//if end
            
        }catch (Exception e) {
            System.out.println("글갯수실패:"+e);
        }finally {
            DBClose.close(con, pstmt, rs);
        }//end
        return cnt;
    }//count2() end

    
    
    public ArrayList<boardDTO> list3(String col, String word, int nowPage, int recordPerPage){
        ArrayList<boardDTO> list=null;
        
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
                sql.append(" SELECT bbs_idx,bbs_title,bbs_id,bbs_count,bbs_date, r ");
                sql.append(" FROM( SELECT bbs_idx,bbs_title,bbs_id,bbs_count,bbs_date, rownum as r ");
                sql.append("       FROM ( SELECT bbs_idx,bbs_title,bbs_id,bbs_count,bbs_date ");
                sql.append("              FROM tb_bbs ");
                sql.append("              ORDER BY bbs_date ");
                sql.append("           ) ");
                sql.append("     ) ");
                sql.append(" WHERE r>=" + startRow + " AND r<= " + endRow) ;
            
          } else {            
                //검색을 하는 경우
                sql.append(" SELECT bbs_idx,bbs_title,bbs_id,bbs_count,bbs_date, r");
                sql.append(" FROM( SELECT bbs_idx,bbs_title,bbs_id,bbs_count,bbs_date, rownum as r");
                sql.append("       FROM ( SELECT bbs_idx,bbs_title,bbs_id,bbs_count,bbs_date");
                sql.append("              FROM tb_bbs");
                
                String search="";
                if(col.equals("subject")) {
                    search += " WHERE bbs_title LIKE '%" + word + "%' ";
                }else if(col.equals("content")) {
                    search += " WHERE bbs_content LIKE '%" + word + "%' ";
                }else if(col.equals("subject_content")) {
                    search += " WHERE bbs_title LIKE '%" + word + "%' ";
                    search += " OR bbs_content LIKE '%" + word + "%' ";
                }else if(col.equals("wname")) {
                    search += " WHERE bbs_id LIKE '%" + word + "%' ";
                }//if end
                
                sql.append(search);        
                
                sql.append("              ORDER BY bbs_date ");
                sql.append("           )");
                sql.append("     )");
                sql.append(" WHERE r>=" + startRow + " AND r<=" + endRow) ;
          }//if end
          
          pstmt=con.prepareStatement(sql.toString());
          rs=pstmt.executeQuery();
          if(rs.next()){
            list=new ArrayList<>();
            do{
              boardDTO dto=new boardDTO();
              dto.setBbs_idx(rs.getInt("bbs_idx"));
              dto.setBbs_title(rs.getString("bbs_title"));
              dto.setBbs_id(rs.getString("bbs_id"));
              dto.setBbs_count(rs.getInt("bbs_count"));
              dto.setBbs_date(rs.getString("bbs_date"));
              list.add(dto);
            }while(rs.next());
          }//if end
          
        }catch(Exception e) {
          System.out.println("목록 페이징 실패: "+e);
        }finally {
          DBClose.close(con, pstmt, rs);
        }   
        return list;              
              
    }//list3() end
    
 
}//class end
