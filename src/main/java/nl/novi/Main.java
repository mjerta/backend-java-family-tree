package nl.novi;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    Person maarten = new Person("Maarten", "Postma", "male", 67);
    Person partner = new Person("Krizia", "Lyn", "Garcia", "female", 32);
    Person childOne = new Person("Tommy", "Postma", "male", 33);
    Person grandChild = new Person("Maarten jr.", "Postma", "male", 0);
    Person grandChildTwo = new Person("Zhoe jr", "Postma", "female", 33);
    Person brother = new Person("Johan", "Postma", "male", 36);
    Person niece = new Person("Fenna", "Postma", "female", 7);
    Person nephew = new Person("Locas", "Postma", "male", 11);
    Person mother = new Person("Joke", "Nijhof", "female", 68);
    Person father = new Person("Wolter", "Postma", "male", 68);
    maarten.setPartner(partner);
    maarten.addSibbling(brother);
    brother.addChild(niece);
    brother.addChild(nephew);

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

    System.out.println("Testing list of children");
    var test = maarten.getChildren();
    for (Person child : test) {
      System.out.println(child.getName());
    }

    // Testing the getAllAnimalsFromGranChildren method
    System.out.println("\nTesting list of animals of grandchildren");
    var grandChildren = maarten.getGrandChildren();
    var allAnimalsFromGrandChildren = maarten.getAllAnimalsFromGrandChildren(grandChildren);
    for (var animal : allAnimalsFromGrandChildren) {
      System.out.println(animal.getName());
    }

    // Testing the getAllNieces method
    System.out.println("\nTesting list of nieces");
    var allNieces = maarten.getAllNieces();
    for (Person lookedUpNiece : allNieces) {
      System.out.println(lookedUpNiece.getName());
    }

    //Testing if i can see my partner
    System.out.println("\nTesting to get if I can add a partner");
    System.out.println(maarten.getPartner().getName());

    //Testing what will happen with the father and if he have children or not
    System.out.println("\nTesting if the father is being set by addparents also will have a child that set the parent");
    maarten.addParents(father, mother);
    var nameOfFather = maarten.getFather().getName();
    System.out.println(nameOfFather);
    var childrenOfFather = maarten.getFather().getChildren();
    for (Person child : childrenOfFather) {
      System.out.println(child.getName());
    }
  }
}