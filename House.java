/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building {

  private ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;

  public House() {
    System.out.println("You have built a house: 🏠");
  }

  public void moveIn(String name) {
    if (residents.contains(name)) {
      System.out.println("Person is already moved in.");
    } else {
      residents.add(name);
    }
  }

  public String moveOut(String name) { // return the name of the person who moved out
    if (residents.contains(name)) {
      residents.remove(name);
      return name;
    } else {
      System.out.println("Cannot move out.");
      return "N/A";
    }
  }
  
  public boolean isResident(String person) {
    if (residents.contains(person)) {
      return true;
    } else {
      return false;
    }
  }

   

  public static void main(String[] args) {
    new House();
  }

}