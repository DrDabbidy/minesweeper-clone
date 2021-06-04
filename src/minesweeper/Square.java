/* Square class for java swing minesweeper clone 
 * David De Martin
 * 25/5/2021
*/

package src.minesweeper;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

// public class Square extends JButton {
public class Square extends JLabel {
    public static final int sideLength = 25;
    
    // needed data for each button
    private int value, state, row, col;
    private ImageIcon state1;
    private Game game;

    public Square(int row, int col, Game game) {
        this.row = row;
        this.col = col;
        this.game = game;

        setSize(sideLength, sideLength);
        setState(0);
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
        switch (value) {
            case -1:
                state1 = game.icons.valueNeg1;
                // state1 = Icons.valueNeg1;
                break;
            case 0:
                state1 = game.icons.value0;
                // state1 = Icons.value0;
                break;
            case 1:
                state1 = game.icons.value1;
                // state1 = Icons.value1;
                break;
            case 2:
                state1 = game.icons.value2;
                // state1 = Icons.value2;
                break;
            case 3:
                state1 = game.icons.value3;
                // state1 = Icons.value3;
                break;
            case 4:
                state1 = game.icons.value4;
                // state1 = Icons.value4;
                break;
            case 5:
                state1 = game.icons.value5;
                // state1 = Icons.value5;
                break;
            case 6:
                state1 = game.icons.value6;
                // state1 = Icons.value6;
                break;
            case 7:
                state1 = game.icons.value7;
                // state1 = Icons.value7;
                break;
            case 8:
                state1 = game.icons.value8;
                // state1 = Icons.value8;
                break;
        }
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;

        // set the button's icon to the proper state
        switch (state) {
            case 0:
                setIcon(game.icons.state0); // undug
                // setIcon(Icons.state0); // undug
                break;
            case 1:
                setIcon(state1); // dug
                break;
            case 2:
                setIcon(game.icons.state2); // flagged
                // setIcon(Icons.state2); // flagged
                break;
            case 3:
                setIcon(game.icons.state3); // pressed button
                // setIcon(Icons.state3); // pressed button
                break;
            case 4:
                setIcon(game.icons.state4); // wrong flag
                // setIcon(Icons.state4); // wrong flag
                break;
            case 5:
                setIcon(game.icons.state5); // clicked bomb
                // setIcon(Icons.state5); // clicked bomb
                break;
        }
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
}
