package ned.dejonghblankenstijn;

import javax.swing.*;
import java.awt.*;
//import java.util.Arrays;

public class Track {

    protected Image[] frames = {
            new ImageIcon("src/main/resources/Track/Track.png").getImage().getScaledInstance(1024,-1,Image.SCALE_DEFAULT)

    };

    protected Image showImage = frames[0];

//    protected void nextImage() {
//        int currentIndex = Arrays.asList(frames).indexOf(showImage);
//        int newIndex = (currentIndex < frames.length-1) ? currentIndex+1 : 0;
//        showImage = frames[newIndex];
//    }
}
