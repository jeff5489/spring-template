package springtemplate.service;

import java.util.List;

import springtemplate.entity.Person;

public interface PersonService {
	
	public List<Person> getPeople();

	public void savePerson(Person thePerson);

	public Person getPerson(int id);

	public void deletePerson(int id);

}
