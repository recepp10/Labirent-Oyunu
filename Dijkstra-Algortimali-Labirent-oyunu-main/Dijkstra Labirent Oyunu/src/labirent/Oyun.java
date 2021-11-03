package labirent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.*;
import static labirent.Mantar.mantarlar;

public class Oyun extends JPanel implements KeyListener, ActionListener {

    View view = new View("oyun ekranı");
    Azman azman = new Azman();
    Gargamel gargamel = new Gargamel();

    int gargamelX;
    int gargamelY;

    public Lokasyon lokasyon = new Lokasyon(180, 150);
    GozlukluSirin gozlukluSirin = new GozlukluSirin();
    Mantar mantar = new Mantar();
    Altin altin = new Altin();
    Puan puan = new Puan();
    Random random = new Random();
    TembelSirin tembelSirin = new TembelSirin();
    Karakter karakterSınıf = new Karakter();

    Oyuncu oyuncu = new Oyuncu();
    String karakter;
    Timer timer = new Timer(1, this);
    private BufferedImage gozluklu;
    private BufferedImage sirine;
    private BufferedImage tembel;
    private BufferedImage altinPng;
    private BufferedImage mantarPng;
    private BufferedImage gargamelPng;
    private BufferedImage azmanPng;
    private int kareBoyut = 30;
    Dusman dusman = new Dusman();
    public double gecenSure = 0;
    public double gecenSure2 = 0;
    int dusmanKontrol;
    int dusmanSayac = 0;
    int azmanX;
    int azmanY;

