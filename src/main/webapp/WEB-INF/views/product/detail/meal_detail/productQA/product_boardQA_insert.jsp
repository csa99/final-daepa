<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
   
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>PRODUCT Q/A</title>
      <style>
 	*{font-family: 'Noto Sans KR', sans-serif; font-weight:bold;}
    .btn_style { width: 120px; height: 50px; padding: .5em; border: 1px solid #123478; background: #123478; border-radius: 5px 5px 5px; color: white; font-weight:bold; margin-left: 10px;}
   	table{width: 95%;border-collapse: collapse;font-weight:bold;}
    tr,td{border:solid 1px #ccc solid;padding: 10px;text-align: center;}
    .text_style,#text_style {
	width: 350px;
	height: 40px;
	padding: .4em;
	margin: 5px;
	font-weight: 600;
	background: white;
	 border: 1px solid #ccc;
    border-radius: 3px;
	font-size: 12pt;
	color: -internal-light-dark(black, white);
	background-color: -internal-light-dark(rgb(255, 255, 255),
		rgb(59, 59, 59));
	} 
	.text_style2 {
		width: 350px;
		height: 20px;
		padding: .2em;
		margin: 5px;
		font-weight: 600;
		background: white;
		 border: 1px solid #ccc;
	    border-radius: 3px;
		font-size: 12pt;
		color: -internal-light-dark(black, white);
		background-color: -internal-light-dark(rgb(255, 255, 255),
			rgb(59, 59, 59));
	} 
   </style>
</head>
<body>
<div style="width:610px; height:900px; background-color: #FFFFFF; border: 1px solid #D5D5D5; border-radius:10px 10px 10px 10px;  padding:10px; margin:0px auto;">
   <h2 style="color:#123478; text-align:center; ">μν λ¬Έμ</h2>
   <hr style="border: 0.25px solid; width:500px; margin: 0 auto; background-color:#D5D5D5; color:#D5D5D5;" />
   <br/>
   
   <table>
      <tr>
         <td style=" width:80; display:none;">${product_id}</td> 
         <td style=" width:80; padding:0px 30px 0px 30px;">
                <img id="image" src="/displayFile?fullName=${aa.product_image}" width=120/>
                  <input type="file" name="file" style="display:none;"/>
         </td>
         <td style=" width:80;">${aa.product_name}</td>
      </tr>
   </table>
   <br/>
   <hr style="border: 0.25px solid; width:500px; margin: 0 auto; background-color:#D5D5D5; color:#D5D5D5;" />
   <form name="frm" encType="multipart/form-data">
      <table style="padding:10px" width=500 >
         <tr>
            <td><input type="hidden" name="product_id" value="${product_id}"/></td>
            <td><input type="hidden" name="boardQA_writer" value="${user_info.user_id}"/></td>
            <!--<td><input type="hidden" value="1992-07-19" readonly/></td> -->
         </tr>
         <tr>
            <td class="title" style="text-align:center;" width=100>μ λͺ©</td>
            <td width=100><input type="text"  class="text_style" name="boardQA_title" size=45 placeholder="μ λͺ©μμλ ₯ν΄μ£ΌμΈμ"/></td>
         </tr>
         <tr>
            <td class="title" style="text-align:center;" width=100>λ΄μ©</td>
            <td width=400>
               <textarea style="width:350px; height:200px; resize: none;"  class="boardQA_contents" name="boardQA_contents"  id="text_style" placeholder="λ¬Έμ λ΄μ©μ μλ ₯ν΄μ£ΌμΈμ                                            γλ°°μ‘κ΄λ ¨, μ£Όλ¬Έ(μ·¨μ/κ΅ν/νλΆ)κ΄λ ¨λ¬Έμ λ° μμ²­μ¬ν­μ  1:1 μ±νλ¬Έμλ₯Ό μ΄μ©ν΄μ£ΌμΈμ"></textarea>
            </td>
         </tr>
      </table>
      <div style="float:right; margin-right:50px;  color:#aaa; font-size:12px;" id="counter">(0 / μ΅λ 500μ)</div>
      <br/>
      <div style="padding:20px; text-align:center; ">
         <input type="button" value="λ±λ‘μ·¨μ" style="width: 120px; height: 50px; background-color:#ffffff; border:1px solid #D5D5D5; cursor:pointer; border-radius:6px 6px 6px 6px; color:#8C8C8C; Font-weight:bold;" onClick="location.href='/meal_detail?product_id=${aa.product_id}'">
         <input type="submit" class="btn_style" value="λ±λ‘">
      </div>
   </form>
</div>   
</body>
<script>

   var product_name="${vo.product_name}";

   //κΈμμ μ€μκ° μΉ΄μ΄ν
   $(frm.boardQA_contents).keyup(function (e){
       var content = $(this).val();
       $('#counter').html("("+content.length+" / μ΅λ 500μ)");   
   
       if (content.length > 500){
           alert("μ΅λ 500μκΉμ§ μλ ₯ κ°λ₯ν©λλ€.");
           $(this).val(content.substring(0, 500));
           $('#counter').html("(500 / μ΅λ 500μ)");
       }
   });

   //μνλ¬Έμ λ±λ‘ λ²νΌ
   $(frm).submit(function(e){
      e.preventDefault();
      var boardQA_contents = $(frm.boardQA_contents).val();
      if(boardQA_contents == "") {
         alert("λ¬Έμ λ΄μ©μ μλ ₯λ°λλλ€"); return;
      }
      if (!confirm(product_name + "μνλ¬Έμλ₯Ό λ±λ‘νμ€λμ?")) return;
      frm.action="product_boardQA_insert";
      frm.method="post"; 
      frm.submit();
      alert("λ±λ‘μ΄ μλ£λμμ΅λλ€.");
   });
</script>
</html>