package kr.co.samjo.tour;

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
public class TourCont {

	TourDAO dao =null;
	
	public TourCont() {
		dao = new TourDAO();//DB연결 객체 생성
		System.out.println("-----TourCont() 객체 생성됨");
	}//end
	
	/*
	@RequestMapping("tour/tourist.do")
	public ModelAndView list() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("tour/tourist");
		mav.addObject("list", dao.list());
		return mav;
	}//list() end
	*/
	
	@RequestMapping(value = "tour/create.do", method = RequestMethod.GET)
	public String createFrom() {
		return "tour/createForm";
	}//createForm() end

	@RequestMapping(value = "/tour/create.do", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute TourDTO dto, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tour/msgView");
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
		dto.setT_img(poster);// 리네임된 파일명을 dto객체 담기
		
		int cnt = dao.create(dto);
		if (cnt == 0) {
			String msg = "<p>여행지 등록 실패</p>";
			String link1 = "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
			String link2 = "<input type='button' value='목록으로' onclick=\"location.href='/tour/tourist.do'\">";
			mav.addObject("msg", msg);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);
		} else {
			String msg = "<p>여행지 등록 성공</p>";
			String img = "<img src='../images/sound.png'>";
			String link2 = "<input type='button' value='목록으로' onclick=\"location.href='/tour/tourist.do'\">";
			mav.addObject("msg", msg);
			mav.addObject("img", img);
			mav.addObject("link2", link2);
		} // if end

		return mav;
	}// createProc() end
	
	@RequestMapping("tour/tourist.do")
    public ModelAndView list(HttpServletRequest req) {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("tour/tourist");
       
        int totalRowCount=dao.totalRowCount(); //총 글갯수
       
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
              list=dao.list(startRow, endRow);          
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
    }//list() end
	
	
	@RequestMapping("tour/festivalList.do")
	public ModelAndView list2(HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
        mav.setViewName("tour/festivalList");
       
        int totalRowCount=dao.totalRowCount2(); //총 글갯수
       
        //페이징
        int numPerPage   = 5;    // 한 페이지당 레코드 갯수
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
              list=dao.list2(startRow, endRow);          
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
	}//list2() end

	
	@RequestMapping("/tour/tourist/read.do")
	public ModelAndView read(String t_cn) {
		ModelAndView mav = new ModelAndView();
		TourDTO dto = dao.read(t_cn);
		mav.setViewName("tour/read");
		mav.addObject("dto", dto);
		return mav;
	}// read() end
	


}
