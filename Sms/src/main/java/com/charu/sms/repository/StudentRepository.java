package com.charu.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.charu.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