    public Oyun() {
        for (String karakterKapısı : karakterSınıf.cumleler) {
            dusmanSayac++;

            if (karakterKapısı.charAt(9) == 'A' || karakterKapısı.charAt(9) == 'a') {
                dusmanKontrol = 1;
                if (karakterKapısı.charAt(20) == 'A' || karakterKapısı.charAt(20) == 'a') {
                    azmanX = 3;
                    azmanY = 0;
                }
                if (karakterKapısı.charAt(20) == 'B' || karakterKapısı.charAt(20) == 'b') {
                    azmanX = 10;
                    azmanY = 0;
                }
                if (karakterKapısı.charAt(20) == 'C' || karakterKapısı.charAt(20) == 'c') {
                    azmanX = 0;
                    azmanY = 5;
                }
                if (karakterKapısı.charAt(20) == 'D' || karakterKapısı.charAt(20) == 'd') {
                    azmanX = 3;
                    azmanY = 10;
                }
            } else {
                dusmanKontrol = 2;
                if (karakterKapısı.charAt(23) == 'A' || karakterKapısı.charAt(23) == 'a') {
                    gargamelX = 3;
                    gargamelY = 0;
                }
                if (karakterKapısı.charAt(23) == 'B' || karakterKapısı.charAt(23) == 'b') {
                    gargamelX = 10;
                    gargamelY = 0;
                }
                if (karakterKapısı.charAt(23) == 'C' || karakterKapısı.charAt(23) == 'c') {
                    gargamelX = 0;
                    gargamelY = 5;
                }
                if (karakterKapısı.charAt(23) == 'D' || karakterKapısı.charAt(23) == 'd') {
                    gargamelX = 3;
                    gargamelY = 10;
                }
            }
        }
        if (dusmanSayac == 2) {
            dusmanKontrol = 3;
        }
        try {
            gozluklu = ImageIO.read(new FileInputStream(new File("gözlüklü.png")));
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            sirine = ImageIO.read(new FileInputStream(new File("sirine.jpg")));
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tembel = ImageIO.read(new FileInputStream(new File("tembel.png")));
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            altinPng = ImageIO.read(new FileInputStream(new File("coin.png")));
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            mantarPng = ImageIO.read(new FileInputStream(new File("mushroom.png")));
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            azmanPng = ImageIO.read(new FileInputStream(new File("azman.jpg")));
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            gargamelPng = ImageIO.read(new FileInputStream(new File("gargamel.jpg")));
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        timer.start();
        String secim = "Lütfen oyuna başlamadan önce\n"
                + "aşağıdaki karakterlerden birini seçiniz\n"
                + "\n1-Gözlüklü Şirin\n\n2-Tembel Şirin\n\n";

        karakter = JOptionPane.showInputDialog(secim);

        while (true) {
            if (karakter.equals("1") || karakter.equals("2")) {
                break;
            }

            karakter = JOptionPane.showInputDialog("Hatalı Seçim !!! \n\n"
                    + "Lütfen oyuna başlamadan önce"
                    + "\naşağıdaki karakterlerden birini seçiniz\n\n"
                    + "1-Gözlüklü Şirin\n\n2-Tembel Şirin\n\n");

        }

        oyuncu.setOyuncuId(karakter);

    }

    @Override
    public void paint(Graphics g) {

        gecenSure++;
        gecenSure2++;
        g.translate(50, 50);
        super.paint(g);
        for (int row = 0; row < karakterSınıf.maze.length; row++) {

            for (int col = 0; col < karakterSınıf.maze[0].length; col++) {

                Color color;

                switch (oyuncu.maze[row][col]) {
                    case 0:
                        color = Color.BLACK;
                        break;

                    default:
                        color = Color.WHITE;

                        break;

                }

                if (row == 5 && col == 6) {
                    color = Color.RED;

                }

                g.setColor(color);
                g.fillRect(kareBoyut * col, kareBoyut * row, 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(kareBoyut * col, kareBoyut * row, 30, 30);

            }

        }
        if (dusmanKontrol == 1) {
            int a, b;
            azman.yol2.clear();
            if (karakter.equals("2")) {
                azman.yoluCiz(azmanX + azmanY * 13, tembelSirin.getKarakterPozisyonX() / 30 + tembelSirin.getKarakterPozisyonY() / 30 * 13);
            }
            if (karakter.equals("1")) {
                azman.yoluCiz(azmanX + azmanY * 13, gozlukluSirin.getKarakterPozisyonX() / 30 + gozlukluSirin.getKarakterPozisyonY() / 30 * 13);
            }
            for (int i = 0; i < azman.yol2.size(); i++) {

                a = azman.yol2.get(i) / 13;
                b = azman.yol2.get(i) % 13;
                g.setColor(Color.green);
                g.fillRect(kareBoyut * b, kareBoyut * a, 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(kareBoyut * b, kareBoyut * a, 30, 30);
            }
            g.drawImage(azmanPng, azmanX * 30, azmanY * 30, 30, 30, this);
        }
        if (dusmanKontrol == 2) {
            int a2, b2;
            gargamel.yol2.clear();
            if (karakter.equals("2")) {
                gargamel.yoluCiz(gargamelX + gargamelY * 13, tembelSirin.getKarakterPozisyonX() / 30 + tembelSirin.getKarakterPozisyonY() / 30 * 13);
            }
            if (karakter.equals("1")) {
                gargamel.yoluCiz(gargamelX + gargamelY * 13, gozlukluSirin.getKarakterPozisyonX() / 30 + gozlukluSirin.getKarakterPozisyonY() / 30 * 13);
            }
            for (int i = 0; i < gargamel.yol2.size(); i++) {

                a2 = gargamel.yol2.get(i) / 13;
                b2 = gargamel.yol2.get(i) % 13;
                g.setColor(Color.blue);
                g.fillRect(kareBoyut * b2, kareBoyut * a2, 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(kareBoyut * b2, kareBoyut * a2, 30, 30);
            }
            g.drawImage(gargamelPng, gargamelX * 30, gargamelY * 30, 30, 30, this);
        }
        if (dusmanKontrol == 3) {
            int a2, b2;
            gargamel.yol2.clear();
            if (karakter.equals("2")) {
                gargamel.yoluCiz(gargamelX + gargamelY * 13, tembelSirin.getKarakterPozisyonX() / 30 + tembelSirin.getKarakterPozisyonY() / 30 * 13);
            }
            if (karakter.equals("1")) {
                gargamel.yoluCiz(gargamelX + gargamelY * 13, gozlukluSirin.getKarakterPozisyonX() / 30 + gozlukluSirin.getKarakterPozisyonY() / 30 * 13);
            }
            for (int i = 0; i < gargamel.yol2.size(); i++) {

                a2 = gargamel.yol2.get(i) / 13;
                b2 = gargamel.yol2.get(i) % 13;
                g.setColor(Color.blue);
                g.fillRect(kareBoyut * b2, kareBoyut * a2, 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(kareBoyut * b2, kareBoyut * a2, 30, 30);
            }
            int a, b;
            azman.yol2.clear();
            if (karakter.equals("2")) {
                azman.yoluCiz(azmanX + azmanY * 13, tembelSirin.getKarakterPozisyonX() / 30 + tembelSirin.getKarakterPozisyonY() / 30 * 13);
            }
            if (karakter.equals("1")) {
                azman.yoluCiz(azmanX + azmanY * 13, gozlukluSirin.getKarakterPozisyonX() / 30 + gozlukluSirin.getKarakterPozisyonY() / 30 * 13);
            }
            for (int i = 0; i < azman.yol2.size(); i++) {

                a = azman.yol2.get(i) / 13;
                b = azman.yol2.get(i) % 13;
                g.setColor(Color.green);
                g.fillRect(kareBoyut * b, kareBoyut * a, 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(kareBoyut * b, kareBoyut * a, 30, 30);
            }
            g.drawImage(gargamelPng, gargamelX * 30, gargamelY * 30, 30, 30, this);
            g.drawImage(azmanPng, azmanX * 30, azmanY * 30, 30, 30, this);
        }
        for (Altin altin : altin.altinlar) {

            g.drawImage(altinPng, kareBoyut * altin.getX(), kareBoyut * altin.getY(), 30, 30, this);

        }
        for (Mantar mantar : Mantar.mantarlar) {
            g.drawImage(mantarPng, kareBoyut * mantar.getX(), kareBoyut * mantar.getY(), 30, 30, this);
        }

        g.setColor(Color.YELLOW);
        if (oyuncu.getOyuncuId().equals("1")) {
            g.drawImage(gozluklu, gozlukluSirin.getKarakterPozisyonX(), gozlukluSirin.getKarakterPozisyonY(), 30, 30, this);
            cikisaUlasildiMi();
        } else if (oyuncu.getOyuncuId().equals("2")) {
            g.drawImage(tembel, tembelSirin.getKarakterPozisyonX(), tembelSirin.getKarakterPozisyonY(), 30, 30, this);
            cikisaUlasildiMi();
        }

        g.drawImage(sirine, kareBoyut * 13 + 5, kareBoyut * 7 - 10, 50, 50, this);

        g.setColor(Color.lightGray);
        if (oyuncu.getSkor() >= 0) {
            g.fillRect(kareBoyut * 18, kareBoyut, 100, 30);
            g.drawRect(kareBoyut * 18, kareBoyut, 100, 30);
            g.setColor(Color.BLACK);
            g.drawString("puan:" + oyuncu.getSkor(), 560, 50);
        } else {
            timer.stop();
            JOptionPane.showMessageDialog(this, "Oyunu Kaybettiniz");
            System.exit(0);

        }

    }

    @Override
    public void repaint() {
        super.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int c = e.getKeyCode();
        if (c == KeyEvent.VK_LEFT) {

            if (karakter.equals("1")) {
                gozlukluSirin.solaGit();

                hareketEttir();

                for (Altin altin : Altin.altinlar) {

                    if ((gozlukluSirin.getKarakterPozisyonX() == altin.getX() * 30 && gozlukluSirin.getKarakterPozisyonY() == altin.getY() * 30) || (gozlukluSirin.getKarakterPozisyonX() == altin.getX() * 30 - 30 && gozlukluSirin.getKarakterPozisyonY() == altin.getY() * 30)) {
                        oyuncu.setSkor(5 + oyuncu.getSkor());
                        altin.altinlar.remove(altin);
                        break;
                    }

                }
                if ((gozlukluSirin.getKarakterPozisyonX() == mantar.getX() * 30 && gozlukluSirin.getKarakterPozisyonY() == mantar.getY() * 30) || (gozlukluSirin.getKarakterPozisyonX() == mantar.getX() * 30 - 30 && gozlukluSirin.getKarakterPozisyonY() == mantar.getY() * 30)) {
                    oyuncu.setSkor(oyuncu.getSkor() + 50);
                    mantar.mantarlar.removeAll(mantarlar);
                }

            } else {

                tembelSirin.solaGit();

                hareketEttir();

                for (Altin altin : Altin.altinlar) {

                    if (tembelSirin.getKarakterPozisyonX() == altin.getX() * 30 && tembelSirin.getKarakterPozisyonY() == altin.getY() * 30) {
                        oyuncu.setSkor(5 + oyuncu.getSkor());
                        altin.altinlar.remove(altin);
                        break;
                    }

                }
                if (tembelSirin.getKarakterPozisyonX() == mantar.getX() * 30 && tembelSirin.getKarakterPozisyonY() == mantar.getY() * 30) {
                    oyuncu.setSkor(oyuncu.getSkor() + 50);
                    mantar.mantarlar.removeAll(mantarlar);
                }

            }
        } else if (c == KeyEvent.VK_RIGHT) {

            if (karakter.equals("1")) {
                gozlukluSirin.sagaGit();
                hareketEttir();

                for (Altin altin : Altin.altinlar) {

                    if ((gozlukluSirin.getKarakterPozisyonX() == altin.getX() * 30 && gozlukluSirin.getKarakterPozisyonY() == altin.getY() * 30) || (gozlukluSirin.getKarakterPozisyonX() == altin.getX() * 30 + 30 && gozlukluSirin.getKarakterPozisyonY() == altin.getY() * 30)) {
                        oyuncu.setSkor(5 + oyuncu.getSkor());
                        altin.altinlar.remove(altin);
                        break;
                    }

                }
                if ((gozlukluSirin.getKarakterPozisyonX() == mantar.getX() * 30 && gozlukluSirin.getKarakterPozisyonY() == mantar.getY() * 30) || (gozlukluSirin.getKarakterPozisyonX() == mantar.getX() * 30 + 30 && gozlukluSirin.getKarakterPozisyonY() == mantar.getY() * 30)) {
                    oyuncu.setSkor(oyuncu.getSkor() + 50);
                    mantar.mantarlar.removeAll(mantarlar);
                }

            } else {
                tembelSirin.sagaGit();

                hareketEttir();

                for (Altin altin : Altin.altinlar) {

                    if (tembelSirin.getKarakterPozisyonX() == altin.getX() * 30 && tembelSirin.getKarakterPozisyonY() == altin.getY() * 30) {
                        oyuncu.setSkor(5 + oyuncu.getSkor());
                        altin.altinlar.remove(altin);
                        break;
                    }

                }
                if (tembelSirin.getKarakterPozisyonX() == mantar.getX() * 30 && tembelSirin.getKarakterPozisyonY() == mantar.getY() * 30) {
                    oyuncu.setSkor(oyuncu.getSkor() + 50);
                    mantar.mantarlar.removeAll(mantarlar);
                }

            }

        } else if (c == KeyEvent.VK_DOWN) {

            if (karakter.equals("1")) {
                gozlukluSirin.asagiGit();
                hareketEttir();

                for (Altin altin : Altin.altinlar) {

                    if ((gozlukluSirin.getKarakterPozisyonX() == altin.getX() * 30 && gozlukluSirin.getKarakterPozisyonY() == altin.getY() * 30) || (gozlukluSirin.getKarakterPozisyonX() == altin.getX() * 30 && gozlukluSirin.getKarakterPozisyonY() == altin.getY() * 30 + 30)) {
                        oyuncu.setSkor(5 + oyuncu.getSkor());
                        altin.altinlar.remove(altin);
                        break;
                    }
                }
                if ((gozlukluSirin.getKarakterPozisyonX() == mantar.getX() * 30 && gozlukluSirin.getKarakterPozisyonY() == mantar.getY() * 30) || (gozlukluSirin.getKarakterPozisyonX() == mantar.getX() * 30 && gozlukluSirin.getKarakterPozisyonY() == mantar.getY() * 30 + 30)) {
                    oyuncu.setSkor(oyuncu.getSkor() + 50);
                    mantar.mantarlar.removeAll(mantarlar);
                }
            } else {
                tembelSirin.asagiGit();

                hareketEttir();

                for (Altin altin : Altin.altinlar) {

                    if (tembelSirin.getKarakterPozisyonX() == altin.getX() * 30 && tembelSirin.getKarakterPozisyonY() == altin.getY() * 30) {
                        oyuncu.setSkor(5 + oyuncu.getSkor());
                        altin.altinlar.remove(altin);
                        break;
                    }
                }
                if (tembelSirin.getKarakterPozisyonX() == mantar.getX() * 30 && tembelSirin.getKarakterPozisyonY() == mantar.getY() * 30) {
                    oyuncu.setSkor(oyuncu.getSkor() + 50);
                    mantar.mantarlar.removeAll(mantarlar);
                }

            }

        } else if (c == KeyEvent.VK_UP) {

            if (karakter.equals("1")) {
                gozlukluSirin.yukariGit();
                hareketEttir();

                for (Altin altin : Altin.altinlar) {

                    if ((gozlukluSirin.getKarakterPozisyonX() == altin.getX() * 30 && gozlukluSirin.getKarakterPozisyonY() == altin.getY() * 30) || (gozlukluSirin.getKarakterPozisyonX() == altin.getX() * 30 && gozlukluSirin.getKarakterPozisyonY() == altin.getY() * 30 - 30)) {
                        oyuncu.setSkor(5 + oyuncu.getSkor());
                        altin.altinlar.remove(altin);
                        break;
                    }

                }
                if ((gozlukluSirin.getKarakterPozisyonX() == mantar.getX() * 30 && gozlukluSirin.getKarakterPozisyonY() == mantar.getY() * 30) || (gozlukluSirin.getKarakterPozisyonX() == mantar.getX() * 30 && gozlukluSirin.getKarakterPozisyonY() == mantar.getY() * 30 - 30)) {
                    oyuncu.setSkor(oyuncu.getSkor() + 50);
                    mantar.mantarlar.removeAll(mantarlar);
                }
            } else {
                tembelSirin.yukariGit();
                hareketEttir();

                for (Altin altin : Altin.altinlar) {

                    if (tembelSirin.getKarakterPozisyonX() == altin.getX() * 30 && tembelSirin.getKarakterPozisyonY() == altin.getY() * 30) {
                        oyuncu.setSkor(5 + oyuncu.getSkor());
                        altin.altinlar.remove(altin);
                        break;
                    }

                }
                if (tembelSirin.getKarakterPozisyonX() == mantar.getX() * 30 && tembelSirin.getKarakterPozisyonY() == mantar.getY() * 30) {
                    oyuncu.setSkor(oyuncu.getSkor() + 50);
                    mantar.mantarlar.removeAll(mantarlar);
                }

            }

        }
    }

    public void hareketEttir() {
        if (dusmanKontrol == 1) {
            if (azman.yol2.size() <= 2) {
                azmanX = 3;
                azmanY = 0;
                oyuncu.setSkor(oyuncu.getSkor() - 5);
                azman.yol2.clear();

            } else {

                azmanX = azman.yol2.get(azman.yol2.size() - 2) % 13;
                azmanY = azman.yol2.get(azman.yol2.size() - 2) / 13;
            }

            if (karakter.equals("1")) {
                if (azmanX * 30 == gozlukluSirin.getKarakterPozisyonX() && azmanY * 30 == gozlukluSirin.getKarakterPozisyonY()) {
                    azmanX = 3;
                    azmanY = 0;
                    oyuncu.setSkor(oyuncu.getSkor() - 5);
                    azman.yol2.clear();
                }
            }
            if (karakter.equals("2")) {
                if (azmanX * 30 == tembelSirin.getKarakterPozisyonX() && azmanY * 30 == tembelSirin.getKarakterPozisyonY()) {
                    azmanX = 3;
                    azmanY = 0;
                    oyuncu.setSkor(oyuncu.getSkor() - 5);
                    azman.yol2.clear();
                }
            }
        }
        if (dusmanKontrol == 2) {
            if (gargamel.yol2.size() <= 2) {
                gargamelX = 10;
                gargamelY = 0;
                oyuncu.setSkor(oyuncu.getSkor() - 15);
                azman.yol2.clear();

            } else {
                gargamelX = gargamel.yol2.get(gargamel.yol2.size() - 3) % 13;
                gargamelY = gargamel.yol2.get(gargamel.yol2.size() - 3) / 13;

            }

            if (karakter.equals("1")) {
                if (gargamelX * 30 == gozlukluSirin.getKarakterPozisyonX() && gargamelY * 30 == gozlukluSirin.getKarakterPozisyonY()) {
                    gargamelX = 10;
                    gargamelY = 0;
                    oyuncu.setSkor(oyuncu.getSkor() - 15);
                    azman.yol2.clear();
                }
            }
            if (karakter.equals("2")) {
                if (gargamelX * 30 == tembelSirin.getKarakterPozisyonX() && gargamelY * 30 == tembelSirin.getKarakterPozisyonY()) {
                    gargamelX = 10;
                    gargamelY = 0;
                    oyuncu.setSkor(oyuncu.getSkor() - 15);
                    gargamel.yol2.clear();
                }
            }
        }
        if (dusmanKontrol == 3) {
            if (gargamel.yol2.size() <= 2) {
                gargamelX = 10;
                gargamelY = 0;
                oyuncu.setSkor(oyuncu.getSkor() - 15);
                azman.yol2.clear();

            } else {
                gargamelX = gargamel.yol2.get(gargamel.yol2.size() - 3) % 13;
                gargamelY = gargamel.yol2.get(gargamel.yol2.size() - 3) / 13;

            }

            if (karakter.equals("1")) {
                if (gargamelX * 30 == gozlukluSirin.getKarakterPozisyonX() && gargamelY * 30 == gozlukluSirin.getKarakterPozisyonY()) {
                    gargamelX = 10;
                    gargamelY = 0;
                    oyuncu.setSkor(oyuncu.getSkor() - 15);
                    azman.yol2.clear();
                }
            }
            if (karakter.equals("2")) {
                if (gargamelX * 30 == tembelSirin.getKarakterPozisyonX() && gargamelY * 30 == tembelSirin.getKarakterPozisyonY()) {
                    gargamelX = 10;
                    gargamelY = 0;
                    oyuncu.setSkor(oyuncu.getSkor() - 15);
                    gargamel.yol2.clear();
                }
            }
            if (azman.yol2.size() <= 2) {
                azmanX = 3;
                azmanY = 0;
                oyuncu.setSkor(oyuncu.getSkor() - 5);
                azman.yol2.clear();

            } else {

                azmanX = azman.yol2.get(azman.yol2.size() - 2) % 13;
                azmanY = azman.yol2.get(azman.yol2.size() - 2) / 13;
            }

            if (karakter.equals("1")) {
                if (azmanX * 30 == gozlukluSirin.getKarakterPozisyonX() && azmanY * 30 == gozlukluSirin.getKarakterPozisyonY()) {
                    azmanX = 3;
                    azmanY = 0;
                    oyuncu.setSkor(oyuncu.getSkor() - 5);
                    azman.yol2.clear();
                }
            }
            if (karakter.equals("2")) {
                if (azmanX * 30 == tembelSirin.getKarakterPozisyonX() && azmanY * 30 == tembelSirin.getKarakterPozisyonY()) {
                    azmanX = 3;
                    azmanY = 0;
                    oyuncu.setSkor(oyuncu.getSkor() - 5);
                    azman.yol2.clear();
                }
            }
        }

    }

    public void hareketEttir2() {

    }

    public void cikisaUlasildiMi() {
        if (gozlukluSirin.getKarakterPozisyonX() == 360 && gozlukluSirin.getKarakterPozisyonY() == 210 || tembelSirin.getKarakterPozisyonX() == 360 && tembelSirin.getKarakterPozisyonY() == 210) {

            timer.stop();
            JOptionPane.showMessageDialog(this, "Oyunu Kazandınız");

            System.exit(0);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

        if (gecenSure == 300) {
            altin.objeOlustur();

        }

        if (gecenSure == 650) {
            altin.objeSil();
            gecenSure = 0;

        }

        if (gecenSure2 == 500) {
            mantar.objeOlustur();

        }

        if (gecenSure2 == 1000) {
            mantar.objeSil();
            gecenSure2 = 0;

        }

    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

}
