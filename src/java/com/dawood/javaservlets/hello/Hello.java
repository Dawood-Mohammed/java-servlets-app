/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawood.javaservlets.hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ooo
 */
@WebServlet(urlPatterns={"/hello","/home"})
public class Hello extends HttpServlet{
    
    public void doGet(HttpServletRequest req , HttpServletResponse res)throws ServletException , IOException{
        //step 1
        res.setContentType("text/html");
        //step 2
        PrintWriter out = res.getWriter();
        //step 3
        out.println("<h1>hello world</h1>");
        //step 4
        out.flush();
        
    }
    
}
