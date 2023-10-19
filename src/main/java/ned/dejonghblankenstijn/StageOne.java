package ned.dejonghblankenstijn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class StageOne implements ActionListener {

    private final JFrame frame;
    private final FrameBuilder plane;


    private final Delay delay = new Delay();
    private final Timer countdown = new Timer(1000,this);
    private final char randomKey = randomChar();
    private final int DURATION = 5000;

    private final KeyAdapter keyAdapter = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            if (e.getKeyCode() == randomKey) {
                frame.removeKeyListener(this);
                plane.setStageOne(false);
                score = Math.max((int) (DURATION - (System.nanoTime() - startTime) / 1000000),0);
                delay.remove();
            }
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countdown) {
            if (plane.getKey() == 49) {
                countdown.stop();
                plane.setKey((char) 51);
            }
            else {
                plane.setKey((char) (plane.getKey() - 1));
            }
        }
    }

    private int score;

    private long startTime;
    public StageOne(JFrame frame, FrameBuilder plane) {
        this.frame = frame;
        this.plane = plane;
    }


    public int run() {
        play();
        delay.add(DURATION);
        stop();
        return score;
    }

    private void play() {
        plane.setStageOne(true);
        countdown.start();
        while (true) {
            if (!countdown.isRunning()) break;

        }
        plane.setKey(randomKey);
        frame.addKeyListener(keyAdapter);
        startTime = System.nanoTime();
    }

    private void stop() {
        frame.removeKeyListener(keyAdapter);
        plane.setStageOne(false);
    }

    private char randomChar() {
        Random r = new Random();
        return (char) ((r.nextInt(26)) + 65);
    }
}