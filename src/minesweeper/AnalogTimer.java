/* An analog timer gui for java swing: extends AnalogCounter
 * David De Martin
 * 25/5/2021
*/

package src.minesweeper;

import java.awt.event.*;
import javax.swing.Timer;

public class AnalogTimer extends AnalogCounter implements ActionListener {
    ActionListener taskPerformer;
    Timer timer;

    public AnalogTimer(Game game) {
        super(0, game);
        timer = new Timer(1000, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.increment();
    }

    public void start() {
        timer.start();
    }

    public int stop() {
        timer.stop();

        return getValue();
    }

    public boolean isRunning() {
        return this.timer.isRunning();
    }
}