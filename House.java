/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building {

  private ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * constructor for house
   * @param name name of house
   * @param address street address of house
   * @param hasDiningRoom boolean indicating whether or not house has a dining room
   * @param hasElevator boolean indicating whether or not house has an elevator
   */
  public House(String name, String address, boolean hasDiningRoom, boolean hasElevator) {
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  /**
  * accessor for whether or not house has dining room
  * @return boolean hasDiningRooom
  */
  public boolean getHasDiningRoom() {
    return hasDiningRoom;
  }

  /**
  * accessor for whether or not house has an elevator
  * @return boolean hasElevator
  */
  public boolean getHasElevator() {
    return hasElevator;
  }

  /**
  * overloaded method to move in a person, as long as they don't already live in the house
  * @param name name of person trying to move in
  */
  public void moveIn(String name) {
    if (residents.contains(name)) {
      throw new RuntimeException("Cannot move in because already a resident");
    }
    residents.add(name);
  }

  /**
  * overloaded method to move in a person given their full name, as long as they don't already live in the house
  * @param firstname first name of person trying to move in
  * @param lastname last name of person trying to move in
  */
  public void moveIn(String firstname, String lastname) {
    String fullname = firstname + " " + lastname;
    if (residents.contains(fullname)) {
      throw new RuntimeException("Cannot move in because already a resident");
    }
    residents.add(fullname);
  }

  /**
  * overloaded method to move out a person, as long as they currently live in the house
  * @param name name of person trying to move out
  * @return name of person who sucessfully moved out
  */
  public String moveOut(String name) {
    if (!residents.contains(name)) {
      throw new RuntimeException("Cannot move out, as person is not moved in yet.");
    }
    residents.remove(name);
    return name;
  }
  
  /**
  * method to move out a person, as long as they currently live in the house
  * @param firstname first name of person trying to move out
  * @param lastname last name of person trying to move out
  * @return full name of person who sucessfully moved out
  */
  public String moveOut(String firstname, String lastname) {
    String fullname = firstname + " " + lastname;
    if (!residents.contains(fullname)) {
      throw new RuntimeException("Cannot move out, as person is not moved in yet.");
    }
    residents.remove(fullname);
    return fullname;
  }

  /**
  * method to check if a person is a resident
  * @param person name of person we are checking about
  * @return boolean indicating if they live in the house
  */
  public boolean isResident(String person) {
    return residents.contains(person);
  }

  /**
   * method to print options in the house
   */
  @Override
  public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + moveIn()\n + moveOut()\n + isResident()");
  } 
  
  /**
   * method that allows user to travel between floors
   */
  @Override
  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    if (!hasElevator && ((this.activeFloor - floorNum) < -1 || (this.activeFloor - floorNum) > 1)) {
      throw new RuntimeException("This building does not have an elevator. Your must travel one floor at a time.");
    }
    this.activeFloor = floorNum;
  }

  public static void main(String[] args) {
  }

}