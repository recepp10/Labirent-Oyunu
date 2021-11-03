package labirent;

import java.util.ArrayList;
import java.util.Random;

public class Altin extends Obje {

    private int x;
    private int y;
    public static ArrayList<Altin> altinlar = new ArrayList<Altin>();
    Random r = new Random();
    GozlukluSirin gozlukluSirin = new GozlukluSirin();
    TembelSirin tembelSirin = new TembelSirin();
    Karakter karakter = new Karakter();
    Oyuncu oyuncu = new Oyuncu();


    public Altin(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Altin() {
    }

    @Override
    public void objeOlustur() {
        for (int i = 0; i < 5; i++) {

            while (true) {
                x = 1 + r.nextInt(11);
                y = 1 + r.nextInt(9);

                for (Altin altin : altinlar) {
                    if (x == altin.getX() && y == altin.getY()) {
                        x = 1 + r.nextInt(11);
                        y = 1 + r.nextInt(9);
                    }

                }


                if (karakter.maze[y][x] == 1) {
                    break;
                }

            }

            altinlar.add(new Altin(x, y));

        }

    }

    @Override
    public void objeSil() {
        altinlar.removeAll(altinlar);
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

}
