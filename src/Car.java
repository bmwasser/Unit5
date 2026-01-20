public class Car {
    
    double speed;       // current speed in miles per hour
    int gear;           // current gear of transmission
    double fuel;        // fuel in tank in range 0 - 1
    String model;       // manufacturer and make
    final int MAX_GEAR = 5;

    // full-args constructor
    public Car(double sp, int gr, double fl, String mod){
        speed = sp;
        gear = gr;
        fuel = fl;
        model = mod;
    }

    // no-args constructor
    public Car(){
        speed = 0;
        gear = 1;
        fuel = 1.0;
        model = "Ford Model T";
    }

    public int upShift(){
        gear = Math.min(gear + 1, MAX_GEAR);
        return gear;
    }

    public int downShift(){
        gear = Math.max(gear - 1, 1);
        return gear;
    }

    public String toString(){
        return model + " going " + speed + "mph in gear: " + gear;
    }

}
