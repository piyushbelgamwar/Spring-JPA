package com.learn.spring.jpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.spring.jpa.entity.Course;
import com.learn.spring.jpa.entity.CourseMaterial;
import com.learn.spring.jpa.repository.CourseMaterialRepository;

@SpringBootTest
public class CourseMaterialRepositoryTest {
	
	@Autowired
	private CourseMaterialRepository courseMaterialRepository;
	
	@Test
	public void SaveCourseMaterial() {
		
		Course course = 
				Course.builder()
					.title("DSA")
					.credit(6)
					.build();
		
		
		CourseMaterial courseMaterial = 
				CourseMaterial.builder()
				.url("www.google.com")
				.course(course)
				.build();
		
		courseMaterialRepository.save(courseMaterial);
	}

	@Test
	public void printAllCourseMaterials() {
		List<CourseMaterial> courseMaterials = 
				courseMaterialRepository.findAll();
		
		System.out.println("printAllCourseMaterials :"+courseMaterials);
	}
	
	
	
	
}
