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

import pl.rsof.hibernate.demo.entity.Instructor;
import pl.rsof.hibernate.demo.entity.InstructorDetail;
import pl.rsof.hibernate.demo.entity.Student;

/**
 * <p></p><p>26 lip 2021</p>
 * @author RS
 *
 */
public class CreateDemo {

	
	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Instructor instructor = new Instructor("Anna", "Pisaniak", "pisaniak1977@wp.pl");
			InstructorDetail instructorDetail = new InstructorDetail("", "flowers");
			instructor.setInstructorDetail(instructorDetail);
			
			session.beginTransaction();
			
			// CascadeType.ALL
			session.save(instructor);
			
			session.getTransaction().commit();
			
			System.out.println("Done, final!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
	}

}
