package nl.novi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

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

}