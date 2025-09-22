public class FunctionsDemo {

    // this is the first type of function having no return type and zero args
    void sum1() {

    }

    // this is the second type of function having no return type but has 2 args
    void sum2(int a, int b) {

    }

    // this is the third type of fucntion having int return type and has zero args
    int sum3() {
        return 0;
    }

    // this is the fourth type of function having int return type and has 2 args
    int sum4(int a, int b) {
        return 0;
    }

    static void sum5(String name) {

    }
    static void sum6(String... name2) {

    }

    public static void main(String[] args) {
        FunctionsDemo.sum5("Dhruv","gfdgf");
        FunctionsDemo.sum6();
    }
}