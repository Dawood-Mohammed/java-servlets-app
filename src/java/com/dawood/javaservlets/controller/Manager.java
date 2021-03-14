/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawood.javaservlets.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author ooo
 */
@WebServlet(urlPatterns={"/manager"})
public class Manager extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest req , HttpServletResponse res)throws ServletException , IOException{
        res.sendRedirect("manageStudent.html");
    }
    
}
