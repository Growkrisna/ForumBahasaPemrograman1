package Final_Project;
import java.util.Scanner;

public class FPkopikelana {

    static Scanner sc = new Scanner(System.in);

    // ===== DATA MASTER =====
    static String[] menu = {
            "Kopi Susu Gula Aren Original",
            "Kopi Susu Gula Aren Creamy",
            "Signature Chocolate Latte",
            "Coffee Creamy Latte",
            "Butterscotch",
            "Butterscotch Sea Salt Latte",
            "Americano",
            "Sunrise Americano",
            "Signature Chocolate",
            "Candy Berry",
            "Pudding",
            "Matcha Latte",
            "Salted Caramel Matcha Latte",
            "Sea Salt Matcha Latte"
    };

    static int[] harga = {
            10000,12000,10000,12000,12000,15000,8000,
            10000,12000,8000,8000,10000,12000,13000
    };

    static int[] terjual = new int[menu.length];
    static int totalPemasukan = 0;

    static boolean kasirBlocked = false;
    static boolean adminBlocked = false;
    static boolean ownerBlocked = false;

    static int[] pemasukanHarian = new int[7];
    static String[] namaHari = {
            "Senin","Selasa","Rabu","Kamis","Jumat","Sabtu","Minggu"
    };

    // ================= MAIN =================
    public static void main(String[] args) {
        boolean app = true;

        while (app) {
            System.out.println("\n=== KOPI KELANA ===");
            System.out.println("1. Kasir");
            System.out.println("2. Admin");
            System.out.println("3. Owner");
            System.out.println("4. Exit");
            System.out.print("Pilih: ");
            int pilih = sc.nextInt();

            switch (pilih) {
                case 1 -> loginKasir();
                case 2 -> loginAdmin();
                case 3 -> loginOwner();
                case 4 -> app = false;
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
        System.out.println("Program selesai.");
    }

    // ================= LOGIN =================
    static boolean login(String role, int pin) {
        int kesempatan = 3;
        while (kesempatan > 0) {
            System.out.print("Masukkan PIN " + role + ": ");
            if (sc.nextInt() == pin) return true;
            kesempatan--;
            System.out.println("PIN salah! Sisa kesempatan: " + kesempatan);
        }
        System.out.println("Akun " + role + " terblokir karena salah PIN 3 kali.");
        return false;
    }

    static void loginKasir() {
        if (kasirBlocked){
            System.out.println("Akun Kasir telah terblokir.");
            return;
        }
        if (login("Kasir", 1111)) {
            menuKasir();
        }
        else {
            kasirBlocked = true;
        }
    }

    static void loginAdmin() {
        if (adminBlocked) {
            System.out.println("Akun Admin telah terblokir.");
            return;
        }
        if (login("Admin", 2222)){
            menuAdmin();
        }
        else {
            adminBlocked = true;
        }
    }

    static void loginOwner() {
        if (ownerBlocked){
            System.out.println("Akun Owner telah terblokir.");
            return;
        }
        if (login("Owner", 3333)){
            menuOwner();
        }
        else{
            ownerBlocked = true;
        }
    }

    // ================= MENU KASIR =================
    static void menuKasir() {
        boolean kasir = true;
        while (kasir) {
            System.out.println("\n--- MENU KASIR ---");
            System.out.println("1. Transaksi");
            System.out.println("2. Kembali");
            System.out.print("Pilih: ");
            int pilih = sc.nextInt();

            if (pilih == 1) transaksi();
            else kasir = false;
        }
    }

    // ================= TRANSAKSI (FIX HARI) =================
    static void transaksi() {
        int total = 0;
        int[] tempTerjual = new int[menu.length];
        boolean beli = true;

        while (beli) {
            tampilMenu();

            System.out.print("Pilih menu: ");
            int p = sc.nextInt() - 1;

            System.out.print("Jumlah: ");
            int qty = sc.nextInt();

            total += harga[p] * qty;
            tempTerjual[p] += qty;

            System.out.print("Tambah pesanan? (1.Ya / 2.Tidak): ");
            if (sc.nextInt() != 1) beli = false;
        }

        System.out.println("Total: Rp" + total);
        System.out.print("Bayar: Rp");
        int bayar = sc.nextInt();

        if (bayar >= total) {
            for (int i = 0; i < terjual.length; i++)
                terjual[i] += tempTerjual[i];

            System.out.println("Kembalian: Rp" + (bayar - total));

            // ===== FIX PEMILIHAN HARI =====
            int h;
            do {
                System.out.println("\nPilih Hari Transaksi:");
                for (int i = 0; i < namaHari.length; i++) {
                    System.out.println((i + 1) + ". " + namaHari[i]);
                }
                System.out.print("Pilih (1-7): ");
                h = sc.nextInt();

                if (h < 1 || h > 7) {
                    System.out.println("Hari tidak valid! Masukkan 1 - 7.");
                }
            } while (h < 1 || h > 7);

            pemasukanHarian[h - 1] += total;
            totalPemasukan += total;

        } else {
            System.out.println("Uang tidak cukup! Transaksi dibatalkan.");
        }
    }

    // ================= MENU ADMIN =================
    static void menuAdmin() {
        boolean admin = true;
        while (admin) {
            System.out.println("\n--- MENU ADMIN ---");
            System.out.println("1. Tampilkan Menu");
            System.out.println("2. Ubah Harga");
            System.out.println("3. Tambah Menu");
            System.out.println("4. Hapus Menu");
            System.out.println("5. Kembali");
            System.out.print("Pilih: ");
            int pilih = sc.nextInt();

            switch (pilih) {
                case 1 -> tampilMenu();
                case 2 -> ubahHarga();
                case 3 -> tambahMenu();
                case 4 -> hapusMenu();
                case 5 -> admin = false;
            }
        }
    }

    static void ubahHarga() {
        sc.nextLine();
        System.out.println("\n --- UBAH HARGA ---");
        System.out.print("Cari nama menu: ");
        String cari = sc.nextLine();

        int idx = cariMenu(cari);
        if (idx != -1) {
            System.out.print("Masukkan harga baru: Rp ");
            int baru = sc.nextInt();

            if (baru > 0) {
                harga[idx] = baru;
                System.out.println("Harga berhasil diubah!");
                tampilMenu();
            } else {
                System.out.println("Harga tidak valid!");
            }
        } else {
            System.out.println("Menu tidak ditemukan!");
        }
    }

    static void tambahMenu(){
        sc.nextLine();
        System.out.println("\n --- TAMBAH MENU ---");
        System.out.print("Nama Menu: ");
        String nama = sc.nextLine().trim();

        if (cariMenu(nama) != -1) {
            System.out.println("Nama menu sudah ada. Silahkan memasukkan nama lainnya.");
            return;
        }

        System.out.print("Harga Menu: Rp ");
        int hargaTambah = sc.nextInt();

        if (hargaTambah <= 0){
            System.out.println("Harga tidak valid!");
            return;
        }

        String[] menuBaru = new String[menu.length + 1];
        int[] hargaBaru = new int[harga.length + 1];
        int[] terjualBaru = new int[terjual.length + 1];

        for (int i = 0; i < menu.length; i++) {
            menuBaru[i] = menu[i];
            hargaBaru[i] = harga[i];
            terjualBaru[i] = terjual[i];
        }

        menuBaru[menu.length] = nama;
        hargaBaru[harga.length] = hargaTambah;
        terjualBaru[terjual.length] = 0;

        menu = menuBaru;
        harga = hargaBaru;
        terjual = terjualBaru;

        System.out.println("Menu berhasil ditambahkan!");
        tampilMenu();
    }


    static void hapusMenu() {
        sc.nextLine();
        System.out.print("Cari menu: ");
        String nama = sc.nextLine();
        int idx = cariMenu(nama);
        if (idx == -1) return;

        String[] menuBaru = new String[menu.length - 1];
        int[] hargaBaru = new int[harga.length - 1];
        int[] terjualBaru = new int[terjual.length - 1];

        int j = 0;
        for (int i = 0; i < menu.length; i++) {
            if (i != idx) {
                menuBaru[j] = menu[i];
                hargaBaru[j] = harga[i];
                terjualBaru[j] = terjual[i];
                j++;
            }
        }

        menu = menuBaru;
        harga = hargaBaru;
        terjual = terjualBaru;

        System.out.println("Menu berhasil dihapus!");
        tampilMenu();
    }

    // ================= MENU OWNER =================
    static void menuOwner() {
        boolean owner = true;
        while (owner) {
            System.out.println("\n--- MENU OWNER ---");
            System.out.println("1. Total Pemasukan");
            System.out.println("2. 5 Menu Terlaris");
            System.out.println("3. Pemasukan Harian");
            System.out.println("4. Cari Menu");
            System.out.println("5. Kembali");
            System.out.print("Pilih: ");
            int p = sc.nextInt();

            if (p == 1) System.out.println("Rp" + totalPemasukan);
            else if (p == 2) menuTerlaris();
            else if (p == 3) tampilPemasukanHarian();
            else if (p == 4) cariMenuOwner();
            else owner = false;
        }
    }

    // ================= METHOD PENDUKUNG =================
    static void tampilMenu() {
        selectionSortNama(menu, harga, terjual);
        for (int i = 0; i < menu.length; i++)
            System.out.println((i+1)+". "+menu[i]+" - Rp"+harga[i]);
    }

    static int cariMenu(String nama) {
        for (int i = 0; i < menu.length; i++)
            if (menu[i].equalsIgnoreCase(nama)) return i;
        return -1;
    }

    static void cariMenuOwner() {
        sc.nextLine();
        System.out.print("Cari menu: ");
        String cari = sc.nextLine();

        for (int i = 0; i < menu.length; i++) {
            if (menu[i].equalsIgnoreCase(cari)) {
                System.out.println(menu[i]+" | Rp"+harga[i]+" | Terjual: "+terjual[i]);
                return;
            }
        }
        System.out.println("Menu tidak ditemukan.");
    }

    static void menuTerlaris() {
        selectionSortTerjual(menu, harga, terjual);
        for (int i = 0; i < 5 && i < menu.length; i++)
            System.out.println(menu[i]+" - "+terjual[i]);
    }

    static void tampilPemasukanHarian() {
        for (int i = 0; i < 7; i++)
            System.out.println(namaHari[i]+" : Rp"+pemasukanHarian[i]);
    }

    // ================= SORTING =================
    static void selectionSortNama(String[] m, int[] h, int[] t) {
        for (int i = 0; i < m.length-1; i++) {
            int min = i;
            for (int j = i+1; j < m.length; j++)
                if (m[j].compareToIgnoreCase(m[min]) < 0)
                    min = j;
            swap(m,h,t,i,min);
        }
    }

    static void selectionSortTerjual(String[] m, int[] h, int[] t) {
        for (int i = 0; i < t.length-1; i++) {
            int max = i;
            for (int j = i+1; j < t.length; j++)
                if (t[j] > t[max])
                    max = j;
            swap(m,h,t,i,max);
        }
    }

    static void swap(String[] m, int[] h, int[] t, int i, int j) {
        String tm = m[i]; m[i] = m[j]; m[j] = tm;
        int th = h[i]; h[i] = h[j]; h[j] = th;
        int tt = t[i]; t[i] = t[j]; t[j] = tt;
    }
}