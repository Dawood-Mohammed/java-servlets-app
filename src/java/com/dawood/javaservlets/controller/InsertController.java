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
@WebServlet(urlPatterns={"/insert"})
public class InsertController extends HttpServlet{
    
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
    
    public void doGet(HttpServletRequest req , HttpServletResponse res)throws ServletException , IOException{
        
    }
    
    @Override
    public void doPost(HttpServletRequest req , HttpServletResponse res)throws ServletException , IOException{
        Student std = new Student();
        std.setFirstName(req.getParameter("firstName"));
        std.setLastName(req.getParameter("lastName"));
        std.setAddress(req.getParameter("address"));
        studentService.save(std);
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<br><br><br>"
                + "<center><h1>Student with name "+std.getFirstName()+" "+std.getLastName()+" has been saved successfully!</h1><br>" +
                "<a href='/index.html' alt='manager'>go back to manager</a>" +
                "</center>");
        out.flush();
    }
    
    public void doDelete(HttpServletRequest req , HttpServletResponse res)throws ServletException , IOException{
        
    }
    
    public void doPut(HttpServletRequest req , HttpServletResponse res)throws ServletException , IOException{
        Student std = new Student();
        int id = Integer.parseInt(req.getParameter("id"));
        std.setId(id);
        std.setFirstName(req.getParameter("firstName"));
        std.setLastName(req.getParameter("lastName"));
        std.setAddress(req.getParameter("address"));
        studentService.updateStudentById(id , std);
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<br><br><br>"
                + "<center><h1>New Student with name "+std.getFirstName()+" "+std.getLastName()+" has been updated successfully!</h1></center>");
        out.flush();
    }
    
}
