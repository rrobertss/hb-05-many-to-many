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

import pl.rsof.hibernate.demo.entity.Course;
import pl.rsof.hibernate.demo.entity.Instructor;
import pl.rsof.hibernate.demo.entity.InstructorDetail;
import pl.rsof.hibernate.demo.entity.Review;
import pl.rsof.hibernate.demo.entity.Student;

/**
 * <p></p><p>26 lip 2021</p>
 * @author RS
 *
 */
public class CreateCourseAndStudentsDemo {

	
	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Course c1 = new Course("Programming JAVA");
		
			session.save(c1);
		
			
			Student s1 = new Student("Adam", "Nowak", "adam2243@gmail.com");
			Student s2 = new Student("Anna", "Cap", "anacap@gmail.com");
			
			c1.addStudent(s1);
			c1.addStudent(s2);
			
			session.save(s1);
			session.save(s2);
			
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
