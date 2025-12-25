package Final_Project;
import java.util.*;


public class Kasir_Kopi_UMKM {

    static Scanner scan = new Scanner(System.in);
    static int total_bayar, kembali, pemasukan, totalPemasukan;
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
    static int[] terjualCoffe, terjualnonCoffe;
    static boolean beli = false, aplikasi = true, login = true;

    static void menu_Coffe (){

    }

    static void menu_nonCoffe (){


        for (int l = 0; l < menu_nonCoffe.length; l++){
            System.out.println((l + 1) + ". " + menu_nonCoffe[l] + " - Rp. " + harga_nonCoffe[l]);
        }
    }

    static void menuKasir() {

        System.out.println("==================================");
        System.out.println("|| Menu ");
        System.out.println("==================================");
        System.out.println("|| 1.Menu Coffe");
        System.out.println("|| 2. Menu non coffe");
        int pilihjenis = scan.nextInt();
        switch (pilihjenis) {
            case 1:
                menu_Coffe();
                break;
            case 2:
                menu_nonCoffe();
                break;
            default:
                System.out.println("Tidak ada pilihan yang sesuai");
        }
    }
        static void menuAdmin () {
            boolean admin = true;
            while (admin){
                System.out.println("\n|| MODE ADMIN ||");
                System.out.println("|| Ubah harga menu ");

                System.out.println("|| 1.Menu Coffe");
                System.out.println("|| 2. Menu non coffe");
                int pilihjenis = scan.nextInt();
                switch (pilihjenis) {
                    case 1:
                        System.out.println("Daftar harga saat ini:");
                        menu_Coffe();
                        break;
                    case 2:
                        System.out.println("Daftar harga saat ini:");
                        menu_nonCoffe();
                        break;
                    default:
                        System.out.println("Tidak ada pilihan yang sesuai");
                }


                System.out.print("\nPilih nomor menu yang ingin diubah: ");
                int ubah = scan.nextInt();

                switch (pilihjenis){
                    case 1:
                        if (ubah >= 1 && ubah <= menu_Coffe.length) {
                        System.out.print("Masukkan harga baru untuk " + menu_Coffe[ubah - 1] + ": Rp");
                        int hargaBaru = scan.nextInt();

                        if (hargaBaru > 0) {
                            harga_Coffe[ubah - 1] = hargaBaru;
                            System.out.println("Harga " + menu_Coffe[ubah - 1] + " berhasil diubah menjadi Rp" + hargaBaru);
                        } else {
                            System.out.println("Harga tidak boleh nol atau negatif!");
                        }
                    } else {
                        System.out.println("Pilihan tidak valid!");
                    }
                        break;
                    case 2 :
                        if (ubah >= 1 && ubah <= menu_nonCoffe.length) {
                            System.out.print("Masukkan harga baru untuk " + menu_nonCoffe[ubah - 1] + ": Rp");
                            int hargaBaru = scan.nextInt();

                            if (hargaBaru > 0) {
                                harga_nonCoffe[ubah - 1] = hargaBaru;
                                System.out.println("Harga " + menu_nonCoffe[ubah - 1] + " berhasil diubah menjadi Rp" + hargaBaru);
                            } else {
                                System.out.println("Harga tidak boleh nol atau negatif!");
                            }
                        } else {
                            System.out.println("Pilihan tidak valid!");
                        }
                        break;

                }

                System.out.print("\nIngin ubah harga lain? (1. Ya / 2. Tidak): ");
                int lagi = scan.nextInt();
                if (lagi != 1) {
                    admin = false;
                }
            }
        }
        static void menuOwner () {
            System.out.println("|| MODE OWNER || ");
            System.out.println("Total Semua Transaksi Penjualan");

            System.out.println("Total Pemasukan: Rp" + totalPemasukan);


            System.out.println("\nKembali ke menu utama...\n");
            return;

        }

    static void login() {
        String id_user = "kris",
                pass_user = "123",
                id_admin = "kay",
                pass_admin = "321",
                id_owner = "wee",
                pass_owner = "213";

        String username;
        String password;
        do {
            System.out.println("Masukan Username");
            username = scan.next();
            System.out.println("Masukan password");
            password = scan.next();
            if (username.equals(id_user) && password.equals(pass_user) || username.equals(id_admin) && password.equals(pass_admin)){
                if (username.equals(id_user)){
                    menuKasir();
                }else if(username.equals(id_admin)) {
                    menuAdmin();
                } else {
                    menuOwner();
                }
            }else {
                System.out.println("Username atau password salah");
            }
        }while (aplikasi);
    }
}