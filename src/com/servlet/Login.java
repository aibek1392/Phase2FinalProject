package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.User;
import com.util.HibernateUtil;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session sess=sf.openSession();
		PrintWriter out = response.getWriter();			
		try {
			Transaction tx = sess.beginTransaction();
			 boolean isCorrect[]= {false};
			List<User> ulist=sess.createQuery("from User ").list();
			ulist.forEach(user->{
				if(user.getName().equalsIgnoreCase(name) && user.getPassword().equals(password)) {
					isCorrect[0]=	true;
					
				}
			});
			if(isCorrect[0]) {
				session.setAttribute("name", name);
				
				response.sendRedirect("dashboard.jsp");
				out.println("<h1 style='color:blue'>User is successfully registered<h1>");
				System.out.println("User added");
			}else {
				session.invalidate();
				request.getRequestDispatcher("registration.jsp").include(request, response);
				out.println("<h1 style=\"color:red\">Invalid username or password<h1>");

			}
		}
		catch(Exception e){
			e.printStackTrace();
		}finally {
			sess.close();
		}
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
