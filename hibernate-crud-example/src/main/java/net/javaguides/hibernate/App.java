package net.javaguides.hibernate;


import java.util.List;

import net.javaguides.hibernate.dao.StudentDao;
import net.javaguides.hibernate.dao.StudentDaoImpl;
import net.javaguides.hibernate.model.Student;

public class App {
	
	public static void main(String args[])
	{
		StudentDao studentDao = new StudentDaoImpl();
		
		//test saveStudent
		
		Student student = new Student("Kishan" , "Singh11" , "ks@gmail.com");
		studentDao.saveStudent(student);
		
		
		//test updateStudent
		student.setFirstName("Mohan");
		studentDao.updateStudent(student);
		
		//test getStudentById
		Student student2 = studentDao.getStudentById(student.getId());
		
		
		
		//test getAllStudents
		List<Student> students = studentDao.getAllStudents();
		students.forEach(student1 -> System.out.println(student1));
//		
		
		
		//test delete
		studentDao.deleteStudent(student.getId());
	}

}
