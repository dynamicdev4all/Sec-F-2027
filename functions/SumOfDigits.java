package functions;

public class SumOfDigits {
    static int sumOfDigit(int num) {
        if (num == 0) {
            return 0;
        }
        return num % 10 + sumOfDigit(num / 10);
    }

    public static void main(String[] args) {
        System.out.println(SumOfDigits.sumOfDigit(123456));

    }
}
