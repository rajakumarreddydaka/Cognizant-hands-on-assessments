package DesignPrinciplesAndPatterns.CommandPatternExample;

public class Main {

    public static void main(String[] args) {

        // Receiver
        Light livingRoomLight = new Light();

        // Commands
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // Invoker
        RemoteControl remote = new RemoteControl();

        // Turn ON Light
        remote.setCommand(lightOn);
        remote.pressButton();

        // Turn OFF Light
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}