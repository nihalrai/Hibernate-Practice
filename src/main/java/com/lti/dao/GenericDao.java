package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GenericDao {
	public void add(Object obj) {
		// step 1 create/obtain EntityManagerFactory object
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory("hibernate-intro");

			em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();

			em.merge(obj); 

			tx.commit();
		} finally {

			em.close();
			emf.close();
		}
	}

	// public Object fetch(Class clazz, Object pk) {
	public <T> T fetch(Class<T> clazz, Object pk) {
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory("hibernate-intro");
			em = emf.createEntityManager();

			T t = em.find(clazz, pk);

			return t;
		} finally {
			em.close();
			emf.close();
		}
	}
}
