package springtemplate.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springtemplate.dao.PersonDAO;
import springtemplate.entity.Person;

@Service
public class PersonServiceImpl implements PersonService {

	// need to inject person dao
	@Autowired
	private PersonDAO personDAO;
		
	@Override
	@Transactional
	public List<Person> getPeople() {
		return personDAO.getPeople();
	}

	@Override
	@Transactional
	public void savePerson(Person person) {
		personDAO.savePerson(person);
	}

	@Override
	@Transactional
	public Person getPerson(int id) {
		return personDAO.getPerson(id);
	}

	@Override
	@Transactional
	public void deletePerson(int id) {
		personDAO.deletePerson(id);
		
	}

}
