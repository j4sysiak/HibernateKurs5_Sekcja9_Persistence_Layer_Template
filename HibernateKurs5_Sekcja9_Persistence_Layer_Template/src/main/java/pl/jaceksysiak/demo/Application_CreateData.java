package pl.jaceksysiak.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.jaceksysiak.demo.entity.Account;
import pl.jaceksysiak.demo.entity.AccountType;
import pl.jaceksysiak.demo.entity.Address;
import pl.jaceksysiak.demo.entity.Bank;
import pl.jaceksysiak.demo.entity.Credential;
import pl.jaceksysiak.demo.entity.Transaction;
import pl.jaceksysiak.demo.entity.User;

public class Application_CreateData {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(User.class)
								.addAnnotatedClass(Account.class)
								.addAnnotatedClass(AccountType.class)
								.addAnnotatedClass(Bank.class)
								.addAnnotatedClass(Address.class)
								.addAnnotatedClass(Credential.class)
								.addAnnotatedClass(Transaction.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			// start a transaction
			session.beginTransaction();
			
			//Creating the Object 
		
			//Saving the Object to DB	
				
			// commit transaction
			session.getTransaction().commit();

		}
		finally {
			
			// add clean up code
			session.close();			
			factory.close();
		}
	}

	}