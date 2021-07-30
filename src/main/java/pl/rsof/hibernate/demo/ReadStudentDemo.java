/*
 *  Company: RS
 *  Project: hibernate-tutorial
 *  Created: 26 lip 2021  12:10:24
 *  Author:  RS 		
 */
package pl.rsof.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.rsof.hibernate.demo.entity.Student;

/**
 * <p></p><p>26 lip 2021</p>
 * @author RS
 *
 */
public class ReadStudentDemo {

	
	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// save
			Student student = new Student("Witold", "Daszka", "wdaszka88@gmail.pl");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			System.out.println("Student saved: "+ student.getFirstName() + " " + student.getLastName());
			
			// retrieve
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, student.getId());
			if (myStudent != null) {
				System.out.println("Retrieve student: "+myStudent.getId()+" "+myStudent.getEmail());
			}
			else {
				System.err.println("Student not found "+student.getId());
			}
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			
		}
		finally {
			factory.close();
		}
	}

}
