
public class Main {
    public static void main(String[] args) {
        int index;
        for (int i = 0; i < 10; i++) {
            index = "abc".hashCode() & (16 - 1);
            System.out.println(index);

        }
    }
}