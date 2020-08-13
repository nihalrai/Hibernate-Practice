package com.lti.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Address;
import com.lti.entity.Employee;

public class EmployeeDao {

	public void add(Employee employee) {
		// step 1 create/obtain EntityManagerFactory object
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");

		// step 2 Create.Obtain EntityManger Object
		EntityManager em = emf.createEntityManager();

		// step 3 Start/participate in a transaction --DML operation should be atomic
		// (ACID properties)
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(employee); // persist method

		tx.commit();

		// should be in finally block
		em.close();
		emf.close();
	}

	public void add(Address addr) {
		// step 1 create/obtain EntityManagerFactory object
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");

		// step 2 Create.Obtain EntityManger Object
		EntityManager em = emf.createEntityManager();

		// step 3 Start/participate in a transaction --DML operation should be atomic
		// (ACID properties)
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(addr); // persist method

		tx.commit();

		// should be in finally block
		em.close();
		emf.close();
	}

	public void update(Employee employee) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.merge(employee);

		tx.commit();

		em.close();
		emf.close();
	}

	public Employee fetch(int psNo) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");

		EntityManager em = emf.createEntityManager();

		Employee emp = em.find(Employee.class, psNo);

		em.close();
		emf.close();

		return emp;
	}

	public List<Employee> fetchAll() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("select e from Employee e");
		List<Employee> employees = q.getResultList();

		em.close();
		emf.close();

		return employees;
	}

	public List<Employee> fetchByDate(int month, int year) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		EntityManager em = emf.createEntityManager();
		List<Employee> employees = new ArrayList<Employee>();

		if (year == 0) {
			Query q = em.createQuery("select e from Employee e where MONTH(e.DOJ) = :mon");
			q.setParameter("mon", month);
			employees = q.getResultList();
		} else if (month == 0) {
			Query q = em.createQuery("select e from Employee e where YEAR(e.DOJ) = :year");
			q.setParameter("year", year);
			employees = q.getResultList();
		}

		em.close();
		emf.close();

		return employees;
	}

	// ex: fetch Employees having salary=x
	public List<Employee> fetchBySalary(double salary) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		EntityManager em = emf.createEntityManager();

		// :dm is used as placeholder
		Query q = em.createQuery("select e from Employee e where e.salary = :sal");
		q.setParameter("sal", salary);

		List<Employee> employees = q.getResultList();

		em.close();
		emf.close();

		return employees;
	}

	// ex: fetch Employees having salary=x
	public List<Employee> fetchEmployeeByLocation(String city) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-intro");
		EntityManager em = emf.createEntityManager();
		
		/*Query q = em.createQuery("select a.id from Address a where a.city = :city");
		q.setParameter("city", city);
		List<Integer> ids = q.getResultList();
		*/
		
		Query q = em.createQuery("select e from Employee e where e.address.id  IN (select a.id from e.address a where a.city = :city)");
		//q = em.createQuery("select e from Employee e where e.address.id  IN :ids");
		q.setParameter("city", city);
		//q.setParameter("ids", ids);
		
		List<Employee> employees = q.getResultList();

		em.close();
		emf.close();

		return employees;
	}
}
