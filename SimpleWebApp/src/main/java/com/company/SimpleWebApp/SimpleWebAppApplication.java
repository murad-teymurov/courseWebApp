package com.company.SimpleWebApp;

import com.company.SimpleWebApp.model.Student;
import com.company.SimpleWebApp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

//import static jdk.internal.org.jline.reader.impl.LineReaderImpl.CompletionType.List;

@SpringBootApplication
public class SimpleWebAppApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SimpleWebAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Student student = new Student(1,"Murad","teymurov");
//		Student student2 = new Student(2,"test","testov");
//
//		ArrayList<Student> list = new ArrayList<>();
//
//		list.add(student);
//		list.add(student2);
//
//		for(int i =0; i<list.size();i++){
//			studentRepository.save(list.get(i));
//		}

	}
}
