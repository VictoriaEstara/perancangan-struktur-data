# Kode ini dibagikan oleh Dedad Fajar dan dapat diakses melalaui github: https://github.com/VictoriaEstara/perancangan-struktur-data
# Kode ini merupakan digunakan sebagai tugas "Challenge: Queue Implementation using Linked List in Python"
  

# Definisi kelas Node untuk representasi simpul dalam linked list
class Node:
    def __init__(self, data):
        self.data = data  # Menyimpan data di dalam simpul
        self.next = None  # Menunjuk ke simpul berikutnya dalam linked list

# Definisi kelas Queue untuk representasi struktur data antrian
class Queue:
    def __init__(self):
        self.front = None  # Menunjuk ke simpul depan antrian
        self.rear = None   # Menunjuk ke simpul belakang antrian

    # Method untuk menambahkan elemen ke belakang antrian (EnQueue)
    def enQueue(self, data):
        new_node = Node(data)  # Membuat simpul baru dengan data yang diberikan
        if self.rear is None:  # Jika antrian kosong
            self.front = self.rear = new_node  # Front dan rear menunjuk ke simpul baru
            return
        self.rear.next = new_node  # Menghubungkan simpul baru dengan simpul belakang
        self.rear = new_node       # Rear menunjuk ke simpul baru

    # Method untuk menghapus elemen dari depan antrian (DeQueue)
    def deQueue(self):
        if self.front is None:  # Jika antrian kosong
            print("Antrian kosong. Tidak ada yang dipanggil.")
            return
        temp = self.front    # Menyimpan referensi ke simpul depan yang akan dihapus
        self.front = temp.next  # Memindahkan front ke simpul berikutnya
        if self.front is None:  # Jika antrian sekarang kosong
            self.rear = None   # Mengatur rear menjadi None juga
        return temp.data     # Mengembalikan data dari simpul depan yang dihapus

    # Method untuk mencetak antrian
    def printQueue(self):
        if self.front is None:  # Jika antrian kosong
            print("Antrian kosong.")
            return
        current = self.front  # Memulai dari simpul depan
        print("Menampilkan Antrian:")
        while current:        # Melakukan iterasi sampai mencapai None (akhir antrian)
            print(current.data)  # Mencetak data dari setiap simpul
            current = current.next  # Bergerak ke simpul berikutnya

# Contoh penggunaan:
if __name__ == "__main__":
    antrian = Queue()  # Membuat objek antrian
    nomor_antrian = 1  # Variabel untuk menyimpan nomor antrian, dimulai dari 1

    while True:
        print("\n=============================")
        print("Menu:")
        print("1. Ambil Antrian")
        print("2. Panggil Antrian")
        print("3. Cetak Antrian")
        print("4. Tutup\n")
        print("=============================\n")

        pilihan = int(input("Pilihan: "))  # Membaca pilihan dari pengguna

        if pilihan == 1:
            antrian.enQueue(nomor_antrian)  # Memanggil method enQueue untuk menambahkan antrian
            print("Antrian Anda Nomor:", nomor_antrian)
            nomor_antrian += 1  # Menambah nomor antrian untuk antrian selanjutnya
        elif pilihan == 2:
            nomor = antrian.deQueue()  # Memanggil method deQueue untuk memanggil antrian
            if nomor is not None:
                print("Antrian Nomor", nomor, "Silahkan ke Loket ya!")
        elif pilihan == 3:
            antrian.printQueue()  # Memanggil method printQueue untuk mencetak antrian
        elif pilihan == 4:
            print("Terima kasih telah menggunakan layanan kami, silahkan datang kembali!")
            print("||| Akastangga Hospital Center |||\n")
            break  # Keluar dari loop jika pilihan adalah 4
        else:
            print("Pilihan tidak valid. Silakan pilih lagi.")