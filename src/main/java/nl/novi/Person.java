package nl.novi;

import com.sun.source.tree.ReturnTree;
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
  private Person partner;
  private List<Person> siblings = new ArrayList<>();
  private List<Person> children = new ArrayList<>();
  private List<Pet> pets = new ArrayList<>();

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
      this.father.addChild(this);
      this.mother = mother;
      this.mother.addChild(this);
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

  public List<Person> getGrandChildren() {
    List<Person> grandChildren = new ArrayList<>();

    for (Person child : children) {
      grandChildren.addAll(child.getChildren());
    }
    return grandChildren;
  }

  public List<Pet> getAllAnimalsFromGrandChildren(List<Person> grandChildren) {
    List<Pet> allAnimalsFromGrandChild = new ArrayList<>();
    for (Person child : grandChildren) {
      allAnimalsFromGrandChild.addAll(child.getPets());
    }
    return allAnimalsFromGrandChild;
  }

  public List<Person> getAllNieces() {
    List<Person> allNieces = new ArrayList<>();
    if (siblings != null) {
      for (Person sibling : siblings) {
        if (sibling.getChildren() != null) {
          boolean nieceFound = false;
          for (Person child : sibling.getChildren()) {
            if (child.sex.equals("female")) {
              nieceFound = true;
              allNieces.add(child);
            }
            if (!nieceFound) {
              System.out.println("No niece was for " + sibling.getName());
            }
          }
        }
        else {
          System.out.println("This sibling has no children");
        }
      }
    }
    else System.out.println("You have no siblings");
    return allNieces;
  }
}
