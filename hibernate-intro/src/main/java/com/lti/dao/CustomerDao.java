package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.entity.Customer;

public class CustomerDao {

	public void databaseIlAddSeiyavum(Customer customer) {          //this method is used to add values
		
		//Steps 1. Load/Create EntityManagerFActory object
		//During this step, META-INF/ persistence.xml is read
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("oracle-pu");
		
		
		//Step 2. Load/create EntityManager object		
		EntityManager em=emf.createEntityManager();
		
		
		//step 3. Start/Participate in a transaction
		EntityTransaction tx=em.getTransaction();
		tx.begin();
	
		
		//Now we can insert/update,delete,select whatever we want
		em.persist(customer);// persist method generates insert query
		
		tx.commit();
		
		//below code should be in finally block
		em.close();
		emf.close();	
	}
	public Customer databaseIlVangudhal(int custId) {         //this method is used to fetch the values
		
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("oracle-pu");
		
		EntityManager em=emf.createEntityManager();
		//find method generates select query
		Customer c= em.find(Customer.class, custId);
		
		em.close();
		emf.close();
		
		return c;
	}
	public void databaseIlMempaduthu(Customer customer) {          //this method is used to update  values
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("oracle-pu");
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		
		 em.merge(customer);
		tx.commit();
		em.close();
		emf.close();
		
	
		
		
	}
}
