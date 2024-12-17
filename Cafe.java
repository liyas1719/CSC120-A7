/* This is a stub for the Cafe class */
public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory 
    private int nMugs; // number of "for here" mugs
    
    /**
     * overloaded constructor for cafe (does not have mugs for in-cafe drinking)
     * @param name name of cafe
     * @param address street address of cafe
     * @param nCoffeeOunces number of ounces of coffee cafe contains
     * @param nSugarPackets number of sugar packets cafe contains
     * @param nCreams number of creams cafe contains
     * @param nCups number of cups cafe contains
     */
    public Cafe(String name, String address, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * overloaded constructor for cafe (has mugs for in-cafe drinking)
     * @param name name of cafe
     * @param address street address of cafe
     * @param nCoffeeOunces number of ounces of coffee cafe contains
     * @param nSugarPackets number of sugar packets cafe contains
     * @param nCreams number of creams cafe contains
     * @param nCups number of cups cafe contains
     * @param nMugs number of mugs cafe contains
     */
    public Cafe(String name, String address, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, int nMugs) {
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        this.nMugs = nMugs;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * overloaded method to sell coffee which decreases inventory (cups, ounces of coffee, sugar, creams) as used
     * @param size size of coffee being sold in ounces
     * @param nSugarPackets number of sugar packets needed
     * @param nCreams number of creams needed
     * @param nCups number of cups needed
     * @param toGo boolean that indicates if coffee order is to go or dine-in
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams, int nCups, boolean toGo) {
        if (this.nCoffeeOunces < size) {
            restock(100, 100, 100, 100, 100);
        } else if (this.nSugarPackets < nSugarPackets) {
            restock(100, 100, 100, 100, 100);
        } else if (this.nCreams < nCreams) {
            restock(100, 100, 100, 100, 100);
        } else if (this.nCups < nCups) {
            restock(100, 100, 100, 100, 100);
        } else if (this.nMugs < nCups) {
            restock(100, 100, 100, 100, 100);
        }
        this.nCoffeeOunces = this.nCoffeeOunces-size;
        this.nSugarPackets = this.nSugarPackets-nSugarPackets;
        this.nCreams = this.nCreams - nCreams;
        if (toGo == true) {
            this.nCups = this.nCups - 1;
        } else {
            this.nMugs = this.nMugs - 1;
        }
    }

    /**
     * overloaded method to sell coffee with no add ins
     * @param size size of coffee being sold in ounces
     * @param nCups number of cups needed
     */
    public void sellCoffee(int size, int nCups) {
        if (this.nCoffeeOunces < size) {
            restock(100, 100, 100, 100, 100);
        } else if (this.nCups < nCups) {
            restock(100, 100, 100, 100, 100);
        }
        this.nCoffeeOunces = this.nCoffeeOunces-size;
        this.nCups = this.nCups - nCups;
    }

    /**
     * method to restock inventory of cafe
     * @param coffeeOunces number of ounces of coffee restocked
     * @param sugarPackets number of sugar packets added
     * @param creams number of creams added
     * @param cups number of cups added
     * @param mugs number of mugs added
     */
    private void restock(int coffeeOunces, int sugarPackets, int creams, int cups, int mugs) {
        System.out.println("Restocking");
        this.nCoffeeOunces = coffeeOunces;
        this.nSugarPackets = sugarPackets;
        this.nCreams = creams;
        this.nCups = cups;
        this.nMugs = mugs;
        System.out.println("Restock complete.");
    }
    
    /**
     * prints out the options of what you can do at this cafe
     */
    @Override
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + sellCoffee()\n + restock()");
    }

    /**
     * method that allows user to explore the floors of the cafe 
     * @param floorNum indicating the floor number the user wants to go to
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
        this.activeFloor = floorNum;
    }

    
    /**
    * creates new cafe, compass
    */
    public static void main(String[] args) {
        new Cafe("Compass Cafe", "In Neilson Library", 1, 400, 30, 45, 400);
    }
    
}
