package com.charu.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.charu.sms.entity.Teacher;
import com.charu.sms.service.TeacherService;

@Controller
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	
	@GetMapping("/teachers")
	public String getAllTeachers(Model model) {
		model.addAttribute("teachers", teacherService.getAllTeachers());
		return "teachers";
	}
	
	@GetMapping("/teachers/form")
	public String createTeacherForm(Model model) {
		Teacher teacher = new Teacher();
		model.addAttribute("teacher", teacher);
		return "create_teacher_form";
	}
	
	@PostMapping("/teachers/add")
	public String addTeacher(@ModelAttribute("teacher") Teacher teacher) {
		teacherService.saveTeacher(teacher);
		return "redirect:/teachers";
	}
	
	@GetMapping("/teachers/edit/{id}")
	public String updateTeacherForm(@PathVariable Long id,Model model) {
		model.addAttribute("teacher", teacherService.geTeacherById(id));
		return "update_teacher";
	}
	
	@PostMapping("/teachers/{id}")
	public String updateTeacher(@PathVariable long id,@ModelAttribute("teacher") Teacher teacher,Model model) {
		Teacher newTeacher = teacherService.geTeacherById(id);
		newTeacher.setId(teacher.getId());
		newTeacher.setName(teacher.getName());
		newTeacher.setEmail(teacher.getEmail());
		newTeacher.setSubject(teacher.getSubject());
		model.addAttribute("teacher", teacherService.saveTeacher(newTeacher));
		return "redirect:/teachers";
	}
	
	@GetMapping("/teachers/{id}")
	public String deleteTeacher(@PathVariable long id,Model model) {
		teacherService.deleteTeacherById(id);
		return "redirect:/teachers";
	}
	

}
