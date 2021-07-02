package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cs/")
public class CsController {
	
	@RequestMapping("notice") //��������
	public String cs_notice(Model model) throws Exception {
		model.addAttribute("pageName", "cs/cs_service.jsp");
		model.addAttribute("leftMenu", "cs_menu.jsp");
		//model.addAttribute("rightContent", "commonQA/list.jsp"); ��������.jsp�߰�
		return "/index";
	}
	
	@RequestMapping("commonQA") //�����ϴ�����
	public String cs_commonqa(Model model) throws Exception {
		model.addAttribute("pageName", "cs/cs_service.jsp");
		model.addAttribute("leftMenu", "cs_menu.jsp");
		model.addAttribute("rightContent", "commonQA/list.jsp");
		return "/index";
	}
	
	@RequestMapping("realtime") //����ä��
	public String cs_realtime(Model model) throws Exception {
		model.addAttribute("pageName", "cs/cs_service.jsp");
		model.addAttribute("leftMenu", "cs_menu.jsp");
		//model.addAttribute("rightContent", "commonQA/list.jsp"); ����ä��.jsp�߰�
		return "/index";
	}
	
	@RequestMapping("suggestion") //�����ϱ�
	public String cs_suggestion(Model model) throws Exception {
		model.addAttribute("pageName", "cs/cs_service.jsp");
		model.addAttribute("leftMenu", "cs_menu.jsp");
		//model.addAttribute("rightContent", "commonQA/list.jsp"); �����ϱ�.jsp�߰�
		return "/index";
	}
	
}
