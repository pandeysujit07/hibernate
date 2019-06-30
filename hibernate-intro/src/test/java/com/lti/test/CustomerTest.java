package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;

public class CustomerTest {

	@Test
	public void testAdd() {
		
		Customer c= new Customer();
		c.setName("pavan");
		c.setEmail("paajjk@gmail.com");
		c.setCity("mum");
		//c.setDateofBirth(dateOfBirth);   // try this on your own
		
		
		CustomerDao dao= new CustomerDao();
		dao.databaseIlAddSeiyavum(c);
		
	}
	
	@Test
	public void testFetch() {
		
		CustomerDao dao = new CustomerDao();
		Customer cust = dao.databaseIlVangudhal(23);
		
		
		System.out.println(cust.getName());
		System.out.println(cust.getEmail());
		System.out.println(cust.getDateOfBirth());
		System.out.println(cust.getCity());
	}
	
	
	
	@Test
	public void testUpdate() {
		
		CustomerDao dao = new CustomerDao();
		Customer cust = dao.databaseIlVangudhal(23);  // please check the id in the db
		
		
		cust.setCity("delhi");
		dao.databaseIlMempaduthu(cust);
	}


}



