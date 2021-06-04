/* An analog counter gui for java swing
 * David De Martin
 * 25/5/2021
*/

package src.minesweeper;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class AnalogCounter extends JPanel {
    private JLabel labelOne, labelTwo, labelThree, bg;
    private int value;
    private Game game;

    public AnalogCounter(int startValue, Game game) {
        this.game = game;

        setSize(64, 40);
        setLayout(null);

        if (startValue >= 1000) { startValue = 999; }
        value = startValue;
        
        labelOne = new JLabel();
        labelOne.setSize(18, 34);
        labelOne.setBounds(3, 3, 18, 34);
        
        labelTwo = new JLabel();
        labelTwo.setSize(18, 34);
        labelTwo.setBounds(23, 0, 18, 40);
        
        labelThree = new JLabel();
        labelThree.setSize(18, 34);
        labelThree.setBounds(43, 3, 18, 34);
        
        bg = new JLabel();
        bg.setSize(64, 40);
        bg.setBounds(0, 0, 64, 40);
        bg.setIcon(game.icons.digitsBg);
        // bg.setIcon(Icons.digitsBg);

        add(labelOne);
        add(labelTwo);
        add(labelThree);
        add(bg);
        
        setDigits(value);
    }

    public void increment() {
        value++;
        setDigits(value);
    }

    public void decrement() {
        value--;
        setDigits(value);
    }

    public void setDigits(int num) {
        int[] digits = new int[3];

        digits[0] = num / 100;
        num %= 100;
        digits[1] = num / 10;
        digits[2] = num % 10;

        assignIcon(labelOne, digits[0]);
        assignIcon(labelTwo, digits[1]);
        assignIcon(labelThree, digits[2]);
    }
    
    public void assignIcon(JLabel label, int num) {
        switch (num) {
            case 0:
                label.setIcon(game.icons.digit0);
                // label.setIcon(Icons.digit0);
                break;
            case 1:
                label.setIcon(game.icons.digit1);
                // label.setIcon(Icons.digit1);
                break;
            case 2:
                label.setIcon(game.icons.digit2);
                // label.setIcon(Icons.digit2);
                break;
            case 3:
                label.setIcon(game.icons.digit3);
                // label.setIcon(Icons.digit3);
                break;
            case 4:
                label.setIcon(game.icons.digit4);
                // label.setIcon(Icons.digit4);
                break;
            case 5:
                label.setIcon(game.icons.digit5);
                // label.setIcon(Icons.digit5);
                break;
            case 6:
                label.setIcon(game.icons.digit6);
                // label.setIcon(Icons.digit6);
                break;
            case 7:
                label.setIcon(game.icons.digit7);
                // label.setIcon(Icons.digit7);
                break;
            case 8:
                label.setIcon(game.icons.digit8);
                // label.setIcon(Icons.digit8);
                break;
            case 9:
                label.setIcon(game.icons.digit9);
                // label.setIcon(Icons.digit9);
                break;
        }
    }

    public int getValue() {
        return this.value;
    }
}
