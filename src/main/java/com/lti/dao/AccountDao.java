package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Transaction;

public class AccountDao extends GenericDao {
	public List<Transaction> fetchMiniStatement(int acno) {
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory("hibernate-intro");
			em = emf.createEntityManager();

			String jpql = "select tx from Transaction tx where tx.account.acno = :no order by tx.dataAndTime desc";
			Query q = em.createQuery(jpql);
			q.setParameter("no", acno);
			q.setMaxResults(5);
			List<Transaction> list = q.getResultList();
			return list;

		} finally {
			em.close();
			emf.close();
		}
	}
}
