package labirent;

import java.util.ArrayList;

public class Puan extends Oyuncu {
GozlukluSirin gozlukluSirin=new GozlukluSirin();
TembelSirin tembelSirin=new TembelSirin();

  Altin altin=new Altin();
  
    public String puaniGoster() {

     return "puanınız: "+getSkor();
    }

    public Puan(String oyuncuId, String oyuncuAdi, String oyuncuTur) {
        super(oyuncuId, oyuncuAdi, oyuncuTur);
    }

    public Puan(String oyuncuId, String oyuncuAdi, String oyuncuTur, int skor) {
        super(oyuncuId, oyuncuAdi, oyuncuTur, skor);
    }

    public Puan() {
    }

    public GozlukluSirin getGozlukluSirin() {
        return gozlukluSirin;
    }

    public void setGozlukluSirin(GozlukluSirin gozlukluSirin) {
        this.gozlukluSirin = gozlukluSirin;
    }

    public TembelSirin getTembelSirin() {
        return tembelSirin;
    }

    public void setTembelSirin(TembelSirin tembelSirin) {
        this.tembelSirin = tembelSirin;
    }

    public Altin getAltin() {
        return altin;
    }

    public void setAltin(Altin altin) {
        this.altin = altin;
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
