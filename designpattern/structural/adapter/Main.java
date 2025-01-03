// Target Interface (what our phone expects)
interface PhoneCharger {
    void chargePhone();
    int getVolts();
}

// Adaptee (incompatible voltage source - wall socket)
class WallSocket {
    public int getVolts() {
        return 240;
    }
}

// Another Adaptee (car battery)
class CarSocket {
    public int getVolts() {
        return 12;
    }
}

// Adapter for Wall Socket
class WallSocketAdapter implements PhoneCharger {
    private WallSocket wallSocket;

    public WallSocketAdapter(WallSocket wallSocket) {
        this.wallSocket = wallSocket;
    }

    @Override
    public void chargePhone() {
        int volts = wallSocket.getVolts();
        System.out.println("Converting Wall Socket voltage from " + volts + "V to 5V");
        System.out.println("Charging phone with 5V...");
    }

    @Override
    public int getVolts() {
        return 5;
    }
}

// Adapter for Car Socket
class CarSocketAdapter implements PhoneCharger {
    private CarSocket carSocket;

    public CarSocketAdapter(CarSocket carSocket) {
        this.carSocket = carSocket;
    }

    @Override
    public void chargePhone() {
        int volts = carSocket.getVolts();
        System.out.println("Converting Car Socket voltage from " + volts + "V to 5V");
        System.out.println("Charging phone with 5V...");
    }

    @Override
    public int getVolts() {
        return 5;
    }
}

// Our Phone
class Phone {
    private int battery = 0;

    public void charge(PhoneCharger charger) {
        if(charger.getVolts() == 5) {
            System.out.println("Phone is connected.");
            charger.chargePhone();
            battery = 100;
            System.out.println("Battery Level: " + battery + "%\n");
        } else {
            System.out.println("Incorrect voltage! Phone could be damaged.");
        }
    }
}

// Main class to demonstrate usage
public class PhoneChargingDemo {
    public static void main(String[] args) {
        // Create phone and voltage sources
        Phone phone = new Phone();
        WallSocket wallSocket = new WallSocket();
        CarSocket carSocket = new CarSocket();

        // Create adapters
        PhoneCharger wallCharger = new WallSocketAdapter(wallSocket);
        PhoneCharger carCharger = new CarSocketAdapter(carSocket);

        // Charging using wall socket
        System.out.println("=== Charging using Wall Socket ===");
        phone.charge(wallCharger);

        // Charging using car socket
        System.out.println("=== Charging using Car Socket ===");
        phone.charge(carCharger);
    }
}