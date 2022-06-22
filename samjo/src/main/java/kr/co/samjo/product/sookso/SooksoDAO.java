package kr.co.samjo.product.sookso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.utility.DBClose;
import net.utility.DBOpen;

public class SooksoDAO {
		
		private DBOpen dbopen=null;
	    private Connection con=null;
	    private PreparedStatement pstmt=null;
	    private ResultSet rs=null;
	    private StringBuilder sql=null;
	   
	    public SooksoDAO() {
	        dbopen=new DBOpen();
	    }//end
	    
	    public ArrayList<SooksoDTO> list(String S_cn){
	        ArrayList<SooksoDTO> list=null;
	        SooksoDTO dto=new SooksoDTO();
	        try {
	            con=dbopen.getConnection();
	            sql=new StringBuilder();
	            sql.append(" SELECT s_cn, s_name, s_addr, s_cont ");
	            sql.append(" FROM tb_sookso ");
	            sql.append(" WHERE s_cn ");
	            sql.append(" ORDER BY s_cn DESC ");
	            pstmt=con.prepareStatement(sql.toString());
	            pstmt.setString(1, dto.getS_cn());
	            rs=pstmt.executeQuery();
	            if(rs.next()) {
	                list=new ArrayList<>();
	                do {
	                    dto.setS_cn(rs.getString("s_cn"));
	                    dto.setS_name(rs.getString("s_name"));
	                    dto.setS_addr(rs.getString("s_addr"));
	                    dto.setS_cont(rs.getString("s_cont"));
	                    list.add(dto);
	                }while(rs.next());
	            }//if end
	        }catch(Exception e){
	            System.out.println("목록 실패:"+e);
	         }finally{
	            DBClose.close(con, pstmt, rs);
	         }//end
	         return list;
	       
	  }//list() end
}

