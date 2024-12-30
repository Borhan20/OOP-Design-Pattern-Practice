public class Main{
    public static void main(String[]args){
        // can't modify final variables
        Vehicle c = new Car();
        //can't override final methods
        c.start();
        c.stop();
        // c.modifySpeed(200);
        System.out.println(c.getVehicleType() + " speed: " + ((Car)c).speed);

        // final class can't be extended
        Env e = new Env();
        // e.modifyName("Development");
        System.out.println(e.name);
    }
}

class Vehicle{
    final void start(){
        System.out.println("Vehicle starting");
    }
    final void stop(){
        System.out.println("Vehicle stopping");
    }
    String getVehicleType(){
        return "Vehicle";
    }
}

class Car extends Vehicle{
    final int speed = 100;
    // void start(){
    //     System.out.println("Car starting");
    // }
    // void stop(){
    //     System.out.println("Car stopping");
    // }
    // void modifySpeed(int value){
    //     speed = value;
    // }
    String getVehicleType(){
        return "Car";
    }
}

final class Env{
    final String name = "Production";
    // void modifyName(String value){
    //     name = value;
    // }
    // void modifyName(){
    //     name = "Development";
    // }
 
}

// class PythonEnv extends Env{
//     final String name = "Python";
//     // void modifyName(String value){
//     //     name = value;
//     // }
//     // void modifyName(){
//     //     name = "Development";
//     // }
// }