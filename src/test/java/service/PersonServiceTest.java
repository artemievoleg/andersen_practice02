package service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import model.Person;
import repository.PersonRepository;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

        @Mock
        private PersonRepository repository;

        @InjectMocks
        private PersonService userService;

        @Before
        public void setUp() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        public void testGetAllPersons_ReturnPersons() {
            List<Person> list = TestData.getPersonList();
            when(repository.getAllPersons()).thenReturn(list);

            assertEquals(userService.getAllPersons(), list);
        }

        @Test
        public void testDeleteById_ValidId_VerifyInvocationsNumber() {
            Person person = TestData.getPerson();
            String id = person.getId();
            userService.deletePersonById(id);
            verify(repository, times(1)).findById(id);
        }

        @Test
        public void testAdd_ValidPerson_VerifyInvocationsNumber() {
            Person person = TestData.getPerson();
            userService.createNewPerson(person);

            verify(repository, times(1)).createPerson(person);
        }

        @Test
        public void testDelete_ValidPerson_VerifyInvocationsNumber() {
            Person person = TestData.getPerson();
            userService.deletePerson(person);
            verify(repository, times(1)).deletePerson(person);
        }

}



