package ned.dejonghblankenstijn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrameBuilder implements ActionListener {
    protected final Timer timer = new Timer(10, this);
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final int xOfset = Math.max((screenSize.width - screenSize.height) / 2, 0);
    private final Clouds clouds = new Clouds();
    private final Track track = new Track();
    private final MovingCharacter character = new MovingCharacter();
    private final int RADIUS = 40;
    public Point randomPoint;
    protected DrawPlane imagePlane = new DrawPlane();
    private boolean moveChar;
    private boolean moveCloud;
    private boolean beginScreen;
    private boolean stageOne;
    private boolean stageTwo;
    private boolean showPoint = false;
    private boolean stageThreeShow;
    private boolean stageThreeMove;
    private boolean scoreMenu;
    private int circlePos = 460;
    private int direction = 1;
    private long timerCycle = 0;
    private char key = 51;
    private int totalScore = 0;

    public int getxOfset() {
        return xOfset;
    }

    public Point getRandomPoint() {
        return randomPoint;
    }

    public void setRandomPoint(Point randomPoint) {
        this.randomPoint = randomPoint;
    }

    public int getRADIUS() {
        return RADIUS;
    }

    public void setShowPoint(boolean showPoint) {
        this.showPoint = showPoint;
    }

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

    public void setKey(char countDown) {
        this.key = countDown;
    }

    public int getCirclePos() {
        return circlePos;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public boolean getScoreMenu() {
        return scoreMenu;
    }

    public void setScoreMenu(boolean scoreMenu) {
        this.scoreMenu = scoreMenu;
    }

    public void setBeginScreen(boolean beginScreen) {
        this.beginScreen = beginScreen;
    }

    public void setStageOne(boolean stageOne) {
        this.stageOne = stageOne;
    }

    public void setStageTwo(boolean stageTwo) {
        this.stageTwo = stageTwo;
    }

    public void setStageThreeShow(boolean stageThreeShow) {
        this.stageThreeShow = stageThreeShow;
    }

    public void setStageThreeMove(boolean stageThreeMove) {
        this.stageThreeMove = stageThreeMove;
    }

    public void addTotalScore(int add) {
        this.totalScore += add;
    }

    protected class DrawPlane extends JPanel {

        public void paintComponent(Graphics g) {
            Color menuBackground = new Color(255, 215, 175);
            g.drawImage(clouds.showImage, xOfset, 0, this);
            g.drawImage(track.showImage, xOfset, screenSize.height * 92 / 256, this);
            g.drawImage(character.showImage, xOfset + 350, 475, this);
            if (beginScreen) {
                applyFont(80, g);
                g.drawString("Press space to start!", xOfset + 100, 300);
            } else if (!scoreMenu) {
                g.setColor(menuBackground);
                g.fillRect(xOfset + screenSize.height - 150, 0, 150, 40);
                g.setColor(Color.BLACK);
                applyFont(30, g);
                g.drawString("" + totalScore, xOfset + screenSize.height - 140, 30);
            }
            if (stageOne) {
                applyFont(40, g);
                String message = "Click the following key as fast as possible:";
                g.drawString(message, xOfset + 100, 300);
                applyFont(60, g);
                g.drawString("" + key, xOfset + 450, 400);
            }
            if (stageTwo) {
                applyFont(40, g);
                String message = "Click the red point as fast as possible:";
                g.drawString(message, xOfset + 150, 300);
                applyFont(60, g);
                g.drawString("" + key, xOfset + 450, 400);
                if (showPoint) {
                    g.setColor(Color.RED);
                    g.fillOval(
                            xOfset + randomPoint.x - RADIUS,
                            randomPoint.y - RADIUS,
                            RADIUS,
                            RADIUS);
                    g.setColor(Color.BLACK);
                }
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
            if (scoreMenu) {
                g.setColor(menuBackground);
                g.fillRect((int) (xOfset + screenSize.height * 0.1),
                        (int) (screenSize.height * 0.01),
                        (int) (screenSize.height * 0.8),
                        (int) (screenSize.height * 0.3));
                g.setColor(Color.BLACK);
                applyFont(60, g);
                g.drawString("" + totalScore, xOfset + 450, (int) (0.08 * screenSize.height));
                g.drawString("Press enter te restart", xOfset + 220, (int) (0.18 * screenSize.height));
                g.drawString("Press Backspace to exit", xOfset + 200, (int) (0.28 * screenSize.height));
            }
        }
    }
}
