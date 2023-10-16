package ned.dejonghblankenstijn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrameBuilder implements ActionListener {
    protected DrawPlane imagePlane = new DrawPlane();

    private final Clouds clouds = new Clouds();
    private final Track track = new Track();
    private final MovingCharacter character = new MovingCharacter();

    private boolean moveChar;
    private boolean moveCloud;
    private boolean drawStartText;
    private boolean stageOne;

    protected final Timer timer = new Timer(100, this);
    private long timerCycle = 0;

//  Stage One variables
    protected int seconds;
    private String message = "Click the following key as fast as possible:";

    private char key = 51;

    protected class DrawPlane extends JPanel {
        public void paintComponent(Graphics g) {
            g.drawImage(clouds.showImage, 0, 0, this);
            g.drawImage(track.showImage,0,368,this);
            g.drawImage(character.showImage, 350, 500, this );
            if (drawStartText) {
                g.setFont(new Font("Monaco", Font.PLAIN,80));
                g.drawString("Press space to start!",100, 300);
            }
            if (stageOne) {
                g.setFont(new Font("Monaco", Font.PLAIN, 40));
                g.drawString(message,100,300);
                g.setFont(new Font("Monaco", Font.PLAIN, 60));
                g.drawString("" + key, 450, 400);
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (timer.getDelay() > 100) {
            timer.setDelay(Math.max(100, timer.getDelay()-20));
        }
         if (moveChar) {
             moveCharacter();
         }
         if (moveCloud) {
             if (timerCycle % 6 == 0) {

                 moveClouds();
             }
         }

        timerCycle++;
        imagePlane.repaint();
    }

    private void setFontSize(int size) {
        imagePlane.setFont(new Font("Monaco", Font.PLAIN, size));
    }

    public void startTimer(){
        timer.start();
    }

    private void moveCharacter() {
        character.nextImage();
    }

    private void moveClouds() {
        clouds.nextImage();
    }

//    private void moveTrack() {
//        track.nextImage();
//    }



    public char getKey() {
        return key;
    }

    public boolean isStageOne() {
        return stageOne;
    }

    public void setMoveChar(boolean moveChar) {
        this.moveChar = moveChar;
    }

    public void setMoveCloud(boolean moveCloud) {
        this.moveCloud = moveCloud;
    }

    public void setDrawStartText(boolean drawStartText) {
        this.drawStartText = drawStartText;
    }

    public void setStageOne(boolean stageOne) {
        this.stageOne = stageOne;
    }

    public void setKey(char countDown) {
        this.key = countDown;
    }
}
