package Logima;
import java.util.*;

    public class Program {
        private static Scanner input = new Scanner(System.in);

        public static void main(String[] args) {
            int bangun, x, y, z;

            System.out.println("ingin mencari volume bangun ruang apa? " + "1. Balok / kubus " + "2. Silinder " + "3. Limas segiempat " + "4. Prisma Segitiga");
            bangun = input.nextInt();
            if (bangun == 1) {
                System.out.println("Masukan panjang");
                x = input.nextInt();
                System.out.println("Masukan lebar");
                y = input.nextInt();
                System.out.println("Masukan tinggi");
                z = input.nextInt();
                System.out.println("Volume: " + baloknkubus(x, y, z));
            } else {
                if (bangun == 2) {
                    System.out.println("Masukan luas");
                    x = input.nextInt();
                    System.out.println("Masukan jari-jari");
                    y = input.nextInt();
                    System.out.println("Volume : " + silinder(x, y));
                } else {
                    if (bangun == 3) {
                        System.out.println("Masukan tinggi");
                        x = input.nextInt();
                        System.out.println("Masukan panjang");
                        y = input.nextInt();
                        System.out.println("Masukan lebar");
                        z = input.nextInt();
                        System.out.println("Volume : " + limas(x, y, z));
                    } else {
                        if (bangun == 4) {
                            System.out.println("Masukan alas");
                            x = input.nextInt();
                            System.out.println("Masukan tinggi");
                            y = input.nextInt();
                            System.out.println("Masukan tinggiprisma");
                            z = input.nextInt();
                            System.out.println("Volume : " + prisma(x, y, z));
                        } else {
                            System.out.println("Tidak ada bangun ruang yang sesuai");
                        }
                    }
                }
            }
        }

        public static int baloknkubus(int p, int l, int t) {
            int kubusnbalok;

            kubusnbalok = p * l * t;

            return kubusnbalok;
        }

        public static double limas(double panjangLimas, double tinggiLimas, int lebarlimas) {
            double limas;

            limas = panjangLimas * tinggiLimas * lebarlimas / 3;

            return limas;
        }

        public static double prisma(double alas, double tinggi, double tinggiprisma) {
            double volume;

            volume = alas * tinggi * tinggiprisma * 1 / 2;

            return volume;
        }

        public static double silinder(double r, double t) {
            double phy, silinder;

            phy = (double) 22 / 7;
            silinder = r * r * t * phy;

            return silinder;
        }
    }
