package functions;

public class RecursionDemo {

    static void printData(int count) {
        // this is called the base case where the recursion ends
        if (count == 7) {
            return;
        }
        // this is called business logic
        System.out.println("JAVA");

        // this is the recursion call
        printData(count + 1);
    }

    static void printData2(int count) {
        // this is called the base case where the recursion ends
        if (count <= 0) {
            return;
        }
        // this is called business logic
        System.out.println("CPP");

        // this is the recursion call
        printData2(count - 1);
    }

    public static void main(String[] args) {
        RecursionDemo.printData(0);
        RecursionDemo.printData2(20-);
    }
}
