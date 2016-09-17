<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function diaryDelete(diaryId) {
		if(confirm("确认删除...")){
// 			注意location的格式 =后面要用"" 引起来 
			window.location="diary_delete.action?diaryId="+diaryId;
		}
	}

</script>

</head>
<body>
	<div class="data_list">
		<div class="data_list_title">
			<img
				src="${pageContext.request.contextPath}/images/diary_show_icon.png" />
			日记信息
		</div>

		<div class="diary_title">
			<h2>${diary.title }</h2>
		</div>
		<div class="diary_info">
			发布时间：『
			<fmt:formatDate value="${diary.releaseDate }" type="date"
				pattern="yyyy-MM-dd HH:mm:ss" />
			』 &nbsp;&nbsp;日记类别：『 ${diary.typeName }』
		</div>
		<div class="diary_content">日记内容：${diary.content }</div>

		<div class="diary_action">
			<button class="btn btn-primary" type="button" onclick="javascript:window.location='diary_preSave.action?diaryId=${diary.diaryId }'">修改日志</button>
			<button class="btn btn-primary" type="button"
				onclick="javascript:history.back()">返回</button>
			<button class="btn btn-danger" type="button" onclick="diaryDelete(${diary.diaryId})">删除日志</button>
		</div>

	</div>

</body>
</html>