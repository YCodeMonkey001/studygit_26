package com.yc.mybatis.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.yc.mybatis.entity.PaginationBean;
import com.yc.mybatis.entity.User;
import com.yc.mybatis.service.UserService;
import com.yc.mybatis.service.impl.UserServiceImpl;
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

	private static final long serialVersionUID = 513537102242703475L;
	private UserService userService;
	
	public UserServlet(){
		userService = new UserServiceImpl();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reqUriStr = req.getRequestURI();
		if(reqUriStr.endsWith("login")){
			doLogin(req,resp);
		}else if(reqUriStr.endsWith("list")){
			doList(req,resp);
			
		}else if(reqUriStr.endsWith("modify")){
			doModify(req,resp);
			
		}
	}
	
	//修改用户信息
	private void doModify(HttpServletRequest request, HttpServletResponse resp) throws IOException, ServletException {
		SmartUpload su =  getSmartUpload(request,resp);
		Request req = su.getRequest();//smartUpload的Request取参数
		
		//取上传文件数据
		File f = su.getFiles().getFile(0);
		if(!f.isMissing()){
			String path = new java.io.File(getServletContext().getRealPath("/")).getParent()+"\\upload26\\"+f.getFileName();
			System.out.println("上传文件的保存位置"+path);
			
			try {
				f.saveAs(path,SmartUpload.SAVE_PHYSICAL);
				f.saveAs("E:\\workspaces\\mybatis-example-usersystem\\src\\main\\webapp\\image\\"+f.getFileName(),SmartUpload.SAVE_PHYSICAL);
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		User user = getReqParam2Obj(req, User.class);
		user.setPicpath("/upload26/"+ f.getFileName());
		System.out.println("UserServlet.modify ==> user:"+user);		
		respOutStr(resp, userService.modifyUser(user)+"");
		
	}
	
	//登录处理
	private void doLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		User user = getReqParam2Obj(req, User.class);
		respOutStr(resp,userService.login(user)+"");
		
	}
	
	//列出用户信息
	private void doList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			String currPage = req.getParameter("page");
			String pageSize = req.getParameter("rows");
			
			PaginationBean<User> userBean = userService.listPartUsers(currPage,pageSize);
			respOutStr(resp,toJsonStr(userBean));
		}
}
