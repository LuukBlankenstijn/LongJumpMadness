package ned.dejonghblankenstijn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StageThree implements ActionListener {
    private final int STAGE_TIME = 10000;

    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final JFrame frame;
    private final FrameBuilder plane;
    private final Delay delay = new Delay();
    private final Timer waitTimer = new Timer(0, this);
    private int score;
    private final KeyAdapter keyAdapter = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                frame.removeKeyListener(this);
                plane.setStageThreeMove(false);
                int distance = (int) Math.abs(screenSize.height * 0.5 - plane.getCirclePos());
                score = (int) ((screenSize.height*0.5 - distance) * 6);
                delay.remove();
            }
        }
    };
    private boolean instantReturn = false;

    public StageThree(JFrame frame, FrameBuilder plane) {
        this.frame = frame;
        this.plane = plane;
        waitTimer.setInitialDelay(STAGE_TIME);
    }

    public int run() {
        plane.setStageThreeShow(true);
        plane.setStageThreeMove(true);
        frame.addKeyListener(keyAdapter);
        waitTimer.start();
        delay.add(STAGE_TIME);
        if (instantReturn) {
            plane.setStageThreeShow(false);
            plane.setStageThreeMove(false);
            return score;
        }
        waitTimer.stop();
        delay.add(2000);
        plane.setStageThreeShow(false);
        return score;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        instantReturn = true;
        waitTimer.stop();

    }
}
