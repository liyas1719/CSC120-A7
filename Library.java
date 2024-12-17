/* This is a stub for the Library class */
import java.util.Hashtable;

import java.util.ArrayList; // import the ArrayList class

public class Library extends Building {
  private Hashtable<String, Boolean> collection;
  private ArrayList<Integer> cardholders; // makes a list of passengers
  private boolean hasElevator;

   
  public Library(String name, String address, boolean hasElevator) {
      this.cardholders = new ArrayList<>();
      this.hasElevator = hasElevator;
      System.out.println("You have built a library: 📖");
      //Hashtable<String, boolean> collection = new Hashtable<>();rs
    }

    public boolean getHasElevator() {
      return hasElevator;
    }

    /**
     * method to add a book to the library if library doesn't already have it
     * @param title title of the book to be added
     */
    public void addTitle(String title) {
      if (collection.containsKey(title)) {
        throw new RuntimeException("We already have this title.");
      } 
      collection.put(title, true);
    } 

    /**
     * method to remove a book from the library if library has it
     * @param title title of the book to be removed
     * @return title of book removed
     */
    public String removeTitle(String title) {
      if (!collection.containsKey(title)) {
        throw new RuntimeException("We do not have this title, so it cannot be removed.");
      }
      collection.remove(title);
      return title;
    }

    /**
     * method to check out a book from the library, as long as library has it and it hasn't already been checked out
     * @param title title of the book to be checked out
     */
    public void checkOut(String title) {
      if (!collection.containsKey(title)) {
        throw new RuntimeException("Book not in library.");
      }
      if (collection.get(title).equals(false)) {
        throw new RuntimeException("Book is not available.");
      }
      collection.remove(title);
      collection.put(title, false);
    }

    public void checkOut(String title, Integer CardNumber) {
      if (this.cardholders.contains(CardNumber)) {
        System.out.println("Welcome back");
      } else {
        cardholders.add(CardNumber);
        System.out.println("New user created");
      }
      if (!collection.containsKey(title)) {
        throw new RuntimeException("Book not in library.");
      }
      if (collection.get(title).equals(false)) {
        throw new RuntimeException("Book is not available.");
      }
      collection.remove(title);
      collection.put(title, false);
    }

    public void returnBook(String title) {
      if (collection.containsKey(title)) {
        if (collection.get(title).equals(false)) {
          collection.remove(title);
          collection.put(title, true);
        } else {
          System.out.println("book already returned");
        } 
      } else {
        System.out.println("book not in library");
      }
    }

    public void returnBook(String title, Integer CardNumber) {
      if (this.cardholders.contains(CardNumber)) {
        System.out.println("Welcome back");
      } else {
        System.out.println("Please enter valid Library Card Number");
      }
      if (collection.containsKey(title)) {
        if (collection.get(title).equals(false)) {
          collection.remove(title);
          collection.put(title, true);
        } else {
          System.out.println("book already returned");
        } 
      } else {
        System.out.println("book not in library");
      }
    }
    
    public boolean containsTitle(String title) { // returns true if the title appears as a key in the Libary's collection, false otherwise 
      if (collection.containsKey(title)) {
        return true;
      } else {
        return false;
      }
  }
    
    public boolean isAvailable(String title) { // returns true if the title is currently available, false otherwise
      if (collection.get(title).equals(true)) {
          return true;
        } else {
          return false;
        }
      }

    public void printCollection() { // prints out the entire collection in an easy-to-read way (including checkout status)
      for (String key : collection.keySet()) {
        System.out.println("Key: " + key + ", Value: " + collection.get(key));
    }
    }
    
    public void printCollection(boolean Availability) {
      for (String key : collection.keySet()) {
        if (collection.get(key) == Availability) {
          System.out.println("Key: " + key + ", Value: " + collection.get(key));
        }
      }
    }

    @Override
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + addTitle()\n + removeTitle()\n + checkOut()\n + returnBook()\n + containsTitle()\n + isAvailable()\n + printCollection()");
    }

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