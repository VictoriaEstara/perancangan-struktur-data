// Kode ini dibagikan oleh Dedad Fajar dan dapat diakses melalaui github: https://github.com/VictoriaEstara/perancangan-struktur-data
// Kode ini merupakan digunakan sebagai tugas "Challenge: Queue Implementation using Linked List in Java"


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AntrianLoket {
    // Method untuk menambahkan antrian (EnQueue)
    private static void enQueue(Queue<Integer> antrian, int nomorAntrian) {
        antrian.add(nomorAntrian); // Menambahkan nomor antrian ke dalam antrian
        System.out.println("Antrian Anda Nomor: " + nomorAntrian); // Menampilkan nomor antrian yang ditambahkan
    }

    // Method untuk memanggil antrian (DeQueue)
    private static void deQueue(Queue<Integer> antrian) {
        if (!antrian.isEmpty()) { // Memeriksa apakah antrian tidak kosong
            System.out.println("Antrian Nomor " + antrian.peek() + " Silahkan ke Loket ya!"); // Menampilkan nomor antrian yang dipanggil
            antrian.poll(); // Menghapus nomor antrian yang dipanggil dari antrian
        } else {
            System.out.println("Antrian kosong. Tidak ada yang dipanggil."); // Menampilkan pesan jika antrian kosong
        }
    }

    // Method untuk mencetak antrian
    private static void printQueue(Queue<Integer> antrian) {
        if (antrian.isEmpty()) { // Memeriksa apakah antrian kosong
            System.out.println("Antrian kosong."); // Menampilkan pesan jika antrian kosong
        } else {
            System.out.println("Menampilkan Antrian:"); // Menampilkan pesan sebelum mencetak antrian
            for (int antrianNomor : antrian) { // Iterasi untuk setiap nomor antrian dalam antrian
                System.out.println(antrianNomor); // Mencetak nomor antrian
            }
        }
    }

    public static void main(String[] args) {
        Queue<Integer> antrian = new LinkedList<>(); // Membuat objek antrian menggunakan LinkedList
        Scanner scanner = new Scanner(System.in); // Membuat objek scanner untuk input dari pengguna
        int nomorAntrian = 1; // Variabel untuk menyimpan nomor antrian, dimulai dari 1

        while (true) {
            System.out.println("\n=============================");
            System.out.println("Menu:");
            System.out.println("1. Ambil Antrian");
            System.out.println("2. Panggil Antrian");
            System.out.println("3. Cetak Antrian");
            System.out.println("4. Tutup\n");
            System.out.println("=============================\n");

            System.out.print("Pilihan: ");
            int pilihan = scanner.nextInt(); // Membaca pilihan dari pengguna

            switch (pilihan) {
                case 1:
                    enQueue(antrian, nomorAntrian); // Memanggil method enQueue untuk menambahkan antrian
                    nomorAntrian++; // Menambah nomor antrian untuk antrian selanjutnya
                    break;
                case 2:
                    deQueue(antrian); // Memanggil method deQueue untuk memanggil antrian
                    break;
                case 3:
                    printQueue(antrian); // Memanggil method printQueue untuk mencetak antrian
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan kami, silahkan datang kembali!"); // Menampilkan pesan keluar dari program
                    System.out.println("||| Akastangga Hospital Center |||\n");
                    scanner.close(); // Menutup scanner untuk mencegah kebocoran sumber daya
                    return; // Keluar dari method main dan program selesai
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi."); // Menampilkan pesan jika pilihan tidak valid
            }
        }
    }
}