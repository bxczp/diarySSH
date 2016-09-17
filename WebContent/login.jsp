<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.bx.entity.User"%>
	
<%
	if(request.getAttribute("user")==null){
		String userName="";
		String password="";
		Cookie[] cookies=request.getCookies();
		for(int i=0;cookies!=null&&i<cookies.length;i++){
			if("user".equals(cookies[i].getName())){
				userName=cookies[i].getValue().split("-")[0];
				password=cookies[i].getValue().split("-")[1];
			}
		}
		User user=new User(userName,password);
		request.setAttribute("user", user);
	}
	
	
%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- 都使用绝对路径 -->
<!--核心CSS文件-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-responsive.css">
<!--Jquery文件，且必须在bootstrap.min.js之前引入-->
<script src="${pageContext.request.contextPath}/bootstrap3/js/jQuery.js"></script>
<!--核心JavaScript文件-->
<script
	src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.min.js"></script>
	
<script type="text/javascript">

	function  checkForm() {
		var userName=$("#userName").val();
		var password=$("#password").val();
		if(userName==null || userName==''){
			$("#error").html("用户名不能为空！");
			return false;
		}
		if(password ==null || password ==''){
			$("#error").html("密码不能为空！");
			return false;
		}
		return true;
	}
</script>
</head>
<body>

<div class="container">
	<form  action="login_login.action" class="form_signin" name="myform" method="post" onsubmit="return checkForm()">
		<h2>日记本登录</h2>
		<input style="width: 200px;" id="userName" name="user.userName" type="text" value="${user.userName }" class="input-block-level" placeholder="用户名" /><br/>
		<input style="width: 200px;" id="password" name="user.password" type="password" value="${user.password }" class="input-block-level" placeholder="密码" /><br/>
		<input style="margin-bottom: 10px;" type="checkbox" id="rember" name="rember" value="rember" />记住我<br/>
		<button class="btn btn-primary" type="submit">登录</button>&nbsp;&nbsp;&nbsp;
		<button class="btn btn-info" type="reset">重置</button><br/>
		<font id="error" color="red">${errorMsg}</font>
		
	</form>
</div>

</body>
</html>