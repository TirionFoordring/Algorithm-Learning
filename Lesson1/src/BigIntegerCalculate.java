import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BigIntegerCalculate{
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static void bigIntegerAdd() throws IOException {
        BigInteger bigInteger1 = new BigInteger(br.readLine());
        BigInteger bigInteger2 = new BigInteger(br.readLine());
        System.out.println(bigInteger1 + " + " + bigInteger2 + " = " + bigInteger1.add(bigInteger2));
    }

    private static void bigIntegerSubtract() throws IOException {
        BigInteger bigInteger1 = new BigInteger(br.readLine());
        BigInteger bigInteger2 = new BigInteger(br.readLine());
        System.out.println(bigInteger1 + " - " + bigInteger2 + " = " + bigInteger1.subtract(bigInteger2));
    }

    private static void bigIntegerMultiply() throws IOException {
        BigInteger bigInteger = new BigInteger(br.readLine());
        long smallInput = Long.parseLong(br.readLine());
        System.out.println(bigInteger + " * " + smallInput + " = " + bigInteger.multiply(BigInteger.valueOf(smallInput)));
    }

    private static void bigIntegerDivide() throws IOException {
        BigInteger bigInteger = new BigInteger(br.readLine());
        long smallInput = Long.parseLong(br.readLine());
        BigInteger result = bigInteger.divide(BigInteger.valueOf(smallInput));
        BigInteger remainder = bigInteger.remainder(BigInteger.valueOf(smallInput));
        System.out.println(bigInteger + " / " + smallInput + ": ");
        System.out.println("result = " + result);
        System.out.println("remainder = " + remainder);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Input \"+\", \"-\", \"*\" or \"/\" to select calculation.");
        String input = br.readLine();
        if (input.equals("+")) {
            bigIntegerAdd();
        } else if (input.equals("-")) {
            bigIntegerSubtract();
        } else if (input.equals("*")) {
            bigIntegerMultiply();
        } else if (input.equals("/")) {
            bigIntegerDivide();
        } else {
            System.out.println("Invalid input");
        }
    }
}