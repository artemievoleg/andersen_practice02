package service;


import model.Person;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public static Person getPerson() {
        Person person = new Person("Вася","Петров");
        return person;
    }

    public static List<Person> getPersonList() {
        Person firstPerson = new Person("Коля","Иванов");
        Person secondPerson = new Person("Петя","Рабинович");
        Person thirdPerson = new Person("Маша","Сидорова");

        List<Person> list = new ArrayList<>();
        list.add(firstPerson);
        list.add(secondPerson);
        list.add(thirdPerson);

        return list;
    }
}
