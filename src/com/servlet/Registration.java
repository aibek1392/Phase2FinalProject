package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.model.User;
import com.util.HibernateUtil;

@WebServlet("/registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session sess=sf.openSession();
		
		PrintWriter out = response.getWriter();	
		response.setContentType("text/html");
		
		try {
			Transaction tx=sess.beginTransaction();
			User u=new User();	
			 boolean isAvailable[]= {true};
			List<User> ulist=sess.createQuery("from User").list();
			ulist.forEach(user->{
				if(user.getName().equalsIgnoreCase(name)) {
						isAvailable[0]=	false;
				}
			});
			System.out.println(u);
			if(isAvailable[0]) {
				u=new User(name,password);
				sess.save(u);
				tx.commit();
				request.getRequestDispatcher("registration.jsp").include(request, response);
				out.println("<h1 style='color:blue'>User is successfully registered<h1>");
				System.out.println("User added");
			}else {
				System.out.println("User already exist");
				request.getRequestDispatcher("registration.jsp").include(request, response);
				out.println("<h1 style=\"color:red\">Please choose another  username<h1>");

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