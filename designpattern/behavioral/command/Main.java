//device interface that define the device methods
interface Device {
    void turnOn();
    void turnOff();
}

//concrete classes that implement the device interface on their own
class TV implements Device {
    @Override
    public void turnOn() {
        System.out.println("TV is turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is turned off");
    }
}

//concrete classes that implement the device interface on their own
class Radio implements Device {
    @Override
    public void turnOn() {
        System.out.println("Radio is turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Radio is turned off");
    }
}

//command interface that define the command methods we can say it executor
interface Command {
    void execute();
}

//concrete classes that implement the command interface on their own
class TurnOnCommand implements Command {
    private Device device;

    public TurnOnCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}

//concrete classes that implement the command interface on their own
class TurnOffCommand implements Command {
    private Device device;

    public TurnOffCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();
    }
}

//invoker class that will take the command and execute it
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class Main {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        Device tv = new TV();
        Device radio = new Radio();
        Command turnOnTV = new TurnOnCommand(tv);
        Command turnOffTV = new TurnOffCommand(tv);
        Command turnOnRadio = new TurnOnCommand(radio);
        Command turnOffRadio = new TurnOffCommand(radio);

        remoteControl.setCommand(turnOnTV);
        remoteControl.pressButton();

        remoteControl.setCommand(turnOffTV);
        remoteControl.pressButton();

        remoteControl.setCommand(turnOnRadio);
        remoteControl.pressButton();

        remoteControl.setCommand(turnOffRadio);
        remoteControl.pressButton();
    }
}