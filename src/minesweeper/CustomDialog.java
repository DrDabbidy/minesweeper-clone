/* The custom game dialog to set the width, height, and # bombs for java swing minesweeper game
 * David De Martin
 * 25/5/2021
*/

package src.minesweeper;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomDialog extends JDialog implements ActionListener {
    JSpinner rowsSpinner, colsSpinner, numBombsSpinner;
    JButton submit, cancel;
    JLabel rowsLabel, colsLabel, numBombsLabel;
    Game game;
    
    public CustomDialog(Game game) {
        this.game = game;

        setTitle("Custom...");
        setLayout(null);
        setSize(250, 200);

        // value, min, max, step
        rowsSpinner = new JSpinner(new SpinnerNumberModel(22, 1, 80, 1));
        colsSpinner = new JSpinner(new SpinnerNumberModel(36, 1, 80, 1));
        numBombsSpinner = new JSpinner(new SpinnerNumberModel(178, 1, 999, 1));

        rowsLabel = new JLabel("Rows: ");
        colsLabel = new JLabel("Cols: ");
        numBombsLabel = new JLabel("Bombs: ");
        
        submit = new JButton("Submit");
        submit.addActionListener(this);
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);

        setLayoutAndSizes();
        addComponenets();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    void setLayoutAndSizes() {
        rowsSpinner.setBounds(90, 10, 50, 30);
        colsSpinner.setBounds(90, 50, 50, 30);
        numBombsSpinner.setBounds(90, 90, 50, 30);

        rowsLabel.setBounds(10, 10, 75, 30);
        colsLabel.setBounds(10, 50, 75, 30);
        numBombsLabel.setBounds(10, 90, 75, 30);

        submit.setBounds(150, 10, 75, 30);
        cancel.setBounds(150, 90, 75, 30);
    }

    void addComponenets() {
        add(rowsSpinner);
        add(colsSpinner);
        add(numBombsSpinner);
        add(rowsLabel);
        add(colsLabel);
        add(numBombsLabel);
        add(submit);
        add(cancel);
    }

    public void actionPerformed(ActionEvent e) {
        Object choice = e.getSource();

        if (choice == submit) {
            int rows = (int)rowsSpinner.getValue(), cols = (int)colsSpinner.getValue(), numBombs = (int)numBombsSpinner.getValue();
            if (rows*cols >= numBombs) {
                game.setCustom(rows, cols, numBombs);
            }
            game.playAgain();
            dispose();
        }
        else if (choice == cancel) {
            dispose();
        }
    }
}
