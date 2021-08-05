package net.javaguides.hibernate.dao;

import java.util.List;
import net.javaguides.hibernate.model.Student;

public interface StudentDao {

	/**
	 * Operations
	 * save Student
	 * get All Students
	 * get Student By Id
	 * update Student
	 * delete Student
	*/

	void saveStudent(Student student);

	void updateStudent(Student student);

	Student getStudentById(long id);

	List<Student> getAllStudents();

	void deleteStudent(long id);

}