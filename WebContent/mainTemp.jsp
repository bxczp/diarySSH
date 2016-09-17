<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- bootstrap响应式设计 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>个人日记本主页</title>
<link href="${pageContext.request.contextPath}/style/diary.css" rel="stylesheet">
<!-- 都使用绝对路径 -->
<!--核心CSS文件-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.css">
<!--可选的Bootstrap主题文件（一般不引入）-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-responsive.css">
<!--Jquery文件，且必须在bootstrap.min.js之前引入-->
<script src="${pageContext.request.contextPath}/bootstrap3/js/jQuery.js"></script>
<!--核心JavaScript文件-->
<script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.js"></script>

<!-- 	引入ckeditor，一个在线文本编辑器 -->
<script src="${pageContext.request.contextPath}/js/ckeditor/ckeditor.js"></script>

<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}
</style>

</head>
<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="#">日记本</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active">
							<a href="main.action?all=true">
								<i class="icon-home"></i>
								&nbsp;主页
							</a>
						</li>
						<li class="active">
							<a href="diary_preSave.action">
								<i class="icon-pencil"></i>
								&nbsp;写日记
							</a>
						</li>
						<li class="active">
							<a href="diaryType_list.action">
								<i class="icon-book"></i>
								&nbsp;日记分类管理
							</a>
						</li>
						<li class="active">
							<a href="user_preSave.action">
								<i class="icon-user"></i>
								&nbsp;个人中心
							</a>
						</li>
					</ul>
				</div>
				<!-- 			搜索表单 -->
				<form name="myForm" class="navbar-form pull-right" method="post" action="main.action?all=true">
					<input class="span2" id="s_title" name="s_title" type="text" style="margin-top: 5px; height: 30px;" placeholder="往事如烟...">
					<button type="submit" class="btn" onkeydown="if(event.keyCode==13) myForm.submit()">
						<i class="icon-search"></i>
						&nbsp;搜索日志
					</button>
				</form>
			</div>
		</div>
	</div>

	<div class="container">
		<!-- 	流式布局 一行12列，其中9列为一组，3列为一组，每个组都占一行-->
		<div class="row-fluid">
			<div class="span9">
				<!-- 			包含JSP页面 -->
				<jsp:include page="${mainPage }"></jsp:include>
			</div>
			<div class="span3">
				<div class="data_list">
					<div class="data_list_title">
						<img src="${pageContext.request.contextPath}/images/user_icon.png" />
						个人中心
					</div>
					<div class="user_image">
						<img alt="用户图片" src="${pageContext.request.contextPath }/userImages/${currentUser.imageName }">
					</div>
					<div class="user_nickName">${currentUser.nickName }</div>
					<div class="user_mood">(${currentUser.mood })</div>
				</div>
				<div class="data_list">
					<div class="data_list_title">
						<img src="${pageContext.request.contextPath}/images/byType_icon.png" />
						按日记类别
					</div>
					<div class="datas">
						<ul>
							<c:forEach var="diaryTypeCount" items="${diaryTypeCountList }">
								<li>
									<span>
										<a href="main.action?diary_typeId=${diaryTypeCount.diaryTypeId }">${diaryTypeCount.typeName }(${diaryTypeCount.diaryCount })</a>
									</span>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>

				<div class="data_list">
					<div class="data_list_title">
						<img src="${pageContext.request.contextPath}/images/byDate_icon.png" />
						按日记日期
					</div>
					<div class="datas">
						<ul>
							<c:forEach var="diaryCount" items="${diaryCountList }">
								<li>
									<span>
										<a href="main.action?diary_releaseDataStr=${diaryCount.releaseDateStr }">${diaryCount.releaseDateStr }(${diaryCount.diaryCount })</a>
									</span>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>