package ned.dejonghblankenstijn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delay implements ActionListener {

    private final Timer delay = new Timer(0,this);

    @Override
    public void actionPerformed(ActionEvent e) {
        delay.stop();
    }

    public void add(int milli) {
        delay.setInitialDelay(milli);
        delay.start();
        while (delay.isRunning()) {
            continue;
        }
    }

    public void remove() {
        delay.stop();
    }
}
