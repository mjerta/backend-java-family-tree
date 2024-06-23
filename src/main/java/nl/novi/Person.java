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

  public Person(String name, String sex, int age, String lastName) {
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

  public void addParents(Person person) {
    if(person.sex.equals("male")) {
      this.father = person;
    } else if (person.sex.equals("female")) {
      this.mother = person;
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
    for(Person child : children) {
      for(Person grandchild : child.getChildren()) {
        grandChildren.add(grandchild);
      }
    }
    return grandChildren;
  }

}
