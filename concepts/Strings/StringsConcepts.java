package concepts.Strings;

public class StringsConcepts {
    public static void main(String[] args) {
        // Declaration
        String name = "Vedant";
        String name1 = "Vedant";
        System.out.print("name == name1 => ");
        System.out.println(name == name1);

        String name2 = new String("Vedant");
        String name3 = new String("Vedant");
        System.out.print("name2 == name3 => ");
        System.out.println(name2 == name3);
        System.out.print("name2.equals(name3) => ");
        System.out.println(name2.equals(name3));
        
    }
}