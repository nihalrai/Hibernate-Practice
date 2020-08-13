import java.time.LocalDate;

import org.junit.Assert.*;
import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Passport;
import com.lti.entity.Person;

public class GenericDaoTest {

	@Test
	public void addPerson() {
		Person person = new Person();
		person.setName("Nihal Rai");
		person.setDateOfBirth(LocalDate.of(1998, 11, 9));

		Passport passport = new Passport();
		passport.setCity("Mumbai");
		passport.setExpiry_date(LocalDate.now());
		passport.setIssue_date(LocalDate.now());
		passport.setPassportNo("NihalRai1");
		passport.setPerson(person);

		person.setPassport(passport);

		GenericDao dao = new GenericDao();
		dao.add(person);
	}

	@Test
	public void addPassportToPerson() {
		GenericDao dao = new GenericDao();

		Person person = (Person) dao.fetch(Person.class, 316);

		Passport passport = new Passport();
		passport.setCity("Delhi");
		passport.setExpiry_date(LocalDate.now());
		passport.setIssue_date(LocalDate.now());
		passport.setPassportNo("NihalRai1");
		passport.setPerson(person);

		person.setPassport(passport);

		dao.add(person);
	}

	@Test
	public void fetchPerson() {
		GenericDao dao = new GenericDao();
		Person person = (Person) dao.fetch(Person.class, 316);

		System.out.print(person.getId() + " " + person.getName() + " " + person.getDateOfBirth());
		Passport passport = person.getPassport();
		System.out.println(" " + passport.getPassportNo() + " " + passport.getCity() + " " + passport.getExpiry_date()
				+ passport.getIssue_date());
	}

	@Test
	public void fetchPassport() {
		GenericDao dao = new GenericDao();
		Passport passport = (Passport) dao.fetch(Passport.class, "NihalRai1");

		System.out.println(passport.getPassportNo() + " " + passport.getCity() + " " + passport.getExpiry_date()
				+ passport.getIssue_date());

		Person person = passport.getPerson();

		System.out.print(" " + person.getId() + " " + person.getName() + " " + person.getDateOfBirth());

	}
}
