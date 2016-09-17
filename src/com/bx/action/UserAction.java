package com.bx.action;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.stereotype.Controller;

import com.bx.entity.User;
import com.bx.service.UserService;
import com.bx.util.PropertiesUtil;
import com.bx.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @date 2016年4月1日 UserAction.java
 * @author CZP
 * @parameter
 */
@Controller
public class UserAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	@Resource
	private UserService userService;
	private User user;
	private String rember;
	private String mainPage;
	// 上传的文件 （名字为 上传组件的name的值）
	private File imagePath;
	// 上传文件的文件名（固定写法为 XXXFileName ）
	private String imagePathFileName;

	public String preSave() {
		mainPage = "/user/userSave.jsp";
		return "preSave";
	}

	public String save() throws Exception {
		// 好要在Struts.xml文件中配置
		if (imagePath != null) {
			String imageName = StringUtil.getCurrentDateString();
			// 获取存放上传图片的路径
			String realPath = ServletActionContext.getServletContext().getRealPath("/userImages");
			System.out.println("realPath:" + realPath);
			String imageFile = imageName + "." + imagePathFileName.split("\\.")[1];
			File file = new File(realPath, imageFile);
			FileUtils.copyFile(imagePath, file);
			user.setImageName(imageFile);
		} else {
			if (StringUtil.isEmpty(user.getImageName())) {
				user.setImageName("");
			}
		}
		userService.update(user);
		return "error";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.request = req;
	}

	public String getRember() {
		return rember;
	}

	public void setRember(String rember) {
		this.rember = rember;
	}

	@Override
	public void setServletResponse(HttpServletResponse resp) {
		this.response = resp;
	}

	public String getMainPage() {
		return mainPage;
	}

	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}

	public File getImagePath() {
		return imagePath;
	}

	public void setImagePath(File imagePath) {
		this.imagePath = imagePath;
	}

	public String getImagePathFileName() {
		return imagePathFileName;
	}

	public void setImagePathFileName(String imagePathFileName) {
		this.imagePathFileName = imagePathFileName;
	}

}
