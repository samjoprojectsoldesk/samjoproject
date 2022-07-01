package kr.co.samjo.admin;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.utility.Utility;

@Controller
public class adminCont {

	adminDAO dao = null;

	public adminCont() {
		dao = new adminDAO();// DB연결 객체 생성
		System.out.println("-----adminCont() 객체 생성됨");
	}// end

	// 결과확인 http://localhost:9095/admin/index.do

	// 요청명령어 등록하고, 실행의 주체는 메소드(함수)
	@RequestMapping("admin/index.do")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		// applicaion.properties환경설정 파일 참조
		// /WEB-INF/views/index.jsp
		mav.setViewName("admin/index");
		return mav;
	}// index() end

	@RequestMapping("admin/tourist.do")
	public ModelAndView list(HttpServletRequest req) {

		// 입력된 검색어 확인(검색어가 있으면 검색어 존재, 검색어가 없으면 빈문자열 "")
		String word = Utility.checkNull(req.getParameter("word"));

		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/tourist");

		int totalRowCount = dao.totalRowCount(); // 총 글갯수

		// 페이징
		int numPerPage = 10; // 한 페이지당 레코드 갯수
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
			list = dao.list(startRow, endRow, word);
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

	@RequestMapping("admin/festivalList.do")
	public ModelAndView list2(HttpServletRequest req) {

		// 입력된 검색어 확인(검색어가 있으면 검색어 존재, 검색어가 없으면 빈문자열 "")
		String word = Utility.checkNull(req.getParameter("word"));

		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/festivalList");

		int totalRowCount = dao.totalRowCount2(); // 총 글갯수

		// 페이징
		int numPerPage = 10; // 한 페이지당 레코드 갯수
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
			list = dao.list2(startRow, endRow, word);
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
	}// list2() end

	@RequestMapping("admin/notice.do")
	public ModelAndView bbsList(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/bbsList");

		int totalRowCount = dao.bbstotalRowCount(); // 총 글갯수

		// 페이징
		int numPerPage = 10; // 한 페이지당 레코드 갯수
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
			list = dao.bbsList(startRow, endRow);
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
		System.out.println(list);
		return mav;
	}// list() end

//packagetourList	
	@RequestMapping("admin/packagetourList.do")
<<<<<<< HEAD
	public ModelAndView list3(HttpServletRequest req) {

		// 입력된 검색어 확인(검색어가 있으면 검색어 존재, 검색어가 없으면 빈문자열 "")
		String word = Utility.checkNull(req.getParameter("word"));

		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/packagetourList");

		int totalRowCount = dao.totalRowCount(); // 총 글갯수

		// 페이징
		int numPerPage = 10; // 한 페이지당 레코드 갯수
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
			list = dao.list4(startRow, endRow);
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
	}// packagetourList() end

	
	
// rentalList
	@RequestMapping("admin/rentalList.do")
	public ModelAndView list4(HttpServletRequest req) {

		// 입력된 검색어 확인(검색어가 있으면 검색어 존재, 검색어가 없으면 빈문자열 "")
		String word = Utility.checkNull(req.getParameter("word"));

		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/rentalList");

		int totalRowCount = dao.totalRowCount(); // 총 글갯수

		// 페이징
		int numPerPage = 10; // 한 페이지당 레코드 갯수
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
			list = dao.list(startRow, endRow, word);
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
	}// rentalList() end

	
	
// rentalcarList
	@RequestMapping("admin/rentalcarList.do")
	public ModelAndView list5(HttpServletRequest req) {

		// 입력된 검색어 확인(검색어가 있으면 검색어 존재, 검색어가 없으면 빈문자열 "")
		String word = Utility.checkNull(req.getParameter("word"));

		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/rentalcarList");

		int totalRowCount = dao.totalRowCount(); // 총 글갯수

		// 페이징
		int numPerPage = 10; // 한 페이지당 레코드 갯수
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
			list = dao.list(startRow, endRow, word);
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
	}// rentalcarList() end

=======
    public ModelAndView list3(HttpServletRequest req) {
		
		//입력된 검색어 확인(검색어가 있으면 검색어 존재, 검색어가 없으면 빈문자열 "")
        String word = Utility.checkNull(req.getParameter("word"));
        
        ModelAndView mav=new ModelAndView();
        mav.setViewName("admin/packagetourList");
       
        int totalRowCount=dao.totalRowCount(); //총 글갯수
       
        //페이징
        int numPerPage   = 10;    // 한 페이지당 레코드 갯수
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
              list=dao.list(startRow, endRow, word);          
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
    }//packagetourList() end
>>>>>>> 030a5bd50115456a1917a20b7aa525bd842dc326
}
