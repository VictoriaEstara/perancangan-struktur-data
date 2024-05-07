// Kode ini dibagikan oleh Dedad Fajar dan dapat diakses melalui github: https://github.com/VictoriaEstara/perancangan-struktur-data

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Mahasiswa {
    String nim;
    String nama;
    int umur;
    int jmlSaudara;

    public Mahasiswa(String nim, String nama, int umur, int jmlSaudara) {
        this.nim = nim;
        this.nama = nama;
        this.umur = umur;
        this.jmlSaudara = jmlSaudara;
    }

    @Override
    public String toString() {
        return "NIM = " + nim + " NAMA = " + nama + " UMUR = " + umur + " JML SAUDARA = " + jmlSaudara;
    }
}

public class saya1 {
    public static void main(String[] args) {
        LinkedList<Mahasiswa> daftarMahasiswa = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMENU UTAMA");
            System.out.println("==========");
            System.out.println("1. Menginput Data Mahasiswa");
            System.out.println("2. Menampilkan Data Mahasiswa");
            System.out.println("3. Mengubah Data Mahasiswa");
            System.out.println("4. Menghapus Data Mahasiswa");
            System.out.println("5. EXIT\n");

            System.out.print("SILAKAN PILIH MENU: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membuang newline character

            switch (pilihan) {
                case 1:
                    System.out.println("\nMenginput Data Mahasiswa");
                    System.out.println("==============");

                    System.out.print("NIM = ");
                    String nim = scanner.nextLine();
                    if (!nim.matches("\\d+")) {
                        System.out.println("NIM harus berisi hanya angka.");
                        break;
                    }

                    System.out.print("NAMA = ");
                    String nama = scanner.nextLine();
                    if (!nama.matches("^[a-zA-Z\\s]+$")) {
                        System.out.println("Nama harus berisi hanya huruf.");
                        break;
                    }

                    System.out.print("UMUR = ");
                    int umur;
                    try {
                        umur = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Umur harus berisi hanya angka.");
                        break;
                    }

                    System.out.print("JML SAUDARA = ");
                    int jmlSaudara;
                    try {
                        jmlSaudara = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Jumlah saudara harus berisi hanya angka.");
                        break;
                    }

                    daftarMahasiswa.add(new Mahasiswa(nim, nama, umur, jmlSaudara));

                    break;
                case 2:
                    System.out.println("\nDATA MHS");
                    System.out.println("========");
                    int i = 1;
                    for (Mahasiswa mhs : daftarMahasiswa) {
                        System.out.println(i + ". " + mhs.toString());
                        i++;
                    }
                    break;
                case 3:
                    System.out.println("\nMengubah Data Mahasiswa");
                    System.out.println("==============");
                    System.out.print("Masukkan nama yang ingin diubah: ");
                    String namaYangDiubah = scanner.nextLine();

                    System.out.print("Pilih opsi penggantian (kata atau indeks): ");
                    String opsi = scanner.nextLine();

                    for (Mahasiswa mhs : daftarMahasiswa) {
                        if (mhs.nama.equals(namaYangDiubah)) {
                            if (opsi.equalsIgnoreCase("kata")) {
                                System.out.print("Masukkan kata yang ingin diganti: ");
                                String kataYangDiganti = scanner.nextLine();

                                System.out.print("Masukkan kata pengganti: ");
                                String kataPengganti = scanner.nextLine();

                                mhs.nama = mhs.nama.replace(kataYangDiganti, kataPengganti);
                            } else if (opsi.equalsIgnoreCase("indeks")) {
                                System.out.print("Masukkan indeks kata yang ingin diganti: ");
                                int indeksKata = scanner.nextInt();
                                scanner.nextLine(); // Membuang newline character

                                System.out.print("Masukkan kata pengganti: ");
                                String kataPengganti = scanner.nextLine();

                                String[] kata = mhs.nama.split(" ");
                                if (indeksKata >= 0 && indeksKata < kata.length) {
                                    kata[indeksKata] = kataPengganti;
                                    mhs.nama = String.join(" ", kata);
                                } else {
                                    System.out.println("Indeks kata tidak valid.");
                                }
                            } else {
                                System.out.println("Opsi tidak valid.");
                            }
                            System.out.println("Data berhasil diubah.");
                        }
                    }
                    // Kode untuk mengubah data mahasiswa
                    break;
                case 4:
                    System.out.println("\nMenghapus Data Mahasiswa");
                    System.out.println("==============");
                    System.out.print("Masukkan nama yang ingin dihapus: ");
                    String namaYangDihapus = scanner.nextLine();

                    Iterator<Mahasiswa> iterator = daftarMahasiswa.iterator();
                    boolean found = false;
                    while (iterator.hasNext()) {
                        Mahasiswa mhs = iterator.next();
                        if (mhs.nama.equals(namaYangDihapus)) {
                            iterator.remove();
                            found = true;
                        }
                    }
                    if (found) {
                        System.out.println("Data berhasil dihapus.");
                    } else {
                        System.out.println("Data tidak ditemukan.");
                    }

                    // Kode untuk menghapus data mahasiswa
                    break;
                case 5:
                    System.out.println("\nTerima kasih!");
                    System.exit(0);
                default:
                    System.out.println("\nMaaf, pilihan tidak valid. Silakan pilih lagi.");
            }
        }
    }
}
