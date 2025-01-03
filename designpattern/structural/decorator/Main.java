// Basic Pizza interface
interface Pizza {
    String getDescription();
    double getPrice();
}

// Basic Pizza implementation
class PlainPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public double getPrice() {
        return 10.0;  // Base price
    }
}

// Base Topping Decorator
class ToppingDecorator implements Pizza {
    protected Pizza pizza;
    protected String toppingName;
    protected double toppingPrice;

    public ToppingDecorator(Pizza pizza, String toppingName, double toppingPrice) {
        this.pizza = pizza;
        this.toppingName = toppingName;
        this.toppingPrice = toppingPrice;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + " + toppingName;
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + toppingPrice;
    }
}

// Main class to show how to order pizza
public class Main {
    public static void main(String[] args) {
        // Order 1: Plain pizza
        Pizza myPizza = new PlainPizza();
        System.out.println("Order 1:");
        System.out.println("Items: " + myPizza.getDescription());
        System.out.println("Total: $" + myPizza.getPrice());
        System.out.println();

        // Order 2: Pizza with cheese
        Pizza cheesePizza = new ToppingDecorator(new PlainPizza(), "Cheese", 2.0);
        System.out.println("Order 2:");
        System.out.println("Items: " + cheesePizza.getDescription());
        System.out.println("Total: $" + cheesePizza.getPrice());
        System.out.println();

        // Order 3: Pizza with cheese and mushrooms
        Pizza mushroomCheesePizza = new ToppingDecorator(
            new ToppingDecorator(new PlainPizza(), "Cheese", 2.0),
            "Mushrooms", 1.5
        );
        System.out.println("Order 3:");
        System.out.println("Items: " + mushroomCheesePizza.getDescription());
        System.out.println("Total: $" + mushroomCheesePizza.getPrice());
        System.out.println();

        // Order 4: Pizza with cheese, mushrooms, and pepperoni
        Pizza deluxePizza = new ToppingDecorator(
            new ToppingDecorator(
                new ToppingDecorator(new PlainPizza(), "Cheese", 2.0),
                "Mushrooms", 1.5
            ),
            "Pepperoni", 2.5
        );
        System.out.println("Order 4:");
        System.out.println("Items: " + deluxePizza.getDescription());
        System.out.println("Total: $" + deluxePizza.getPrice());
    }
}