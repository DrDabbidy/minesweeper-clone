/* The info window for java swing minesweeper clone
 * David De Martin
 * 25/5/2021
*/

package src.minesweeper;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class InfoDialog extends JDialog {
    JLabel info;

    public InfoDialog() {
        setSize(550, 200);
        info = new JLabel(
            "<html>" +
            "<div style='margin: 50, 50, 50, 25'>" +
            "<h3>How to play Minesweeper!</h3>" +
            "<p>- You are presented with a minefield.</p>" +
            "<p>- You must uncover all the safe squares, without digging up any mines.</p>" +
            "<p>- Left click to dig up a square.</p>" +
            "<p>- Right click to put down a flag where you think a mine exists.</p>" +
            "<p>- When you open a square, the number tells you how many mines are adjacent to that square.</p>" +
            "</div>" +
            "</html>");
        add(info);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
