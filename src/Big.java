import java.math.BigInteger;

public class Big {
    
    public static void main(String[] args) {
        int n = 30;

        System.out.printf("%-5s | %-15s | %-40s%n", "i", "int Factorial", "BigInteger Factorial");
        System.out.println("-----------------------------------------------------");

        for (int i = 1; i <= n; i++) {
            int normalFact = calcFactorial(i);
            BigInteger bigFact = bigCalcFactorial(i);

            System.out.printf("%-5d | %-15d | %-40d%n", i, normalFact, bigFact);
        }
    }

    public static int calcFactorial(int n){
        int result = 1;
        
        for (int i = 1; i <= n; i++){
            result = result * i;
        }

        return result;
    }

    public static BigInteger bigCalcFactorial(int n){
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

}
