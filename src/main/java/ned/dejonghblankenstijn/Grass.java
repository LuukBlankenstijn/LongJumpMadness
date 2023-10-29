package ned.dejonghblankenstijn;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Grass {

    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final int frameSize = screenSize.height;

    protected Image[] frames = {
            new ImageIcon("src/main/resources/Grass/Trackgrass1.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Grass/Trackgrass2.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Grass/Trackgrass3.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Grass/Trackgrass4.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Grass/Trackgrass5.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Grass/Trackgrass6.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Grass/Trackgrass7.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Grass/Trackgrass8.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Grass/Trackgrass9.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Grass/Trackgrass10.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Grass/Trackgrass11.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Grass/Trackgrass12.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Grass/Trackgrass13.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),


    };

    protected Image showImage = frames[0];

    protected void nextImage() {
        int currentIndex = Arrays.asList(frames).indexOf(showImage);
        int newIndex = (currentIndex < frames.length-1) ? currentIndex+1 : 0;
        showImage = frames[newIndex];
    }
}
