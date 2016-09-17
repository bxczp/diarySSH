<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function checkForm() {
		var nickName = document.getElementById("nickName").value;
		if (nickName == null || nickName == "") {
			document.getElementById("error").innerHTML = "昵称不能为空！";
			return false;
		}
		return true;
	}
</script>

</head>
<body>
	<div class="data_list">
		<div class="data_list_title">
			<img
				src="${pageContext.request.contextPath}/images/user_edit_icon.png" />
			个人信息设置
		</div>
		<!-- 		流式栈 -->
		<div class="row-fluid" style="padding-top: 20px">
			<div class="span4">
				<img alt="用户图片" src="${pageContext.request.contextPath }/userImages/${currentUser.imageName }">
			</div>
			<div class="span8">
				<!-- 有图片上传的form 其中enctype要为multipart/form-data-->
				<form action="user_save.action" method="post"
					enctype="multipart/form-data" onsubmit="return checkForm()">
					<table width="100%">
						<tr>
							<td width="20%">头像路径</td>
							<td><input type="file" id="imagePath" name="imagePath" /></td>
						</tr>
						<tr>
							<td>个人昵称</td>
							<td><input type="text" id="nickName" name="user.nickName"
								style="margin-top: 5px; height: 30px;"
								value="${currentUser.nickName }" /></td>
						</tr>
						<tr>
							<td>心情</td>
							<td><textarea id="mood" name="user.mood" row="10"
									style="width: 100%">${currentUser.mood }</textarea></td>
						</tr>
						<tr>
							<td>
							<input type="hidden" id="userId" name="user.userId" value="${currentUser.userId }"/>
							<input type="hidden" id="password" name="user.password" value="${currentUser.password }"/>
							<input type="hidden" id="userName" name="user.userName" value="${currentUser.userName }" />
								<button class="btn btn-primary" type="submit">保存</button>
							</td>
							<td>
								<button class="btn btn-primary" type="button"
									onclick="javascript:history:back">返回</button>
							</td>
						</tr>
					</table>
					<font color="red" id="error"></font>
				</form>
			</div>
		</div>

	</div>
</body>
</html>