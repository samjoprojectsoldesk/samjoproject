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
            sql.append(" INSERT INTO tb_bbs(bbsno, wname, subject, content, passwd, ip, grpno) ");
            sql.append(" VALUES (bbs_seq.nextval, ?, ?, ?, ?, ?, (SELECT NVL(MAX(bbsno), 0)+1 FROM tb_bbs)) ");

            pstmt=con.prepareStatement(sql.toString());
            
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
            sql.append(" SELECT bbsno, wname, subject, readcnt, regdt, indent ");
            sql.append(" FROM tb_bbs ");
            sql.append(" ORDER BY grpno DESC, ansnum ASC ");
            
            pstmt=con.prepareStatement(sql.toString());
            rs=pstmt.executeQuery();
            if(rs.next()) {
                list=new ArrayList<boardDTO>();
                do {
                }while(rs.next());
            }//end
            
        }catch (Exception e) {
            System.out.println("전체목록실패:"+e);
        }finally {
            DBClose.close(con, pstmt, rs);
        }//end
        return list;
    }//list() end
    
    
    
    public boardDTO read(int bbsno) {
        boardDTO dto=null;
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" SELECT bbsno, wname, subject, content, readcnt, regdt, ip, grpno, indent, ansnum ");
            sql.append(" FROM tb_bbs ");
            sql.append(" WHERE bbsno=? ");
            
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, bbsno);
            
            rs=pstmt.executeQuery();
            if(rs.next()) {
            }//end
            
        }catch (Exception e) {
            System.out.println("상세보기실패:"+e);
        }finally {
            DBClose.close(con, pstmt, rs);
        }//end
        return dto;
    }//read() end
    
    
    
    public void incrementCnt(int bbsno) {
        try {
            con=dbopen.getConnection();
            
            sql=new StringBuilder();
            sql.append(" UPDATE tb_bbs ");
            sql.append(" SET readcnt=readcnt+1 ");
            sql.append(" WHERE bbsno=? ");
            
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, bbsno);
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
            sql.append(" WHERE bbsno=? AND passwd=? ");
            
            pstmt=con.prepareStatement(sql.toString());
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
            sql.append(" SET wname=? ");
            sql.append(" , subject=? ");
            sql.append(" , content=? ");
            sql.append(" , ip=? ");
            sql.append(" WHERE bbsno=? AND passwd=? ");
            
            pstmt=con.prepareStatement(sql.toString());
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
            sql.append(" SELECT bbsno, wname, subject, readcnt, regdt, indent ");
            sql.append(" FROM tb_bbs ");
            
            //검색어가 존재한다면
            if(word.length()>=1) {
                String search="";
                if(col.equals("subject_content")) {
                    search+=" WHERE subject LIKE '%" + word + "%' ";
                    search+=" OR content LIKE '%" + word + "%'";
                }else if(col.equals("subject")) {
                    search+=" WHERE subject LIKE '%" + word + "%' ";
                }else if(col.equals("content")) {
                    search+=" WHERE content LIKE '%" + word + "%' ";
                }else if(col.equals("wname")) {
                    search+=" WHERE wname LIKE '%" + word + "%' ";
                }//if end
                sql.append(search);
            }//if end
            
            sql.append(" ORDER BY grpno DESC, ansnum ASC ");
            
            pstmt=con.prepareStatement(sql.toString());
            rs=pstmt.executeQuery();
            if(rs.next()) {
                list=new ArrayList<boardDTO>();
                do {
                    boardDTO dto=new boardDTO(); //한줄담기
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
                    search+=" WHERE subject LIKE '%" + word + "%' ";
                    search+=" OR content LIKE '%" + word + "%'";
                }else if(col.equals("subject")) {
                    search+=" WHERE subject LIKE '%" + word + "%' ";
                }else if(col.equals("content")) {
                    search+=" WHERE content LIKE '%" + word + "%' ";
                }else if(col.equals("wname")) {
                    search+=" WHERE wname LIKE '%" + word + "%' ";
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
                sql.append(" SELECT bbsno,subject,wname,readcnt,indent,regdt, r");
                sql.append(" FROM( SELECT bbsno,subject,wname,readcnt,indent,regdt, rownum as r");
                sql.append("       FROM ( SELECT bbsno,subject,wname,readcnt,indent,regdt");
                sql.append("              FROM tb_bbs");
                sql.append("              ORDER BY grpno DESC, ansnum ASC");
                sql.append("           )");
                sql.append("     )");
                sql.append(" WHERE r>=" + startRow + " AND r<=" + endRow) ;
            
          } else {            
                //검색을 하는 경우
                sql.append(" SELECT bbsno,subject,wname,readcnt,indent,regdt, r");
                sql.append(" FROM( SELECT bbsno,subject,wname,readcnt,indent,regdt, rownum as r");
                sql.append("       FROM ( SELECT bbsno,subject,wname,readcnt,indent,regdt");
                sql.append("              FROM tb_bbs");
                
                String search="";
                if(col.equals("subject")) {
                    search += " WHERE subject LIKE '%" + word + "%' ";
                }else if(col.equals("content")) {
                    search += " WHERE content LIKE '%" + word + "%' ";
                }else if(col.equals("subject_content")) {
                    search += " WHERE subject LIKE '%" + word + "%' ";
                    search += " OR content LIKE '%" + word + "%' ";
                }else if(col.equals("wname")) {
                    search += " WHERE wname LIKE '%" + word + "%' ";
                }//if end
                
                sql.append(search);        
                
                sql.append("              ORDER BY grpno DESC, ansnum ASC");
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
