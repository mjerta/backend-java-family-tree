package nl.novi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PetTest {
  private Pet pet;

  @BeforeEach
  void setUp() {
    pet = new Pet("Sammy", 2, "Samoyed");
  }

  @Test
  void canGetName() {
    // arrange
    var name = "Vlekkie";
    // act
    pet.setName(name);
    var sut = pet.getName();
    // assert
    assertEquals(name, sut);
  }

  @Test
  void canGetAge() {
    // arrange
    var age = 4;
    // act
    pet.setAge(age);
    var sut = pet.getAge();
    // assert
    assertEquals(age, sut);
  }

  @Test
  void canGetSpecies() {
    // arrange
    var jackRussle = "jack russle";
    // act
    pet.setSpecies(jackRussle);
    var sut = pet.getSpecies();
    // assert
    assertEquals(jackRussle, sut);
  }

  @Test
  void canGetOwner() {
    // arrange
    var person = new Person("Maarten", "Postma", "male", 33);
    // act
    pet.setOwner(person);
    var sut = pet.getOwner();
    // assert
    assertEquals(person, sut);
  }

}
