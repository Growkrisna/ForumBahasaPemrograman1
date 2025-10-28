//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class forum4ifelse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int member = 1;
        int nonmember = 0;

        System.out.println("|| Kasir Dengan Banyak Diskon ||");
        System.out.print("|| Apakah memiliki member? (1 = ya, 0 = tidak): ");
        int identity = in.nextInt();

        System.out.print("|| Masukan harga barang 1: ");
        double barang1 = in.nextDouble();

        System.out.print("|| Masukan harga barang 2: ");
        double barang2 = in.nextDouble();

        double total = barang1 + barang2;
        System.out.println();
        System.out.println("|| Total harga sebelum diskon: " + total);
        System.out.println();
        double diskon10 = 0.1,
                diskon20 = 0.2,
                diskon30 = 0.3,
                diskonmember = 0.05;

        double awaldiskon = 0 ,
                totaldiskon = 0,
                diskonakhir = 0;

        // diskon?
        if (total > 100000 && total <= 200000) {
            awaldiskon = total * diskon10;
            System.out.println("|| Dapat diskon 10%");
        } else if (total > 200000 && total <= 300000) {
            awaldiskon = total * diskon20;
            System.out.println("|| Dapat diskon 20% ||");
        } else if (total > 300000 && total <= 400000) {
            awaldiskon = total * diskon30;
            System.out.println("|| dapat diskon 30% ||");
        } else {
            awaldiskon = 0;
        }
        System.out.println("");
        double diskonawal = total - awaldiskon;
        System.out.println("|| Potongan harga menjadi :" +diskonawal);
        System.out.println("");

        // ekstra diskon?
        if (identity == member) {
            diskonakhir = (total - awaldiskon) * diskonmember ;
        } else {
            diskonakhir = awaldiskon;
        }

        double totalbayar = total - awaldiskon - diskonakhir;
        System.out.println("|| total diskon untuk member :" +totalbayar);
        System.out.println();
        System.out.println("|| Total diskon yang didapat: " +awaldiskon+ " dan " +diskonakhir);
        System.out.println("");
        System.out.println("|| Total yang harus dibayar: " + totalbayar+ "||");
        System.out.print("|| Masukan nominal pembayaran : ");
        double pembayaran = in.nextDouble();

        double kembalian = pembayaran - totalbayar;

        if (kembalian == 0) {
            System.out.println("|| Uang pas");
        } else {
            System.out.println("|| Kembalianmu " + kembalian);
        }
    }
}