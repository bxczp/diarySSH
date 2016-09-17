<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript">
	function diaryTypeDelete(diaryTypeId) {
		if(confirm("确认删除...")){
// 			注意location的格式 =后面要用"" 引起来 
			window.location.href="${pageContext.request.contextPath}/diaryType_delete.action?diaryTypeId="+diaryTypeId;
		}
	}

</script>
<div class="data_list">
		<div class="data_list_title">
		<img src="${pageContext.request.contextPath}/images/list_icon.png"/>
		日记类别列表
		<span class="diaryType_add">
			<button class="btn  btn-success" type="button" onclick="javascript:window.location='${pageContext.request.contextPath}/diaryType_preSave.action'">增加类别</button> 
		</span>
		</div>
		<div>
<!-- 		bootstrap样式 -->
			<table class="table table-striped table-hover">
				<tr>
					<th>编号</th>
					<th>日记类别名称</th>
					<th>操作</th>
				</tr>
<%-- 				注意var与items的区别，带${}与不带 --%>
				<c:forEach var="diaryType" items="${ diaryTypeList}">
					<tr>
						<td>${diaryType.diaryTypeId }</td>
						<td>${diaryType.typeName }</td>
						<td>
								<button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='${pageContext.request.contextPath }/diaryType_preSave.action?diaryTypeId=${ diaryType.diaryTypeId }'">修改</button>
								&nbsp;&nbsp;<button class="btn btn-mini btn-danger" type="button"  onclick="diaryTypeDelete(${diaryType.diaryTypeId})">删除</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div align="center"><font color="red">${error}</font></div>
</div>