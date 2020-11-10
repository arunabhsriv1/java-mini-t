package com.cybage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.dao.ManagerDaoI;
import com.cybage.pojos.Batch;
import com.cybage.pojos.Plans;
import com.cybage.services.ManagerServiceI;
import com.cybage.services.ManagerServiceImpl;


public class ManagerServlet extends HttpServlet {
	
	ManagerServiceI manager=new ManagerServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
			
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String action=req.getServletPath();
		
		switch (action) {
		case "/newplan":
			showNewPlanForm(req, res);
			break;
		case "/insertplan":
			insertPlan(req, res);
			break;

		case "/deleteplan":
			break;

		case "/editplan":
			break;

		case "/updateplan":
			break;
			
		default:
			break;
		}
		
		
		
	}
	
		
	private void showNewPlanForm(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		RequestDispatcher dispatcher=req.getRequestDispatcher("plan-form.jsp");
		dispatcher.forward(req, res);
	}
		
	private void insertPlan(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException, Exception {
		int sportId=Integer.parseInt(req.getParameter("sportId"));
		String planName=req.getParameter("planName");
		double fees=Double.parseDouble(req.getParameter("fees"));
		int duration=Integer.parseInt(req.getParameter("duration"));
		Plans newPlan= new Plans(sportId, planName, fees, duration);
	
		manager.addPlan(newPlan);
		res.sendRedirect("list-plan");
	}
		
}
	

	

