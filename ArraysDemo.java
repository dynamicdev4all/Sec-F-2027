//CRUD - Create, Read, Update, Delete

import java.util.Scanner;

public class ArraysDemo {
    static int arr[];

    static void createArray(Scanner sc) {
        System.out.println("Please enter the size of the array");
        int size = sc.nextInt();
        arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Please enter the " + (i + 1) + " value");
            arr[i] = sc.nextInt();
        }
    }

    static void readArray() {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]");
        System.out.println();
    }

    static void updateArray(Scanner sc) {
        System.out.println("Please enter the index you want to update");
        int index = sc.nextInt();
        System.out.println("Please the value you want to update");
        int val = sc.nextInt();
        arr[index] = val;
    }

    static void deleteArray(Scanner sc) {
        System.out.println("Please enter the index value you want to delete");
        int delIndex = sc.nextInt();
        for (int i = delIndex; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Press 1 to create array");
            System.out.println("Press 2 to read array");
            System.out.println("Press 3 to update array");
            System.out.println("Press 4 to deletion in array");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    createArray(sc);
                    break;
                case 2:
                    readArray();
                    break;
                case 3:
                    updateArray(sc);
                    break;
                case 4:
                    deleteArray(sc);
                    break;

                default:
                    break;
            }
        }

    }
}
