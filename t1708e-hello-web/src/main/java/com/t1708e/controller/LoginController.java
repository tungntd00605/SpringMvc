package com.t1708e.controller;

import com.t1708e.entity.User;
import com.t1708e.model.UserModel;
import com.t1708e.util.PasswordUltility;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginController extends HttpServlet {
    private UserModel userModel = new UserModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userModel.findUserByUsernameAndStatus(username, User.Status.ACTIVE);

        if(user == null){
            req.setAttribute("reason", "NO USER");
            req.getRequestDispatcher("/login-failed.jsp").forward(req, resp);
        }

        String hashedPassword = PasswordUltility.hashPassword(password, user.getSalt());
        System.out.println("HASHED PASS==========: " + hashedPassword);
        System.out.println("DATABASE PASS ==========:" + user.getPassword());
        if(!hashedPassword.equals(user.getPassword()) ){
            req.setAttribute("reason", "WRONG PASSWORD");
            req.getRequestDispatcher("/login-failed.jsp").forward(req, resp);
        }

        req.setAttribute("user", user);
        req.getRequestDispatcher("/login-success.jsp").forward(req, resp);
    }
}
