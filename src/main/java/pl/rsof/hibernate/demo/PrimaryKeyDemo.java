/*
 *  Company: RS
 *  Project: hibernate-tutorial
 *  Created: 26 lip 2021  11:37:37
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
public class PrimaryKeyDemo {

	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			Student student1 = new Student("Anna", "Kowalska", "akowalska99@gmail.com");
			Student student2 = new Student("Karol", "Sikorski", "carro555@op.pl");
			Student student3 = new Student("Dorota", "Liszka", "dorota.liszka@wp.pl");

			session.beginTransaction();

			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			session.getTransaction().commit();

		}catch(Exception e) {

		}
		finally {
			factory.close();
		}
	}

}
