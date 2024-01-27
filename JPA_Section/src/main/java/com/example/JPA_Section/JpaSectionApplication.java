package com.example.JPA_Section;

import com.example.JPA_Section.dao.StudentDAO;
import com.example.JPA_Section.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaSectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaSectionApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner-> {
//			System.out.println("Hello World");
			//Student to_be_updated = studentDAO.findById(1);
//			to_be_updated.setFirstName("Kareem");
//			to_be_updated.setLastName("Afifi");
//			studentDAO.update(to_be_updated);
			studentDAO.delete(3);


		};

	}

	private void createStudent(StudentDAO studentDAO) {
		Student s = new Student("Name" , "antrhing", "anything@gmail.com");
		studentDAO.save(s);

	}

}
