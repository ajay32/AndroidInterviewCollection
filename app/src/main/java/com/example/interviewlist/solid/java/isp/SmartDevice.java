package com.example.interviewlist.solid.java.isp;

// suppose I have a smart device that has so many functionalities but not all devices have that much functionality

// below you can see smart watch has forced to implement functionality that is so irrelevant
//  ISP violation
// SRP - this SmartDevice interface is handling multiple responsibility violation SRP
// LSP not violating now but at risk if subclasses implement unnecessary interface methods.
// OCP - violation  suppose we need to add new functionality.we have to modify SmartDevice interface and all its subclasses
// DIP - does not apply here
public interface SmartDevice {
    void playMusic();
    void displayTime();
    void readTemperature();
    void makeCoffee();
}


 class SmartWatch implements SmartDevice {
    @Override
    public void playMusic() {
        // Implementation to play music
    }

    @Override
    public void displayTime() {
        // Implementation to
    }

     @Override
     public void readTemperature() { // ISP violation
         throw new UnsupportedOperationException("SmartWatch does not support reading temperature.");
     }

     @Override
     public void makeCoffee() {
         throw new UnsupportedOperationException("SmartWatch cannot make coffee.");
     }
}

// you may find the fixed version below for this
//OCP fixed -- for new functionality now we can add new interfaces. are not depended on single interface
// LSP - does not apply here
// DIP -- now we have higer level implentations (interfaces) to depend on rather than concrete classes so no violation

 interface MusicPlayer {  // SRP fixed each interface has one functionality
    void playMusic();
}

 interface TimeDisplay {
    void displayTime();
}

 interface TemperatureReader {
    void readTemperature();
}

 interface CoffeeMaker {
    void makeCoffee();
}

 class SmartWatch1 implements MusicPlayer, TimeDisplay { // fixed ISP coz implementing relevant functionality
    @Override
    public void playMusic() {
        // Implementation to play music
    }

    @Override
    public void displayTime() {
        // Implementation to display time
    }
}




