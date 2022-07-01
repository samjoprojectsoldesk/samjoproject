package kr.co.samjo.board2;

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
import net.utility.Utility;

@Controller
public class boardCont {

	boardDAO dao = null;

	public boardCont() {
		dao = new boardDAO();// DB연결 객체 생성
		System.out.println("-----boardCont() 객체 생성됨");
	}// end

	/*
	 * @RequestMapping("tour/tourist.do") public ModelAndView list() { ModelAndView
	 * mav=new ModelAndView(); mav.setViewName("tour/tourist");
	 * mav.addObject("list", dao.list()); return mav; }//list() end
	 */

	@RequestMapping(value = "board/boardcreate.do", method = RequestMethod.GET)
	public String createFrom() {
		return "board2/createForm";
	}// createForm() end

	@RequestMapping(value = "/board/boardcreate.do", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute boardDTO dto, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board2/msgView");
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

		dto.setBbs_img(poster);// 리네임된 파일명을 dto객체 담기
		
		int cnt = dao.create(dto);
		if (cnt == 0) {
			String msg = "<p>게시판 등록 실패</p>";
			String link1 = "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
			String link2 = "<input type='button' value='목록으로' onclick=\"location.href='/board/List.do'\">";
			mav.addObject("msg", msg);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);
		} else {
			String msg = "<p>게시판 등록 성공</p>";
			String img = "<img src='../images/sound.png'>";
			String link2 = "<input type='button' value='목록으로' onclick=\"location.href='/board/List.do'\">";
			mav.addObject("msg", msg);
			mav.addObject("img", img);
			mav.addObject("link2", link2);
		} // if end

		return mav;
	}// create() end

	@RequestMapping("/board/List.do")
	public ModelAndView list(HttpServletRequest req) {
		
		//입력된 검색어 확인(검색어가 있으면 검색어 존재, 검색어가 없으면 빈문자열 "")
        String word = Utility.checkNull(req.getParameter("word"));
        String col = Utility.checkNull(req.getParameter("col"));
        
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board2/List");

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
			list = dao.list(startRow, endRow, col, word);
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

	@RequestMapping("/board/boardread.do")
	public ModelAndView read(int bbs_idx) {
		ModelAndView mav = new ModelAndView();
		boardDTO dto = dao.read(bbs_idx);
		mav.setViewName("board2/read");
		mav.addObject("dto", dto);
		return mav;
	}// read() end

	@RequestMapping(value = "/board/updateForm.do", method = RequestMethod.GET)
	public ModelAndView updateForm(int bbs_idx) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board2/updateForm");
		boardDTO dto = dao.read(bbs_idx);// 수정하고자 하는 행 가져오기
		mav.addObject("dto", dto);
		return mav;
	}// updateForm() end

	@RequestMapping(value = "/board/updateForm.do", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute boardDTO dto, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board2/msgView");

		System.out.println(dto.toString());
		String basePath = req.getRealPath("/storage");
		boardDTO oldDTO = dao.read(dto.getBbs_idx()); // 기존에 저장된 정보 가져오기
		System.out.println(oldDTO.toString());

		// ---------------------------------------------------------------------
		// 파일을 수정할 것인지?

		// 1)posterMF1

		MultipartFile posterMF1 = dto.getPosterMF();
		if (posterMF1.getSize() > 0) { // 새로운 포스터 파일이 첨부되서 전송되었는지?
			// 기존 파일 삭제
			UploadSaveManager.deleteFile(basePath, oldDTO.getBbs_img());

			// 신규 파일 저장
			String poster = UploadSaveManager.saveFileSpring30(posterMF1, basePath);
			dto.setBbs_img(poster); // 새롭게 첨부된 신규 파일명

		} else {
			// 포스터 파일을 수정하지 않는 경우
			dto.setBbs_img(oldDTO.getBbs_img()); // 기존에 저장된 파일명

		} // if end


		// ---------------------------------------------------------------------

		int cnt = dao.update(dto);
		if (cnt == 0) {
			String msg = "<p>게시판 수정 실패!!</p>";
			String img = "<img src='../images/fail.png'>";
			String link1 = "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
			String link2 = "<input type='button' value='게시판목록' onclick=\\\"location.href='/board/List.do'\\\">";
			mav.addObject("msg", msg);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);
		} else {
			String msg = "<p>여행지가 수정 되었습니다</p>";
			String img = "<img src='../images/sound.png'>";
			String link2 = "<input type='button' value='게시판목록' onclick=\\\"location.href='/board/List.do'\\\">";
			mav.addObject("msg", msg);
			mav.addObject("img", img);
			mav.addObject("link2", link2);
		} // if end
		return mav;
	}// updateProc() end

	@RequestMapping(value = "/board/deleteForm.do", method = RequestMethod.GET)
	public ModelAndView deleteForm(int bbs_idx) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board2/deleteForm");
		boardDTO dto = dao.read(bbs_idx);// 수정하고자 하는 행 가져오기
		mav.addObject("dto", dto);
		return mav;
	}// deleteForm() end

	@RequestMapping(value = "/board/deleteForm.do", method = RequestMethod.POST)
	public ModelAndView deleteProc(int bbs_idx, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board2/msgView");

		// 삭제하고자 하는 글정보 가져오기(storage폴더에서 삭제할 파일명을 보관하기 위해)
		boardDTO oldDTO = dao.read(bbs_idx);

		int cnt = dao.delete(bbs_idx);
		if (cnt == 0) {
			String msg = "<p>게시판 삭제 실패!!</p>";
			String img = "<img src='../images/fail.png'>";
			String link1 = "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
			String link2 = "<input type='button' value='게시판목록' onclick=\"location.href='/board/List.do'\">";
			mav.addObject("msg", msg);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);
		} else {
			String msg = "<p>게시판이 삭제되었습니다</p>";
			String img = "<img src='../images/sound.png'>";
			String link2 = "<input type='button' value='게시판목록' onclick=\"location.href='/board/List.do'\">";

			mav.addObject("msg", msg);
			mav.addObject("img", img);
			mav.addObject("link2", link2);
			// 첨부했던 파일 삭제
			String basePath = req.getRealPath("/storage");
			UploadSaveManager.deleteFile(basePath, oldDTO.getBbs_img());

		} // if end
		return mav;
	}// deleteProc() end

}