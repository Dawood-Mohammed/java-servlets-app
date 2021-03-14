/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawood.javaservlets.dao;

import com.dawood.javaservlets.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ooo
 */
public class StudentDaoImpl implements StudentDao{

    private Connection conn;
    
    public StudentDaoImpl(Connection conn){
        this.conn = conn;
    }
    
    @Override
    public List<Student> findAll() {
        List students = new ArrayList();
        Student std;
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM STUDENT");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                std = new Student(rs.getInt("id") , rs.getString("first_name") , rs.getString("last_name") , rs.getString("address"));
                students.add(std);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public Student findStudentById(Integer id) {
        Student std;
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM STUDENT WHERE ID=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                std = new Student(rs.getInt("id") , rs.getString("first_name") , rs.getString("last_name") , rs.getString("address"));
                return std;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateStudentById(Integer id, Student std) {
        try{
            PreparedStatement ps = conn.prepareStatement("UPDATE STUDENT SET FIRST_NAME=? , LAST_NAME=? , ADDRESS=? WHERE ID=?");
            ps.setString(1,std.getFirstName());
            ps.setString(2,std.getLastName());
            ps.setString(3,std.getAddress());
            ps.setInt(4,id);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void save(Student std){
        try{
            PreparedStatement ps = conn.prepareStatement("INSERT INTO STUDENT(FIRST_NAME,LAST_NAME,ADDRESS) VALUES(?,?,?)");
            ps.setString(1,std.getFirstName());
            ps.setString(2,std.getLastName());
            ps.setString(3,std.getAddress());
            ps.executeUpdate();
            System.out.println("\n\n\n\t\tINSERTED \n\n\n");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudentById(Integer id) {
        try{
            PreparedStatement ps = conn.prepareStatement("DELETE FROM `student` WHERE ID=?");
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    
    
}
