package ned.dejonghblankenstijn;

import java.awt.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class MovingCharacter {
    JFrame frame = new JFrame ("component, container, helper example");
    JPanel panel = new JPanel();
    int counter = 1;

    TimerTask task = new TimerTask() {
        public void run() {
            image.setIcon(frames[counter]);
            counter = (counter < 7) ? counter+1 : 0;
        }
    };

    Timer timer = new Timer();

    ImageIcon[] frames = {new ImageIcon("src/main/resources/Player/Player/Player_frames1.png"),
            new ImageIcon("src/main/resources/Player/Player/Player_frames2.png"),
            new ImageIcon("src/main/resources/Player/Player/Player_frames3.png"),
            new ImageIcon("src/main/resources/Player/Player/Player_frames4.png"),
            new ImageIcon("src/main/resources/Player/Player/Player_frames5.png"),
            new ImageIcon("src/main/resources/Player/Player/Player_frames6.png"),
            new ImageIcon("src/main/resources/Player/Player/Player_frames7.png"),
            new ImageIcon("src/main/resources/Player/Player/Player_frames8.png"),

    };
    JLabel image = new JLabel(frames[0]);


    void demo() {
        frame.add(panel);
        Color mauve = new Color(255, 100, 100);
        panel.setBackground( mauve );
        frame.setSize(400, 300);
        frame.setLocation(2000, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.add(image,BorderLayout.CENTER);


        long delay = 100L;
        timer.schedule(task,delay,delay);






    }
    public static void main(String[] a) { new MovingCharacter().demo(); }
}

