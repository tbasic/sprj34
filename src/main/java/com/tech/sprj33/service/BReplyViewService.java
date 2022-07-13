package com.tech.sprj33.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tech.sprj33.dao.LunchDao;
import com.tech.sprj33.dto.LunchDto;

public class BReplyViewService implements BServiceInf{

	@Override
	public void execute(Model model) {
		System.out.println("BReplyViewService-------");
//		map으로 변환
		Map<String, Object> map=model.asMap();
//		map->request
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		String bid=request.getParameter("bid");
		
		
		
		LunchDao dao=new LunchDao();
		LunchDto dto=dao.replyView(bid);
		
		
		model.addAttribute("reply_view",dto);
	}
}
