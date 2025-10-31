package Forum7;

import java.util.*;
public class PerulanganBersarang {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int total_biaya = 0, kembali,
                harga = 0;

        boolean beli = false, aplikasi = true;
        while (aplikasi == true) {

            System.out.println("|| Menu Utama ||");
            System.out.println("|| 1.Kasir");
            System.out.println("|| 2.Admin");
            System.out.println("|| 3.Owner");
            System.out.println("|| 4.Exit");
            System.out.println("|| Pilih peranmu");
            int menuUtama = sc.nextInt();

            switch (menuUtama) {
                case 1:
                    beli = true;

                    while (beli == true) {

                        String[] menu = {"Espresso", "Amercano", "Cafe Latte", "Cafe Mocca", "Cappuccino"};

                        System.out.println("|| YOI KONO MENU ||");
                        int length = menu.length;
                        for (int i = 0; i < menu.length; i++) {
                            System.out.println((i + 1) + ". " + menu[i]);
                        }

                        System.out.println("|| Masukan nomor menu yang anda pilih ||");
                        int pilih = sc.nextInt();

                        if (pilih >= 1 && pilih <= menu.length) {
                            System.out.println("Menu yang anda pilih : " + menu[pilih - 1]);
                        } else {
                            System.out.println("Pilihan tidak ada di daftar menu");
                        }

                        switch (pilih) {
                            case 1:
                                harga = harga + 8000;
                                break;

                            case 2:
                                harga = harga + 10000;
                                break;

                            case 3:
                                harga = harga + 15000;
                                break;

                            case 4:
                                harga = harga + 15000;
                                break;

                            case 5:
                                harga = harga + 15000;
                                break;

                            default:
                                System.out.println("Tidak ada pilihan benar");
                                break;

                        }

                        System.out.println("|| Ingin membeli menu lain? 1. Ya 2. Tidak||");
                        int lanjut = sc.nextInt();

                        if (lanjut == 1) {
                            total_biaya = total_biaya + harga;
                        } else {
                            beli = false;
                            total_biaya = total_biaya + harga;
                        }

                    }
                    System.out.println("total biaya yang harus dibayar Rp." + total_biaya);

                    System.out.print("Uang bayar : ");
                    int bayar = sc.nextInt();

                    kembali = bayar - total_biaya;

                    if (bayar >= total_biaya) {
                        System.out.println("Kembalian kamu : " + kembali);
                    } else {
                        System.out.println("Uangmu kurang WOII");
                    }

                    System.out.println("");
                    System.out.println("Kembali ke menu utama");
                    System.out.println("");
                    break;
                case 2:
                case 3:
                case 4:
                    System.out.println("Sampai jumpa lagiii !!!");
                    System.exit(0);
                    break;
                default:
            }
        }








    }
}
