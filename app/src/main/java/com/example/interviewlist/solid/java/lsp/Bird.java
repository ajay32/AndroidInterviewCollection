package com.example.interviewlist.solid.java.lsp;


// this is breaking LSP coz .. ostrich can not substiute for bird
// why its violating because superClass Bird has a capability to fly ..but its subClass Ostrich can not fly.
public abstract class Bird {
    public abstract void fly();
}


 class Sparrow extends Bird {
    @Override
    public void fly() {
        System.out.println("Sparrow flying high.");
    }
}
 class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostrich cannot fly.");
    }
}

 class BirdTest {
    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        makeItFly(sparrow);

        Bird ostrich = new Ostrich();
        makeItFly(ostrich); // This will throw an exception
    }

    private static void makeItFly(Bird bird) {
        bird.fly();
    }
}


//============== lets created a fix version for it ==================

// LSP violation - fix
// SRP  - no violation ( all classes and interface has single responsibility)
// OCP - no violation - Lets suppose we need a new Bird (fly or noFly) I can easily add without modifying existing code
// ISP - no violation because FlyingBird interface does not force non-fly birds like ostrich to implement its interface
// DIP - no DIP apply
 abstract class Bird1 {
    // Common bird-related methods
}

 interface FlyingBird { // we are making interface for fly becuase all birds can not fly
    void fly();
}

 class Sparrow1 extends Bird1 implements FlyingBird {
    @Override
    public void fly() {
        System.out.println("Sparrow flying high.");
    }
}

 class Ostrich1 extends Bird1 {
    // Ostrich-specific methods
}

 class BirdTest1 {
    public static void main(String[] args) {
        FlyingBird sparrow = new Sparrow1();
        makeItFly(sparrow);

        Bird1 ostrich = new Ostrich1();
        // makeItFly(ostrich); // This is now a compile-time error
    }

    private static void makeItFly(FlyingBird bird) {
        bird.fly();
    }
}




