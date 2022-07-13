package com.tech.sprj33.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tech.sprj33.dao.JoinIDao;
import com.tech.sprj33.dao.LunchIDao;
import com.tech.sprj33.dto.LunchDto;
import com.tech.sprj33.service.BContentViewService;
import com.tech.sprj33.service.BDeleteService;
import com.tech.sprj33.service.BModifyService;
import com.tech.sprj33.service.BReplyService;
import com.tech.sprj33.service.BReplyViewService;
import com.tech.sprj33.service.BServiceInf;
import com.tech.sprj33.service.BWriteService;
import com.tech.sprj33.vopage.SearchVO;

@Controller
@RequestMapping("/join/*")
public class JoinController {
//	BServiceInf commandInf;
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/joinform")
	public String joinform(HttpServletRequest request, SearchVO searchVO, Model model) {
		System.out.println("=========pass by joinform()=============");
//		db접속 데이터 가져오기
//		commandInf=new BListService();
//		commandInf.execute(model);
		
		return "join/joinform";
	}
	@RequestMapping("/join")
	public String join(HttpServletRequest request, SearchVO searchVO, Model model) {
		System.out.println("=========pass by join()=============");
//		db접속 데이터 가져오기
//		commandInf=new BListService();
//		commandInf.execute(model);
		String mid=request.getParameter("mid");
		String mpw=request.getParameter("mpw");
		String mnn=request.getParameter("mnn");
		
		JoinIDao dao=sqlSession.getMapper(JoinIDao.class);
		dao.join(mid, mpw, mnn);
		
		
		return "redirect:/lunchboard/list";
	}

}
