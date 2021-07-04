package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.persistence.GroupSalesDAO;
import com.example.persistence.MeterialDAO;
import com.example.persistence.ProductDAO;
import com.example.service.MeterialService;
import com.example.service.ProductService;

@Controller
public class IndexController {
	@Autowired
	ProductDAO product_dao;
	
	@Autowired
	MeterialDAO meterial_dao;
	
	@Autowired
	GroupSalesDAO group_dao;
	
	@Autowired
	ProductService product_service;
	
	@Autowired
	MeterialService meterial_service;
	
	//�ε���
	@RequestMapping("index") 
	public String index(Model model){
		model.addAttribute("pageName", "indexList.jsp");
		return "/index";
	}	
	
	
	//��ü��ǰ-1�ι�ŰƮ
	@RequestMapping("/meals") 
	public String all_product(Model model,String searchType){
		model.addAttribute("pageName", "product/meal/container.jsp");
		model.addAttribute("product_list", "meal_category/each_meal_list.jsp");
		String type[]={"��ü","����","�ػ깰","��/�а���"};
		model.addAttribute("type", type);
		model.addAttribute("searchType", searchType);
		return "/index";
	}
	
	//��ü��ǰ-ä��,��ä
	@RequestMapping("/veges") 
	public String vegetable(Model model,String searchType){
		model.addAttribute("pageName", "product/vege/container.jsp");
		model.addAttribute("product_list", "vege_category/each_vege_list.jsp");
		String type[]={"��ü","�ʷ�","����","����","�Ͼ�"};
		model.addAttribute("type", type);
		model.addAttribute("searchType", searchType);
		return "/index";
	}
	
	//�������� ī�װ�
	@RequestMapping("group_product") 
	public String group_product(Model model){
		model.addAttribute("pageName", "product/group/list.jsp");
		return "/index";
	}
	
	//��ü��ǰ ī�װ�->�� ��������
	@RequestMapping("meal_detail") 
	public String mealdetail(Model model,String product_id)throws Exception{
		model.addAttribute("pageName", "product/detail/meal_detail/meal_detail.jsp");
		model.addAttribute("product_review", "review/plist.jsp");
		model.addAttribute("product_div", "meal_read_div.jsp");
		////////////////////////20210702������ �������� !!!
		model.addAttribute("product_boardQA_list", "productQA/product_boardQA_list.jsp");
		
		model.addAttribute("vo", product_service.read(product_id));
		model.addAttribute("vo", product_dao.read(product_id));
		return "/index";
	}
	
	//��ü��ǰ ī�װ�->ä�� ��������
	@RequestMapping("vege_detail") 
	public String vege_detail(Model model,String meterial_id)throws Exception{
		model.addAttribute("pageName", "product/detail/vege_detail/vege_detail.jsp");
		model.addAttribute("meterial_review", "review/mlist.jsp");
		model.addAttribute("product_div", "vege_read_div.jsp");
		model.addAttribute("vo", meterial_service.read(meterial_id));
		return "/index";
	}
	
	//��ü��ǰ ī�װ�->�����Ǹ� ��������
	@RequestMapping("group_detail") 
	public String group_detail(Model model,String sales_id)throws Exception{
		model.addAttribute("pageName", "product/detail/group_detail/group_detail.jsp");
		model.addAttribute("product_div", "group_read_div.jsp");
		model.addAttribute("vo", group_dao.read(sales_id));
		return "/index";
	}
}