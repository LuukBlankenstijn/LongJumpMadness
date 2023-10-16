package ned.dejonghblankenstijn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Game implements ActionListener {

    private final JFrame frame = new JFrame("Long Jump Madness");
    private final FrameBuilder framebuilder = new FrameBuilder();


    private volatile boolean beginActive;

    private final Timer delay = new Timer(0,this);
    private final Timer countdown = new Timer(1000,this);
    private long startTime;
    private long endTime;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delay){
            delay.stop();
        }
        if (e.getSource() == countdown) {
            if (framebuilder.getKey() == 49) {
                countdown.stop();
                framebuilder.setKey((char) 51);
            }
            else {
                framebuilder.setKey((char) (framebuilder.getKey() - 1));
            }
        }
    }

    public Game() {
        setupFrame();
    }

    public void run() {
        int score = 0;
        beginScreen();
        do {
        } while (beginActive);
        addDelay(2000);
        score += stageOne();
        System.out.println(score);
    }

    private void setupFrame() {
        frame.add(framebuilder.imagePlane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(960,960));
        frame.setResizable(false);
        frame.setVisible(true);
        framebuilder.startTimer();
    }

    private void beginScreen() {
        beginActive = true;
        framebuilder.setMoveChar(false);
        framebuilder.setMoveCloud(false);
        framebuilder.setDrawStartText(true);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    frame.removeKeyListener(this);
                    framebuilder.timer.setDelay(200);
                    framebuilder.setMoveChar(true);
                    framebuilder.setMoveCloud(true);
                    framebuilder.setDrawStartText(false);
                    beginActive = false;
                }
            }
        });
    }

    private int stageOne() {
        framebuilder.setStageOne(true);
        countdown.start();
        while (countdown.isRunning()){

        }
        char randomKey = randomChar();
        framebuilder.setKey(randomKey);
        startTime = System.nanoTime();
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == randomKey) {
                    frame.removeKeyListener(this);
                    framebuilder.setStageOne(false);
                }
            }
        });

        endTime = System.nanoTime();
        int timeMilliseconds = (int) ((endTime - startTime) / 1000);
        System.out.println(timeMilliseconds);
        //noinspection LoopConditionNotUpdatedInsideLoop
        while (framebuilder.isStageOne()) continue;
        return Math.max(1600-timeMilliseconds,0);
    }

    private void addDelay(int milliseconds) {
        delay.setInitialDelay(milliseconds);
        delay.start();
        while (delay.isRunning()) {
            continue;
        }
    }

    private char randomChar() {
        Random r = new Random();
        return (char) ((r.nextInt(26)) + 65);
    }
}
