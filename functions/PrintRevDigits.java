package functions;

public class PrintRevDigits {


    static void printRevDigits(int count) {
        if (count <= 0) {
            return;
        }
        System.out.println(count);
        printRevDigits(count - 1);
    }





    static void printDigits(int count) {
        if (count <= 0) {
            return;
        }
        printDigits(count - 1);
        System.out.println(count);
    }

    public static void main(String[] args) {
        PrintRevDigits.printRevDigits(5);




        
        PrintRevDigits.printDigits(5);
    }
}
