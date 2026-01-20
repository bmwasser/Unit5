public class App {
    public static void main(String[] args) throws Exception {
        Car myCar = new Car(0, 1, 0.5, "Toyota RAV4");
        Car yourCar = new Car();
       
        myCar.upShift();

        yourCar.downShift();

        System.out.println(myCar);
        System.out.println(yourCar);
    }
}
