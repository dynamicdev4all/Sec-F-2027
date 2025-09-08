public class StringDemo {
    public static void main(String[] args) {
        // String name = "Aayush";// this is my initial data
        // System.out.println(name);
        // name = name + " Kumar";//here we are doing changes in string
        // name = name + " Kumar is";//here we are doing changes in string
        // System.out.println(name);

        // String name = "Aayush";
        // String name2 = "aayush";
        // String name3 = "aayush";
        // System.out.println(name == name2);
        // System.out.println(name3 == name2); //true

        // String name = "Aayush";
        // String name2 = new String("Aayush").intern();
        // System.out.println(name == name2);

        // == is used to comapare the ref of two diff strings

        // String name = "Aayush";
        // String name2 = "Aayush";
        // System.out.println(name.equals(name2));
        // String name3 = "Aayush";
        // String name4 = new String("Aayush");
        // System.out.println(name3.equals(name4));
        String name = "Aayush";
        String name2 = "aayush";
        System.out.println(name.equalsIgnoreCase(name2));
        String name3 = "Aayush";
        String name4 = new String("Aayush");
        System.out.println(name3.equals(name4));
    }
}
 

//Count the no of vowels and consonants in your name