import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;

public class CustomerTest {

	@Test
	public void addCustomer() {
		Customer cust = new Customer();
		cust.setName("Nihal Rai");
		cust.setEmail("nihal@lti");
		
		CustomerDao dao = new CustomerDao();
		
		dao.add(cust);
	}

	@Test
	public void fetchCustomer() {
		CustomerDao dao = new CustomerDao();
		Customer cust = dao.fetch(1);
		
		System.out.println(cust.toString());
		
		//cust.getId();
		//cust.getName();
		//cust.getEmail();
	}
	
	@Test
	public void updateCustomer() {
		CustomerDao dao = new CustomerDao();
		
		Customer cust = dao.fetch(1);
		cust.setName("Prashant");
		
		dao.update(cust);
	}
	
	@Test
	public void fetchAllCustomer() {
		CustomerDao dao = new CustomerDao();
		
		List<Customer> custs = dao.fetchAll();
		
		System.out.println(custs.toString());	
		
	}
	
	//email part
	@Test
	public void fetchByEmail() {
		CustomerDao dao = new CustomerDao();
		
		List<Customer> custs = dao.fetchByEmail("lti");
		
		assertNotNull(custs);
		assertEquals(1, custs.size());
		
		System.out.println(custs.toString());	
		
	}

}
