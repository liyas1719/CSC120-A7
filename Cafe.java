/* This is a stub for the Cafe class */
public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory 
    
    public Cafe(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        this.nCoffeeOunces = this.nCoffeeOunces-size;
        this.nSugarPackets = this.nSugarPackets-nSugarPackets;
        this.nCreams = this.nCreams - nCreams;
    }

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        }

    

    public static void main(String[] args) {
        new Cafe(50, 32, 14, 4);
    }
    
}
