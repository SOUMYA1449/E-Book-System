package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.ConnectionDb;
import com.entity.User;

@WebServlet("/UserRegister")
public class UserSignup extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String Fullname = req.getParameter("fullname");
			String Email = req.getParameter("email");
			String Password = req.getParameter("password");
			
			User u = new User(Fullname,Email,Password);
			UserDao dao = new UserDao(ConnectionDb.getConnection());
			
		HttpSession session = req.getSession();
		
		boolean f = dao.register(u);
			
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
