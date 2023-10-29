package ned.dejonghblankenstijn;


import javax.swing.*;

public class Jump {
    private final FrameBuilder plane;

    private final Delay delay = new Delay();

    public Jump(FrameBuilder plane) {
        this.plane = plane;
    }

    public void run() {
        plane.setJump(true);
        delay.add(3000);
        plane.setJump(false);

    }
}
