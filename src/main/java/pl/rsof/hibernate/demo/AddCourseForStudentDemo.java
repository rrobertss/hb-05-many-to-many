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
public class AddCourseForStudentDemo {

	
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
			int id = 2;
			Student student = session.get(Student.class, id);
			
			Course c1 = new Course("Spring framework guru");
			Course c2 = new Course("Spring for beginners");
			Course c3 = new Course("SOLID");
			
			c1.addStudent(student);
			c2.addStudent(student);
			c3.addStudent(student);
			
			session.save(c1);
			session.save(c2);
			session.save(c3);
			
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
