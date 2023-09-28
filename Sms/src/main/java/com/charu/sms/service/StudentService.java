package com.charu.sms.service;

import java.util.List;

import com.charu.sms.entity.Student;

//import antlr.collections.List;

public interface StudentService {
	
	List <Student> getAllStudents();
	Student saveStudent(Student student);
	Student getStudentById(Long id);
	Student updateStudent(Student student);
	void deleteStudentById(Long id);

}
