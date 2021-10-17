package com.learn.spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.spring.jpa.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
