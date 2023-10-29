package ned.dejonghblankenstijn;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class MovingCharacter {
    private final static int playerScale = 5;
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    protected Image[] frames = {
            new ImageIcon("src/main/resources/Character/Player_frames1.png").getImage().getScaledInstance(-1, screenSize.height / playerScale, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Character/Player_frames2.png").getImage().getScaledInstance(-1, screenSize.height / playerScale, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Character/Player_frames3.png").getImage().getScaledInstance(-1, screenSize.height / playerScale, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Character/Player_frames4.png").getImage().getScaledInstance(-1, screenSize.height / playerScale, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Character/Player_frames5.png").getImage().getScaledInstance(-1, screenSize.height / playerScale, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Character/Player_frames6.png").getImage().getScaledInstance(-1, screenSize.height / playerScale, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Character/Player_frames7.png").getImage().getScaledInstance(-1, screenSize.height / playerScale, Image.SCALE_DEFAULT),
    };

    protected Image showImage = frames[2];

    protected void nextImage() {
        int currentIndex = Arrays.asList(frames).indexOf(showImage);
        int newIndex = (currentIndex < frames.length - 1) ? currentIndex + 1 : 0;
        showImage = frames[newIndex];
    }

}
