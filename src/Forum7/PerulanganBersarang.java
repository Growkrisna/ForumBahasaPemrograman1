package Forum7;

import java.util.*;

public class PerulanganBersarang {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int total_biaya = 0, kembali;
        boolean beli = false, aplikasi = true;

        // Variabel baru untuk menyimpan total pemasukan
        int totalPemasukan = 0;

        // Data menu dan harga disimpan di luar agar bisa diakses semua peran
        String[] menu = {"Espresso", "Americano", "Cafe Latte", "Cafe Mocca", "Cappuccino"};
        int[] harga = {8000, 10000, 15000, 15000, 15000};

        while (aplikasi) {
            System.out.println("|| Menu Utama ||");
            System.out.println("1. Kasir");
            System.out.println("2. Admin");
            System.out.println("3. Owner");
            System.out.println("4. Exit");
            System.out.print("Pilih peranmu: ");
            int menuUtama = sc.nextInt();

            switch (menuUtama) {
                case 1:
                    beli = true;
                    total_biaya = 0; // reset setiap transaksi baru

                    while (beli) {
                        System.out.println("\n|| YOI KONO MENU ||");
                        for (int i = 0; i < menu.length; i++) {
                            System.out.println((i + 1) + ". " + menu[i] + " - Rp" + harga[i]);
                        }

                        System.out.print("Masukkan nomor menu yang anda pilih: ");
                        int pilih = sc.nextInt();

                        if (pilih >= 1 && pilih <= menu.length) {
                            System.out.println("Menu yang anda pilih : " + menu[pilih - 1]);
                            System.out.print("Masukkan jumlah yang ingin dibeli: ");
                            int jumlah = sc.nextInt();
                            int subtotal = harga[pilih - 1] * jumlah;
                            total_biaya += subtotal;
                        } else {
                            System.out.println("Pilihan tidak ada di daftar menu");
                        }

                        System.out.print("Ingin membeli menu lain? (1. Ya / 2. Tidak): ");
                        int lanjut = sc.nextInt();
                        if (lanjut != 1) {
                            beli = false;
                        }
                    }

                    System.out.println("\nTotal biaya yang harus dibayar Rp." + total_biaya);
                    System.out.print("Uang bayar: Rp");
                    int bayar = sc.nextInt();
                    kembali = bayar - total_biaya;

                    if (bayar >= total_biaya) {
                        System.out.println("Kembalian kamu: Rp" + kembali);
                        // Tambahkan transaksi sukses ke total pemasukan
                        totalPemasukan += total_biaya;
                        System.out.println("Transaksi berhasil! Pemasukan bertambah Rp" + total_biaya);
                    } else {
                        System.out.println("Uangmu kurang WOII");
                        System.out.println("Transaksi dibatalkan!");
                    }

                    System.out.println("\nKembali ke menu utama...\n");
                    break;

                case 2:
                    boolean ubahLagi = true;
                    while (ubahLagi) {
                        System.out.println("\n|| MODE ADMIN ||");
                        System.out.println("Daftar harga saat ini:");
                        for (int i = 0; i < menu.length; i++) {
                            System.out.println((i + 1) + ". " + menu[i] + " - Rp" + harga[i]);
                        }

                        System.out.print("\nPilih nomor menu yang ingin diubah: ");
                        int ubah = sc.nextInt();

                        if (ubah >= 1 && ubah <= menu.length) {
                            System.out.print("Masukkan harga baru untuk " + menu[ubah - 1] + ": Rp");
                            int hargaBaru = sc.nextInt();

                            if (hargaBaru > 0) {
                                harga[ubah - 1] = hargaBaru;
                                System.out.println("Harga " + menu[ubah - 1] + " berhasil diubah menjadi Rp" + hargaBaru);
                            } else {
                                System.out.println("Harga tidak boleh nol atau negatif!");
                            }
                        } else {
                            System.out.println("Pilihan tidak valid!");
                        }

                        System.out.print("\nIngin ubah harga lain? (1. Ya / 2. Tidak): ");
                        int lagi = sc.nextInt();
                        if (lagi != 1) {
                            ubahLagi = false;
                        }
                    }
                    System.out.println("\nKembali ke menu utama...\n");
                    break;

                case 3:
                    System.out.println("|| MODE OWNER || ");
                    System.out.println("Total Semua Transaksi Penjualan");

                    System.out.println("Total Pemasukan: Rp" + totalPemasukan);


                    System.out.println("\nKembali ke menu utama...\n");
                    break;

                case 4:
                    System.out.println("Sampai jumpa lagiii !!!");
                    aplikasi = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        }
        sc.close();
    }
}