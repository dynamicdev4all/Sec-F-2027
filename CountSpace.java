public class CountSpace {
    public static void main(String[] args) {
        String str = "   THis is       rdec Sec f    ";
        str = str.trim();// to remove extra space from start and end
        int spaceCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && str.charAt(i + 1) != ' ') {
                spaceCount++;
            }
        }
        spaceCount++;
        System.out.println("the total words are " + spaceCount);
    }
}