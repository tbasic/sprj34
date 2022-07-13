package com.tech.sprj33.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tech.sprj33.dao.LunchDao;
import com.tech.sprj33.dto.LunchDto;

public class BWriteService implements BServiceInf{

	@Override
	public void execute(Model model) {
		System.out.println("BWriteService-------");
//		map으로 변환
		Map<String, Object> map=model.asMap();
//		map->request
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		String bName=request.getParameter("bName");
		String bTitle=request.getParameter("bTitle");
		String bContent=request.getParameter("bContent");
		
		//System.out.println("bName   :  "+bName);
		
		LunchDao dao=new LunchDao();
		dao.write(bName,bTitle,bContent);
	}
}
