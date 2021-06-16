package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("index") //�ε���
	public String index(Model model){
		model.addAttribute("pageName", "indexList.jsp");
		return "/index";
	}
	
	@RequestMapping("cs_service") //������
	public String cs_service(Model model) throws Exception {
		model.addAttribute("pageName", "cs/cs_service.jsp");
		model.addAttribute("leftMenu", "cs_menu.jsp");
		return "/index";
	}
	
	@RequestMapping("all_product") //��ü��ǰ ī�װ�
	public String all_product(Model model){
		model.addAttribute("pageName", "all/list.jsp");
		return "/index";
	}
	
	@RequestMapping("group_product") //�������� ī�װ�
	public String group_product(Model model){
		model.addAttribute("pageName", "group/list.jsp");
		return "/index";
	}
	
	@RequestMapping("detail") //��ü��ǰ ī�װ�->��ǰ��������
	public String detail(Model model){
		model.addAttribute("pageName", "detail/detail.jsp");
		return "/index";
	}
	
}
