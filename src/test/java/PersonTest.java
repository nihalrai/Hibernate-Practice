import org.junit.Assert.*;

import com.lti.dao.GenericDao;
import com.lti.dao.PersonDao;
import com.lti.entity.Passport;
import com.lti.entity.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PersonTest {

	@Test
	public void fetchPassportByExpiryDate() {
		PersonDao dao = new PersonDao();
		List<Person> list = dao.fetchByPassportExpiryDate(LocalDate.of(2020, 12, 12));
		for (Person person : list) {
			System.out.print(" " + person.getId() + " " + person.getName() + " " + person.getDateOfBirth());
		}
	}

	@Test
	public void fetchPassport() {
		PersonDao dao = new PersonDao();
		Passport passport = dao.fetchPassport("Nihal Rai");
		System.out.println(passport.getPassportNo() + " " + passport.getCity() + " " + passport.getExpiry_date()
				+ passport.getIssue_date());
	}

	@Test
	public void fetchNameAndPassportNo() {
		PersonDao dao = new PersonDao();
		List<Object[]> list = dao.fetchNameAndPassportNo();
		for (Object[] i : list) {
			System.out.println((String) i[0] + " " + (String) i[1]);
		}
	}

}
