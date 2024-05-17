import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class tugasOF {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Antrian Rumah Sakit
        Queue<String> antrian = new ArrayDeque<String>(10);
        int nomorAntrian = 1;

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

            try {
                switch (pilihan) {
                    case 1:
                        System.out.println("Silakan masukkan nama pasien:");
                        String namaPasien = input.next();
                        antrian.offer(namaPasien);
                        System.out.println("Pasien berhasil ditambahkan ke antrian.");

                        // Simpan data antrian ke file
                        simpanDataAntrian(namaPasien, nomorAntrian);
                        nomorAntrian++;
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
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan input: " + e.getMessage());
                input.nextLine(); // Clear the input buffer
            }
        } while (pilihan != 4);

        input.close();
    }

    private static void simpanDataAntrian(String namaPasien, int nomorAntrian) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("data_antrian.txt", true));
            writer.write("Nomor Antrian: " + nomorAntrian + "\n");
            writer.write("Nama Pasien: " + namaPasien + "\n");
            writer.write("Tanggal: " + java.time.LocalDate.now() + "\n");
            writer.write("--------------------\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan data antrian: " + e.getMessage());
        }
    }
}