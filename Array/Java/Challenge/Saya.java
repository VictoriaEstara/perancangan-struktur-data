// Kode ini dibagikan oleh Dedad Fajar dan dapat diakses melalui github: https://github.com/VictoriaEstara/perancangan-struktur-data

import java.util.Scanner;

class Mahasiswa {
    String nim;
    String nama;
    int umur;
    int jumlahSaudara;

    Mahasiswa(String nim, String nama, int umur, int jumlahSaudara) {
        this.nim = nim;
        this.nama = nama;
        this.umur = umur;
        this.jumlahSaudara = jumlahSaudara;
    }

    @Override
    public String toString() {
        return "NIM : " + nim + " Nama : " + nama + " Umur : " + umur + " Jumlah Saudara : " + jumlahSaudara;
    }
}

public class Saya {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mahasiswa[] mahasiswas = new Mahasiswa[3];
        int jumlahMahasiswa = 0;

        while (true) {
            System.out.println("\nMenu Utama");
            System.out.println("----------------------");
            System.out.println("1. Input Data Mahasiswa");
            System.out.println("2. Menampilkan Data Mahasiswa");
            System.out.println("3. Exit");
            System.out.print("\nPilihlah Menu Berikut : ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membuang newline character

            switch (pilihan) {
                case 1:
                    System.out.println("\nInput Data Mahasiswa");
                    System.out.println("----------------------");
                    System.out.print("NIM : ");
                    String nim = scanner.nextLine();
                    System.out.print("Nama : ");
                    String nama = scanner.nextLine();
                    System.out.print("Umur : ");
                    int umur = scanner.nextInt();
                    System.out.print("Jumlah Saudara : ");
                    int jumlahSaudara = scanner.nextInt();

                    mahasiswas[jumlahMahasiswa] = new Mahasiswa(nim , nama, umur, jumlahSaudara);
                    jumlahMahasiswa++;
                    break;
                case 2:
                    System.out.println("\nData Mahasiswa");
                    System.out.println("----------------------");
                    for (int i = 0; i < jumlahMahasiswa; i++) {
                        System.out.println((i+1) + ". " + mahasiswas[i]);
                    }
                    break;
                case 3:
                    System.out.println("Sekian dan Terima kasih!");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}