<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h2>공지사항</h2>
<form name="frm">
	<input type="hidden" name="notice_number" value="${vo.notice_number}"/>
	<table>
		<tr>
			<td>제목</td>
			<td colspan=3><input type="text" name="notice_title" value="${vo.notice_title}"/></td>
		</tr>
		<tr>
			<td>작성자</td>
			<th>${vo.notice_writer}</th>
			<td>작성일</td>
			<td><fmt:formatDate value="${vo.notice_write_date}" pattern="yyyy-MM-dd"/></td>
		</tr>
		<tr>
			<td>수정일</td>
			<td><fmt:formatDate value="${vo.notice_modify_date}" pattern="yyyy-MM-dd"/></td>
			<td>조회수</td>
			<td>${vo.notice_click}</td>
		</tr>
		<tr>
			<td colspan=4><textarea name="notice_contents" style="width:500px; height:200px; resize: none;">${vo.notice_contents}</textarea></td>
		</tr>
	</table>
	<button id="btn_modify">수정</button><input type="button" id="btn_list" value="목록">
</form>
<script>
	$("#btn_modify").on("click",function(e){
		e.preventDefault();
		if(!confirm("수정하시겠습니까?")) return;
		frm.action="notice_update";
		frm.method="post";
		frm.submit();
	});
	$("#btn_list").on("click",function(e){
		e.preventDefault();
		location.href="/admin/main";
	});
</script>