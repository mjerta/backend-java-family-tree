package nl.novi;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class Person {

  private String name;
  private String middleName;
  private String lastName;
  private String sex;
  private int age;
  private Person mother;
  private Person father;
  private List<Person> siblings;
  private List<Person> children;
  private List<Pet> pets;

  public Person(String name, String lastName, String sex, int age) {
    this.name = name;
    this.sex = sex;
    this.age = age;
    this.lastName = lastName;
  }

  public Person(String name, String middleName, String lastName, String sex, int age) {
    this.name = name;
    this.middleName = middleName;
    this.lastName = lastName;
    this.sex = sex;
    this.age = age;
  }

  public void addParents(Person farther, Person mother) {
    if (farther.sex.equals("male") && mother.sex.equals("female")) {
      this.father = farther;
      this.mother = mother;
    }
    else {
      System.out.println("One of the parent has the wrong gender filled in.");
    }
  }

  public void addChild(Person child) {
    children.add(child);
  }

  public void addSibbling(Person sibbling) {
    siblings.add(sibbling);
  }

  public List<Person> getGrandChildren(Person person) {
    List<Person> grandChildren = new ArrayList<>();
    for (Person child : children) {
      grandChildren.addAll(child.getChildren());
    }
    return grandChildren;
  }
}
