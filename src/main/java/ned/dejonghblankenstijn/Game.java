package ned.dejonghblankenstijn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game {

    JFrame frame = new JFrame("Long Jump Madness");
    FrameBuilder framebuilder = new FrameBuilder();

    public void run() {
        frame.add(framebuilder.imagePlane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(960,960));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    frame.removeKeyListener(this);
                    framebuilder.drawStartText = false;
                    framebuilder.timer.setDelay(200);
                    framebuilder.startTimer();
                }
            }
        });
//        framebuilder.startTimer();
    }
}
