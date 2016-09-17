<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function checkForm() {
		var title = document.getElementById("title").value;
		//使用ckeditor的接口获取日记的内容
		var content = CKEDITOR.instances.content.getData();
		var typeId = document.getElementById("typeId").value;
		if (title == null || title == "") {
			document.getElementById("error").innerHTML = "标题不能为空！";
			return false;
		}
		if (content == null || content == "") {
			document.getElementById("error").innerHTML = "内容不能为空！";
			return false;
		}
		if (typeId == null || typeId == "") {
			document.getElementById("error").innerHTML = "请选择日志类别！";
			return false;
		}
		return true;
	}
</script>
</head>
<body>

	<div class="data_list">
		<div class="data_list_title">
			<c:choose>
				<c:when test="${diary.diaryId !=null}">
					<img
						src="${pageContext.request.contextPath}/images/diary_type_edit_icon.png" />修改日记</div>
		</c:when>
				<c:otherwise>
					<img
						src="${pageContext.request.contextPath}/images/diary_add_icon.png" />写日记</div>
	</c:otherwise>
			</c:choose>
		
	<form action="diary_save.action" method="post"
		onsubmit="return checkForm()">
		<div>
			<div class="diary_title">
				<input type="text" id="title" name="diary.title" value="${diary.title }"
					class="input-xlarge" style="margin-top: 5px; height: 30px;"
					placeholder="日志标题..." />
			</div>
			<!-- 				日记类别 -->
			<div class="diary_type">
				<!-- 				下拉框 -->
				<select id="typeId" name="diary.typeId">
					<option value="">选择日记类别...</option>
					<c:forEach var="diaryTypeCount" items="${diaryTypeCountList }">
						<option value="${diaryTypeCount.diaryTypeId }"
							${diaryTypeCount.diaryTypeId==diary.typeId?'selected':''}>${diaryTypeCount.typeName}</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<textarea class="ckeditor" id="content" name="diary.content">${diary.content }</textarea>
			</div>

			<div>
				<input type="hidden" id="diaryId" name="diary.diaryId" value="${diary.diaryId }" />
				<input type="submit" class="btn btn-primary" value="保存" />
				<button class="btn btn-primary" type="button"
					onclick="javascript:history.back()">取消</button>
				<font id="error" color="red">${error }</font>
			</div>

		</div>
	</form>

	</div>

</body>
</html>