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

import pl.rsof.hibernate.demo.entity.Course;
import pl.rsof.hibernate.demo.entity.Instructor;
import pl.rsof.hibernate.demo.entity.InstructorDetail;

/**
 * <p></p><p>26 lip 2021</p>
 * @author RS
 *
 */
public class GetInstructorCoursesDemo {

	
	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int id = 1;
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, id);
			List<Course>courses = instructor.getCourses();
			
			System.out.println("Instructor "+instructor.getFirstName()+" "+instructor.getLastName());
			System.out.println("Courses "+courses);
			
			
			session.getTransaction().commit();
			
			System.out.println("Done, final!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
