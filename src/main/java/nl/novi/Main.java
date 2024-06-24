package nl.novi;

public class Main {
  public static void main(String[] args) {

    Person maarten = new Person("Maarten", "Postma", "male", 33);

    maarten.addChild(new Person("Tammy", "Postma", "female", 0));
    maarten.addChild(new Person("Hansje", "Postma", "male", 33));

    var test = maarten.getChildren();
    for (Person child : test) {
      System.out.println(child.getName());
    }
  }
}