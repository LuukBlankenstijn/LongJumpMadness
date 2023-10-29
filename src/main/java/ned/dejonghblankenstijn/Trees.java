package ned.dejonghblankenstijn;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Trees {

    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final int frameSize = screenSize.height;

    protected Image[] frames = {
            new ImageIcon("src/main/resources/Trees/Track trees1.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Trees/Track trees2.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Trees/Track trees3.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Trees/Track trees4.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Trees/Track trees5.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Trees/Track trees6.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Trees/Track trees7.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Trees/Track trees8.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Trees/Track trees9.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
            new ImageIcon("src/main/resources/Trees/Track trees10.png").getImage().getScaledInstance(frameSize,-1,Image.SCALE_DEFAULT),
    };

    protected Image showImage = frames[0];

    protected void nextImage() {
        int currentIndex = Arrays.asList(frames).indexOf(showImage);
        int newIndex = (currentIndex < frames.length-1) ? currentIndex+1 : 0;
        showImage = frames[newIndex];
    }
}
