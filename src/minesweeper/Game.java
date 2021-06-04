/* Minesweeper clone made in Java Swing
 * David De Martin
 * ICS4u
 * 25/5/2021
*/

package src.minesweeper;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

public class Game extends JFrame implements ActionListener {
    boolean gameOver;
    Board gridFrontend;
    enum Difficulty {
        BEGINNER,
        INTERMEDIATE,
        EXPERT,
        CUSTOM
    }
    Difficulty difficulty = Difficulty.INTERMEDIATE;
    final int[] beginner = {9, 9, 10};
    final int[] intermediate = {16, 16, 40};
    final int[] expert = {16, 30, 99};
    int[] custom = {22, 36, 178};
    public final Icons icons = new Icons();
    JMenuBar menu;
    JMenu gameMenu, helpMenu;
    JMenuItem newGameItem, bestTimesItem, exitItem, howToPlayItem, beginnerItem, intermediateItem, expertItem, customItem;
    BufferedReader br;
    BufferedWriter bw;
    Time[] bestTimes;
    File leaderboard;

    public Game() throws IOException {
        setTitle("Minesweeper!");
        setResizable(false);
        // setIconImage(ImageIO.read(new File("assets\\-1.bmp"))); // use if you open the minesweeper folder directly
        setIconImage(ImageIO.read(getClass().getResource("-1.bmp"))); // use for jar
        
        gameOver = false;

        // init the menu bar
        initMenuBar();
            
        // create and add the board
        gridFrontend = new Board(intermediate, this);
        add(gridFrontend);
        pack();

        // create and manage the leaderboards
        bestTimes = new Time[3];
        createLeaderboard();
        getBestTimes();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JMenuItem choice = (JMenuItem) e.getSource();

        // do various actions based on which component was clicked
        if (choice == exitItem) {
            // exit the application
            System.exit(0);
        }
        else if (choice == beginnerItem) {              // set the difficulty
            if (difficulty != Difficulty.BEGINNER) {
                difficulty = Difficulty.BEGINNER;
                playAgain();
            }
        }
        else if (choice == intermediateItem) {
            if (difficulty != Difficulty.INTERMEDIATE) {
                difficulty = Difficulty.INTERMEDIATE;
                playAgain();
            }
        }
        else if (choice == expertItem) {
            if (difficulty != Difficulty.EXPERT) {
                difficulty = Difficulty.EXPERT;
                playAgain();
            }
        }
        else if (choice == customItem) {
            if (difficulty != Difficulty.CUSTOM) {
                difficulty = Difficulty.CUSTOM;
            }
            new CustomDialog(this);
        }
        else if (choice == bestTimesItem) {
            // show the leaderboard
            displayBestTimes();
        }
        else if (choice == newGameItem) {
            // play again
            playAgain();
        }
        else if (choice == howToPlayItem) {
            // show the info dialogue
            new InfoDialog();
        }
    }

    public void setCustom(int rows, int cols, int numBombs) {
        custom = new int[]{ rows, cols, numBombs };
    }

    // resets the game and creates/adds a new board
    public void playAgain() {
        gameOver = false;
        remove(gridFrontend);

        switch(difficulty) {
            case BEGINNER:
                gridFrontend = new Board(beginner, this);
                break;
            case INTERMEDIATE:           
                gridFrontend = new Board(intermediate, this);
                break;
            case EXPERT:
                gridFrontend = new Board(expert, this);
                break;
            case CUSTOM:
                gridFrontend = new Board(custom, this);
                break;
        }

        add(gridFrontend);
        validate();
        repaint();
        pack();
    }

    // initializes the menu bar and adds it
    public void initMenuBar() {
        menu = new JMenuBar();

        gameMenu = new JMenu("Game");
        newGameItem = new JMenuItem("New");
        beginnerItem = new JMenuItem("Beginner");
        intermediateItem = new JMenuItem("Intermediate");
        expertItem = new JMenuItem("Expert");
        customItem = new JMenuItem("Custom...");
        bestTimesItem = new JMenuItem("Best Times");
        exitItem = new JMenuItem("Exit");
        newGameItem.addActionListener(this);
        beginnerItem.addActionListener(this);
        intermediateItem.addActionListener(this);
        expertItem.addActionListener(this);
        customItem.addActionListener(this);
        bestTimesItem.addActionListener(this);
        exitItem.addActionListener(this);
        gameMenu.add(newGameItem);
        gameMenu.addSeparator();;
        gameMenu.add(beginnerItem);
        gameMenu.add(intermediateItem);
        gameMenu.add(expertItem);
        gameMenu.add(customItem);
        gameMenu.addSeparator();
        gameMenu.add(bestTimesItem);
        gameMenu.addSeparator();
        gameMenu.add(exitItem);

        helpMenu = new JMenu("Help");
        howToPlayItem = new JMenuItem("How to play");
        howToPlayItem.addActionListener(this);
        helpMenu.add(howToPlayItem);

        menu.add(gameMenu);
        menu.add(helpMenu);

        setJMenuBar(menu);
    }

