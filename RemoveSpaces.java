import java.util.Scanner;

public class RemoveSpaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner("THis is java rdec gzb");
        String s = "";
        while (sc.hasNext()) {
            s = s + sc.next();

        }
        System.out.println(s);
    }
}
