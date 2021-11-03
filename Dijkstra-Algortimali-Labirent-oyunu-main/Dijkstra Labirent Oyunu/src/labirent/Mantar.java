package labirent;

import java.util.ArrayList;
import java.util.Random;

public class Mantar extends Obje {

   Karakter karakter=new Karakter();
           
    Oyuncu oyuncu = new Oyuncu();
    public static ArrayList<Mantar> mantarlar = new ArrayList<Mantar>();
    Altin altin = new Altin();
    Random r = new Random();
    private int x;
    private int y;

    public Karakter getKarakter() {
        return karakter;
    }

    public void setKarakter(Karakter karakter) {
        this.karakter = karakter;
    }

    public Oyuncu getOyuncu() {
        return oyuncu;
    }

    public void setOyuncu(Oyuncu oyuncu) {
        this.oyuncu = oyuncu;
    }

    public static ArrayList<Mantar> getMantarlar() {
        return mantarlar;
    }

    public static void setMantarlar(ArrayList<Mantar> mantarlar) {
        Mantar.mantarlar = mantarlar;
    }

    public Random getR() {
        return r;
    }

    public void setR(Random r) {
        this.r = r;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Mantar(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Mantar() {
    }

    @Override
    public void objeOlustur() {

        while (true) {
            x = 1 + r.nextInt(11);
            y = 1 + r.nextInt(9);
            for (Altin altin : altin.altinlar) {
                if (x == altin.getX() && y == altin.getY()) {
                    x = 1 + r.nextInt(11);
                    y = 1 + r.nextInt(10);
                }
            }
            if (karakter.maze[y][x] == 1) {
                break;
            }

           

        }
 mantarlar.add(new Mantar(x, y));
    }

    @Override
    public void objeSil() {
        mantarlar.removeAll(mantarlar);
    }

}
