/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawood.javaservlets.service;

import com.dawood.javaservlets.dao.StudentDao;
import com.dawood.javaservlets.entity.Student;

import java.util.List;

/**
 *
 * @author ooo
 */
public class StudentService {
    
    private StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    public Student findStudentById(Integer id) {
        return studentDao.findStudentById(id);
    }
    
    public void save(Student std){
        studentDao.save(std);
    }

    public void updateStudentById(Integer id, Student std) {
        studentDao.updateStudentById(id, std);
    }

    public void deleteStudentById(Integer id) {
        studentDao.deleteStudentById(id);
    }

    public StudentDao getStudentDaoImpl() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
}
