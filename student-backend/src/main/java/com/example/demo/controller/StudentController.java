package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class StudentController {
	@Autowired
	private StudentRepo studentrepo;
	@GetMapping("/stud")
	public String getstr(){
		return "hello";
	}
//	get all student
	
	@GetMapping("/student")
	public List<Student> getAllStudent(){
		return studentrepo.findAll();
	}
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id){
		Student student= studentrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(student);
		
	}
	@PostMapping("/student")
	public Student createStudent(@RequestBody  Student student) {
		System.out.print(student);
		return studentrepo.save(student);
	}
	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudentById(@PathVariable Long id,@RequestBody Student studentD){
		Student student= studentrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		student.setFirstname(studentD.getFirstname());
		student.setLastname(studentD.getLastname());
		student.setEmailId(studentD.getEmailId());
		student.setSalaryPackage(studentD.getSalaryPackage());
		Student updatedStudent=studentrepo.save(student);
		return ResponseEntity.ok(updatedStudent);	
	}
//	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Map<String,Boolean>>  deleteEmployee(@PathVariable Long id){
		Student student= studentrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		studentrepo.delete(student);
		Map<String,Boolean> res=new HashMap<>();
		res.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(res);
	}
	
}
