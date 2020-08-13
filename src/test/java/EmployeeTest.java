import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.lti.dao.EmployeeDao;
import com.lti.entity.Employee;

public class EmployeeTest {

	@Test
	public void addEmployee() {
		Employee emp = new Employee();

		emp.setName("Nihal Rai");
		emp.setDataOfJoining(LocalDate.of(2020, 5, 1));
		emp.setSalary(35000);
		
		EmployeeDao dao = new EmployeeDao();

		dao.add(emp);

		emp = new Employee();
		emp.setName("Abhishek Kumar");
		emp.setDataOfJoining(LocalDate.of(2019, 5, 1));
		emp.setSalary(35000);
		
		dao.add(emp);

	}

	@Test
	public void fetchByPsNo() {
		EmployeeDao dao = new EmployeeDao();
		Employee emp = dao.fetch(203);

		System.out.println(emp.toString());

		// cust.getId();
		// cust.getName();
		// cust.getEmail();
	}

	@Test
	public void updateEmployee() {
		EmployeeDao dao = new EmployeeDao();

		Employee emp = dao.fetch(202);
		emp.setName("Prashant");

		dao.update(emp);
	}

	@Test
	public void fetchAllEmployee() {
		EmployeeDao dao = new EmployeeDao();

		List<Employee> emps = dao.fetchAll();

		System.out.println(emps.toString());

	}

	// date part
	@Test
	public void fetchByMonthYear() {
		EmployeeDao dao = new EmployeeDao();

		List<Employee> emps = dao.fetchByDate(5, 0);

		System.out.println(emps.toString());
		
		dao = new EmployeeDao();
		emps = dao.fetchByDate(0, 2019);
		System.out.println(emps.toString());
	}

	@Test
	public void fetchBySalary() {
		EmployeeDao dao = new EmployeeDao();

		List<Employee> emps = dao.fetchBySalary((double)35000);
		
		System.out.println(emps.toString());
	}

}
