package service;

import repository.PersonRepository;
import model.Person;

import java.util.List;

public class PersonService {

    private PersonRepository personRepository = new PersonRepository();

    public void createNewPerson(Person person){
        personRepository.createPerson(person);
    }

    public List<Person> getAllPersons() {
        return personRepository.getAllPersons();
    }

    public void deletePerson(Person person) {
        personRepository.deletePerson(person);
    }

    public void deletePersonById(String id) {
        deletePerson(personRepository.findById(id));
    }


}
