import java.util.List;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Dept;
import com.lti.entity.Emp;

public class EmpDeptTest {
	@Test
	public void addDept() {
		Dept d = new Dept();
		d.setDeptno(1);
		d.setName("IT");
		d.setLocation("Mahape");
		
		new GenericDao().add(d);
	}
	
	@Test
	public void addEmps() {
		GenericDao dao = new GenericDao();
		Dept d = dao.fetch(Dept.class, 1);
		
		Emp e1 = new Emp();
		e1.setEmpno(1);
		e1.setName("Nihal Rai");
		e1.setSalary(350000);
		e1.setDept(d);
		dao.add(e1);
		
		Emp e2 = new Emp();
		e2.setEmpno(2);
		e2.setName("Prashant Rai");
		e2.setSalary(350000);
		e2.setDept(d);
		
		dao.add(e2);
	}
	
	@Test
	public void fetchDept() {
		GenericDao dao = new GenericDao();
		Dept d = dao.fetch(Dept.class, 1);
		
		System.out.println(d.getName() + " " + d.getLocation());
		
		List<Emp> emps = d.getEmployees();
		for(Emp emp: emps) {
			System.out.println(emp.getEmpno() + ", " + emp.getName() + ", " + emp.getSalary());
		}
	}
	
	@Test
	public void fetchEmp() {
		GenericDao dao = new GenericDao();
		Emp e = dao.fetch(Emp.class, 1);
		
		System.out.println(e.getName() + " " + e.getSalary());
		
		Dept d = e.getDept();
		System.out.println(d.getName() + " " + d.getLocation());
	}
}
