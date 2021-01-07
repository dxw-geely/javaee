package com.example.servlet;

import com.example.entiy.UserDo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/success")
public class SuccessServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDo user = (UserDo)req.getAttribute("user");

        if (user != null) {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("登陆成功！ 欢迎" + user.getUsername());
        }
    }
}
