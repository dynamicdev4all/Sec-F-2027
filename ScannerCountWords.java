import java.util.Scanner;

public class ScannerCountWords {
    public static void main(String[] args) {
        // String str = ;
        int spaceCount = 0;

        Scanner sc = new Scanner("This is       RDEC Sec F");

        while (sc.hasNext()) {
            spaceCount++;
            sc.next();
        }
        System.out.println("The number of words are " + spaceCount);
    }
}