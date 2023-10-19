package ned.dejonghblankenstijn;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BeginScreen {
    private final JFrame frame;
    private final FrameBuilder plane;

    public BeginScreen(JFrame frame, FrameBuilder plane) {
        this.frame = frame;
        this.plane = plane;
    }

    private volatile boolean beginActive = false;

    private final KeyAdapter keyAdapter = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            if (e.getKeyCode() == KeyEvent.VK_SPACE){
                frame.removeKeyListener(this);
                plane.timer.setDelay(15);
                plane.setMovement(true);
                plane.setDrawStartText(false);
                beginActive = false;
            }
        }
    };

    public void run() {
        beginActive = true;
        plane.setMovement(false);
        plane.setDrawStartText(true);
        frame.addKeyListener(keyAdapter);
        while(beginActive){
            continue;
        }

    }
}
