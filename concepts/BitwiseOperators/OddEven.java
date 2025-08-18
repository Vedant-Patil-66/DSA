package concepts.BitwiseOperators;

public class OddEven {

    private static boolean checkOddOrEven(int num){
        return !((num & 1) == 1);
    }
    public static void main(String[] args) {
        int n = 61;
        System.out.println(checkOddOrEven(n));
    }
}
