package com.charu.sms.service;

import java.util.List;

import com.charu.sms.entity.Teacher;

public interface TeacherService {
	
	List<Teacher> getAllTeachers();
	Teacher saveTeacher(Teacher teacher);
	Teacher geTeacherById(Long id);
	Teacher updaTeacher(Teacher teacher);
	void deleteTeacherById(Long id);

}
