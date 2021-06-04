/* A class of icons for the minesweeper game 
 * David De Martin
 * 25/5/2021
*/

package src.minesweeper;

import javax.swing.ImageIcon;
import java.awt.Image;

public class Icons {
    // icons for different states
    public final ImageIcon state0 = new ImageIcon(new ImageIcon(getClass().getResource("state0.png")).getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use for jar
    public final ImageIcon state2 = new ImageIcon(new ImageIcon(getClass().getResource("state2.png")).getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use for jar
    public final ImageIcon state3 = new ImageIcon(new ImageIcon(getClass().getResource("state3.png")).getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use for jar
    public final ImageIcon state4 = new ImageIcon(new ImageIcon(getClass().getResource("state4.png")).getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use for jar
    public final ImageIcon state5 = new ImageIcon(new ImageIcon(getClass().getResource("state5.png")).getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use for jar
    // public static final ImageIcon state0 = new ImageIcon(new ImageIcon("assets\\state0.png").getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use if you open the minesweeper folder directly
    // public static final ImageIcon state2 = new ImageIcon(new ImageIcon("assets\\state2.png").getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use if you open the minesweeper folder directly
    // public static final ImageIcon state3 = new ImageIcon(new ImageIcon("assets\\state3.png").getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use if you open the minesweeper folder directly
    // public static final ImageIcon state4 = new ImageIcon(new ImageIcon("assets\\state4.png").getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use if you open the minesweeper folder directly
    // public static final ImageIcon state5 = new ImageIcon(new ImageIcon("assets\\state5.png").getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use if you open the minesweeper folder directly

    public final ImageIcon valueNeg1 = new ImageIcon(new ImageIcon(getClass().getResource("-1.png")).getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use for jar
    public final ImageIcon value0 = new ImageIcon(new ImageIcon(getClass().getResource("0.png")).getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use for jar
    public final ImageIcon value1 = new ImageIcon(new ImageIcon(getClass().getResource("1.png")).getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use for jar
    public final ImageIcon value2 = new ImageIcon(new ImageIcon(getClass().getResource("2.png")).getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use for jar
    public final ImageIcon value3 = new ImageIcon(new ImageIcon(getClass().getResource("3.png")).getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use for jar
    public final ImageIcon value4 = new ImageIcon(new ImageIcon(getClass().getResource("4.png")).getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use for jar
    public final ImageIcon value5 = new ImageIcon(new ImageIcon(getClass().getResource("5.png")).getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use for jar
    public final ImageIcon value6 = new ImageIcon(new ImageIcon(getClass().getResource("6.png")).getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use for jar
    public final ImageIcon value7 = new ImageIcon(new ImageIcon(getClass().getResource("7.png")).getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use for jar
    public final ImageIcon value8 = new ImageIcon(new ImageIcon(getClass().getResource("8.png")).getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use for jar
    // public static final ImageIcon valueNeg1 = new ImageIcon(new ImageIcon("assets\\-1.png").getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use if you open the minesweeper folder directly
    // public static final ImageIcon value0 = new ImageIcon(new ImageIcon("assets\\0.png").getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use if you open the minesweeper folder directly
    // public static final ImageIcon value1 = new ImageIcon(new ImageIcon("assets\\1.png").getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use if you open the minesweeper folder directly
    // public static final ImageIcon value2 = new ImageIcon(new ImageIcon("assets\\2.png").getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use if you open the minesweeper folder directly
    // public static final ImageIcon value3 = new ImageIcon(new ImageIcon("assets\\3.png").getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use if you open the minesweeper folder directly
    // public static final ImageIcon value4 = new ImageIcon(new ImageIcon("assets\\4.png").getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use if you open the minesweeper folder directly
    // public static final ImageIcon value5 = new ImageIcon(new ImageIcon("assets\\5.png").getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use if you open the minesweeper folder directly
    // public static final ImageIcon value6 = new ImageIcon(new ImageIcon("assets\\6.png").getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use if you open the minesweeper folder directly
    // public static final ImageIcon value7 = new ImageIcon(new ImageIcon("assets\\7.png").getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use if you open the minesweeper folder directly
    // public static final ImageIcon value8 = new ImageIcon(new ImageIcon("assets\\8.png").getImage().getScaledInstance(Square.sideLength, Square.sideLength, Image.SCALE_SMOOTH)); // use if you open the minesweeper folder directly

    public final ImageIcon digit0 = new ImageIcon(new ImageIcon(getClass().getResource("d0.png")).getImage().getScaledInstance(18, 34, Image.SCALE_SMOOTH)); // use for jar
    public final ImageIcon digit1 = new ImageIcon(new ImageIcon(getClass().getResource("d1.png")).getImage().getScaledInstance(18, 34, Image.SCALE_SMOOTH)); // use for jar
    public final ImageIcon digit2 = new ImageIcon(new ImageIcon(getClass().getResource("d2.png")).getImage().getScaledInstance(18, 34, Image.SCALE_SMOOTH)); // use for jar
    public final ImageIcon digit3 = new ImageIcon(new ImageIcon(getClass().getResource("d3.png")).getImage().getScaledInstance(18, 34, Image.SCALE_SMOOTH)); // use for jar
    public final ImageIcon digit4 = new ImageIcon(new ImageIcon(getClass().getResource("d4.png")).getImage().getScaledInstance(18, 34, Image.SCALE_SMOOTH)); // use for jar
    public final ImageIcon digit5 = new ImageIcon(new ImageIcon(getClass().getResource("d5.png")).getImage().getScaledInstance(18, 34, Image.SCALE_SMOOTH)); // use for jar
    public final ImageIcon digit6 = new ImageIcon(new ImageIcon(getClass().getResource("d6.png")).getImage().getScaledInstance(18, 34, Image.SCALE_SMOOTH)); // use for jar
    public final ImageIcon digit7 = new ImageIcon(new ImageIcon(getClass().getResource("d7.png")).getImage().getScaledInstance(18, 34, Image.SCALE_SMOOTH)); // use for jar
    public final ImageIcon digit8 = new ImageIcon(new ImageIcon(getClass().getResource("d8.png")).getImage().getScaledInstance(18, 34, Image.SCALE_SMOOTH)); // use for jar
    public final ImageIcon digit9 = new ImageIcon(new ImageIcon(getClass().getResource("d9.png")).getImage().getScaledInstance(18, 34, Image.SCALE_SMOOTH)); // use for jar
    public final ImageIcon digitsBg = new ImageIcon(new ImageIcon(getClass().getResource("nums_background.png")).getImage().getScaledInstance(64, 40, Image.SCALE_SMOOTH)); // use for jar
    // public static final ImageIcon digit0 = new ImageIcon(new ImageIcon("assets\\d0.png").getImage().getScaledInstance(18, 34, Image.SCALE_SMOOTH));
    // public static final ImageIcon digit1 = new ImageIcon(new ImageIcon("assets\\d1.png").getImage().getScaledInstance(18, 34, Image.SCALE_SMOOTH));
    // public static final ImageIcon digit2 = new ImageIcon(new ImageIcon("assets\\d2.png").getImage().getScaledInstance(18, 34, Image.SCALE_SMOOTH));
    // public static final ImageIcon digit3 = new ImageIcon(new ImageIcon("assets\\d3.png").getImage().getScaledInstance(18, 34, Image.SCALE_SMOOTH));
    // public static final ImageIcon digit4 = new ImageIcon(new ImageIcon("assets\\d4.png").getImage().getScaledInstance(18, 34, Image.SCALE_SMOOTH));
    // public static final ImageIcon digit5 = new ImageIcon(new ImageIcon("assets\\d5.png").getImage().getScaledInstance(18, 34, Image.SCALE_SMOOTH));
    // public static final ImageIcon digit6 = new ImageIcon(new ImageIcon("assets\\d6.png").getImage().getScaledInstance(18, 34, Image.SCALE_SMOOTH));
    // public static final ImageIcon digit7 = new ImageIcon(new ImageIcon("assets\\d7.png").getImage().getScaledInstance(18, 34, Image.SCALE_SMOOTH));
    // public static final ImageIcon digit8 = new ImageIcon(new ImageIcon("assets\\d8.png").getImage().getScaledInstance(18, 34, Image.SCALE_SMOOTH));
    // public static final ImageIcon digit9 = new ImageIcon(new ImageIcon("assets\\d9.png").getImage().getScaledInstance(18, 34, Image.SCALE_SMOOTH));
    // public static final ImageIcon digitsBg = new ImageIcon(new ImageIcon("assets\\nums_background.png").getImage().getScaledInstance(64, 40, Image.SCALE_SMOOTH));

    public final ImageIcon[] faceIcons = new ImageIcon[]{new ImageIcon(getClass().getResource("face_unpressed.png")), new ImageIcon(getClass().getResource("face_pressed.png")), new ImageIcon(getClass().getResource("face_active.png")), new ImageIcon(getClass().getResource("face_victory.png")), new ImageIcon(getClass().getResource("face_lose.png"))};  // use for jar
    // public static final ImageIcon[] faceIcons = new ImageIcon[]{new ImageIcon("assets\\face_unpressed.png"), new ImageIcon("assets\\face_pressed.png"), new ImageIcon("assets\\face_active.png"), new ImageIcon("assets\\face_victory.png"), new ImageIcon("assets\\face_lose.png")};
}
