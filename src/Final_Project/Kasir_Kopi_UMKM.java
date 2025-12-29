package Final_Project;
import java.util.*;


public class Kasir_Kopi_UMKM {

    static Scanner scan = new Scanner(System.in);
    static int total_bayar, kembali, pemasukan, totalPemasukan, total_biaya;
    static  String[] menu_Coffe = { "Susu kopi gula aren (Reguler)",
            "Susu kopi gula aren (Premium)",
            "Salted caramel latte",
            "Toffe creammy latte",
            "Butterscoth latte",
            "Butterscoth sea salt latte",
            "Americano",
            "Sunrise americano"
    };

    static String[] menu_nonCoffe = {
            "Signature choclate",
            "Candy berry",
            "Oishi bliss pudding",
            "Matcha latte",
            "Salted caramel matcha latte",
            "Sea salt matcha latte"
    };

    static int[] harga_nonCoffe = {12000,8000,8000,10000,12000,13000};
    static int[] harga_Coffe = {10000,12000,10000,12000,12000,15000,8000,10000};
    static int[] terjual_Coffe = new int[menu_Coffe.length], terjual_nonCoffe = new int[menu_nonCoffe.length];
    static boolean beli = false, aplikasi = true, login = true;

    static void menu_Coffe () {
        for (int l = 0; l < menu_Coffe.length; l++) {
            System.out.println((l + 1) + ". " + menu_Coffe[l] + " - Rp. " + harga_Coffe[l]);
        }
    }

    static void menu_nonCoffe() {
            System.out.println("\n--- MENU NON COFFEE ---");
            for (int i = 0; i < menu_nonCoffe.length; i++) {
                System.out.println((i + 1) + ". " + menu_nonCoffe[i] + " - Rp" + harga_nonCoffe[i]);
            }
        }

    static int transaksi_Coffee() {
        menu_Coffe();
        System.out.print("Pilih menu: ");
        int pilih = scan.nextInt() - 1;

        if (pilih >= 0 && pilih < menu_Coffe.length) {
            System.out.print("Jumlah: ");
            int jumlah = scan.nextInt();
            terjual_Coffe[pilih] += jumlah;
            return harga_Coffe[pilih] * jumlah;
        } else {
            System.out.println("Menu tidak valid!");
            return 0;
        }
    }

    static int transaksi_nonCoffee() {
        menu_nonCoffe();
        System.out.print("Pilih menu: ");
        int pilih = scan.nextInt() - 1;

        if (pilih >= 0 && pilih < menu_nonCoffe.length) {
            System.out.print("Jumlah: ");
            int jumlah = scan.nextInt();
            terjual_nonCoffe[pilih] += jumlah;
            return harga_nonCoffe[pilih] * jumlah;
        } else {
            System.out.println("Menu tidak valid!");
            return 0;
        }
    }

    static void menuKasir() {

        total_bayar = 0;   // reset transaksi
        beli = true;

        while (beli) {
            System.out.println("\n==================================");
            System.out.println("|| MENU KASIR ||");
            System.out.println("==================================");
            System.out.println("|| 1. Menu Coffee");
            System.out.println("|| 2. Menu Non Coffee");
            System.out.println("|| 3. Selesai");
            System.out.println("==================================");
            System.out.print("Pilih : ");
            int pilihjenis = scan.nextInt();

            switch (pilihjenis) {
                case 1:
                    total_bayar += transaksi_Coffee();
                    break;
                case 2:
                    total_bayar += transaksi_nonCoffee();
                    break;
                case 3:
                    beli = false;
                    break;
                default:
                    System.out.println("Tidak ada pilihan yang sesuai");
            }
        }

        // PEMBAYARAN SEKALI DI AKHIR
        if (total_bayar > 0) {
            System.out.println("\nTotal Bayar: Rp" + total_bayar);
            System.out.print("Uang dibayar: Rp");
            int bayar = scan.nextInt();

            if (bayar >= total_bayar) {
                kembali = bayar - total_bayar;
                System.out.println("Kembalian: Rp" + kembali);
                totalPemasukan += total_bayar;
                System.out.println("Transaksi berhasi, terimakasih telah mampir!!!\n");
            } else {
                System.out.println("Uang tidak cukup. Transaksi dibatalkan.");
            }
        }
}

    static int cari_Coffee(String nama) {
        for (int i = 0; i < menu_Coffe.length; i++) {
            if (menu_Coffe[i].equalsIgnoreCase(nama)) {
                return i; // ketemu
            }
        }
        return -1; // tidak ketemu
    }

    static int cari_nonCoffee(String nama) {
        for (int i = 0; i < menu_nonCoffe.length; i++) {
            if (menu_nonCoffe[i].equalsIgnoreCase(nama)) {
                return i;
            }
        }
        return -1;
    }

