package com.mxl.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mxl.entity.User;
import com.mxl.service.UserService;
import com.mxl.service.imp.UserServiceimp;

public class UserControll extends HttpServlet{

	private UserService userService = new UserServiceimp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
		System.out.println(">>>>>>>>>>>>>>>doGet()>>>>>>>>>>>>>>>>>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userName = req.getParameter("username");
		String pwd = req.getParameter("password");
		User user = new User();
		user.setUserName(userName);
		user.setPassword(pwd);
		System.out.println(">>>>>>>>>>>>>>>>>>doPost()>>>>>>>>>>>>>>>>>>>>>>");
		boolean b = userService.checkUser(user);
		System.out.println(">>>>>>>>>>>>>>userService.checkUser()>>>>>>>>>>>>>>>>>>>");
		if (b) {
			req.getSession().setAttribute("username", userName);
			req.getRequestDispatcher("welcome.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("error.jsp").forward(req, resp);
		}
	}
}
