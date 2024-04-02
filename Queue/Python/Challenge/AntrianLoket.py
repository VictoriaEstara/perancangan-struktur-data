# Kode ini dibagikan oleh Dedad Fajar dan dapat diakses melalaui github: https://github.com/VictoriaEstara/perancangan-struktur-data
# Kode ini merupakan digunakan sebagai tugas Challenge Queue using Java and Python
  

class AntrianLoket:
    MAX_SIZE = 10  # Maksimal ukuran antrian

    def __init__(self):
        self.antrian = [0] * (self.MAX_SIZE + 1)  # Inisialisasi array untuk menyimpan antrian
        self.front = 0  # Indeks depan antrian
        self.rear = -1  # Indeks belakang antrian
        self.size = 0  # Jumlah elemen dalam antrian
        self.next_number = 1  # Nomor antrian selanjutnya yang akan diambil

    def ambil_antrian(self):
        if self.size == self.MAX_SIZE:  # Jika antrian penuh
            print("Antrian penuh. Tidak bisa mengambil antrian.")
            return
        self.rear = (self.rear + 1) % (self.MAX_SIZE + 1)  # Menggerakkan rear ke indeks berikutnya (dengan modulus)
        self.antrian[self.rear] = self.next_number  # Menyimpan nomor antrian di rear
        self.next_number += 1  # Menambahkan nomor antrian selanjutnya
        self.size += 1  # Menambah jumlah elemen dalam antrian
        print("Antrian Anda Nomor:", self.antrian[self.rear])  # Menampilkan nomor antrian yang diambil

    def panggil_antrian(self):
        if self.size == 0:  # Jika antrian kosong
            print("Antrian kosong. Tidak ada yang dipanggil.")
            return
        print("Antrian Nomor", self.antrian[self.front], "Silahkan Ke Loket ya!")  # Menampilkan nomor antrian yang dipanggil
        self.front = (self.front + 1) % (self.MAX_SIZE + 1)  # Menggeser front ke indeks berikutnya (dengan modulus)
        self.size -= 1  # Mengurangi jumlah elemen dalam antrian

    def cetak_antrian(self):
        if self.size == 0:  # Jika antrian kosong
            print("Antrian kosong.")
            return
        print("Menampilkan Antrian:")
        count = self.size
        i = self.front
        while count > 0:  # Iterasi melalui semua elemen dalam antrian
            print(self.antrian[i])  # Mencetak nomor antrian
            i = (i + 1) % (self.MAX_SIZE + 1)  # Menggeser ke elemen berikutnya (dengan modulus)
            count -= 1  # Mengurangi hitungan elemen yang belum dicetak


if __name__ == "__main__":
    antrian_loket = AntrianLoket()

    while True:
        print("\n=============================")
        print("MENU:")
        print("1. Ambil Antrian")
        print("2. Panggil Antrian")
        print("3. Cetak Antrian")
        print("4. Tutup\n")
        print("=============================\n")

        pilihan = input("Pilihan: ")

        if pilihan == '1':
            antrian_loket.ambil_antrian()
        elif pilihan == '2':
            antrian_loket.panggil_antrian()
        elif pilihan == '3':
            antrian_loket.cetak_antrian()
        elif pilihan == '4':
            print("Terima kasih telah menggunakan layanan kami, silahkan datang kembali!")
            print("||| Akastangga Hospital Center |||\n")
            break
        else:
            print("Pilihan tidak valid. Silakan pilih lagi.")