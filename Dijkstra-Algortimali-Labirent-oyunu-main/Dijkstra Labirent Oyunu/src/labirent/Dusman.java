package labirent;

import java.util.ArrayList;





public class Dusman extends Karakter {
private String dusmanId;
private String dusmanAdi;
private String dusmantur;

    public String getDusmanId() {
        return dusmanId;
    }

    public void setDusmanId(String dusmanId) {
        this.dusmanId = dusmanId;
    }

    public String getDusmanAdi() {
        return dusmanAdi;
    }

    public void setDusmanAdi(String dusmanAdi) {
        this.dusmanAdi = dusmanAdi;
    }

    public String getDusmantur() {
        return dusmantur;
    }

    public void setDusmantur(String dusmantur) {
        this.dusmantur = dusmantur;
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

    public Dusman(String dusmanId, String dusmanAdi, String dusmantur) {
        this.dusmanId = dusmanId;
        this.dusmanAdi = dusmanAdi;
        this.dusmantur = dusmantur;
    }

    public Dusman() {
    }

  

}
