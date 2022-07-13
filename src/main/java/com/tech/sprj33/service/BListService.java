package com.tech.sprj33.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.tech.sprj33.dao.LunchDao;
import com.tech.sprj33.dto.LunchDto;

public class BListService implements BServiceInf{

	@Override
	public void execute(Model model) {
		System.out.println("BListService-------");
		LunchDao dao=new LunchDao();//훳호출  BoardDao()의 생성자호출
		ArrayList<LunchDto> dtos=dao.list();
		
		//리턴받은 내용을 모델에 담기
		model.addAttribute("list",dtos);
		
	}
}
