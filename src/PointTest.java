import java.awt.Point;

public class PointTest {
    
    public static void main(String[] args) {
        Point p1 = new Point();
        System.out.println(p1);
        Point p2 = new Point(4,5);
        System.out.println(p2);
        Point p3 = new Point(p2);
        System.out.println(p3);
        Boolean isEqual = p2.equals(p3);
        System.out.println(isEqual);
        Point location = p2.getLocation();
        System.out.println(location);
        double x = p3.getX();
        System.out.println(x);
        double y = p2.getY();
        System.out.println(y);
        Point p4 = new Point(6,7);
        p4.move(3,5);
        System.out.println(p4);
        p4.setLocation(3.5,4.5);
        System.out.println(p4);
        p4.setLocation(3,4);
        System.out.println(p4);
        p4.setLocation(p1);
        System.out.println(p4);
        String stringP1 = p1.toString();
        System.out.println(stringP1);
        p2.translate(3,3);
        System.out.println(p2);
    }



    // Questions:
    // a) Free Software Foundation
    // b) 90% of the file is comments while the other 10% is actual code
    // c) The rounding of a double in the setLocation method rounds up the amount so in
    //    the case of 3.5 or 4.5, it rounds up to 4 and 5 respectively

}
