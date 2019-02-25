package com.lijw.controller;

import com.lijw.pojo.DBCPUtils;
import com.sun.org.apache.bcel.internal.generic.DCMPG;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        //resp.getWriter().write("first");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp);
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String userpass = req.getParameter("userpass");
        Connection conn = DBCPUtils.getConnection();
        String sql = "SELECT username,userpass FROM logins WHERE username = ? AND userpass = ?";
        Statement stmt = null;
        ResultSet result = null;
        try {
            stmt = conn.prepareStatement(sql);
            ((PreparedStatement) stmt).setString(1,username);
            ((PreparedStatement) stmt).setString(2,userpass);
            result = ((PreparedStatement) stmt).executeQuery();
            if(!result.next()){
                resp.setContentType("/firstWeb/servlet/Myservlet/login.jsp");
            }else{
                req.getRequestDispatcher("/").forward(req,resp);

                //resp.setHeader("refresh","3,URL=http://localhost:8080/firstWeb/servlet/Myservlet/login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBCPUtils.closedAll(conn,stmt,result);
        }
    }
}
