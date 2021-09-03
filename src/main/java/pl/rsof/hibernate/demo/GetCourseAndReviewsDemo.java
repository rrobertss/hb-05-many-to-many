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
public class GetCourseAndReviewsDemo {

	
	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			int id = 10;
			Course c1 = session.get(Course.class, id);
			
			
			System.out.println("Course "+c1.getTitle());
			System.out.println("Reviews "+c1.getReviews());
			
			
			
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
