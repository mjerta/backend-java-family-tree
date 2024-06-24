package nl.novi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PersonTest {

  private Person person;
  private Person personWithMiddleName;

  @BeforeEach
  void setUp() {
    person = new Person("Maarten", "Postma", "male", 33);
    personWithMiddleName = new Person("John", "Middle", "Doe", "male", 33);
  }

  @Test
  void canGetFirstName() {
    // arrange
    var firstName = "Maarten";
    // act
    person.setName(firstName);
    personWithMiddleName.setName(firstName);
    // assert
    assertEquals(firstName, person.getName());
    assertEquals(firstName, personWithMiddleName.getName());
  }

  @Test
  void canGetMiddleName() {
    // arrange
    var middleName = "John";
    // act
    person.setMiddleName(middleName);
    var sut = person.getMiddleName();
    // assert
    assertEquals(middleName, sut);
  }

  @Test
  void canGetLastName() {
    // arrange
    var lastName = "John";
    // act
    person.setLastName(lastName);
    var sut = person.getLastName();
    // assert
    assertEquals(lastName, sut);
  }

  @Test
  void canGetSex() {
    // arrange
    var sex = "male";
    // act
    person.setSex("male");
    var sut = person.getSex();
    // assert
    assertEquals(sex, sut);
  }

  @Test
  void canGetAge() {
    // arrange
    var age = 33;
    // act
    person.setAge(age);
    var sut = person.getAge();
    // assert
    assertEquals(age, sut);
  }

  @Test
  void canGetMother() {
    // arrange
    var mother = new Person("Joke", "Nijhof", "female", 68);
    // act
    person.setMother(mother);
    var sut = person.getMother();
    // assert
    assertEquals(mother, sut);
  }

  @Test
  void canGetFarther() {
    // arrange
    var dad = new Person("Wolter", "Postma", "male", 68);
    // act
    person.setFather(dad);
    var sut = person.getFather();
    // assert
    assertEquals(dad, sut);
  }

  @Test
  void canGetSiblings() {
    // arrange
    var brotherOne = new Person("Maarten", "Postma", "male", 33);
    var brotherTwo = new Person("Johan", "Postma", "male", 36);
    List<Person> siblings = new ArrayList<>();
    siblings.add(brotherOne);
    siblings.add(brotherTwo);
    // act
    personWithMiddleName.setSiblings(siblings);
    var sut = personWithMiddleName.getSiblings();
    // assert
    assertEquals(siblings, sut);
  }

  @Test
  void canGetChildren() {
    // arrange
    var childOne = new Person("Tommy", "Emmanuel", "Postma", "male", 2);
    var childTwo = new Person("Arkiesha", "Zhoe", "Olos", "female", 7);
    List<Person> children = new ArrayList<>();
    children.add(childOne);
    children.add(childTwo);
    // act
    person.setChildren(children);
    var sut = person.getChildren();
    // assert
    assertEquals(children, sut);
  }

  @Test
  void canGetAllPets() {
    // arrange
    var germanShepard = new Pet("Rex", 6, "German Shepard");
    var samoyed = new Pet("Sammy", 4, "Samoyed");
    List<Pet> pets = new ArrayList<>();
    pets.add(germanShepard);
    pets.add(samoyed);
    // act
    person.setPets(pets);
    var sut = person.getPets();
    // assert
    assertEquals(pets, sut);
  }

  @Test
  void canAddParents() {
    //arrange
    var father = new Person("Wolter", "Postma", "male", 68);
    var mother = new Person("Joke", "Nijhof", "female", 68);
    // act
    person.addParents(father, mother);
    var sutMother = person.getMother();
    var sutFather = person.getFather();
    // assert
    assertEquals(mother, sutMother);
    assertEquals(father, sutFather);
  }

  @Test
  void canNotAddParentsBecauseOfWrondGender() {
    // arrange
    var father = new Person("Wolter", "Postma", "female", 68);
    var mother = new Person("Joke", "Nijhof", "male", 68);
    // act
    person.addParents(father, mother);
    var sutMother = person.getMother();
    var sutFather = person.getFather();
    // assert
    assertNotEquals(mother, sutMother);
    assertNotEquals(father, sutFather);
  }

  @Test
  void canAddChild() {
    // arrange
    var newBaby = new Person("Tamara", "Postma", "female", 0);
    // act
    person.addChild(newBaby);
    var sut = person.getChildren();
    // assert
    assertEquals(sut.size(), 1);
  }

}