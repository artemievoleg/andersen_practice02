import model.Person;
import service.PersonService;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        Person person = new Person("Jhon","Andersen");
        Person person2 = new Person("Jhon2","Andersen");
        PersonService personService = new PersonService();
        personService.createNewPerson(person);
        personService.createNewPerson(person2);
        List<Person> personList = personService.getAllPersons();
        for (Person p:personList) {
            System.out.println(p.getLastname());
        }
    }
}
