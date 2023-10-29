package ned.dejonghblankenstijn;


import javax.swing.*;

public class Jump {
    private final JFrame frame;
    private final FrameBuilder plane;

    private final Delay delay = new Delay();

    public Jump(JFrame frame, FrameBuilder plane) {
        this.frame = frame;
        this.plane = plane;
    }

    public void run() {
        plane.setJump(true);
        delay.add(3000);

    }
}
