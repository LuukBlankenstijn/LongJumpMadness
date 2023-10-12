package ned.dejonghblankenstijn;

import java.awt.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class MovingCharacter {
    protected ImageIcon[] frames = {
            new ImageIcon("src/main/resources/Player/Player/Player_frames1.png"),
            new ImageIcon("src/main/resources/Player/Player/Player_frames2.png"),
            new ImageIcon("src/main/resources/Player/Player/Player_frames3.png"),
            new ImageIcon("src/main/resources/Player/Player/Player_frames4.png"),
            new ImageIcon("src/main/resources/Player/Player/Player_frames5.png"),
            new ImageIcon("src/main/resources/Player/Player/Player_frames6.png"),
            new ImageIcon("src/main/resources/Player/Player/Player_frames7.png"),
            new ImageIcon("src/main/resources/Player/Player/Player_frames8.png"),
    };
    protected JLabel image = new JLabel(frames[0]);



}

