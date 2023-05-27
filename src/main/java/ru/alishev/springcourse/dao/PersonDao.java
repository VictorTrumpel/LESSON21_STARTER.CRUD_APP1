package ru.alishev.springcourse.dao;

import java.util.*;

import org.springframework.stereotype.Component;

import ru.alishev.springcourse.modles.Person;

@Component
public class PersonDao {
  private static int POPLE_COUNT = 0;
  private List<Person> people;

  {
    people = new ArrayList<>();

    people.add(new Person(++POPLE_COUNT, "Tom"));
    people.add(new Person(++POPLE_COUNT, "Djack"));
    people.add(new Person(++POPLE_COUNT, "Mike"));
    people.add(new Person(++POPLE_COUNT, "Bob"));
    people.add(new Person(++POPLE_COUNT, "Katy"));
  }

  public List<Person> index() {
    return people;
  }

  public Person show(int id) {
    return people
        .stream()
        .filter(person -> person.getId() == id)
        .findAny()
        .orElse(null);
  }

  public void save(Person person) {
    person.setId(++POPLE_COUNT);
    people.add(person);
  }

  public void update(int id, Person person) {
    Person personShouldUpdate = show(id);

    personShouldUpdate.setName(person.getName());
  }

  public void delete(int id) {
    people.removeIf(person -> person.getId() == id);
  }
}
