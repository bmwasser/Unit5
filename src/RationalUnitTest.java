public class RationalUnitTest {
    public static void main(String[] args) {
        Rational r1 = new Rational();
        Rational r2 = new Rational(5, 10);
        Rational r3 = new Rational(2, 3);
        Rational r4 = new Rational(4, 3);
        Rational r5 = new Rational(2);
        System.out.println("toString on zero: \t" + r1.toString().equals("0/1"));
        System.out.println("toString on fraction: \t" + r3.toString().equals("2/3"));
        System.out.println("toString on whole num: \t" + r5.toString().equals("2/1"));
        System.out.println();

        System.out.println("toDouble on zero: \t" + (r1.toDouble() == 0));
        System.out.println("toDouble on fraction: \t" + (r2.toDouble() == 0.5));
        System.out.println("toDouble on whole num: \t" + (r5.toDouble() == 2));
        System.out.println();
       
        System.out.println("invert fraction: \t" + r2.invert().equals(r5));
        System.out.println("invert whole: \t\t" + r5.invert().equals(r2));
        System.out.println();
       
        System.out.println("add on zero + frac: \t" + r1.add(r3).equals(r3));
        System.out.println("add on fractions: \t" + r2.add(r4).equals(new Rational(11, 6)));
        System.out.println("add on whole + frac: \t" + r3.add(r5).equals(new Rational(8, 3)));
        System.out.println();
       
        System.out.println("subtr on zero - frac: \t" + r1.subtract(r3).equals(new Rational(-2,3)));
        System.out.println("subtr on fractions: \t" + r4.subtract(r3).equals(r3));
        System.out.println("subtr on whole - frac: \t" + r5.subtract(r2).equals(new Rational(3, 2)));
        System.out.println();
       
        System.out.println("mult on zero * frac: \t" + r1.multiply(r4).equals(r1));
        System.out.println("mult on fractions: \t" + r2.multiply(r4).equals(r3));
        System.out.println("mult on whole * frac: \t" + r5.multiply(r3).equals(r4));
        System.out.println();

        System.out.println("divide on zero / frac: \t" + r1.divide(r3).equals(r1));
        System.out.println("divide on fractions: \t" + r4.divide(r3).equals(r5));
        System.out.println("divide on whole / frac: " + r5.divide(r2).equals(new Rational(4)));

    }

}