    static int ubahHarga(){
        return 0;
    }

    static int tambahMenu(){
        return 0;
    }

    static int hapusMenu(){
        return 0;
    }

    static void menuAdmin() {
        boolean admin = true;
        while (admin) {
            System.out.println("\n|| MODE ADMIN ||");
            System.out.println("|| 1. Tampilkan Menu");
            System.out.println("|| 2. Ubah Harga");
            System.out.println("|| 3. Tambah Menu");
            System.out.println("|| 4. Hapus Menu");
            System.out.println("|| 5. Kembali");
            System.out.print("|| Pilih: ");

            int pilih = scan.nextInt();

            switch (pilih) {
                case 1 -> menu_Coffe();
                case 2 -> ubahHarga();      // method lama kamu
                case 3 -> tambahMenu();
                case 4 -> hapusMenu();
                case 5 -> admin = false;
                default -> System.out.println("|| Pilihan tidak valid!");
            }
        }
    }


    static void sort_Coffee() {
        for (int i = 0; i < terjual_Coffe.length - 1; i++) {
            int maxIdx = i;

            for (int j = i + 1; j < terjual_Coffe.length; j++) {
                if (terjual_Coffe[j] > terjual_Coffe[maxIdx]) {
                    maxIdx = j;
                }
            }

            // tukar jumlah terjual
            int temp = terjual_Coffe[i];
            terjual_Coffe[i] = terjual_Coffe[maxIdx];
            terjual_Coffe[maxIdx] = temp;

            // tukar nama menu
            String tempMenu = menu_Coffe[i];
            menu_Coffe[i] = menu_Coffe[maxIdx];
            menu_Coffe[maxIdx] = tempMenu;
        }
    }

    static void sort_nonCoffee() {
        for (int i = 0; i < terjual_nonCoffe.length - 1; i++) {
            int maxIdx = i;

            for (int j = i + 1; j < terjual_nonCoffe.length; j++) {
                if (terjual_nonCoffe[j] > terjual_nonCoffe[maxIdx]) {
                    maxIdx = j;
                }
            }

            int temp = terjual_nonCoffe[i];
            terjual_nonCoffe[i] = terjual_nonCoffe[maxIdx];
            terjual_nonCoffe[maxIdx] = temp;

            String tempMenu = menu_nonCoffe[i];
            menu_nonCoffe[i] = menu_nonCoffe[maxIdx];
            menu_nonCoffe[maxIdx] = tempMenu;
        }
    }

    static void menuOwner () {
        boolean ownerMode = true;
        while (ownerMode) {
            System.out.println("|| MODE OWNER || ");
            System.out.println("|| 1.Lihat total transaksi dan menu terlaris");
            System.out.println("|| 2.Exit");
            System.out.print("|| Pilih :");
            int menuOwner = scan.nextInt();
            if (menuOwner == 1){
                System.out.println("Total Pemasukan: Rp" + totalPemasukan);
                System.out.println("\n|| PRODUK TERLARIS COFFEE \n");
                sort_Coffee();
                for (int i = 0; i < menu_Coffe.length; i++) {
                    System.out.println("|| "+menu_Coffe[i] + " | Terjual: " + terjual_Coffe[i]);
                }

                System.out.println("\n|| PRODUK TERLARIS NON COFFEE\n");
                sort_nonCoffee();
                for (int i = 0; i < menu_nonCoffe.length; i++) {
                    System.out.println("|| "+ menu_nonCoffe[i] + " | Terjual: " + terjual_nonCoffe[i]);
                }
            } else if (menuOwner == 2){
                ownerMode = false;
                System.out.println("\n|| See you next time!!\n");
            } else {
                System.out.println("|| Tidak ada menu yang sesuai");
            }
            System.out.println("\nTotal Semua Transaksi Penjualan");

            System.out.println("Total Pemasukan: Rp" + totalPemasukan);

            System.out.println("\nKembali ke menu utama...\n");

        }
    }

    static void login() {
        // Login user
        String id_user = "kris",
                pass_user = "123",
                // Login admin
                id_admin = "kay",
                pass_admin = "321",
                // login owner
                id_owner = "wee",
                pass_owner = "213";

        String username;
        String password;
        do {
            System.out.println("Masukan Username");
            username = scan.next();
            System.out.println("Masukan password");
            password = scan.next();
            if (username.equals(id_user) && password.equals(pass_user)) {
                menuKasir();
            } else if (username.equals(id_admin) && password.equals(pass_admin)) {
                menuAdmin();
            } else if (username.equals(id_owner) && password.equals(pass_owner)) {
                menuOwner();

        }else {
                System.out.println("Username atau password salah");
            }
        }while (aplikasi);
    }

    public static void main(String[] args) {
        login();
    }
}