public class Rational{

    private int numerator;
    private int denominator;

    /**
     * Creates a default rational number by setting zero over one
     */
    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
        this.reduce();
    }

    /**
     * Creates a rational number by taking a numerator and denominator
     * @param num
     * @param denom
     */
    public Rational(int num, int denom) {
        this.numerator = num;
        this.denominator = denom;
        this.reduce();
    }

    /**
     * Creates a rational number by taking a numerator and putting it over 1
     * @param num
     */
    public Rational(int num) {
        this.numerator = num;
        this.denominator = 1;
        this.reduce();
    }

    /**
     * Finds the greatest common divisor of a and b using the Euclidean algorithm 
     */
    private void reduce() {
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        int a = Math.abs(numerator);
        int b = Math.abs(denominator);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        int gcd = a;

        numerator /= gcd;
        denominator /= gcd;
    }

    /**
     * Formats the numerators and denominators that were given by the user into a 
     * format that is able to be printed as a String
     * @return String
     */
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    /**
     * Converts the rational number into a double 
     * @return double
     */
    public double toDouble() {
        return (double) this.numerator / this.denominator;
    }

    /**
     * Inverts the rational number by flipping the numerator and denominator of given
     * @return Rational
     */
    public Rational invert() {
        return new Rational(this.denominator, this.numerator);
    }

    /**
     * Checks to see if the numerator and denominator of each rational number 
     * are equal to each other
     * @param other
     * @return boolean
     */
    public boolean equals(Rational other){
        return (this.numerator == other.numerator) && (this.denominator == other.denominator);
    }

    /**
     * Adds the two rational numbers given by giving both like denominators
     * and then adding them together to create a sum
     * @param other
     * @return Rational
     */
    public Rational add(Rational other) {
        int addNum = this.numerator * other.denominator + this.denominator * other.numerator;
        int addDenom = this.denominator * other.denominator;
        Rational sum = new Rational(addNum, addDenom);
        sum.reduce();
        return sum;
    }

    /**
     * Subtracts two rational numbers from each other by giving them like denominators
     * and then subtracting them together to create a difference
     * @param other
     * @return Rational
     */
    public Rational subtract(Rational other) {
        int subNum = this.numerator * other.denominator - this.denominator * other.numerator;
        int subDenom = this.denominator * other.denominator;
        Rational diff = new Rational(subNum, subDenom);
        diff.reduce();
        return diff;
    }

    /**
     * Takes the two rational numbers given and multiplies the two numerators and denominators
     * together creating a product
     * @param other
     * @return Rational
     */
    public Rational multiply(Rational other) {
        int multiNum = this.numerator * other.numerator;
        int multiDenom = this.denominator * other.denominator;
        Rational product = new Rational(multiNum, multiDenom);
        product.reduce();
        return product;
    }

    /**
     * Takes the two rational numbers and inverts the second rational number that was sent as a parameter
     * then multiplying the numerator and denominator of both rationals
     * @param other
     * @return Rational
     */
    public Rational divide(Rational other) {
        int divideNum = this.numerator * other.denominator;
        int divideDenom = this.denominator * other.numerator;
        Rational answer = new Rational(divideNum, divideDenom);
        answer.reduce();
        return answer;
    }

}