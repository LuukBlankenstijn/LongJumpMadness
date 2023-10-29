package ned.dejonghblankenstijn;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Clouds {
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final int frameSize = screenSize.height;
    protected Image[] frames = {
            new ImageIcon("src/main/resources/Clouds/Clouds_background1.png").getImage().getScaledInstance(frameSize, -1, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Clouds/Clouds_background2.png").getImage().getScaledInstance(frameSize, -1, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Clouds/Clouds_background3.png").getImage().getScaledInstance(frameSize, -1, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Clouds/Clouds_background4.png").getImage().getScaledInstance(frameSize, -1, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Clouds/Clouds_background5.png").getImage().getScaledInstance(frameSize, -1, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Clouds/Clouds_background6.png").getImage().getScaledInstance(frameSize, -1, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Clouds/Clouds_background7.png").getImage().getScaledInstance(frameSize, -1, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Clouds/Clouds_background8.png").getImage().getScaledInstance(frameSize, -1, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Clouds/Clouds_background9.png").getImage().getScaledInstance(frameSize, -1, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Clouds/Clouds_background10.png").getImage().getScaledInstance(frameSize, -1, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Clouds/Clouds_background11.png").getImage().getScaledInstance(frameSize, -1, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Clouds/Clouds_background12.png").getImage().getScaledInstance(frameSize, -1, Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Clouds/Clouds_background13.png").getImage().getScaledInstance(frameSize, -1, Image.SCALE_DEFAULT),
    };

    protected Image showImage = frames[0];

    protected void nextImage() {
        int currentIndex = Arrays.asList(frames).indexOf(showImage);
        int newIndex = (currentIndex < frames.length - 1) ? currentIndex + 1 : 0;
        showImage = frames[newIndex];
    }
}
