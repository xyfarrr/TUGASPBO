import java.sql.*;
import java.util.Scanner;

public class TokoRetail {
    // Konfigurasi Database
    private static final String URL = "jdbc:mysql://localhost:3306/toko_retail"; // sesuaikan port MySQL-mu jika bukan 3306
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection conn;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            // Koneksi ke Database
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            int pilihan;
            do {
                tampilkanMenu();
                System.out.print("Pilihan : ");
                if (scanner.hasNextInt()) {
                    pilihan = scanner.nextInt();
                    scanner.nextLine(); // membersihkan buffer setelah nextInt
                } else {
                    System.out.println("Masukkan harus berupa angka!");
                    scanner.nextLine(); // membersihkan inputan salah
                    pilihan = -1;
                    continue;
                }

                switch (pilihan) {
                    case 1: tampilSemuaData(); break;
                    case 2: tambahData(); break;
                    case 3: cariData(); break;
                    case 4: ubahData(); break;
                    case 5: hapusData(); break;
                    case 0: System.out.println("Terima kasih!"); break;
                    default: System.out.println("Pilihan tidak valid!");
                }
                System.out.println();
            } while (pilihan != 0);

            conn.close();
        } catch (SQLException e) {
            System.out.println("Koneksi database gagal: " + e.getMessage());
        }
    }

    private static void tampilkanMenu() {
        System.out.println("+-----------------------------------+");
        System.out.println("|         MENU TOKO RETAIL          |");
        System.out.println("+-----------------------------------+");
        System.out.println("|  1. Tampil Semua Data             |");
        System.out.println("|  2. Tambah Data                   |");
        System.out.println("|  3. Cari Data                     |");
        System.out.println("|  4. Ubah Data                     |");
        System.out.println("|  5. Hapus Data                    |");
        System.out.println("|  0. Keluar                        |");
        System.out.println("+-----------------------------------+");
    }

    // MENU 1: Tampil Semua Data
    private static void tampilSemuaData() {
        String query = "SELECT * FROM barang";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\n+-----------------------------------------------------------+");
            System.out.println("|                 DAFTAR BARANG TOKO RETAIL                 |");
            System.out.println("+---+--------+---------------------------+-------+----------+");
            System.out.println("| # | Kode   | Nama Barang               | Harga | Stok     |");
            System.out.println("+---+--------+---------------------------+-------+----------+");

            int no = 1;
            while (rs.next()) {
                System.out.printf("| %d | %-6s | %-25s | %5d | %8d |\n",
                        no++,
                        rs.getString("kode"),
                        rs.getString("nama_barang"),
                        rs.getInt("harga"),
                        rs.getInt("stok"));
            }
            System.out.println("+---+--------+---------------------------+-------+----------+");
            System.out.println("Total: " + (no - 1) + " barang");

        } catch (SQLException e) {
            System.out.println("Gagal memuat data: " + e.getMessage());
        }
    }

    // MENU 2: Tambah Data
    private static void tambahData() {
        System.out.println("\n--- TAMBAH DATA BARANG ---");
        System.out.print("Masukkan Kode Barang : "); String kode = scanner.nextLine();
        System.out.print("Masukkan Nama Barang : "); String nama = scanner.nextLine();
        System.out.print("Masukkan Harga       : "); int harga = scanner.nextInt();
        System.out.print("Masukkan Stok        : "); int stok = scanner.nextInt();
        scanner.nextLine(); // PERBAIKAN: Membersihkan sisa buffer setelah nextInt()

        // PERBAIKAN: Definisikan nama kolom secara eksplisit agar aman jika struktur tabel berubah
        String query = "INSERT INTO barang (kode, nama_barang, harga, stok) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, kode);
            ps.setString(2, nama);
            ps.setInt(3, harga);
            ps.setInt(4, stok);
            ps.executeUpdate();
            System.out.println("Data berhasil ditambahkan!");
        } catch (SQLException e) {
            System.out.println("Gagal menambah data: " + e.getMessage());
        }
    }

    // MENU 3: Cari Data
    private static void cariData() {
        System.out.println("\n--- CARI DATA BARANG ---");
        System.out.print("Masukkan Kode / Nama Barang yang dicari: ");
        String keyword = scanner.nextLine();

        String query = "SELECT * FROM barang WHERE kode = ? OR nama_barang LIKE ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, keyword);
            ps.setString(2, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            System.out.println("\nHasil Pencarian:");
            boolean ditemukan = false;
            while (rs.next()) {
                ditemukan = true;
                System.out.println("Kode: " + rs.getString("kode") + " | Nama: " + rs.getString("nama_barang") + " | Harga: " + rs.getInt("harga") + " | Stok: " + rs.getInt("stok"));
            }
            if (!ditemukan) {
                System.out.println("Data tidak ditemukan.");
            }
        } catch (SQLException e) {
            System.out.println("Gagal mencari data: " + e.getMessage());
        }
    }

    // MENU 4: Ubah Data
    private static void ubahData() {
        System.out.println("\n--- UBAH DATA BARANG ---");
        System.out.print("Masukkan Kode Barang yang ingin diubah: ");
        String kode = scanner.nextLine();

        System.out.print("Nama Barang Baru : "); String nama = scanner.nextLine();
        System.out.print("Harga Baru       : "); int harga = scanner.nextInt();
        System.out.print("Stok Baru        : "); int stok = scanner.nextInt();
        scanner.nextLine(); // PERBAIKAN: Membersihkan sisa buffer setelah nextInt()

        String query = "UPDATE barang SET nama_barang = ?, harga = ?, stok = ? WHERE kode = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, nama);
            ps.setInt(2, harga);
            ps.setInt(3, stok);
            ps.setString(4, kode);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Data berhasil diubah!");
            else System.out.println("Kode barang tidak ditemukan.");
        } catch (SQLException e) {
            System.out.println("Gagal mengubah data: " + e.getMessage());
        }
    }

    // MENU 5: Hapus Data
    private static void hapusData() {
        System.out.println("\n--- HAPUS DATA BARANG ---");
        System.out.print("Masukkan Kode Barang yang ingin dihapus: ");
        String kode = scanner.nextLine();

        String query = "DELETE FROM barang WHERE kode = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, kode);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Data berhasil dihapus!");
            else System.out.println("Kode barang tidak ditemukan.");
        } catch (SQLException e) {
            System.out.println("Gagal menghapus data: " + e.getMessage());
        }
    }
}