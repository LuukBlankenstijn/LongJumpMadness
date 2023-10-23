package ned.dejonghblankenstijn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrameBuilder implements ActionListener {
    protected final Timer timer = new Timer(10, this);
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private final Clouds clouds = new Clouds();
    private final Track track = new Track();
    private final MovingCharacter character = new MovingCharacter();
    protected DrawPlane imagePlane = new DrawPlane();
    private boolean moveChar;
    private boolean moveCloud;
    private boolean beginScreen;
    private boolean stageOne;
    private boolean stageThreeShow;
    private boolean stageThreeMove;
    private int circlePos = 460;
    private int direction = 1;
    private long timerCycle = 0;
    private char key = 51;



    private int totalScore = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (timer.getDelay() > 10) {
            timer.setDelay(Math.max(10, timer.getDelay() - 1));
        }
        if (moveChar) {
            if (timerCycle % 10 == 0) {
                moveCharacter();
            }
        }
        if (moveCloud) {
            if (timerCycle % 80 == 0) {

                moveClouds();
            }
        }
        if (stageThreeMove) {
            int moveRate = (int) Math.round(-65.1 * Math.pow(10, -6) * Math.pow(circlePos - 480, 2) + 15);
            if (circlePos >= 890) {
                direction *= -1;
                circlePos = 890;
            }
            if (circlePos <= 30) {
                direction *= -1;
                circlePos = 30;
            }
            circlePos = circlePos + (moveRate * direction);
        }

        timerCycle++;
        imagePlane.repaint();
    }

    private void applyFont(int size, Graphics g) {
        g.setFont(new Font("Monaco", Font.PLAIN, size));
    }

    public void startTimer() {
        timer.start();
    }

    private void moveCharacter() {
        character.nextImage();
    }

    private void moveClouds() {
        clouds.nextImage();
    }

    public void setMoveChar(boolean moveChar) {
        this.moveChar = moveChar;
    }

    public void setMoveCloud(boolean moveCloud) {
        this.moveCloud = moveCloud;
    }

    public void setMovement(boolean move) {
        setMoveCloud(move);
        setMoveChar(move);
    }

    public char getKey() {
        return key;
    }
    public int getCirclePos() {
        return circlePos;
    }
    public int getTotalScore() {
        return totalScore;
    }

    public void setKey(char countDown) {
        this.key = countDown;
    }

    public void setBeginScreen(boolean beginScreen) {
        this.beginScreen = beginScreen;
    }

    public void setStageOne(boolean stageOne) {
        this.stageOne = stageOne;
    }

    public void setStageThreeShow(boolean stageThreeShow) {
        this.stageThreeShow = stageThreeShow;
    }

    public void setStageThreeMove(boolean stageThreeMove) {
        this.stageThreeMove = stageThreeMove;
    }
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
    public void addTotalScore(int add) {
        this.totalScore += add;
    }

    protected class DrawPlane extends JPanel {

        public void paintComponent(Graphics g) {
            int xOfset = Math.max((screenSize.width - screenSize.height) / 2,0);
            g.drawImage(clouds.showImage, xOfset, 0, this);
            g.drawImage(track.showImage, xOfset, screenSize.height * 92 / 256, this);
            g.drawImage(character.showImage, xOfset + 350, 475, this);
            if (beginScreen) {
                applyFont(80, g);
                g.drawString("Press space to start!", xOfset + 100, 300);
            }
            else {
                g.setColor(new Color(255, 215,175));
                g.fillRect(xOfset + screenSize.height - 150,0,150,40);
                g.setColor(Color.BLACK);
                applyFont(30,g);
                g.drawString("" + totalScore,xOfset + screenSize.height - 140, 30);
            }
            if (stageOne) {
                applyFont(40, g);
                String message = "Click the following key as fast as possible:";
                g.drawString(message, xOfset + 100, 300);
                applyFont(60, g);
                g.drawString("" + key, xOfset + 450, 400);
            }
            if (stageThreeShow) {
                String message = "Press space to stop the the moving point";
                applyFont(40, g);
                g.drawString(message, xOfset + 100, 300);
                g.setColor(Color.BLACK);
                g.fillRect(xOfset + 50, 800, 860, 10);
                g.setColor(Color.WHITE);
                g.fillRect(xOfset + 475, 780, 10, 50);
                g.fillOval(xOfset + circlePos, 785, 40, 40);
            }
        }

    }
}
