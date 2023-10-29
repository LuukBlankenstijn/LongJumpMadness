package ned.dejonghblankenstijn;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ScoreMenu extends JPanel {
    private final JFrame frame;
    private final FrameBuilder plane;


    private volatile boolean endScreen = false;
    private volatile boolean rerun;
    private final KeyAdapter keyAdapter = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                System.out.println("Enter");
                frame.removeKeyListener(this);
                rerun = true;
                endScreen = false;
                plane.setScoreMenu(false);
            }
            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                frame.removeKeyListener(this);
                rerun = false;
                endScreen = false;
                plane.setScoreMenu(false);
            }
        }
    };

    public ScoreMenu(JFrame frame, FrameBuilder plane) {
        this.frame = frame;
        this.plane = plane;
    }

    public boolean run() {
        endScreen = true;
        plane.setMovement(false);
        plane.setScoreMenu(true);

        frame.addKeyListener(keyAdapter);

        while (endScreen) {
            Thread.onSpinWait();
        }
        return rerun;
    }
}
