/* This is a stub for the Library class */
import java.util.Hashtable;
import java.util.ArrayList; // import the ArrayList class

public class Library extends Building {
  private Hashtable<String, Boolean> collection;
  private ArrayList<Integer> cardholders; // makes a list of passenge
   
  public Library(String name, String address) {
      this.cardholders = new ArrayList<>();
      System.out.println("You have built a library: 📖");
      //Hashtable<String, boolean> collection = new Hashtable<>();rs
    }
    public void addTitle(String title) {
      collection.put(title, true);
    }

    public String removeTitle(String title) {
      if (collection.containsKey(title)) {
        collection.remove(title);
        return title;
      } else {
        return "none";
      }
    }

    public void checkOut(String title) {
      if (collection.containsKey(title)) {
        if (collection.get(title).equals(true)) {
          collection.remove(title);
          collection.put(title, false);
        } else {
          System.out.println("book not available");
        } 
      } else {
        System.out.println("book not in library");
      }
    }

    public void checkOut(String title, Integer CardNumber) {
      if (this.cardholders.contains(CardNumber)) {
        System.out.println("Welcome back");
      } else {
        cardholders.add(CardNumber);
        System.out.println("New user created");
      }
      if (collection.containsKey(title)) {
        if (collection.get(title).equals(true)) {
          collection.remove(title);
          collection.put(title, false);
        } else {
          System.out.println("book not available");
        } 
      } else {
        System.out.println("book not in library");
      }
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

    public static void main(String[] args) {
    }
  
  }