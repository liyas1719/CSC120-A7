/* This is a stub for the Library class */
import java.util.Hashtable;

public class Library extends Building {
  private Hashtable<String, Boolean> collection;

    public Library() {
      System.out.println("You have built a library: 📖");
      //Hashtable<String, boolean> collection = new Hashtable<>();
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
    
    public static void main(String[] args) {
      new Library();
    }
  
  }