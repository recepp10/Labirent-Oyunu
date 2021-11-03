package labirent;

import javax.swing.*;

import java.awt.HeadlessException;

import java.util.Random;

public class View extends JFrame {

    public View(String title) throws HeadlessException {
        super(title);
    }

    public static void main(String[] args) {

        View view = new View("Oyun Ekranı");
        Random random = new Random();
        view.setResizable(false);
        view.setFocusable(false);
        view.setSize(800, 600);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel jLabel = new JLabel();

        Oyun oyun = new Oyun();

        oyun.requestFocus();

        oyun.addKeyListener(oyun);
        oyun.setFocusable(true);
        oyun.setFocusTraversalKeysEnabled(false);

        view.add(oyun);
        view.setVisible(true);

    }

}
