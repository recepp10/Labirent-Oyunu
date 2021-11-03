package labirent;

import java.util.ArrayList;

public class GozlukluSirin extends Oyuncu {
Karakter karakter=new Karakter();
    private int karakterPozisyonX = 180;
    private int karakterPozisyonY = 150;


    public int getKarakterPozisyonX() {
        return karakterPozisyonX;
    }

    public void setKarakterPozisyonX(int karakterPozisyonX) {
        this.karakterPozisyonX = karakterPozisyonX;
    }

    public int getKarakterPozisyonY() {
        return karakterPozisyonY;
    }

    public void setKarakterPozisyonY(int karakterPozisyonY) {
        this.karakterPozisyonY = karakterPozisyonY;
    }
    Lokasyon lokasyon = new Lokasyon();

    public void solaGit() {
        if (lokasyon.getX() <= 30) {
            lokasyon.setX(30);
        } else {
            if (maze[lokasyon.getY() / 30][lokasyon.getX() / 30 - 2] == 0 || maze[lokasyon.getY() / 30][lokasyon.getX() / 30 - 1] == 0) {
                lokasyon.setX(lokasyon.getX());

            } else {
                lokasyon.setX(lokasyon.getX() - 60);

            }
        }
        karakterPozisyonX = lokasyon.getX();
        karakterPozisyonY = lokasyon.getY();
  
    }

    public void sagaGit() {
        if (lokasyon.getX() >= 360) {
            lokasyon.setX(360);
        } else {
            if (maze[lokasyon.getY() / 30][lokasyon.getX() / 30 + 2] == 0 || maze[lokasyon.getY() / 30][lokasyon.getX() / 30 + 1] == 0) {
                lokasyon.setX(lokasyon.getX());
            } else {
                lokasyon.setX(lokasyon.getX() + 60);
            }
        }
        karakterPozisyonX = lokasyon.getX();
        karakterPozisyonY = lokasyon.getY();

    }

    public void yukariGit() {
        if (lokasyon.getY() <= 30) {
            lokasyon.setY(30);
        } else {
            if (maze[lokasyon.getY() / 30 - 2][lokasyon.getX() / 30] == 0 || maze[lokasyon.getY() / 30 - 1][lokasyon.getX() / 30] == 0) {
                lokasyon.setY(lokasyon.getY());
            } else {

                lokasyon.setY(lokasyon.getY() - 60);
            }
        }
        karakterPozisyonX = lokasyon.getX();
        karakterPozisyonY = lokasyon.getY();

    }

    public void asagiGit() {

        if (lokasyon.getY() >= 270) {
            lokasyon.setY(270);
        } else {
            if (maze[lokasyon.getY() / 30 + 2][lokasyon.getX() / 30] == 0 || maze[lokasyon.getY() / 30 + 1][lokasyon.getX() / 30] == 0) {
                lokasyon.setY(lokasyon.getY());
            } else {

                lokasyon.setY(lokasyon.getY() + 60);
            }
        }
        karakterPozisyonX = lokasyon.getX();
        karakterPozisyonY = lokasyon.getY();

    }

    public GozlukluSirin(String oyuncuId, String oyuncuAdi, String oyuncuTur, int skor) {
        super(oyuncuId, oyuncuAdi, oyuncuTur, skor);
    }

    public GozlukluSirin() {
    }

    public Karakter getKarakter() {
        return karakter;
    }

    public void setKarakter(Karakter karakter) {
        this.karakter = karakter;
    }

    public Lokasyon getLokasyon() {
        return lokasyon;
    }

    public void setLokasyon(Lokasyon lokasyon) {
        this.lokasyon = lokasyon;
    }

    public ArrayList<String> getCumleler() {
        return cumleler;
    }

    public void setCumleler(ArrayList<String> cumleler) {
        this.cumleler = cumleler;
    }

    public ArrayList<String> getNumaralar() {
        return numaralar;
    }

    public void setNumaralar(ArrayList<String> numaralar) {
        this.numaralar = numaralar;
    }

    public static int[][] getMaze() {
        return maze;
    }

    public static void setMaze(int[][] maze) {
        Karakter.maze = maze;
    }

}
