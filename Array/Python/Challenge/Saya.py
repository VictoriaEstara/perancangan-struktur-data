# Kode ini dibagikan oleh Dedad Fajar dan dapat diakses melalui github: https://github.com/VictoriaEstara/perancangan-struktur-data

class Mahasiswa:
    def __init__(self, nim, nama, umur, jml_saudara):
        self.nim = nim
        self.nama = nama
        self.umur = umur
        self.jml_saudara = jml_saudara

mahasiswa_list = []

def input_data_mahasiswa():
    nim = input("NIM : ")
    nama = input("Nama : ")
    umur = input("Umur : ")
    jml_saudara = input("Jumlah Saudara : ")
    mahasiswa = Mahasiswa(nim, nama, umur, jml_saudara)
    mahasiswa_list.append(mahasiswa)
    print("\nData mahasiswa berhasil disimpan.\n")

def tampil_data_mahasiswa():
    if not mahasiswa_list:
        print("Belum ada data mahasiswa yang tersimpan.\n")
        return
    print("\nData Mahasiswa")
    print("----------------------")
    for idx, mahasiswa in enumerate(mahasiswa_list, 1):
        print(f"{idx}. NIM : {mahasiswa.nim} Nama : {mahasiswa.nama} Umur : {mahasiswa.umur} Jumlah Saudara : {mahasiswa.jml_saudara}")
    print()

def main():
    while True:
        print("Menu Utama")
        print("----------------------")
        print("1. Input Data Mahasiswa")
        print("2. Menampilkan Data Mahasiswa")
        print("3. Exit")
        choice = input("\nPilihlah Menu Berikut : ")
        
        if choice == '1':
            print("\nInput Data Mahasiswa")
            print("----------------------")
            input_data_mahasiswa()
        elif choice == '2':
            tampil_data_mahasiswa()
        elif choice == '3':
            print("Terima kasih telah menggunakan program ini.")
            break
        else:
            print("Pilihan tidak valid. Silakan pilih menu yang tersedia.\n")

if __name__ == "__main__":
    main()
