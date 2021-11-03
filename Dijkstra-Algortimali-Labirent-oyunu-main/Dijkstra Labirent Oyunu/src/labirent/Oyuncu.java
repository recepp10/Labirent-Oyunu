package labirent;

public class Oyuncu extends Karakter {

    private String oyuncuId;
    private String oyuncuAdi;
    private String oyuncuTur;
    private int skor = 20;

    public Oyuncu(String oyuncuId, String oyuncuAdi, String oyuncuTur) {
        this.oyuncuId = oyuncuId;
        this.oyuncuAdi = oyuncuAdi;
        this.oyuncuTur = oyuncuTur;
    }

 

    public String getOyuncuId() {
        return oyuncuId;
    }

    public void setOyuncuId(String oyuncuId) {
        this.oyuncuId = oyuncuId;
    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }

    public String getOyuncuTur() {
        return oyuncuTur;
    }

    public void setOyuncuTur(String oyuncuTur) {
        this.oyuncuTur = oyuncuTur;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }

    public Oyuncu(String oyuncuId, String oyuncuAdi, String oyuncuTur, int skor) {
        this.oyuncuId = oyuncuId;
        this.oyuncuAdi = oyuncuAdi;
        this.oyuncuTur = oyuncuTur;
        this.skor = skor;
    }

    public Oyuncu() {

    }

}
