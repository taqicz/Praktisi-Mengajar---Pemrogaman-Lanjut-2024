import java.util.ArrayDeque;
import java.util.Queue;


public class queue {
    public static void main(String[] args) {

        // Antrean Rumah Sakit
        Queue<String> nama = new ArrayDeque<>(10);
        nama.offer("Septi");
        nama.offer("Rudi");
        nama.offer("Bagas");
        nama.offer("Susanto");
        nama.offer("Susanti");

            for (String next = nama.poll(); next != null; next = nama.poll()) {
                System.out.println(nama);
            }
    }
}