<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script> 
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   
   <style>
      table{width: 100%;border-collapse: collapse;border-bottom:solid 1px;}
      td{border:solid 1px rgb(200, 200, 200) solid;padding: 10px;text-align: center;}
      .row:hover{cursor:pointer;}
      .row{border-top:solid 1px rgb(200, 200, 200);}
      .title{border-top:2px solid; text-align: center; background:#FAFAFA;}
      #pagination{text-align: center; font-weight:bold;}
      #pagination a{text-decoration:none; color:#123478;}
      #pagination .active{color:#ccc;}
      #review_insert{text-align:right;}
      #total{display:none;}
        .btn_style { width: 120px; height: 50px; padding: .5em; border: 1px solid #123478; background: #123478; border-radius: 5px 5px 5px; color: white; font-weight:bold; margin-left: 10px;}
   </style>
</head>
<body>
   <div id="boardQAread" style="margin:0px auto; border:1px solid; border-radius:10px 10px 10px 10px; width:700px; border-color:#BDBDBD">
   <h2 style="text-align:center;"> '${vo.product_name}' μν λ¬Έμ</h2>
      <form name="frm" action="boardQA_read"  enctype="multipart/form-data">
      <input type="hidden" name="boardQA_number" value="${vo.boardQA_number}"/>
      <input type="hidden" name="product_name" value="${vo.product_name}"/>
         <table width="600">
            <tr>
                <td colspan="4" style="border-top:2px solid;"></td>
            </tr>
            
            <tr>
               <td style="background:#FAFAFA; border-bottom:1px solid #D8D8D8;">μ λͺ©</td>
               <td colspan="3" style="border-bottom:1px solid #EAEAEA; text-align:left;">${vo.boardQA_title}</td>
            </tr>
            <tr>
               <td style="background:#FAFAFA; border-bottom:1px solid #D8D8D8;" >μμ±μ</td>
               <td colspan="3" style="border-bottom:1px solid #EAEAEA; text-align:left">${vo.boardQA_writer}</td>
            </tr>
            <tr>
               <td style="background:#FAFAFA; ">μμ±μΌ</td>
               <td style="text-align:left"><fmt:formatDate value="${vo.boardQA_write_date}" pattern="yyyy-MM-dd kk:mm:ss"/></td>
               <!-- <td>${vo.boardQA_write_date}</td> -->
               <td style="background:#FAFAFA">λ΅λ³μν</td>
               <c:if test="${vo.boardQA_click==1}">
                  <td style="text-align:center; width:80; font-weight:bold; color:#123478">λ΅λ³μλ£</td>
               </c:if>
               <c:if test="${vo.boardQA_click==0}">
                  <td style="text-align:center; width:80; color:#A6A6A6">λ΅λ³λκΈ°</td>
               </c:if>
            </tr>
            <tr>
                <td colspan="4" style="border-bottom:1px solid #FAFAFA;"></td>
            </tr>
            <!-- μμ μμ μμ μμ μμ μμ μμ μμ μμ μμ μμ μμ μμ μμ μμ μμ μμ μμ μμ μμ μμ μμ μμ μμ μμ μμ  -->
            <tr>
               <c:if test="${vo.answer_contents==null}">
                        <td colspan="4" style="text-align:left"> <span> π¬  ${vo.boardQA_contents}</span><br/><br/> <span style="font-weight:bold; ">π’ <MARQUEE direction="right" scrolledelay="5000" width="100px">λ΅λ³λκΈ°</MARQUEE></span></td>      
                  </c:if>
                  <c:if test="${vo.answer_contents!=null}">
                        <td colspan="4" style="text-align:left"> <span> π¬  ${vo.boardQA_contents}</span><br/><br/> <span><b>π’ ${vo.answer_contents}</b></span></td>      
                  </c:if>      
            </tr>
            <tr>
               <c:if test="${vo.boardQA_writer == user_info.user_id}">
                  <td colspan="4" style="border-top:1px solid #EAEAEA; text-align:right; padding:20px 10px 20px 0px" >
                      <input type="button" class="btn_style" value="λͺ©λ‘μ΄λ" onClick="location.href='/meal_detail?product_id=${vo.product_id}'"/>
                     <input type="button" class="btn_style" value="μ­μ " id="btnDelete">
                  </td>
               </c:if>
               <c:if test="${vo.boardQA_writer != user_info.user_id}">
                  <td colspan="4" style="border-top:1px solid #EAEAEA; text-align:right; padding:20px 10px 20px 0px" >
                     <input type="button" class="btn_style" value="λͺ©λ‘μ΄λ" onClick="location.href='/meal_detail?product_id=${vo.product_id}'"/>
                  </td>
               </c:if>
            </tr>
            <tr>
         </tr>
         </table>   
      </form>
   </div>
   
   <br/>
   <!--
   <c:if test="${admin_vo.admin_id!=null}">
      <div style="text-align:center;">
         <input type="button" class="btn_style" value="λ¬Έμλ΅λ³μμ±" onClick="location.href='/board/product_boardQA_update?boardQA_number=${vo.boardQA_number} & product_id=${vo.product_id}'"/>
      </div>
   </c:if>   
   <c:if test="${admin_vo.admin_id==null}">
      <div style="text-align:center;">
         <input type="hidden" class="btn_style" value="λ¬Έμλ΅λ³μμ±" onClick="location.href='/board/product_boardQA_update?boardQA_number=${vo.boardQA_number} & product_id=${vo.product_id}'"/>
      </div>
   </c:if>   
    -->
    
   <c:if test="${user_info.user_id=='daepa'}">
      <div style="text-align:center;">
         <input type="button" class="btn_style" value="λ¬Έμλ΅λ³μμ±" onClick="location.href='/board/product_boardQA_update?boardQA_number=${vo.boardQA_number} & product_id=${vo.product_id}'"/>
         <input type="button" class="btn_style" value="μ­μ " id="btnDelete">
      </div>
   </c:if>   
   <c:if test="${user_info.user_id!='daepa' || user_info.user_id==null}">
      <div style="text-align:center;">
         <input type="hidden" class="btn_style" value="λ¬Έμλ΅λ³μμ±" onClick="location.href='/board/product_boardQA_update?boardQA_number=${vo.boardQA_number} & product_id=${vo.product_id}'"/>
      </div>
   </c:if>
   
   
</body>
<script>
   var boardQA_number="${vo.boardQA_number}";
   //μνλ¬Έμ μ­μ 
   $("#btnDelete").on("click", function(){
      if(!confirm("μ­μ νμκ² μ΅λκΉ?")) return;
      frm.action="/board/product_boardQA_delete";
      frm.method="get";
      frm.submit();
   });
   
</script>
</html>