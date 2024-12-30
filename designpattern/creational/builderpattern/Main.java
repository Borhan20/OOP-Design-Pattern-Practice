interface Builder{
    void constructCar();
}

class CarBuilder implements Builder{
    private Car car;
    public CarBuilder(){
        car = new Car();
    }
    public void constructCar(){
        car.setEngine("V8");
        car.setWheels(4);
        // car.setChassis("Monocoque");
        car.setBody("Sedan");
    }

    public Car getCar(){
        return car;
    }

}

class Car{
    private String engine;
    private int wheels;
    private String chassis;
    private String body;
    public void setEngine(String engine){
        this.engine = engine;
    }
    public void setWheels(int wheels){
        this.wheels = wheels;
    }
    // public void setChassis(String chassis){
    //     this.chassis = chassis;
    // }
    public void setBody(String body){
        this.body = body;
    }
    public void display(){
        System.out.println("Engine: "+engine);
        System.out.println("Wheels: "+wheels);
        System.out.println("Chassis: "+chassis);
        System.out.println("Body: "+body);
    }
}

class Main{
    public static void main(String[]args){
        CarBuilder cb = new CarBuilder();
        cb.constructCar();
        Car car = cb.getCar();
        car.display();
    }
}

