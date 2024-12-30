// Prototype interface
interface Character extends Cloneable {
    Character clone();
    void attack();
}

// Concrete character - Warrior
class Warrior implements Character {
    private String name;
    private String weapon;
    
    public Warrior() {
        this.weapon = "sword";
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public Character clone() {
        Warrior clone = null;
        try {
            clone = (Warrior) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
    
    @Override
    public void attack() {
        System.out.println(name + " attacks with " + weapon);
    }
}

// Demo class
public class Main {
    public static void main(String[] args) {
        // Create the original warrior
        Warrior warrior = new Warrior();
        warrior.setName("Original Warrior");
        
        // Clone the warrior to create new characters
        Warrior warrior1 = (Warrior) warrior.clone();
        warrior1.setName("Warrior 1");
        
        Warrior warrior2 = (Warrior) warrior.clone();
        warrior2.setName("Warrior 2");
        
        // Test the characters
        System.out.println("Testing characters:");
        warrior.attack();  // Output: Original Warrior attacks with sword
        warrior1.attack(); // Output: Warrior 1 attacks with sword
        warrior2.attack(); // Output: Warrior 2 attacks with sword
    }
}