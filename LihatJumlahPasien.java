import java.util.ArrayList;
import java.util.Scanner;

public class LihatJumlahPasien {

    static class Pasien {
        String nama;
        int umur;
        String alamat;
        String keluhan;

        public Pasien(String nama, int umur, String alamat, String keluhan) {
            this.nama = nama;
            this.umur = umur;
            this.alamat = alamat;
            this.keluhan = keluhan;
        }

        @Override
        public String toString() {
            return "Nama: " + nama + ", Umur: " + umur + ", Alamat: " + alamat + ", Keluhan: " + keluhan;
        }
    }

    static ArrayList<Pasien> daftarPasien = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    // Fitur 1: Pendaftaran Pasien Baru
    public static void pendaftaranPasienBaru() {
        System.out.print("Masukkan nama pasien: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan umur pasien: ");
        int umur = scanner.nextInt();
        scanner.nextLine(); // Bersihkan buffer
        System.out.print("Masukkan alamat pasien: ");
        String alamat = scanner.nextLine();
        System.out.print("Masukkan keluhan pasien: ");
        String keluhan = scanner.nextLine();

        daftarPasien.add(new Pasien(nama, umur, alamat, keluhan));
        System.out.println("Pasien berhasil didaftarkan!");
    }

    // Fitur 2: Menampilkan daftar pasien
    public static void tampilkanDaftarPasien() {
        if (daftarPasien.isEmpty()) {
            System.out.println("Belum ada pasien.");
        } else {
            System.out.println("Daftar Pasien:");
            for (Pasien pasien : daftarPasien) {
                System.out.println(pasien);
            }
        }
    }

    // Fitur 3: Cari pasien berdasarkan nama
    public static void cariPasien() {
        System.out.print("Masukkan nama pasien yang ingin dicari: ");
        String nama = scanner.nextLine();
        boolean ditemukan = false;

        for (Pasien pasien : daftarPasien) {
            if (pasien.nama.equalsIgnoreCase(nama)) {
                System.out.println("Data Pasien Ditemukan: " + pasien);
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Pasien dengan nama " + nama + " tidak ditemukan.");
        }
    }

    // Fitur 4: Edit data pasien
    public static void editDataPasien() {
        System.out.print("Masukkan nama pasien yang ingin diedit: ");
        String nama = scanner.nextLine();
        boolean ditemukan = false;

        for (Pasien pasien : daftarPasien) {
            if (pasien.nama.equalsIgnoreCase(nama)) {
                System.out.print("Masukkan nama baru (tekan Enter jika tidak ingin mengubah): ");
                String namaBaru = scanner.nextLine();
                if (!namaBaru.isEmpty()) {
                    pasien.nama = namaBaru;
                }

                System.out.print("Masukkan umur baru (atau 0 jika tidak ingin mengubah): ");
                int umurBaru = scanner.nextInt();
                if (umurBaru != 0) {
                    pasien.umur = umurBaru;
                }
                scanner.nextLine();

                System.out.print("Masukkan alamat baru (tekan Enter jika tidak ingin mengubah): ");
                String alamatBaru = scanner.nextLine();
                if (!alamatBaru.isEmpty()) {
                    pasien.alamat = alamatBaru;
                }

                System.out.print("Masukkan keluhan baru (tekan Enter jika tidak ingin mengubah): ");
                String keluhanBaru = scanner.nextLine();
                if (!keluhanBaru.isEmpty()) {
                    pasien.keluhan = keluhanBaru;
                }

                System.out.println("Data pasien berhasil diubah.");
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Pasien dengan nama " + nama + " tidak ditemukan.");
        }
    }

    // Fitur 5: Hapus data pasien
    public static void hapusDataPasien() {
        System.out.print("Masukkan nama pasien yang ingin dihapus: ");
        String nama = scanner.nextLine();
        boolean ditemukan = false;

        for (int i = 0; i < daftarPasien.size(); i++) {
            if (daftarPasien.get(i).nama.equalsIgnoreCase(nama)) {
                daftarPasien.remove(i);
                System.out.println("Pasien dengan nama " + nama + " berhasil dihapus.");
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Pasien dengan nama " + nama + " tidak ditemukan.");
        }
    }

    // Fitur 6: Jumlah pasien terdaftar
    public static void jumlahPasien() {
        System.out.println("Jumlah pasien terdaftar: " + daftarPasien.size());
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nPilih opsi:");
            System.out.println("1. Pendaftaran Pasien Baru");
            System.out.println("2. Lihat Daftar Pasien");
            System.out.println("3. Cari Pasien");
            System.out.println("4. Edit Data Pasien");
            System.out.println("5. Hapus Data Pasien");
            System.out.println("6. Jumlah Pasien Terdaftar");
            System.out.println("7. Keluar");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Bersihkan buffer

            switch (pilihan) {
                case 1:
                    pendaftaranPasienBaru();
                    break;
                case 2:
                    tampilkanDaftarPasien();
                    break;
                case 3:
                    cariPasien();
                    break;
                case 4:
                    editDataPasien();
                    break;
                case 5:
                    hapusDataPasien();
                    break;
                case 6:
                    jumlahPasien();
                    break;
                case 7:
                    System.out.println("Keluar dari program.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
    }
}
