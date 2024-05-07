# Kode ini dibagikan oleh Dedad Fajar dan dapat diakses melalui github: https://github.com/VictoriaEstara/perancangan-struktur-data

class Mahasiswa:
    def __init__(self, nim, nama, umur, jml_saudara):
        self.nim = nim
        self.nama = nama
        self.umur = umur
        self.jml_saudara = jml_saudara
        self.next = None

    def __str__(self):
        return f"NIM = {self.nim} NAMA = {self.nama} UMUR = {self.umur} JML SAUDARA = {self.jml_saudara}"


class LinkedList:
    def __init__(self):
        self.head = None

    def add_mahasiswa(self, mahasiswa):
        if not self.head:
            self.head = mahasiswa
        else:
            current = self.head
            while current.next:
                current = current.next
            current.next = mahasiswa

    def display_mahasiswa(self):
        current = self.head
        while current:
            print(current)
            current = current.next

    def find_mahasiswa(self, nama):
        current = self.head
        while current:
            if current.nama == nama:
                return current
            current = current.next
        return None

    def delete_mahasiswa(self, nama):
        current = self.head
        prev = None
        while current:
            if current.nama == nama:
                if prev:
                    prev.next = current.next
                else:
                    self.head = current.next
                return True
            prev = current
            current = current.next
        return False


linked_list = LinkedList()

while True:
    print("\nMENU UTAMA")
    print("==========")
    print("1. Menginput Data Mahasiswa")
    print("2. Menampilkan Data Mahasiswa")
    print("3. Mengubah Data Mahasiswa")
    print("4. Menghapus Data Mahasiswa")
    print("5. EXIT\n")

    pilihan = int(input("SILAKAN PILIH MENU: "))

    if pilihan == 1:
        print("\nMenginput Data Mahasiswa")
        print("==============")

        nim = input("NIM = ")
        nama = input("NAMA = ")
        umur = int(input("UMUR = "))
        jml_saudara = int(input("JML SAUDARA = "))

        mahasiswa_baru = Mahasiswa(nim, nama, umur, jml_saudara)
        linked_list.add_mahasiswa(mahasiswa_baru)

    elif pilihan == 2:
        print("\nDATA MHS")
        print("========")
        linked_list.display_mahasiswa()

    elif pilihan == 3:
        print("\nMengubah Data Mahasiswa")
        print("==============")
        nama_yang_diubah = input("Masukkan nama yang ingin diubah: ")
        mahasiswa = linked_list.find_mahasiswa(nama_yang_diubah)
        if mahasiswa:
            opsi = input("Pilih opsi penggantian (kata atau indeks): ")
            if opsi.lower() == "kata":
                kata_yang_diganti = input("Masukkan kata yang ingin diganti: ")
                kata_pengganti = input("Masukkan kata pengganti: ")
                mahasiswa.nama = mahasiswa.nama.replace(kata_yang_diganti, kata_pengganti)
                print("Data berhasil diubah.")
            elif opsi.lower() == "indeks":
                indeks_kata = int(input("Masukkan indeks kata yang ingin diganti: "))
                kata_pengganti = input("Masukkan kata pengganti: ")
                kata = mahasiswa.nama.split(" ")
                if 0 <= indeks_kata < len(kata):
                    kata[indeks_kata] = kata_pengganti
                    mahasiswa.nama = " ".join(kata)
                    print("Data berhasil diubah.")
                else:
                    print("Indeks kata tidak valid.")
            else:
                print("Opsi tidak valid.")
        else:
            print("Data tidak ditemukan.")

    elif pilihan == 4:
        print("\nMenghapus Data Mahasiswa")
        print("==============")
        nama_yang_dihapus = input("Masukkan nama yang ingin dihapus: ")
        if linked_list.delete_mahasiswa(nama_yang_dihapus):
            print("Data berhasil dihapus.")
        else:
            print("Data tidak ditemukan.")

    elif pilihan == 5:
        print("\nTerima kasih!")
        break

    else:
        print("\nMaaf, pilihan tidak valid. Silakan pilih lagi.")
