import java.util.Scanner;

public class forumswichcase {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);

        String nama_menu = "",
                sub_menu = "";
        int harga = 0,
                jumlah = 0,
                totalbiaya = 0;

        double diskon = 0,
                biayaakhir = 0;

        char memiliki_member;

        System.out.println("||  Warung Sederhana ||");
        System.out.println("________________________");
        System.out.println("------ Menu Makanan ------");
        System.out.println("1. Sate");
        System.out.println("2. Pecel");
        System.out.println("3. Penyetan");
        System.out.println("________________________");

        System.out.println("Ketik angka menu yang ingin dipilih (1 -3)");
        int pilihan_menu = a.nextInt();

        switch (pilihan_menu){
            case 1:
                System.out.println("Daftar menu sate");
                System.out.println("1. Sate ayam : 1.500 per tusuk");
                System.out.println("2. Sate kambing : 3.000 per tusuk");
                int pilihan_sate = a.nextInt();

                if (pilihan_sate == 1) {
                    sub_menu = "Sate Ayam";
                    harga = 1500;
                } else if (pilihan_sate == 2) {
                    sub_menu = "Sate Kambing";
                    harga = 3000;
                } else {
                    System.out.println("Pilihan tidak valid!");
                    return;
                }
                    nama_menu = "Sate";
                    break;

            case 2 :
                System.out.println("Daftar menu pecel");
                System.out.println("1. Lauk ayam : 13.000 per porsi");
                System.out.println("2. Lauk empal :15.000 per porsi");
                int pilihan_pecel = a.nextInt();

                if (pilihan_pecel == 1) {
                    sub_menu = "Pecel lauk ayam";
                    harga = 13000;
                } else if (pilihan_pecel == 2) {
                    sub_menu = "Pecel lauk empal";
                    harga = 15000;
                } else {
                    System.out.println("Pilihan tidak valid!");
                    return;
                }
                nama_menu = "Pecel";
                break;

            case 3:
                System.out.println("Daftar menu penyetan");
                System.out.println("1. Lauk tahu/tempe : 5.000 per porsi");
                System.out.println("2. Lauk telur :7.000 per porsi");
                System.out.println("1. Lauk ayam : 10.000 per porsi");
                int pilihan_penyetan = a.nextInt();

                if (pilihan_penyetan == 1) {
                    sub_menu = "Pecel lauk tahu/tempe";
                    harga = 5000;
                } else if (pilihan_penyetan == 2) {
                    sub_menu = "Pecel lauk telur";
                    harga = 7000;
                } else if (pilihan_penyetan == 3) {
                    sub_menu = "Pecel lauk telur";
                    harga = 10000;
                } else {
                    System.out.println("Pilihan tidak valid!");
                    return;
                }
                nama_menu = "Penyetan";
                break;
            default:
                System.out.println("Pilihan menu tidak valid");
                return;
        }
        System.out.println("Masukan jumlah yang dibeli");
        jumlah = a.nextInt();

        totalbiaya = harga * jumlah;

        System.out.print("Apakah memiliki kartu member? (y/t): ");
        memiliki_member = a.next().charAt(0);

        // Hitung diskon dan biaya akhir
        if (memiliki_member == 'y' || memiliki_member == 'Y') {
            diskon = totalbiaya * 0.05;
            biayaakhir = totalbiaya - diskon;
        } else {
            biayaakhir = totalbiaya;
        }

        //  BIAYA AKHIR

        System.out.println("________________________");
        System.out.println("|| Struk Pembayaran ||");
        System.out.println("________________________");
        System.out.println("Menu         : " + nama_menu);
        System.out.println("Jenis        : " + sub_menu);
        System.out.println("Harga Satuan : Rp " + harga);
        System.out.println("Jumlah       : " + jumlah);
        System.out.println("Total Biaya  : Rp " + totalbiaya);
        System.out.println("Member       : " + (memiliki_member == 'y' || memiliki_member == 'Y' ? "Ya" : "Tidak"));

        if (memiliki_member == 'y' || memiliki_member == 'Y') {
            System.out.println("Diskon (5%) : Rp " + diskon);
        }

        System.out.println("Biaya Akhir  : Rp " + biayaakhir);
    }
}
