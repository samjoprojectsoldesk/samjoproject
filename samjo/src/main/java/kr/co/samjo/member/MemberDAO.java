package kr.co.samjo.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.samjo.utility.DBClose;
import kr.co.samjo.utility.DBOpen;

public class MemberDAO {
	private DBOpen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private StringBuilder sql=null;
	
	public MemberDAO() {
		dbopen=new DBOpen();
	}//end

	

	public String loginProc(MemberDTO dto) {
		String mlevel=null;
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" SELECT mlevel ");
			sql.append(" FROM member ");
			sql.append(" WHERE id=? and passwd=? ");
			sql.append(" AND mlevel in ('A1', 'B1', 'C1', 'D1') ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getId()); 
			pstmt.setString(2, dto.getPasswd()); 
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				mlevel=rs.getString("mlevel");
			}//if end
			
		}catch (Exception e) {
			System.out.println("로그인실패:" + e);
		}finally {
			DBClose.close(con, pstmt, rs);
		}//end
		return mlevel;
	}//loginProc() end
	
	
	public int duplecateID(String id) {
		int cnt=0;
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" SELECT COUNT(id) as cnt ");
			sql.append(" FROM tb_user ");
			sql.append(" WHERE id=? ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, id); 
			
			rs= pstmt.executeQuery();
			if(rs.next()) {
				cnt=rs.getInt("cnt");
			}//if end
			
		}catch (Exception e) {
			System.out.println("아이디 중복 확인 실패:" + e);
		}finally {
			DBClose.close(con, pstmt, rs);
		}//end
		return cnt;
		
	}//duplecateID() end
			

	public int create(MemberDTO dto) {
		int cnt=0;
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" INSERT INTO member(id, passwd, mname, tel, email, zipcode, address1, address2, job, mlevel, mdate) ");
			sql.append(" VALUES(?,?,?,?,?,?,?,?,?.'D1', sysdate) ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getId()); 
			pstmt.setString(2, dto.getPasswd());
			pstmt.setString(3, dto.getMname());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getZipcode());
			pstmt.setString(7, dto.getAddress1());
			pstmt.setString(8, dto.getAddress2());
			pstmt.setString(9, dto.getJob());
			
			cnt= pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("회원 가입 실패 :" + e);
		}finally {
			DBClose.close(con, pstmt);
		}//end
		return cnt;
		
	}//create() end
	
	
	public boolean findID(MemberDTO dto) {
		boolean flag=false;
		try {
			con=dbopen.getConnection();
			sql=new StringBuilder();
			
			//이름과 이메일이 일치하는 id 가져오기
			sql.append(" SELECT id ");
			sql.append(" FROM member ");
			sql.append(" WHERE mname=? AND email=? ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getMname());
			pstmt.setString(2, dto.getEmail());
			rs=pstmt.executeQuery();
			if(rs.next()) { //이름과 이메일 일치되었다면
				String id=rs.getString("id"); //1)아이디
				
				//[임시 비밀번호 발급] - 대문자, 소문자, 숫자를 이용해서 랜덤하게 10글자를 만들기
				String[] ch= {
						"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
                        "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
                        "0","1","2","3","4","5","6","7","8","9"
				};
				
				//ch배열에서 랜덤하게 10글자 발생
				StringBuilder imsiPW=new StringBuilder(); //2)임시 비밀번호
				for(int i=0; i<10; i++) {
					int num=(int)(Math.random()*ch.length); //ch[0]~ch[61]까지 존재
					imsiPW.append(ch[num]);
				}//for end
				
				
				//임시비밀번호로 업데이트 하기
				sql=new StringBuilder();
				sql.append(" UPDATE member ");
				sql.append(" SET passwd=? ");
				sql.append(" WHERE mname=? AND email=? ");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, imsiPW.toString());
				pstmt.setString(2, dto.getMname());
				pstmt.setString(3, dto.getEmail());//여기 수정했어요
				
				int cnt=pstmt.executeUpdate();
				if(cnt==1) { //임시 비밀번호로 업데이트 되었다면
					
					String content="";
					content+="<hr>";
					content+="<table border='1'>";
					content+="<tr>";
					content+="	<th>아이디</th>";
					content+="	<th>" + id + "</th>";
					content+="</tr>";
					content+="<tr>";
					content+="	<th>임시비밀번호</th>";
					content+="	<th>" + imsiPW.toString() + "</th>";
					content+="</tr>";
					content+="</table>";
					
					
					
					flag=true;//최종적으로 성공
					
				}else {
					flag=false;
				}//if end
			}//if end
			
		}catch (Exception e) {
			System.out.println("아이디/비번 찾기 실패 :" + e);
		}finally {
			DBClose.close(con, pstmt);
		}//end
		return flag;
		
	}//findID() end
	
	
	public MemberDTO read(String id) {
		MemberDTO dto=null;
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" SELECT passwd, mname, tel, email, zipcode, address1, address2, job ");
			sql.append(" FROM member ");
			sql.append(" WHERE id=? ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, id); // 1 -> 첫번째 ?
			
			//pstmt.executeUpdate() -> insert, update, delete문 실행할 때
			rs=pstmt.executeQuery();  //->select문 실행할 때
			if(rs.next()) { //행이 존재 하나요?
				dto=new MemberDTO();
				dto.setPasswd(rs.getString("passwd"));
				dto.setMname(rs.getString("mname"));
				dto.setTel(rs.getString("tel"));
				dto.setEmail(rs.getString("email"));
				dto.setZipcode(rs.getString("zipcode"));
				dto.setAddress1(rs.getString("address1"));
				dto.setAddress2(rs.getString("address2"));
				dto.setJob(rs.getString("job"));
			}//if end
			
		}catch (Exception e) {
			System.out.println("회원 정보 가져오기 실패 :" + e);
		}finally {
			DBClose.close(con, pstmt, rs);
		}//end
		return dto;
		
	}//read() end
	
	
	
	public int modifyProc(MemberDTO dto) {
		int cnt=0;//SQL문을 실행한 행의 갯수
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" UPDATE member ");
			sql.append(" SET passwd=?, mname=?, tel=?, email=?, zipcode=?, address1=?, address2=?, job=? ");
			sql.append(" WHERE id=? ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getPasswd());
			pstmt.setString(2, dto.getMname());
			pstmt.setString(3, dto.getTel());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getZipcode());
			pstmt.setString(6, dto.getAddress1());
			pstmt.setString(7, dto.getAddress2());
			pstmt.setString(8, dto.getJob());
			pstmt.setString(9, dto.getId());
			
			cnt=pstmt.executeUpdate(); //insert, update, delete문 실행
			
		}catch (Exception e) {
			System.out.println("회원 정보 가져오기 실패 :" + e);
		}finally {
			DBClose.close(con, pstmt);
		}//end
		return cnt;
		
	}//modifyProc() end
	
	
	
	
	
	
	
	
}//class end
