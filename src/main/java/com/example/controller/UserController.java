package com.example.controller;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.example.domain.UserVO;
import com.example.persistence.UserDAO;

@Controller
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	UserDAO dao;	
	
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	@RequestMapping("login")
	public String login(Model model){
		model.addAttribute("pageName","user/login.jsp");
		return "/index";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String,Object> loginPost(String user_id, String user_password,HttpSession session,boolean chkLogin,HttpServletResponse response)throws Exception{
		  HashMap<String,Object> map = new HashMap<String,Object>();
		  int result = 0; //���̵� ���� ���
		  UserVO vo = dao.login(user_id);
		  if(vo!=null){
			  if(passEncoder.matches(user_password,vo.getUser_password())){
				  result=1; //�α��μ���
			  }if(chkLogin){
				  Cookie cookie = new Cookie("user_id",vo.getUser_id()); //��Ű����
				  cookie.setPath("/");
				  cookie.setMaxAge(60*60*24*7); //7�ϰ� ����
				  response.addCookie(cookie);
			  }
			  System.out.println("�α���Ȯ��........."+vo.toString());
			  session.setAttribute("user_id", vo.getUser_id());
			  String path=(String)session.getAttribute("path");
			  if(path==null) path="/index";
			  map.put("path", path);
		  }else{
			  result=2; //��й�ȣ ����ġ
		  }
		  map.put("result", result);
		  return map;
	}
	
	@RequestMapping("logout")
	public String logout(Model model,HttpSession session,HttpServletResponse response, HttpServletRequest request){
		model.addAttribute("pageName","home.jsp");
		session.invalidate();
		Cookie cookie = WebUtils.getCookie(request, "user_id");
		if(cookie != null){
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		return "/index";
	}	
}
