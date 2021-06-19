package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	//�ε���
	@RequestMapping("index") 
	public String index(Model model){
		model.addAttribute("pageName", "indexList.jsp");
		return "/index";
	}
	
	//��ü��ǰ ī�װ�
	@RequestMapping("all_product") 
	public String all_product(Model model){
		model.addAttribute("pageName", "product/all/list.jsp");
		return "/index";
	}
	
	//��ü��ǰ-1�ι�ŰƮ,����ǰ
	@RequestMapping("/all/meal") 
	public String meal(Model model){
		model.addAttribute("pageName", "product/all/meal.jsp");
		return "/index";
	}
	
	//��ü��ǰ-����
	@RequestMapping("/all/meat") 
	public String meat(Model model){
		model.addAttribute("pageName", "product/all/meat.jsp");
		return "/index";
	}
	
	//��ü��ǰ-�ػ깰
	@RequestMapping("/all/sea") 
	public String sea(Model model){
		model.addAttribute("pageName", "product/all/sea.jsp");
		return "/index";
	}
	
	//��ü��ǰ-ä��,��ä
	@RequestMapping("/all/vegetable") 
	public String vegetable(Model model){
		model.addAttribute("pageName", "product/all/vegetable.jsp");
		return "/index";
	}
	
	//��ü��ǰ-���,���̷�
	@RequestMapping("/all/seasoning") 
	public String seasoning(Model model){
		model.addAttribute("pageName", "product/all/seasoning.jsp");
		return "/index";
	}
	
	//�������� ī�װ�
	@RequestMapping("group_product") 
	public String group_product(Model model){
		model.addAttribute("pageName", "product/group/list.jsp");
		return "/index";
	}
	
	//��ü��ǰ ī�װ�->��ǰ��������
	@RequestMapping("detail") 
	public String detail(Model model){
		model.addAttribute("pageName", "product/detail/detail.jsp");
		return "/index";
	}
	
}