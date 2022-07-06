package kr.co.samjo.product.rentalcar;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.utility.UploadSaveManager;

@Controller
public class rentalcarCont {
	rentalcarDAO dao = null;
	
	public rentalcarCont() {
		dao = new rentalcarDAO();
		System.out.println("-----rentalcarCont객체 생성됨");
	}
	//Ins	
	@RequestMapping(value = "rentalcarIns.do", method = RequestMethod.GET) //admin/
	public ModelAndView Ins() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("rentalcar/Ins");
		return mav;
	}//Ins() end
	

	
//InsProc
		@RequestMapping(value = "rentalcarIns.do", method = RequestMethod.POST) //admin/
		public ModelAndView Ins(@ModelAttribute rentalcarDTO dto, HttpServletRequest req) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("rentalcar/msgView");
			
			// ----------------------------------------------------------------------------
						// 첨부된 파일 처리
						// ->실제 파일은 /storage폴더에 저장
						// ->저장된 파일 관련 정보는 media테이블에 저장

						// 파일 저장 폴더의 실제 물리적인 경로 가져오기
						String basePath = req.getRealPath("/storage");

						// 1)<input type='file' name='posterMF' size='50'>
						MultipartFile posterMF = dto.getPosterMF(); // 파일 가져오기
						// storage폴더에 파일을 저장하고, 리네임된 파일명 반환
						String poster = UploadSaveManager.saveFileSpring30(posterMF, basePath);
						dto.setC_img(poster);// 리네임된 파일명을 dto객체 담기

			int cnt = dao.create(dto);
			if (cnt == 0) {
				String msg = "<p>렌트카 등록 실패</p>";
				String img = "<img src='../images/fail.png'>";
				String link1 = "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
				String link2 = "<input type='button' value='렌트카 목록' onclick='location.href=\"List.do\"'>";
				mav.addObject("msg", msg);
				mav.addObject("img", img);
				mav.addObject("link1", link1);
				mav.addObject("link2", link2);
			} else {
				String msg = "<p>렌트카 등록 성공</p>";
				String img = "<img src='../images/sound.png'>";
				String link1 = "<input type='button' value='계속등록' onclick='location.href=\"Ins.do\"'>";
				String link2 = "<input type='button' value='렌트카 목록' onclick='location.href=\"List.do\"'>";
				mav.addObject("msg", msg);
				mav.addObject("img", img);
				mav.addObject("link1", link1);
				mav.addObject("link2", link2);
			} // if end
			return mav;
		}//InsProc() end
		
		
		
//List	
		@RequestMapping("rentalcar/List.do")
		public ModelAndView List(HttpServletRequest req) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("rentalcar/List");

			int totalRowCount = dao.totalRowCount(); // 총 글갯수

			// 페이징
			int numPerPage = 9; // 한 페이지당 레코드 갯수
			int pagePerBlock = 10; // 페이지 리스트

			String pageNum = req.getParameter("pageNum");
			if (pageNum == null) {
				pageNum = "1";
			}

			int currentPage = Integer.parseInt(pageNum);
			int startRow = (currentPage - 1) * numPerPage + 1;
			int endRow = currentPage * numPerPage;

			// 페이지 수
			double totcnt = (double) totalRowCount / numPerPage;
			int totalPage = (int) Math.ceil(totcnt);

			double d_page = (double) currentPage / pagePerBlock;
			int Pages = (int) Math.ceil(d_page) - 1;
			int startPage = Pages * pagePerBlock;
			int endPage = startPage + pagePerBlock + 1;

			List list = null;
			if (totalRowCount > 0) {
				list = dao.list(startRow, endRow);
			} else {
				list = Collections.EMPTY_LIST;
			} // if end

			int number = 0;
			number = totalRowCount - (currentPage - 1) * numPerPage;

			mav.addObject("number", number);
			mav.addObject("pageNum", currentPage);
			mav.addObject("startRow", startRow);
			mav.addObject("endRow", endRow);
			mav.addObject("count", totalRowCount);
			mav.addObject("pageSize", pagePerBlock);
			mav.addObject("totalPage", totalPage);
			mav.addObject("startPage", startPage);
			mav.addObject("endPage", endPage);
			mav.addObject("list", list);
			return mav;
		}// list() end
		
		
