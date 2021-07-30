/*
 *  Company: RS
 *  Project: hibernate-tutorial
 *  Created: 26 lip 2021  12:10:24
 *  Author:  RS 		
 */
package pl.rsof.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.rsof.hibernate.demo.entity.Student;

/**
 * <p></p><p>26 lip 2021</p>
 * @author RS
 *
 */
public class QueryStudentDemo {

	
	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
		
			session.beginTransaction();
			
			// query
			List<Student>listStudents = session.createQuery("from Student").getResultList();
			
			// display
			for (Student s : listStudents) {
				System.out.println(s);
//				System.out.println(s.getFirstName()+" "+s.getLastName() );
			}
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			
		}
		finally {
			factory.close();
		}
	}

}
