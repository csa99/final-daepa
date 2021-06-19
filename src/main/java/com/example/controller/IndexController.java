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
	
	//��ü��ǰ-1�ι�ŰƮ
	@RequestMapping("/meals") 
	public String all_product(Model model){
		model.addAttribute("pageName", "product/meal/container.jsp");
		model.addAttribute("product_list", "meal_category/each_meal_list.jsp");
		String type[]={"��ü","����","�ػ깰","��/�а���"};
		model.addAttribute("type", type);
		return "/index";
	}
	
	//��ü��ǰ-ä��,��ä
	@RequestMapping("/veges") 
	public String vegetable(Model model){
		model.addAttribute("pageName", "product/vege/container.jsp");
		model.addAttribute("product_list", "vege_category/each_vege_list.jsp");
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