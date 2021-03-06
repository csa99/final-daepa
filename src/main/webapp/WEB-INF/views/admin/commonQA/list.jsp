<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/resources/css/admin_main.css"/>
<style>
	#div_content{width: 100%; margin:0px auto;}
	table {width: 100%; border-top: 1px solid #444444; border-collapse: collapse;}
	tr, td {border-bottom: 1px solid #444444;padding: 10px;}
	#total{display:none;}
	#pagination{text-align: center; margin-top:10px;}
 #pagination a{text-decoration:none; color:#123478; font-weight:bold;}
 #pagination .active{color:#ccc}
</style>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<br/><h2>자주하는질문</h2><br/>
   <div class="div_container" >
      <div class="div_checkbox" style="float:left;">
         <select id="type">
            <option value="commonQA_title">제목</option>
            <option value="commonQA_contents">내용</option>
         </select>
         <input type="text" id="keyword" class="admin_text"/>
         <button class="btn_admin" id="btn_search">검색</button>
      </div>   
   <span style="float:right;">
      <c:if test="${admin_id!=null}">
         <div>
            <button class="btn_admin" onClick="location.href='/board/admin_commonQA_insert'">글쓰기</button>   
         </div>
      </c:if>
   </span>
   </div>
<div id="div_content">
   <table id="tbl" class="table"></table>
      <script id="temp" type="text/x-handlebars-template">
         <tr class="title">
            <td width=200>번호</td>
            <td width=800>제목</td>   
         </tr>
         {{#each list}}
           <tr class="row">  
            <td class="commonQA_number">{{commonQA_number}}</td>
            <td>{{commonQA_title}}</td>
           </tr>
         <tr class="c_row" style="display:none" commonQA_number={{commonQA_number}}>
                 <td></td>
            <td><textarea rows="10" cols="100" style="border:none;" readonly>{{commonQA_contents}}</textarea></td>
            </tr>
         {{/each}}
      </script>
   <div id="pagination"></div>
   <span id="total"></span>
</div>
<script>
   var page=1;
   getNotice();
   /*$("#tbl").on("click",".tr_row",function(){
      if($("#tbl .row").css("display")=="none"){
         $(this).next().show();
         $(this).next().css("display:block;");
      }else if($("#tbl .row").css("display")!="none"){
         $(this).next().hide();
         $(this).next().css("display:none;");
      }
      $(this).next().toggle();
   });*/
   //클릭시 하단에 tr 글 출력
   $(".table").on("click",".row",function(){
        var tr = $(this);
       var no = tr.find(".commonQA_number").html();
      $(".c_row").each(function(){
         var commonQA_number = $(this).attr("commonQA_number");
         if(no==commonQA_number){
            if($(this).css("display")=="none"){
               $(this).show();
            }else{
               $(this).hide();
            }
         }else{
            $(this).hide();
         }
      });
   });
   $(".admin_text").on("keydown",function(e){
      if(e.keyCode==13) {
         $("#btn_search").click();
      }
   });
   $("#btn_search").on("click",function(){
      var page=1;
      getNotice();
   });
   
   function getNotice(){
      var type=$("#type").val();
      var keyword=$(".admin_text").val();
      //alert("111");
      $.ajax({
         type:"get",
         url:"/board/admin_commonQA.json",
         dataType:"json",
            data:{"page":page,"searchType":type,"keyword":keyword},
            success:function(data){
               var temp = Handlebars.compile($("#temp").html());
               $("#tbl").html(temp(data));
               $("#total").html("검색수:" + data.pm.totalCount);
               
               //페이징목록출력
               var str="";
               var prev=data.pm.startPage-1;
               var next=data.pm.endPage+1;            

               if(data.pm.prev) str +="<a href='" + prev + "'>◀</a>";
               for(var i=data.pm.startPage;i<=data.pm.endPage; i++){
                  if(i==page){
                     str += "<a class='active' href='" + i + "'>&nbsp&nbsp" + i + "&nbsp&nbsp</a> ";
                  }else{
                        str += "<a href='" + i + "'>&nbsp&nbsp" + i + "&nbsp&nbsp</a> ";
                  }   
               }
               if(data.pm.next) str +="<a href='" + next + "'>▶</a>";
               $("#pagination").html(str);
            }
         });
      };
        
      $("#pagination").on("click","a",function(e){
         e.preventDefault();
         page = $(this).attr("href");
         getNotice();
      });
</script>