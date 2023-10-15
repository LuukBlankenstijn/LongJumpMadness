package ned.dejonghblankenstijn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrameBuilder implements ActionListener {
    protected boolean moveChar = true;
    protected boolean moveCloud = true;
    protected boolean drawStartText = true;




    private final Clouds clouds = new Clouds();
    private final Track track = new Track();
    private final MovingCharacter character = new MovingCharacter();


    protected DrawPlane imagePlane = new DrawPlane();


    protected class DrawPlane extends JPanel {
        public void paintComponent(Graphics g) {
            g.drawImage(clouds.showImage, 0, 0, this);
            g.drawImage(track.showImage,0,368,this);
            g.drawImage(character.showImage, 350, 500, this );
            if (drawStartText) {
                g.drawString("Press space to start!",100, 300);
            }
        }
    }

    public FrameBuilder() {
        imagePlane.setFont(new Font("Monaco", Font.PLAIN, 80));
    }

    final Timer timer = new Timer(100, this);
    int timerCycle = 0;

    public void startTimer(){
        timer.start();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (timer.getDelay() > 100) {
            timer.setDelay(timer.getDelay()-20);
        }
         if (moveChar) {
             moveCharacter();
         }
         if (moveCloud) {
             if (timerCycle % 6 == 0) {
                 timerCycle = 0;
                 moveClouds();
             }
         }

        timerCycle++;
        imagePlane.repaint();
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
}
