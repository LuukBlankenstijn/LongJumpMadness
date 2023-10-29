package ned.dejonghblankenstijn;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BeginScreen {
    private final JFrame frame;
    private final FrameBuilder plane;
    private volatile boolean beginActive = false;
    private final KeyAdapter keyAdapter = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                frame.removeKeyListener(this);
                plane.timer.setDelay(15);
                plane.setMovement(true);
                plane.setBeginScreen(false);
                beginActive = false;
            }
        }
    };

    public BeginScreen(JFrame frame, FrameBuilder plane) {
        this.frame = frame;
        this.plane = plane;
    }

    public void run() {
        plane.getTrack().showImage = plane.getTrack().frames[0];
        plane.getCharacter().showImage = plane.getCharacter().frames[2];
        beginActive = true;
        plane.setMovement(false);
        plane.setBeginScreen(true);
        frame.addKeyListener(keyAdapter);
        while (beginActive) {
            Thread.onSpinWait();
        }

    }
}
