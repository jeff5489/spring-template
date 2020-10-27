package springtemplate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springtemplate.entity.Person;

@Repository
public class PersonDAOImpl implements PersonDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Person> getPeople() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Person> theQuery = 
				currentSession.createQuery("from Person"
//						+ " order by last_name"
						,
						Person.class);
		
		// execute query and get result list
		List<Person> people = theQuery.getResultList();
				
		// return the results		
		return people;
	}

	@Override
	public void savePerson(Person person) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the person ... finally LOL
		currentSession.saveOrUpdate(person);
		
	}

	@Override
	public Person getPerson(int id) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Person person = currentSession.get(Person.class, id);
		
		return person;
	}

	@Override
	public void deletePerson(int id) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Person where id=:personId");
		theQuery.setParameter("personId", id);
		
		theQuery.executeUpdate();
	}

}
