import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class studiAntreanRS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Antrian Rumah Sakit
        Queue<String> antrian = new ArrayDeque<String>(10);

        int pilihan = 0;

        do {
            System.out.println("\nSelamat datang di Rumah Sakit XYZ!");
            System.out.println("Silakan pilih menu:");
            System.out.println("1. Masukkan pasien ke antrian");
            System.out.println("2. Panggil pasien berikutnya");
            System.out.println("3. Tampilkan antrian");
            System.out.println("4. Keluar");

            System.out.print("Masukkan pilihan Anda: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("Silakan masukkan nama pasien:");
                    antrian.offer(input.next());
                    System.out.println("Pasien berhasil ditambahkan ke antrian.");
                    break;
                case 2:
                    if (!antrian.isEmpty()) {
                        System.out.println("Pasien berikutnya silakan masuk.");
                        System.out.println(antrian.poll());
                    } else {
                        System.out.println("Antrian kosong.");
                    }
                    break;
                case 3:
                    System.out.println("Daftar Antrean : " + antrian);
                    break;
                case 4:
                    System.out.println("Terima kasih");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 4);

        input.close();
    }
}