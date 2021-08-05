package net.javaguides.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.javaguides.hibernate.model.Student;
import net.javaguides.hibernate.util.HibernateUtil;

public class StudentDaoImpl implements StudentDao {


	private static final Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);
	String vMethodName = "";

	@Override
	public void saveStudent(Student student) {
	
		vMethodName = "saveStudent";
		logger.info(vMethodName + " method starting ---------------------1");

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();
			logger.info(vMethodName + " | transaction begin   ---------------------2");

			// save student object
			session.save(student);
			logger.info(vMethodName + " | session saved   ---------------------3");

			// commit the transaction
			transaction.commit();
			
			logger.info(vMethodName + " | transaction commited   ---------------------4");

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			logger.warn(vMethodName + " | Something went wrong !   ----------------Catch");
		}

		logger.info(vMethodName + " method ending   ---------------------5");
	}

	@Override
	public void updateStudent(Student student) {

		vMethodName = "updateStudent";
		logger.info(vMethodName + " method start ---------------------1");
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();
			logger.info(vMethodName + " | transaction begin   ---------------------2");

			// update student object
			session.saveOrUpdate(student);
			logger.info(vMethodName + " | session savedOrUpdate completed   ---------------------3");

			// commit the transaction
			transaction.commit();
			logger.info(vMethodName + " | transaction commited   ---------------------4");

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			logger.warn(vMethodName + " | Something went wrong !   ----------------Catch");
		}
		logger.info(vMethodName + " method ending   ---------------------5");
	}

	@Override
	public Student getStudentById(long id) {
		
		vMethodName = "getStudentById";
		logger.info(vMethodName + " method starting ---------------------1");
		
		Transaction transaction = null;
		Student student = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();
			logger.info(vMethodName + " | transaction begin   ---------------------2");

			// get student object
//			student = session.get(Student.class, id);
			student = session.load(Student.class, id);
			logger.info(vMethodName + " | session load completed   ---------------------3");

			// commit the transaction
			transaction.commit();
			logger.info(vMethodName + " | transaction commited with autoId "+ id+ " ---------------------4");

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			logger.warn(vMethodName + " | Something went wrong !   ----------------Catch");
		}
		logger.info(vMethodName + " method ending   ---------------------5");
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		vMethodName = "getAllStudents";
		logger.info(vMethodName + " method starting ---------------------1");
		
		Transaction transaction = null;
		List<Student> students = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();
			logger.info(vMethodName + " | transaction begin   ---------------------2");

			// get students
			students = session.createQuery("from Student").list();
			logger.info(vMethodName + " | session createQuery completed   ---------------------3");

			// commit the transaction
			transaction.commit();
			logger.info(vMethodName + " | transaction commited   ---------------------4");

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			logger.warn(vMethodName + " | Something went wrong !   ----------------Catch");

		}
		logger.info(vMethodName + " method ending   ---------------------5");
		return students;
	}

	@Override
	public void deleteStudent(long id) {
		vMethodName = "deleteStudent";
		logger.info(vMethodName + " method starting ---------------------1");
		
		Transaction transaction = null;
		Student student = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction = session.beginTransaction();
			logger.info(vMethodName + " | transaction begin   ---------------------2");

			// get student object by id
			student = session.get(Student.class, id);
			// delete student object
			session.delete(student);
			logger.info(vMethodName + " | session delete completed   ---------------------3");

			// commit the transaction
			transaction.commit();
			logger.info(vMethodName + " | transaction commited   ---------------------4");

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			logger.warn(vMethodName + " | Something went wrong !   ----------------Catch");
		}
		logger.info(vMethodName + " method ending   ---------------------5");
	}

}
