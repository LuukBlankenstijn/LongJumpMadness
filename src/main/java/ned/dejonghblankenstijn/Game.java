package ned.dejonghblankenstijn;

import javax.swing.*;
import java.awt.*;

public class Game {

    private final JFrame frame = new JFrame("Long Jump Madness");
    private final FrameBuilder framebuilder = new FrameBuilder();
    private final BeginScreen beginScreen = new BeginScreen(frame, framebuilder);
    private final StageOne stageOne = new StageOne(frame, framebuilder);
    private final StageTwo stageTwo = new StageTwo(frame, framebuilder);
    private final StageThree stageThree = new StageThree(frame, framebuilder);
    private final ScoreMenu scoreMenu = new ScoreMenu(frame, framebuilder);

    private final Delay delay = new Delay();

    private boolean rerun = true;

    public Game() {
        setupFrame();
    }

    private void setupFrame() {
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(framebuilder.imagePlane, BorderLayout.CENTER);
        frame.setVisible(true);
        framebuilder.startTimer();

    }

    public void run() {
        while (rerun) {
            beginScreen.run();
            delay.add(2000);
            framebuilder.addTotalScore(stageOne.run());
            delay.add(2000);
            framebuilder.addTotalScore(stageTwo.run());
            delay.add(2000);
            framebuilder.addTotalScore(stageThree.run());
            rerun = scoreMenu.run();
            System.out.println(rerun);
        }
        framebuilder.timer.stop();
        frame.dispose();
    }
}
