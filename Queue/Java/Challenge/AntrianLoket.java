// Kode ini dibagikan oleh Dedad Fajar dan dapat diakses melalaui github: https://github.com/VictoriaEstara/perancangan-struktur-data
// Kode ini merupakan digunakan sebagai tugas Challenge Queue using Java and Python


import java.util.Scanner;

public class AntrianLoket {
    private static final int MAX_SIZE = 10; // Maksimal ukuran antrian
    private int[] antrian = new int[MAX_SIZE + 1]; // Array untuk menyimpan antrian
    private int front = 0; // Indeks depan antrian
    private int rear = -1; // Indeks belakang antrian
    private int size = 0; // Jumlah elemen dalam antrian
    private int nextNumber = 1; // Nomor antrian selanjutnya yang akan diambil

    public static void main(String[] args) {
        AntrianLoket antrianLoket = new AntrianLoket();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=============================");
            System.out.println("MENU:");
            System.out.println("1. Ambil Antrian");
            System.out.println("2. Panggil Antrian");
            System.out.println("3. Cetak Antrian");
            System.out.println("4. Tutup\n");
            System.out.println("=============================\n");

            System.out.print("Pilihan: ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    antrianLoket.ambilAntrian();
                    break;
                case "2":
                    antrianLoket.panggilAntrian();
                    break;
                case "3":
                    antrianLoket.cetakAntrian();
                    break;
                case "4":
                    System.out.println("Terima kasih telah menggunakan layanan kami, silahkan datang kembali!");
                    System.out.println("||| Akastangga Hospital Center |||\n");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }
    }

    public void ambilAntrian() {
        if (size == MAX_SIZE) { // Jika antrian penuh
            System.out.println("Antrian penuh. Tidak bisa mengambil antrian.");
            return;
        }
        rear = (rear + 1) % (MAX_SIZE + 1); // Menggeser rear ke indeks berikutnya (dengan modulus)
        antrian[rear] = nextNumber; // Menyimpan nomor antrian di rear
        nextNumber++; // Menambahkan nomor antrian selanjutnya
        size++; // Menambah jumlah elemen dalam antrian
        System.out.println("Antrian Anda Nomor: " + antrian[rear]); // Menampilkan nomor antrian yang diambil
    }

    public void panggilAntrian() {
        if (size == 0) { // Jika antrian kosong
            System.out.println("Antrian kosong. Tidak ada yang dipanggil.");
            return;
        }
        System.out.println("Antrian Nomor " + antrian[front] + " Silahkan ke Loket ya!"); // Menampilkan nomor antrian yang dipanggil
        front = (front + 1) % (MAX_SIZE + 1); // Menggeser front ke indeks berikutnya (dengan modulus)
        size--; // Mengurangi jumlah elemen dalam antrian
    }

    public void cetakAntrian() {
        if (size == 0) { // Jika antrian kosong
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Menampilkan Antrian:");
        int count = size;
        int i = front;
        while (count > 0) { // Iterasi melalui semua elemen dalam antrian
            System.out.println(antrian[i]); // Mencetak nomor antrian
            i = (i + 1) % (MAX_SIZE + 1); // Menggeser ke elemen berikutnya (dengan modulus)
            count--; // Mengurangi hitungan elemen yang belum dicetak
        }
    }
}
