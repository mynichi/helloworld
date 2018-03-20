package com.imac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Double price = Double.parseDouble(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		System.out.println(id+"\t"+price+"\t"+quantity);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String[] hobbies = request.getParameterValues("hobbies");
		System.out.println(username + "\t" + password + "\t" + hobbies);
		for (String s : hobbies)
			System.out.println(s);

		PrintWriter out = response.getWriter();

		if (username.equals("lyj") && password.equals("12345")) {
			System.out.println("ok");
			out.println("<html><body><h1>OK</h1></body></html>");

		} else {
			System.out.println("not ok");
			out.println("<html><body><h1>NO OK</h1></body></html>");
		}

	}

}
