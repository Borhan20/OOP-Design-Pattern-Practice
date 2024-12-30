public class Main {
    public static void main(String[] args) {
        VehicleFactory vf = new VehicleFactory();
        Vehicle car = vf.getVehicle("Car");
        Vehicle eBike = vf.getVehicle("Electric Bike");

        // Use car
        System.out.println("\nUsing Car:");
        System.out.println(car.getVehicleType());
        car.start();
        car.stop();

        // Use electric bike
        System.out.println("\nUsing E-Bike:");
        System.out.println(eBike.getVehicleType());
        eBike.start();
        eBike.stop();
    }
}

class VehicleFactory {
    public Vehicle getVehicle(String vehicleType) {
        if (vehicleType == null) {
            return null;
        }
        if (vehicleType.equalsIgnoreCase("Car")) {
            return new Car();
        } else if (vehicleType.equalsIgnoreCase("Electric Bike")) {
            return new ElectricBike();
        }
        return null;
    }
}

interface Vehicle {
    void start();
    void stop();
    String getVehicleType();
}

class Car implements Vehicle {
    private String fuelType = "Petrol";

    @Override
    public void start() {
        System.out.println("Car: Insert key and turn ignition");
    }

    @Override
    public void stop() {
        System.out.println("Car: Apply brakes and turn off engine");
    }

    @Override
    public String getVehicleType() {
        return "Car running on " + fuelType;
    }
}

class ElectricBike implements Vehicle {
    private int batteryLevel = 100;

    @Override
    public void start() {
        System.out.println("E-Bike: Press power button");
    }

    @Override
    public void stop() {
        System.out.println("E-Bike: Press power button to turn off");
    }

    @Override
    public String getVehicleType() {
        return "Electric Bike with " + batteryLevel + "% battery";
    }
}
