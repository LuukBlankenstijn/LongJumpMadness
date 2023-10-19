package ned.dejonghblankenstijn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StageThree implements ActionListener {
    public StageThree(JFrame frame, FrameBuilder plane) {
        this.frame = frame;
        this.plane = plane;
        waitTimer.setInitialDelay(STAGE_TIME);
    }
    
    private final int STAGE_TIME = 10000;

    private final JFrame frame;
    private final FrameBuilder plane;

    private final Delay delay = new Delay();
    private final Timer waitTimer = new Timer(0,this);
    

    private int score;
    private boolean instantReturn = false;

    private final KeyAdapter keyAdapter = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                frame.removeKeyListener(this);
                plane.setStageThreeMove(false);
                int distance = Math.abs(plane.getCirclePos());
                score = (500 - distance) * 6;
                delay.remove();
            }
        }
    };

    public int run() {
        plane.setStageThreeShow(true);
        plane.setStageThreeMove(true);
        frame.addKeyListener(keyAdapter);
        waitTimer.start();
        delay.add(STAGE_TIME);
        if (instantReturn) {
            plane.setStageThreeShow(false);
            plane.setStageThreeMove(false);
            return  score;
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
