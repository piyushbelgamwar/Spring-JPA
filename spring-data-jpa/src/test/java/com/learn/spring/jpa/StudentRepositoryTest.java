package com.learn.spring.jpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.spring.jpa.entity.Guardian;
import com.learn.spring.jpa.entity.Student;
import com.learn.spring.jpa.repository.StudentRepository;

@SpringBootTest
//@DataJpaTest
public class StudentRepositoryTest {
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void saveStudent() {
		
		Student student =  Student.builder()
				.emailId("piyush@gmail.com")
				.firstName("piyush")
				.lastName("Belgamwar")
//				.guardianName("Ram")
//				.guardianEmail("ram@gmail.com")
//				.guardianMobile("9878788756")
				.build();
		
		studentRepository.save(student);
		
	}
	@Test
	public void printAllStudent() {
		List<Student> studentList = studentRepository.findAll();
		
		System.out.println("studentList :"+studentList);
		
	}
	@Test
	public void saveStudentWithGuardian() {
		Guardian guardian = Guardian.builder()
				.name("tejas")
				.email("tejas@gmail.com")
				.mobile("1234554321")
				.build();
		
		
		Student student = Student.builder()
				.firstName("shivam")
				.emailId("shivam@gmail.com")
				.lastName("kumar")
				.guardian(guardian)
				.build();
		
		studentRepository.save(student);
	}
	@Test
	public void printStudentByFirstName() {
		List<Student> students =
				studentRepository.findByFirstName("shivam");
		System.out.println("studentByFirstName "+students);
	}
	
	@Test
	public void printStudentByFirstNameContaining(){
		
		List<Student> students =
				studentRepository.findByFirstNameContaining("pi");
		System.out.println("studentByFirstNameContaining" + students);
	}
	

	 
    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students =
                studentRepository.findByGuardianName("tejas");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByEmailAddress() {
    	Student student = studentRepository.getStudentbyEmailAddress("shivam@gmail.com");
    	System.out.println("printStudentByEmailAddress "+student);
    }
    
    @Test
    public void printStudenFirstnametByEmailAddress() {
    	String firstName = studentRepository.getStudentFirstNameByEmailAddress("shivam@gmail.com");
    	System.out.println("firstName :"+firstName);
    }
    
    @Test
    public void printgetStudentByEmailAddressNative() {
    	
    	Student student =
    			studentRepository.getStudentByEmailAddressNative("shivam@gmail.com");
    	System.out.println("printgetStudentByEmailAddressNative "+student);
    }
	
    @Test
    public void printgetStudentByEmailAddressNativeParam() {
    	
    	Student student =
    			studentRepository.getStudentByEmailAddressNativeParam("shivam@gmail.com");
    	System.out.println("getStudentByEmailAddressNativeParam "+student);
    }
    @Test
    public void printupdateStudentNameByEmailIdTest() {
	
    studentRepository.updateStudentNameByEmailId("shivam 21", "shivam@gmail.com");
    
    }
}