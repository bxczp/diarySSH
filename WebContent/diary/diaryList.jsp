<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="data_list">
		<div class="data_list_title">
		<img src="${pageContext.request.contextPath}/images/list_icon.png"/>
		日记列表</div>
		<div class="diary_datas">
			<ul class="diary_datas_ul">
				<c:forEach var="diary" items="${diaryList }">
				<li>
					『<fmt:formatDate value="${diary.releaseDate }" type="date" pattern="yyyy-MM-dd" />』
					<span>
						&nbsp;&nbsp;<a href="diary_show.action?diaryId=${diary.diaryId }" style="font-size: 15px">${diary.title }</a>
					</span>
				</li>
				</c:forEach>
			</ul>
		</div>
		<div class="pagination pagination-centered">
			<ul>
				${pageCode }
			</ul>
		</div>
</div>