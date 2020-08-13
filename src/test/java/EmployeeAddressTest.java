import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.lti.dao.CustomerDao;
import com.lti.dao.EmployeeDao;
import com.lti.entity.Address;
import com.lti.entity.Customer;
import com.lti.entity.Employee;

public class EmployeeAddressTest {
	@Test
	public void addAnEmployee() {
		Employee emp = new Employee();

		emp.setName("Prashant Rai");
		emp.setDataOfJoining(LocalDate.of(2020, 5, 1));
		emp.setSalary(35000);

		EmployeeDao dao = new EmployeeDao();

		dao.add(emp);
	}

	@Test
	public void addAddressForAnExistingEmployee() {
		EmployeeDao dao = new EmployeeDao();
		Employee emp = dao.fetch(203);
		
		Address addr = new Address();
		addr.setCity("Mumbai");
		addr.setPincode(400001);
		addr.setLandMark("Navy Nagar");
		
		emp.setAddress(addr);
		dao.add(addr);
		dao.update(emp);
	}

	@Test
	public void addAnEmployeeAlongWithAddress() {
		Employee emp = new Employee();
		
		emp.setName("Nihal Bhardwaj");
		emp.setDataOfJoining(LocalDate.of(2020, 5, 1));
		emp.setSalary(35000);
		
		Address addr = new Address();
		addr.setCity("Mumbai");
		addr.setPincode(400001);
		addr.setLandMark("Navy Nagar");
		emp.setAddress(addr);
		
		EmployeeDao dao = new EmployeeDao();
		dao.add(emp);		
	}
	
	@Test
	public void fetchEmployeeByLocation() {
		EmployeeDao dao = new EmployeeDao();
		List<Employee> emps = dao.fetchEmployeeByLocation("Mumbai");
		
		System.out.println(emps.toString());
		
		//cust.getId();
		//cust.getName();
		//cust.getEmail();
	}
}
