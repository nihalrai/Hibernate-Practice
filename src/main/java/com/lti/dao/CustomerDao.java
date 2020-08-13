package com.lti.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Customer;

public class CustomerDao {

	public void add(Customer customer) {
		// step 1 create/obtain EntityManagerFactory object
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");

		// step 2 Create.Obtain EntityManger Object
		EntityManager em = emf.createEntityManager();

		// step 3 Start/participate in a transaction --DML operation should be atomic
		// (ACID properties)
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(customer); // persist method

		tx.commit();

		// should be in finally block
		em.close();
		emf.close();
	}

	public void update(Customer customer) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.merge(customer);

		tx.commit();

		em.close();
		emf.close();
	}

	public Customer fetch(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");

		EntityManager em = emf.createEntityManager();

		Customer cust = em.find(Customer.class, id);

		em.close();
		emf.close();

		return cust;
	}

	public List<Customer> fetchAll() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("select c from Customer c");
		List<Customer> customers = q.getResultList();

		em.close();
		emf.close();

		return customers;
	}

	//ex: fetch customers having gmail account
	public List<Customer> fetchByEmail(String domain){

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		EntityManager em = emf.createEntityManager();
		
		// :dm is used as placeholder
		Query q = em.createQuery("select c from Customer c where c.email like :dm");
		q.setParameter("dm", "%" + domain + "%");
		
		List<Customer> customers = q.getResultList();
		
		em.close();
		emf.close();

		return customers;
	}
}
