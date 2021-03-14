/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawood.javaservlets.controller;

import com.dawood.javaservlets.dao.StudentDao;
import com.dawood.javaservlets.dao.StudentDaoImpl;
import com.dawood.javaservlets.entity.Student;
import com.dawood.javaservlets.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ooo
 */
@WebServlet(urlPatterns={"/deletestudent"})
public class DeleteHandler extends HttpServlet{
    
    private StudentService studentService;
    private StudentDao studentDao;
    private Connection conn;
    
    @Override
    public void init(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/students","root","");
        }catch(SQLException se){
            se.printStackTrace();
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
        studentDao = new StudentDaoImpl(conn);
        studentService = new StudentService(studentDao);
    }
    
    public void doPost(HttpServletRequest req , HttpServletResponse res)throws ServletException , IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        int stdId = Integer.parseInt(req.getParameter("id"));
        Student std = studentService.findStudentById(stdId);
        out.println("<html>"
                + "<head><title>student app</title></head>"
                + "<body>"
                + "<center>"
                + "<br><br><br>"
                + "<h1> Students Manager (process deletion)</h1>"
                + "<form action=\"delete\" method=\"post\">"
                + "<table>"
                +"<tr>"
                + "<td>Student ID</td>"
                + "<td><input type=\"text\" value="+std.getId()+" name=\"id\" /></td>"
                + "</tr>"
                + "<tr>"
                + "<td>First Name</td>"
                + "<td><input type=\"text\" value="+std.getFirstName()+" name=\"firstName\" /></td>"
                + "</tr>"
                + "<tr>"
                + "<td>Last Name</td>"
                + "<td><input type=\"text\" value="+std.getLastName()+" name=\"lastName\" /></td>"
                + "</tr>"
                + "<tr>"
                + "<td>Address</td>"
                + "<td><input type=\"text\" value="+std.getAddress()+" name=\"address\" /></td>"
                + "</tr>"
                + "</table>"
                + "<br>"
                + "<input type='submit' value='Delete'/>"
                + "</form>"
                + "</center>"
                + "</body>"
                + "</html>");
        out.flush();
    }
    
}
