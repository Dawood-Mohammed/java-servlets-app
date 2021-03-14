/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawood.javaservlets.dao;

import com.dawood.javaservlets.entity.Student;
import java.util.List;

/**
 *
 * @author ooo
 */
public interface StudentDao {
    
    public List<Student> findAll();
    
    public Student findStudentById(Integer id);
    
    public void save(Student std);
    
    public void updateStudentById(Integer id, Student std);
    
    public void deleteStudentById(Integer id);
    
}
