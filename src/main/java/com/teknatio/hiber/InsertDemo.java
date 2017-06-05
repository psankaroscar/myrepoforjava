package com.teknatio.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertDemo {

	public static void main(String[] args) {

		Users user1 = new Users();
		user1.setId((short) 6);
		user1.setFirstName("Gowthami");
		user1.setLastName("G");
		user1.setUserName("gowthami");
		user1.setEmail("g123@g.com");

		// 1. load configuration
		Configuration cfg = new Configuration();
		cfg.configure();

		// 2. build Session Factory
		SessionFactory sf = cfg.buildSessionFactory();//meta data related to ORM is the internal state

		// 3(a). create session
		Session session = sf.openSession();

		// 3(b)
		Transaction tx = session.beginTransaction();

		// 4. do operations
		session.save(user1);

		// 3(c)
		tx.commit();

		// 5.close the session
		session.close();
		System.out.println("Done!");

	}
}
