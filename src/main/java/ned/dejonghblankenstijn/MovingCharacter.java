package ned.dejonghblankenstijn;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class MovingCharacter {
    private final static int playerScale = 5;
    private final static int jumpScale = 4;
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

    protected Image[] jump = {
            new ImageIcon("src/main/resources/Player/Jump/player_jump2.png").getImage().getScaledInstance(-1, screenSize.height / jumpScale, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Player/Jump/player_jump3.png").getImage().getScaledInstance(-1, screenSize.height / jumpScale, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Player/Jump/player_jump4.png").getImage().getScaledInstance(-1, screenSize.height / jumpScale, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Player/Jump/player_jump5.png").getImage().getScaledInstance(-1, screenSize.height / jumpScale, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Player/Jump/player_jump6.png").getImage().getScaledInstance(-1, screenSize.height / jumpScale, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Player/Jump/player_jump7.png").getImage().getScaledInstance(-1, screenSize.height / jumpScale, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Player/Jump/player_jump8.png").getImage().getScaledInstance(-1, screenSize.height / jumpScale, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Player/Jump/player_jump9.png").getImage().getScaledInstance(-1, screenSize.height / jumpScale, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Player/Jump/player_jump10.png").getImage().getScaledInstance(-1, screenSize.height / jumpScale, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Player/Jump/player_jump11.png").getImage().getScaledInstance(-1, screenSize.height / jumpScale, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Player/Jump/player_jump12.png").getImage().getScaledInstance(-1, screenSize.height / jumpScale, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Player/Jump/player_jump13.png").getImage().getScaledInstance(-1, screenSize.height / jumpScale, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Player/Jump/player_jump14.png").getImage().getScaledInstance(-1, screenSize.height / jumpScale, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Player/Jump/player_jump15.png").getImage().getScaledInstance(-1, screenSize.height / jumpScale, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Player/Jump/player_jump16.png").getImage().getScaledInstance(-1, screenSize.height / jumpScale, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Player/Jump/player_jump17.png").getImage().getScaledInstance(-1, screenSize.height / jumpScale, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Player/Jump/player_jump18.png").getImage().getScaledInstance(-1, screenSize.height / jumpScale, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Player/Jump/player_jump1.png").getImage().getScaledInstance(-1, screenSize.height / jumpScale, Image.SCALE_DEFAULT),
    };

    protected Image showImage = frames[2];
    protected Image jumpImage = jump[0];

    protected void nextImage() {
        int currentIndex = Arrays.asList(frames).indexOf(showImage);
        int newIndex = (currentIndex < frames.length - 1) ? currentIndex + 1 : 0;
        showImage = frames[newIndex];
    }

    protected void nextImageJump() {
        int currentIndex = Arrays.asList(jump).indexOf(jumpImage);
        int newIndex = (currentIndex < jump.length - 1) ? currentIndex + 1 : currentIndex;
        jumpImage = jump[newIndex];
    }

}
