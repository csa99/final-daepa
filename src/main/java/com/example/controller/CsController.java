package com.example.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.persistence.NoticeDAO;

@Controller
public class CsController {
	/*20210701 ���� ��������*/
	@Resource(name="uploadPath")
	String path;
	
	/*20210701 ���� ��������*/
	@Autowired
	NoticeDAO notice_dao;
	
	@RequestMapping("cs_service") //������
	public String cs_service(Model model) throws Exception {
		model.addAttribute("pageName", "cs/cs_service.jsp");
		model.addAttribute("leftMenu", "cs_menu.jsp");
		model.addAttribute("rightContent", "commonQA/list.jsp");
		/*20210701 ���� ��������*/
		model.addAttribute("rightContent", "detail/notice/notice_list.jsp");
		//model.addAttribute("rightContent", "realtime/chat.jsp");
		return "/index";
	}
	
}
