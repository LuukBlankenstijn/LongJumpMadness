package ned.dejonghblankenstijn;

import java.awt.*;
import javax.swing.*;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class Game{
    JFrame frame = new JFrame("Long Jump Madness");

    private Background background;
    private Track track;
    private final MovingCharacter character = new MovingCharacter();
    private ScoreMenu score;

    private StageOne stageOne;
    private StageTwo stageTwo;
    private StageThree stageThree;

    protected boolean moveCharacter;
    protected boolean moveClouds;

    Timer timer = new Timer("Clock");
    private int clockCounter = 0;
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if (moveCharacter) {
                character.image.setIcon(character.frames[clockCounter%8]);
            }
            clockCounter++;
        }
    };

    public Game() {
        frame.setSize(1152,1050);
        frame.add(character.image);
        moveCharacter=true;
        timer.schedule(task,0,100);
        frame.setVisible(true);
    }
}
