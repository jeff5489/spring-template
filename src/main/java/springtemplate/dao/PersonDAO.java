package springtemplate.dao;

import java.util.List;

import springtemplate.entity.Person;

public interface PersonDAO {
	
	public List<Person> getPeople();

	public void savePerson(Person person);

	public Person getPerson(int theId);

	public void deletePerson(int theId);

}