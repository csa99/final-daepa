package com.example.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.domain.Criteria;
import com.example.domain.MeterialVO;
import com.example.domain.PageMaker;
import com.example.domain.ProductVO;
import com.example.persistence.MeterialDAO;

@Controller
@RequestMapping("/meterial/")
public class MeterialController {
	@Resource(name="uploadPath")
	String path;
	
	@Autowired
	MeterialDAO meterial_dao;
	
	@RequestMapping("meterial.json")
	@ResponseBody
	public Map<String,Object> meterial_list(Criteria cri)throws Exception{
		Map<String,Object> map=new HashMap<>();
		cri.setPerPageNum(20);
		PageMaker pm=new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(meterial_dao.totalCount(cri));
		
		map.put("list", meterial_dao.list(cri));
		map.put("pm", pm);
		map.put("cri", cri);
		return map;
	}
	
	@RequestMapping("admin_meterial.json")
	@ResponseBody
	public Map<String,Object> admin_meterial_list(Criteria cri)throws Exception{
		Map<String,Object> map=new HashMap<>();
		cri.setPerPageNum(10);
		PageMaker pm=new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(meterial_dao.totalCount(cri));
		
		map.put("list", meterial_dao.admin_list(cri));
		map.put("pm", pm);
		map.put("cri", cri);
		return map;
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String admin_update(MeterialVO vo, MultipartHttpServletRequest multi)throws Exception{
		System.out.println("어드민 재료수정!!!!!!!!"+vo.toString());
		MeterialVO oldVO=meterial_dao.read(vo.getMeterial_id());
		
		//대표 이미지 파일업로드
		MultipartFile file=multi.getFile("file");
		if(!file.isEmpty()){
			String image=System.currentTimeMillis()+"_"+file.getOriginalFilename();
			file.transferTo(new File(path + "/" + image));
			vo.setProduct_image(image);
			
			//예전이미지가 존재한다면 삭제
			if(oldVO.getProduct_image()!=null){
				new File(path + "/" + oldVO.getMeterial_image()).delete();
			}
		}else{
			vo.setMeterial_image(oldVO.getMeterial_image());
		}
		meterial_dao.update(vo);
		return "redirect:/admin/meterial";
	}
}
