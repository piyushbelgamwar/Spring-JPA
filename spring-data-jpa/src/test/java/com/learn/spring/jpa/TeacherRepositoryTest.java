package com.learn.spring.jpa;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.spring.jpa.entity.Course;
import com.learn.spring.jpa.entity.Teacher;
import com.learn.spring.jpa.repository.TeacherRepository;

@SpringBootTest
public class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository teacherRepository;
	@Test
	public void saveTeacher() {
		List<Course> courses = new ArrayList<>();
 		Course courseDBA = 
				Course.builder()
				.title("DBA")
				.credit(5)
				.build();
 		courses.add(courseDBA);
		
 		Course courseREACT = 
				Course.builder()
				.title("REACT")
				.credit(7)
				.build();
 		courses.add(courseREACT);
 		
		Teacher teacher = 
				Teacher.builder()
				.firstName("Sunil")
				.lastName("ailani")
				//.courses(courses)
				.build();
		
		teacherRepository.save(teacher);
	}
	
}
