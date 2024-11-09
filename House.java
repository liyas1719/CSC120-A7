/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building {

  private ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;

  public House(String name, String address) {
    System.out.println("You have built a house: 🏠");
  }

  public void moveIn(String name) {
    if (residents.contains(name)) {
      System.out.println("Person is already moved in.");
    } else {
      residents.add(name);
    }
  }

  public void moveIn(String firstname, String lastname) {
    String fullname = firstname + " " + lastname;
    if (residents.contains(fullname)) {
      System.out.println("Person is already moved in.");
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
  
  public String moveOut(String firstname, String lastname) { // return the name of the person who moved out
    String fullname = firstname + " " + lastname;
    if (residents.contains(fullname)) {
      residents.remove(fullname);
      return fullname;
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

  @Override
  public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + moveIn()\n + moveOut()\n + isResident()");
  } 
  
  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
  }

  public static void main(String[] args) {
  }

}