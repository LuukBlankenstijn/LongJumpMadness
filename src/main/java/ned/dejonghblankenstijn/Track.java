package ned.dejonghblankenstijn;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Track {
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final int frameSize = screenSize.height;

    protected Image[] frames = {
//            new ImageIcon("src/main/resources/Track/Track.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Track/Sandbox1.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Track/Sandbox2.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Track/Sandbox3.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Track/Sandbox4.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Track/Sandbox5.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Track/Sandbox6.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Track/Sandbox7.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Track/Sandbox8.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Track/Sandbox9.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Track/Sandbox10.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Track/Sandbox11.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Track/Sandbox12.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Track/Sandbox13.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Track/Sandbox14.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Track/Sandbox15.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Track/Sandbox16.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
    };

    protected Image showImage = frames[0];

    protected void nextImage() {
        int currentIndex = Arrays.asList(frames).indexOf(showImage);
        int newIndex = (currentIndex < frames.length-1) ? currentIndex+1 : 0;
        showImage = frames[newIndex];
    }
}
