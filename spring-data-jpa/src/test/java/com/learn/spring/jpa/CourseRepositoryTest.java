package com.learn.spring.jpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.learn.spring.jpa.entity.Course;
import com.learn.spring.jpa.entity.Student;
import com.learn.spring.jpa.entity.Teacher;
import com.learn.spring.jpa.repository.CourseRepository;

@SpringBootTest
public class CourseRepositoryTest {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	public void printCourse() {
		List<Course> courses = 
				courseRepository.findAll();
		
		System.out.println("Course  :"+courses);
	}
	
	 @Test
	    public void saveCourseWithTeacher() {
	        Teacher teacher = Teacher.builder()
	                .firstName("Priyanka")
	                .lastName("Singh")
	                .build();

	        Course course = Course
	                .builder()
	                .title("Python")
	                .credit(6)
	                .teacher(teacher)
	                .build();

	        courseRepository.save(course);
	    }
	@Test
	 public void findAllPagination() {
		 Pageable firstPageWithThreeRecords = 
				 PageRequest.of(0, 3);
		 
		 Pageable secondPageWithTwoRecords = 
				 PageRequest.of(0, 2);
		 
		 List<Course> courses = 
				 courseRepository.findAll(firstPageWithThreeRecords)
				 					.getContent();
		 
		 long totalElements =
	                courseRepository.findAll(secondPageWithTwoRecords)
	                .getTotalElements();

	        long totalPages =
	                courseRepository.findAll(secondPageWithTwoRecords)
	                .getTotalPages();

	        System.out.println("totalPages = " + totalPages);
	        
	        System.out.println("totalElements = " + totalElements);
		 
		 System.out.println("courses :"+courses);
		 
				 
		 
	 }
	
		@Test
		public void findAllSorting() {

			Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));

			Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());

			Pageable sortByTtileAndCreditDesc = PageRequest.of(0, 2,
					Sort.by("title").descending().and(Sort.by("credit")));

		List<Course> courses =
				courseRepository.findAll(sortByTitle).getContent();
		
		System.out.println("courses :"+courses);
		
		}
	
	@Test
	 public void printFindByTitleContaing() {
		 Pageable firstPageTenRecords =
				 		PageRequest.of(0, 10);
		 List<Course> courses =
				 courseRepository.findByTitleContaining("DSA", firstPageTenRecords).getContent();
		 
		 System.out.println("course "+ courses);
	 
	 }
	
	
    @Test
    public void saveCourseWithStudentAndTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Lizze")
                .lastName("Morgan")
                .build();

        Student student = Student.builder()
                .firstName("Abhishek")
                .lastName("Singh")
                .emailId("abhishek@gmail.com")
                .build();

        Course course = Course
                .builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}
		
	 
		

