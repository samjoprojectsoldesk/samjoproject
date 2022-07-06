package kr.co.samjo.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import kr.co.samjo.bbs.notice.noticeDTO;
import kr.co.samjo.board2.boardDTO;
import kr.co.samjo.product.sookso.SooksoDTO;
import kr.co.samjo.product.packagetour.packagetourDTO;
import kr.co.samjo.product.packagetour.packagetourDTO;
import kr.co.samjo.product.rental.rentalDTO;
import kr.co.samjo.product.rentalcar.rentalcarDTO;
import kr.co.samjo.product.sookso.SooksoDTO;
import kr.co.samjo.tour.TourDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

public class adminDAO {
	private DBOpen dbopen = null;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private StringBuilder sql = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy. MM. dd. a HH:mm:ss");

	public adminDAO() {
		dbopen = new DBOpen();
	}// end

	


}