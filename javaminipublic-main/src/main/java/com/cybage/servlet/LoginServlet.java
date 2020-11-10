package com.cybage.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.dao.UsersDaoImpl;
import com.cybage.pojos.Users;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDaoImpl dao;

	public void init() throws ServletException {
		// dao inst
		try {
			dao = new UsersDaoImpl();
		} catch (Exception e) {
			// centralized err handling in servlets
			throw new ServletException("err in init", e);
		}
	}

	
	public void destroy() {
		try {
			dao.cleanUp();
		} catch (Exception e) {
			throw new RuntimeException("err in destroy", e);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set cont type
		response.setContentType("text/html");
		// PW --for sending response to clnt
		try (PrintWriter pw = response.getWriter()) {
			// read req params
			String email = request.getParameter("email");
			String pwd = request.getParameter("password");
			// invoke DAO's method for validation
			Users u = dao.authenticateUser(email, pwd);
			if (u == null) {
				pw.print("<h4>Invalid Login, Pls <a href=login.html>Retry</a></h4>");
			} else {
				pw.print("from 1st page...<br>");
				pw.flush();
				//save user details under request scope
				request.setAttribute("details", u);
				//replace clnt pull by server pull
				RequestDispatcher rd=request.getRequestDispatcher("manager");
				if(rd != null)
					rd.include(request, response);
				pw.print("after including the contents");
			}
		} catch (Exception e) {
			throw new ServletException("err in do-get", e);
		}
	}

}
