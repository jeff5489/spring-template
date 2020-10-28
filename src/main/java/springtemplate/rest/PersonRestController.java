package springtemplate.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springtemplate.entity.Person;
import springtemplate.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonRestController {

	// add code for the "/hello" endpoint
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}
	
	@GetMapping("/hello2")
	public String sayHello2() {
		return "Reached hello2!";
	}
	
	// autowire the CustomerService
	@Autowired
	private PersonService personService;
	
	// add mapping for GET /customers
	@CrossOrigin
	@GetMapping("/people")
	public List<Person> getPeople() {
		
		return personService.getPeople();
	}	
	
	// add mapping for GET /customers/{customerId}
	@GetMapping("/people/{personId}")
	public Person getCustomer(@PathVariable int personId) {
		
		Person person = personService.getPerson(personId);
		
		if (person == null) {
			throw new PersonNotFoundException("Customer id not found - " + personId);
		}
		
		return person;
	}
	
	// add mapping for POST /customers  - add new customer
	@PostMapping("/people")
	public Person addCustomer(@RequestBody Person person) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		person.setId(0);
		personService.savePerson(person);
		return person;
	}
	
	// add mapping for PUT /customers - update existing customer
	@PutMapping("/people")
	public Person updateCustomer(@RequestBody Person person) {
		
		personService.savePerson(person);
		
		return person;
	}
	
	// add mapping for DELETE /customers/{customerId} - delete customer
	@DeleteMapping("/people/{personId}")
	public String deleteCustomer(@PathVariable int personId) {
		
		Person tempPerson = personService.getPerson(personId);
		
		// throw exception if null
		if (tempPerson == null) {
			throw new PersonNotFoundException("Customer id not found - " + personId);
			
		}
				
		personService.deletePerson(personId);
		
		return "Deleted customer id - " + personId;
	}
		
}