//Read	
		@RequestMapping("rentalcar/Read.do")
			public ModelAndView Read(String c_code, HttpServletRequest req) {
			ModelAndView mav = new ModelAndView();
			rentalcarDTO dto = dao.read(c_code);
			mav.setViewName("rentalcar/Read");
			mav.addObject("dto", dto);

			int totalRowCount=dao.reviewtotalRowCount(c_code); //총 글갯수
		       
	        //페이징
	        int numPerPage   = 9;    // 한 페이지당 레코드 갯수
	        int pagePerBlock = 10;   // 페이지 리스트
	       
	        String pageNum=req.getParameter("pageNum");
	        if(pageNum==null){
	              pageNum="1";
	        }
	       
	        int currentPage=Integer.parseInt(pageNum);
	        int startRow   =(currentPage-1)*numPerPage+1;
	        int endRow     =currentPage*numPerPage;
	       
	        //페이지 수
	        double totcnt = (double)totalRowCount/numPerPage;
	        int totalPage = (int)Math.ceil(totcnt);
	         
	        double d_page = (double)currentPage/pagePerBlock;
	        int Pages     = (int)Math.ceil(d_page)-1;
	        int startPage = Pages*pagePerBlock;
	        int endPage   = startPage+pagePerBlock+1;
	       
	       
	        List list=null;     
	        if(totalRowCount>0){           
	              list=dao.reviewList(c_code, startRow, endRow);          
	        } else {           
	              list=Collections.EMPTY_LIST;           
	        }//if end
	         
	        int number=0;
	        number=totalRowCount-(currentPage-1)*numPerPage;
	         
	        mav.addObject("number",    number);
	        mav.addObject("pageNum",   currentPage);
	        mav.addObject("startRow",  startRow);
	        mav.addObject("endRow",    endRow);
	        mav.addObject("count",     totalRowCount);
	        mav.addObject("pageSize",  pagePerBlock);
	        mav.addObject("totalPage", totalPage);
	        mav.addObject("startPage", startPage);
	        mav.addObject("endPage",   endPage);
	        mav.addObject("list", list);
			return mav;
		}// read() end
		
		
		
//Delete	
		@RequestMapping(value = "rentalcarDelete.do", method = RequestMethod.GET)//admin/
		public ModelAndView Delete(String c_code) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("rentalcar/Delete");
			rentalcarDTO dto = dao.read(c_code);// 수정하고자 하는 행 가져오기
			mav.addObject("dto", dto);
			return mav;
		}// deleteForm() end
		
		
		
//DeleteProc	
		@RequestMapping(value = "rentalcarDelete.do", method = RequestMethod.POST)//admin/
		public ModelAndView DeleteProc(String c_code, HttpServletRequest req) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("rentalcar/msgView");

			// 삭제하고자 하는 글정보 가져오기(storage폴더에서 삭제할 파일명을 보관하기 위해)
			rentalcarDTO oldDTO = dao.read(c_code);

			int cnt = dao.delete(c_code);
			if (cnt == 0) {
				String msg = "<p>렌트카 삭제 실패!!</p>";
				String img = "<img src='../images/fail.png'>";
				String link1 = "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
				String link2 = "<input type='button' value='렌트카 목록' onclick=\"location.href='/../rentalcar/List.do'\">";
				mav.addObject("msg", msg);
				mav.addObject("img", img);
				mav.addObject("link1", link1);
				mav.addObject("link2", link2);
			} else {
				String msg = "<p>렌트카가 삭제되었습니다</p>";
				String img = "<img src='../images/sound.png'>";
				String link2 = "<input type='button' value='렌트카 목록' onclick=\"location.href='/../rentalcar/List.do'\">";
				mav.addObject("msg", msg);
				mav.addObject("img", img);
				mav.addObject("link2", link2);
			} // if end
			return mav;
		}// deleteProc() end

		
		
//Update	
		@RequestMapping(value = "rentalcarUpdate.do", method = RequestMethod.GET) //admin/
		public ModelAndView Update(String c_code) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("rentalcar/Update");
			rentalcarDTO dto = dao.read(c_code);// 수정하고자 하는 행 가져오기
			mav.addObject("dto", dto);
			return mav;
		}// updateForm() end

		
		
//UpdateProc
		@RequestMapping(value = "rentalcarUpdate.do", method = RequestMethod.POST) //admin/
		public ModelAndView updateProc(@ModelAttribute rentalcarDTO dto) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("rentalcar/msgView");

			int cnt = dao.update(dto);
			
			if (cnt == 0) {
				String msg = "<p>렌트카 수정 실패!!</p>";
				String img = "<img src='../images/fail.png'>";
				String link1 = "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
				String link2 = "<input type='button' value='렌트카 목록' onclick=\"location.href='/../rentalcar/List.do'\">";
				mav.addObject("msg", msg);
				mav.addObject("img", img);
				mav.addObject("link1", link1);
				mav.addObject("link2", link2);
			} else {
				String msg = "<p>렌트카가 수정되었습니다</p>";
				String img = "<img src='../images/sound.png'>";
				String link2 = "<input type='button' value='렌트카 목록' onclick=\"location.href='/../rentalcar/List.do'\">";
				mav.addObject("msg", msg);
				mav.addObject("img", img);
				mav.addObject("link2", link2);
			} // if end

			return mav;

		}// UpdateProc() end		
}
