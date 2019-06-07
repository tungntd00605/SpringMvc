package com.t1708e.controller;

import com.sun.jndi.toolkit.url.Uri;
import com.t1708e.entity.User;
import com.t1708e.model.UserModel;
import com.t1708e.util.PasswordUltility;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

public class RegisterController extends HttpServlet {
    private UserModel userModel = new UserModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String salt = "";
        try {
            salt = PasswordUltility.getSalt();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        String hashedPassword = PasswordUltility.hashPassword(password, salt);

        User user = new User(username, hashedPassword, salt, fullName, email, phone, User.Status.ACTIVE.getValue());
        userModel.save(user);

        req.setAttribute("user", user);
        req.getRequestDispatcher("/register-success.jsp").forward(req, resp);
    }
}
