package nl.novi;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    Person maarten = new Person("Maarten", "Postma", "male", 67);
    Person childOne = new Person("Tommy", "Postma", "male", 33);
    Person grandChild = new Person("Maarten jr.", "Postma", "male", 0);
    Person grandChildTwo = new Person("Zhoe jr", "Postma", "female", 33);

    Pet dogOne = new Pet("Sammy", 3, "samoyed");
    Pet dogTwo = new Pet("Jack", 6, "jack-russle");
    List<Pet> pets = new ArrayList<Pet>();
    pets.add(dogOne);
    pets.add(dogTwo);
    Pet dogThree = new Pet("Boo", 3, "Booka");
    Pet dogFour = new Pet("La", 6, "Lala");
    List<Pet> petsTwo = new ArrayList<Pet>();
    petsTwo.add(dogThree);
    petsTwo.add(dogFour);

    maarten.addChild(new Person("Tammy", "Postma", "female", 0));
    maarten.addChild(new Person("Hansje", "Postma", "male", 33));
    maarten.addChild(childOne);
    childOne.addChild(grandChild);
    childOne.addChild(grandChildTwo);
    grandChild.setPets(pets);
    grandChildTwo.setPets(petsTwo);

//    var test = maarten.getChildren();
//    for (Person child : test) {
//      System.out.println(child.getName());
//    }

    // Testing the getAllAnimalsFromGranChildren function
    var grandChildren = maarten.getGrandChildren();
    var allAnimalsFromGrandChildren = maarten.getAllAnimalsFromGrandChildren(grandChildren);
    for (var animal : allAnimalsFromGrandChildren) {
      System.out.println(animal.getName());
    }

  }
}