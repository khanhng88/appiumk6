package lab06;

public class Lab06_3Test {
    public static void main(String[] args) {
        String str = "100 minutes 20 hours";
        char [] charArray = str.toCharArray();
        for (char c : charArray) {
            if(Character.isDigit(c)) {
                System.out.print(c);
            }
        }
    }
}
