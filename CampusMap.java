import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    /**
     * method to return the directory of buildings
     * @return directory of buildings (String)
     */
    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    /**
     * creates campus map
     */
    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Cafe("Compass Cafe", "7 Neilson Drive, Northampton, MA 01063", 40, 40, 40, 40));
        myMap.addBuilding(new Cafe("Campus Center Cafe", "100 Elm St, Northampton, MA 01063", 40, 40, 40, 40, 40));
        myMap.addBuilding(new Library ("Neilson Library", "7 Neilson Drive, Northampton, MA 01063", true));
        myMap.addBuilding(new House ("Wilson House", "1 Paradise Rd, Northampton, MA 01063", true, false));
        myMap.addBuilding(new House ("Haven House", "110 Elm St, Northampton, MA 01060",false, false));
        myMap.addBuilding(new Building("McConnell Hall", "2 Tyler Ct, Northampton, MA 01060", 4));
        myMap.addBuilding(new Building ("Burton Hall", "46 College Ln, Northampton, MA 01063", 4));
        myMap.addBuilding(new Library("Hillyer Art Library", "22 Elm St, Northampton, MA 01063", true));
        System.out.println(myMap);
    }
    
}
