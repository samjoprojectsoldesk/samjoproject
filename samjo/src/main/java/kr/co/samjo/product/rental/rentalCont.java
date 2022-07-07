package kr.co.samjo.product.rental;

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
public class rentalCont {
	rentalDAO dao = null;

	public rentalCont() {
		dao = new rentalDAO();
		System.out.println("-----rentalCont객체 생성됨");
	}

// Ins
	@RequestMapping(value = "rentalIns.do", method = RequestMethod.GET) // /admin/
	public ModelAndView Ins() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("rentalcar/rentalIns");
		return mav;
	}// Ins() end

// InsProc
	@RequestMapping(value = "rentalIns.do", method = RequestMethod.POST) // /admin/
	public ModelAndView Ins(@ModelAttribute rentalDTO dto, HttpServletRequest req) {
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
					dto.setU_img(poster);// 리네임된 파일명을 dto객체 담기
		
		int cnt = dao.create(dto);
		if (cnt == 0) {
			String msg = "<p>렌트카 업체 등록 실패</p>";
			String img = "<img src='../images/fail.png'>";
			String link1 = "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
			String link2 = "<input type='button' value='렌트카 업체 목록' onclick=\"location.href='/../rentalcar/List.do'\">";
			mav.addObject("msg", msg);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);
		} else {
			String msg = "<p>렌트카 업체 등록 성공</p>";
			String img = "<img src='../images/sound.png'>";
			String link1 = "<input type='button' value='계속등록' onclick=\"location.href='/../rentalcar/List.do'\">";
			String link2 = "<input type='button' value='렌트카 업체 목록' onclick=\"location.href='/../rentalcar/List.do'\">";
			mav.addObject("msg", msg);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);
		} // if end
		return mav;
	}// InsProc() end

	
//Delete	
	@RequestMapping(value = "rentalDelete.do", method = RequestMethod.GET)// /admin/
	public ModelAndView Delete(String u_code) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("rentalcar/rentalDelete");
		rentalDTO dto = dao.read(u_code);// 수정하고자 하는 행 가져오기
		mav.addObject("dto", dto);
		return mav;
	}// deleteForm() end

	
	
	// DeleteProc
	@RequestMapping(value = "rentalDelete.do", method = RequestMethod.POST)// /admin/
	public ModelAndView DeleteProc(String u_code, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("rentalcar/msgView");

		// 삭제하고자 하는 글정보 가져오기(storage폴더에서 삭제할 파일명을 보관하기 위해)
		rentalDTO oldDTO = dao.read(u_code);

		int cnt = dao.delete(u_code);
		if (cnt == 0) {
			String msg = "<p>렌트카 업체 삭제 실패!!</p>";
			String img = "<img src='../images/fail.png'>";
			String link1 = "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
			String link2 = "<input type='button' value='렌트카 업체 목록' onclick=\"location.href='/../rentalcar/List.do'\">";
			mav.addObject("msg", msg);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);
		} else {
			String msg = "<p>렌트카 업체가 삭제되었습니다</p>";
			String img = "<img src='../images/sound.png'>";
			String link2 = "<input type='button' value='렌트카 업체 목록' onclick=\"location.href='/../rentalcar/List.do'\">";
			mav.addObject("msg", msg);
			mav.addObject("img", img);
			mav.addObject("link2", link2);
		} // if end
		return mav;
	}// deleteProc() end

	
	
// Update
	@RequestMapping(value = "rentalUpdate.do", method = RequestMethod.GET)// /admin/
	public ModelAndView Update(String u_code) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("rentalcar/rentalUpdate");
		rentalDTO dto = dao.read(u_code);// 수정하고자 하는 행 가져오기
		mav.addObject("dto", dto);
		return mav;
	}// updateForm() end

	
	
// UpdateProc
	@RequestMapping(value = "rentalUpdate.do", method = RequestMethod.POST)// /admin/
	public ModelAndView updateProc(@ModelAttribute rentalDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("rentalcar/msgView");

		int cnt = dao.update(dto);

		if (cnt == 0) {
			String msg = "<p>렌트카 업체 수정 실패!!</p>";
			String img = "<img src='../images/fail.png'>";
			String link1 = "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
			String link2 = "<input type='button' value='렌트카 업체 목록' onclick=\"location.href='/../rentalcar/List.do'\">";
			mav.addObject("msg", msg);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);
		} else {
			String msg = "<p>렌트카 업체가 수정되었습니다</p>";
			String img = "<img src='../images/sound.png'>";
			String link2 = "<input type='button' value='렌트카 업체 목록' onclick=\"location.href='/../rentalcar/List.do'\">";
			mav.addObject("msg", msg);
			mav.addObject("img", img);
			mav.addObject("link2", link2);
		} // if end

		return mav;

	}// UpdateProc() end
}
