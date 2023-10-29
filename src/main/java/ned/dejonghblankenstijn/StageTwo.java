package ned.dejonghblankenstijn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StageTwo implements ActionListener {
    public StageTwo(JFrame frame, FrameBuilder plane) {
        this.frame = frame;
        this.plane = plane;
        this.randomPoint = new Point(
                (int) ((screenSize.width - (RADIUS * 2)) * Math.random()),
                (int) ((screenSize.height - (RADIUS * 2))* Math.random())
        );
    }

    private final JFrame frame;

    private final FrameBuilder plane;

    private final Delay delay = new Delay();
    private final Timer countdown = new Timer(1000,this);
    private final int RADIUS = 20;
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private final Point randomPoint;

    private final int DURATION = 50000000;

    private final MouseAdapter mouseAdapter = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            double distance = randomPoint.distance(
                    e.getXOnScreen() + plane.getxOfset(),
                    e.getYOnScreen());
            System.out.println(distance);
            if(distance < RADIUS) {
                frame.removeMouseListener(this);
                plane.setStageTwo(false);
                score = Math.max((int) (DURATION - (System.nanoTime() - startTime) / 1000000),0);
                delay.remove();
            }
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countdown) {
            if (plane.getKey() == 49) {
                countdown.stop();
                plane.setKey((char) 51);
            }
            else {
                plane.setKey((char) (plane.getKey() - 1));
            }
        }
    }

    private int score;
    private long startTime;

    private void startCountdown() {
        plane.setKey((char) 51);
        countdown.start();
    }

    public int run() {
        plane.setRandomPoint(new Point(
                (int) ((screenSize.height - (RADIUS * 2)) * Math.random()),
                (int) ((screenSize.height - (RADIUS * 2))* Math.random())
        ));
        plane.setStageTwo(true);
        startCountdown();
        while (true) {
            if (!countdown.isRunning()) break;
        }
        frame.addMouseListener(mouseAdapter);
        startTime = System.nanoTime();
        delay.add(DURATION);
        frame.removeMouseListener(mouseAdapter);
        plane.setStageTwo(false);
        return score;
    }
}