    // creates leaderboard file if none present. inits leaderboard File variable
    public void createLeaderboard() {
       leaderboard = new File(System.getProperty("user.home") + "\\leaderboard.txt");
        if (!leaderboard.exists()) {
            try {
                leaderboard.createNewFile();
                resetBestTimes();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // reads the leaderboard from file
    public void getBestTimes() {
        try {
            br = new BufferedReader(new FileReader(leaderboard));
            // br = new BufferedReader(new FileReader("src\\assets\\leaderboard.txt".toString()));

            for (int i = 0; i < 3; i++) {
                String[] temp = br.readLine().split(" ");
                bestTimes[i] = new Time(temp[0], Integer.parseInt(temp[1]));
            }

            br.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // writes new best times to leaderboard
    public void setBestTimes() {
        try {
            bw = new BufferedWriter(new FileWriter(leaderboard, false));
            // bw = new BufferedWriter(new FileWriter("src\\assets\\leaderboard.txt", false));

            for (int i = 0; i < 3; i++) {
                bw.write(sanitize(bestTimes[i].getName()) + " " + bestTimes[i].getTime() + "\n");
            }

            bw.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // update the bestTimes array with a new time when game ends
    public void updateBestTimes(int time) {
        int i = 0;
        switch (difficulty) {
            case BEGINNER:
                i = 0;
                break;
            case INTERMEDIATE:
                i = 1;
                break;
            case EXPERT:
                i = 2;    
                break;
            case CUSTOM:
                return;    
        }        
        if (time < bestTimes[i].getTime()) {
            String name = JOptionPane.showInputDialog(null, new JLabel("<html>You have the fastest time for this level. Please enter your name.</html>"), "About", JOptionPane.PLAIN_MESSAGE);

            if (name == null) { name = "Anonymous"; }

            bestTimes[i] = new Time(name, time);

            setBestTimes();
        }
    }

    // resets the best times file and array
    public void resetBestTimes() {
        for (int i = 0; i < 3; i++) {
            bestTimes[i] = new Time("Anonymous", 999);
        }
        setBestTimes();
    }

    // shows the best times with a custom JDialog
    public void displayBestTimes() {
        JDialog dialog = new JDialog();
        JLabel name1, time1, name2, time2, name3, time3;
        JButton exit, reset;

        dialog.setSize(300, 225);
        dialog.setLayout(null);

        name1 = new JLabel(formatName(bestTimes[0].getName()));
        name1.setBounds(25, 15, 100, 25);
        time1 = new JLabel(Integer.toString(bestTimes[0].getTime())+ " seconds");
        time1.setBounds(175, 15, 100, 25);
        
        name2 = new JLabel(formatName(bestTimes[1].getName()));
        name2.setBounds(25, 50, 100, 25);
        time2 = new JLabel(Integer.toString(bestTimes[1].getTime())+ " seconds");
        time2.setBounds(175, 50, 100, 25);
        
        name3 = new JLabel(formatName(bestTimes[2].getName()));
        name3.setBounds(25, 85, 100, 25);
        time3 = new JLabel(Integer.toString(bestTimes[2].getTime())+ " seconds");
        time3.setBounds(175, 85, 100, 25);

        exit = new JButton("Exit");
        exit.setBounds(175, 125, 100, 30);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        reset = new JButton("Reset");
        reset.setBounds(25, 125, 100, 30);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetBestTimes();
                time1.setText("999 seconds");
                time2.setText("999 seconds");
                time3.setText("999 seconds");
                name1.setText("Anonymous");
                name2.setText("Anonymous");
                name3.setText("Anonymous");
            }
        });
        
        dialog.add(exit);
        dialog.add(reset);
        dialog.add(time1);
        dialog.add(time2);
        dialog.add(time3);
        dialog.add(name1);
        dialog.add(name2);
        dialog.add(name3);

        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    // formats names to keep them below a certain length
    public String formatName(String name) {
        if (name.length() > 15) {
            return name.substring(0, 15) + "...";
        }
        return name;
    }

    // removes spaces from names to avoid errors
    public String sanitize(String s) {
        return s.replaceAll(" ", "_");
    }

    public static void main(String[] args) throws IOException {
        new Game();
    }
}