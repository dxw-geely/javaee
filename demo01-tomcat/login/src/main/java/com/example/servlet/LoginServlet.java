package com.example.servlet;

import com.example.dao.UserDao;
import com.example.entiy.UserDo;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //req.setCharacterEncoding("utf-8");
//        Enumeration<String> headerNames = req.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String s = headerNames.nextElement();
//            String header = req.getHeader(s);
//            System.out.println(s + "+++++" + header);
//        }

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDo loginUser = new UserDo();
        loginUser.setUsername(username);
        loginUser.setPassword(password);



//        Map<String, String[]> map = req.getParameterMap();
//        Set<String> strings = map.keySet();
//        for (String name : strings) {
//            String[] value = map.get(name);
//            System.out.println(name + "----" + value[0]);
//        }

        UserDo user = new UserDao().login(loginUser);

        if (user == null) {
            req.getRequestDispatcher("/failed").forward(req, resp);
        } else {
            req.setAttribute("user", user);
            req.getRequestDispatcher("/success").forward(req, resp);
        }

    }
}
