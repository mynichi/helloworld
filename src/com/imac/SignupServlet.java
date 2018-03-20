package com.imac;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignupServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Client c = new Client();
		c.setUsername(request.getParameter("username"));
		c.setPassword(request.getParameter("password"));
		c.setGender(request.getParameter("gender"));
		c.setAge(request.getParameter("age"));
		c.setWechat(request.getParameter("wechat"));
		DB db = new DB();
		db.signup(c);

	}

}
