package com.example.servlet;

import com.example.entiy.UserDo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/failed")
public class FailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setContentType("text/html;charset=utf-8");
        resp.setContentType("application/json;charset=UTF-8");
        String json = "{\"message\": \"登陆失败，用户名或密码错误\"," +
                "\"code\": 0}";
        resp.getWriter().write(json);
    }
}
