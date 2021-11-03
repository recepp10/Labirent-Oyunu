package labirent;

public class TembelSirin extends Oyuncu {

    Lokasyon lokasyon = new Lokasyon();
    private int karakterPozisyonX = 180;
    private int karakterPozisyonY = 150;
    Oyuncu oyuncu = new Oyuncu();
    Karakter karakter = new Karakter();
    Dusman dusman = new Dusman();
    Azman azman = new Azman();

    public void solaGit() {
        if (lokasyon.getX() <= 30) {
            lokasyon.setX(30);
        } else {
            if (maze[lokasyon.getY() / 30][lokasyon.getX() / 30 - 1] == 0) {
                lokasyon.setX(lokasyon.getX());
            } else {
                lokasyon.setX(lokasyon.getX() - 30);
            }
        }
        karakterPozisyonX = lokasyon.getX();

        karakterPozisyonY = lokasyon.getY();

        
        setSkor(getSkor() + 10);

    }

    public void sagaGit() {
        if (lokasyon.getX() >= 360) {
            lokasyon.setX(360);
        } else {
            if (maze[lokasyon.getY() / 30][lokasyon.getX() / 30 + 1] == 0) {
                lokasyon.setX(lokasyon.getX());
            } else {
                lokasyon.setX(lokasyon.getX() + 30);
            }
        }
        karakterPozisyonX = lokasyon.getX();
        karakterPozisyonY = lokasyon.getY();
 
    }

    public void yukariGit() {
        if (lokasyon.getY() <= 30) {
            lokasyon.setY(30);
        } else {
            if (maze[lokasyon.getY() / 30 - 1][lokasyon.getX() / 30] == 0) {
                lokasyon.setY(lokasyon.getY());
            } else {

                lokasyon.setY(lokasyon.getY() - 30);
            }
        }
        karakterPozisyonX = lokasyon.getX();
        karakterPozisyonY = lokasyon.getY();
    
    }

    public void asagiGit() {

        if (lokasyon.getY() >= 270) {
            lokasyon.setY(270);
        } else {
            if (maze[lokasyon.getY() / 30 + 1][lokasyon.getX() / 30] == 0) {
                lokasyon.setY(lokasyon.getY());
            } else {

                lokasyon.setY(lokasyon.getY() + 30);
            }
        }
        karakterPozisyonX = lokasyon.getX();
        karakterPozisyonY = lokasyon.getY();

    }

    public Lokasyon getLokasyon() {
        return lokasyon;
    }

    public void setLokasyon(Lokasyon lokasyon) {
        this.lokasyon = lokasyon;
    }

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

    public TembelSirin(String oyuncuId, String oyuncuAdi, String oyuncuTur, int skor) {
        super(oyuncuId, oyuncuAdi, oyuncuTur, skor);
    }

    public TembelSirin() {
    }

}
