/* This is a stub for the Cafe class */
public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory 
    private int nMugs; // number of "for here" mugs
    private boolean ToGo; //for here or to go
    
    public Cafe(String name, String address, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    public Cafe(String name, String address, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, int nMugs) {
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        this.nMugs = nMugs;
        System.out.println("You have built a cafe: ☕");
    }

    public void sellCoffee(int size, int nSugarPackets, int nCreams, boolean ToGo) {
        this.nCoffeeOunces = this.nCoffeeOunces-size;
        this.nSugarPackets = this.nSugarPackets-nSugarPackets;
        this.nCreams = this.nCreams - nCreams;
        if (ToGo == true) {
            this.nCups = this.nCups - 1;
        } else {
            this.nMugs = this.nMugs - 1;
        }
    }

    public void sellCoffee(int size) {
        this.nCoffeeOunces = this.nCoffeeOunces-size;
    }

    private void restock(int CoffeeOunces, int SugarPackets, int Creams, int Cups, int Mugs) {
        System.out.println("Restocking");
        this.nCoffeeOunces = CoffeeOunces;
        this.nSugarPackets = SugarPackets;
        this.nCreams = Creams;
        this.nCups = Cups;
        this.nMugs = Mugs;
        System.out.println("Restock complete.");
    }
    
    @Override
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + sellCoffee()\n + restock()");
    }

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

    

    public static void main(String[] args) {
    }
    
}
