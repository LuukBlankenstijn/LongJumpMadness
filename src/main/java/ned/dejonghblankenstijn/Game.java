package ned.dejonghblankenstijn;

import javax.swing.*;
import java.awt.*;

public class Game {

    private final JFrame frame = new JFrame("Long Jump Madness");
    private final FrameBuilder framebuilder = new FrameBuilder();
    private final BeginScreen beginScreen = new BeginScreen(frame,framebuilder);
    private final StageOne stageOne = new StageOne(frame,framebuilder);

    private final Delay delay = new Delay();

    public Game() {
        setupFrame();
    }

    private void setupFrame() {
        frame.add(framebuilder.imagePlane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(960,960));
        frame.setResizable(false);
        frame.setVisible(true);
        framebuilder.startTimer();
    }

    public void run() {
        int score = 0;
        beginScreen.run();
        delay.add(2000);
        score += stageOne.run();
        System.out.println(score);

    }
}
