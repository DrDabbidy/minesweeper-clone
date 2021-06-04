/* Board class for java swing minesweeper clone 
 * David De Martin
 * 25/5/2021
*/

package src.minesweeper;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class Board extends JPanel {
    Square[][] gridBackend;
    Random rdm = new Random();
    int rows, cols, numBombs, numDugSquares, offset, pressedRow, pressedCol;
    Game game;
    JLabel playAgainButton;
    AnalogCounter bombCounter;
    boolean mousePressedOnSquare, mouseMiddlePressedOnSquare;
    AnalogTimer timer;

    // initialize the Board object
    public Board(int[] data, Game game) {
        this.rows = data[0];
        this.cols = data[1];
        this.numBombs = data[2];
        this.game = game;
        numDugSquares = 0;
        offset = 50;
        mousePressedOnSquare = false;
        mouseMiddlePressedOnSquare = false;


        setPreferredSize(new Dimension(cols*Square.sideLength, rows*Square.sideLength+offset));
        setLayout(null);

        initializePlayAgainButton();
        initializeBombCounter();
        initializeTimer();
        initializeBoard();
    }

    // initialize the board
    void initializeBoard() {
        gridBackend = new Square[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // create the Square
                gridBackend[row][col] = new Square(row, col, game);
                // add the listener to respond to left, middle, and right clicks, presses, releases, etc.
                gridBackend[row][col].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {}

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        if (game.gameOver) { return; }

                        Square square = (Square)e.getSource();

                        if (mousePressedOnSquare) {
                            if (square.getState() == 0) {
                                square.setState(3);
                            }
                        }
                        if (mouseMiddlePressedOnSquare) {
                            if (square.getState() == 1) {
                                middlePressed(square);
                            }
                        }
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        Square square = (Square)e.getSource();
                        if (square.getState() == 3) {
                            square.setState(0);
                        }
                        if (mouseMiddlePressedOnSquare) {
                            middleReleased(square);
                        }
                    }
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (game.gameOver) { return; }
                        
                        Square square = (Square)e.getSource();
                        pressedRow = square.getRow();
                        pressedCol = square.getCol();
                        int button = e.getButton();

                        if (square.getState() == 0 && button == MouseEvent.BUTTON1) {
                            mousePressedOnSquare = true;
                            square.setState(3);
                            playAgainButton.setIcon(game.icons.faceIcons[2]);
                            // playAgainButton.setIcon(Icons.faceIcons[2]);
                        }
                        else if (square.getState() == 1 && button == MouseEvent.BUTTON2) {
                            mouseMiddlePressedOnSquare = true;
                            middlePressed(square);
                        }
                        
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) {                 
                        Square s = (Square)e.getSource();
                        int y = (int)e.getPoint().getY()+s.getY()-50, x = (int)e.getPoint().getX()+s.getX();
                        int col = x / Square.sideLength;
                        int row = y / Square.sideLength;

                        try {
                            Square square = gridBackend[row][col];

                            if (square.getState() == 3) {
                                square.setState(0);
                                playAgainButton.setIcon(game.icons.faceIcons[0]);
                                // playAgainButton.setIcon(Icons.faceIcons[0]);
                            }

                            if (game.gameOver) { return; }

                            switch (e.getButton()) {
                                case MouseEvent.BUTTON1:
                                    mousePressedOnSquare = false;
                                    leftClicked(square);
                                    break;
                                case MouseEvent.BUTTON3:
                                    rightClicked(square);
                                    break;
                                case MouseEvent.BUTTON2:
                                    mouseMiddlePressedOnSquare = false;
                                    // middleReleased(square);
                                    middleClicked(square);
                                    break;
                            }
                        }
                        catch (Exception error) {
                            error.printStackTrace();
                        }
                    }
                });
                
                gridBackend[row][col].setBounds(col*Square.sideLength, row*Square.sideLength+offset, Square.sideLength, Square.sideLength);
                add(gridBackend[row][col]);
            }
        }

        addBombs();
        addDangers();
    }

    // randomly add bombs to the board
    void addBombs() {
        ArrayList<Integer> chosen = new ArrayList<Integer>(numBombs);
        for (int i = 0; i < numBombs; i++) {
            while (true) {
                int candidate = rdm.nextInt(rows*cols);
                if (!chosen.contains(candidate)) {
                    gridBackend[candidate / cols][candidate % cols].setValue(-1);
                    // grid[candidate / 16][candidate % 16].setState(1); // DELETE
                    chosen.add(candidate);
                    break;
                }
            }
        }
    }

    // set the values of all the squares to their danger value
    void addDangers() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (gridBackend[row][col].getValue() != -1) {
                    gridBackend[row][col].setValue(getDanger(row, col));
                }
            }
        }
    }

    // get the danger value of a square (equal to # of adjacent bombs)
    int getDanger(int row, int col) {
        int count = 0;
        int[][] offsets = {{-1,-1},{-1, 0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};

        for (int[] offset : offsets) {
            int newrow = row + offset[0];
            int newcol = col + offset[1];
            if (newrow >= 0 && newrow < rows && newcol >= 0 && newcol < cols && gridBackend[newrow][newcol].getValue() == -1) {
                count++;
            }
        }

        return count;
    }

    // init play button with action listener to create a new game when clicked
    void initializePlayAgainButton() {
        playAgainButton = new JLabel();
        playAgainButton.setSize(40, 40);
        playAgainButton.setIcon(game.icons.faceIcons[0]);
        // playAgainButton.setIcon(Icons.faceIcons[0]);
        playAgainButton.setBounds((cols*Square.sideLength)/2 - 20, 5, 40, 40);
        playAgainButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                // playAgainButton.setIcon(Icons.faceIcons[1]);
                playAgainButton.setIcon(game.icons.faceIcons[1]);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                playAgainButton.setIcon(game.icons.faceIcons[0]);
                // playAgainButton.setIcon(Icons.faceIcons[0]);
                game.playAgain();
            }
        });

        add(playAgainButton);
    }

    // create a new bomb counter
    void initializeBombCounter() {
        bombCounter = new AnalogCounter(numBombs, game);
        bombCounter.setBounds(10, 5, 64, 40);

        add(bombCounter);
    }

    // create a new timer
    void initializeTimer() {
        timer = new AnalogTimer(game);
        timer.setBounds(cols*Square.sideLength - 74, 5, 64, 40);

        add(timer);
    }

    // called when a square is left clicked
    void leftClicked(Square square) {
        // make sure the square is undug
        if (square.getState() == 0) {
            // start the timer if not running
            if (!timer.isRunning()) {
                timer.start();
            }

            // do various actions based on the square's value
            if (square.getValue() == 0) {
                square.setState(1);
                numDugSquares++;
                floodFill(square.getRow(), square.getCol());
            }
            else if (square.getValue() == -1) {
                square.setState(5);
                revealBombs();
                game.gameOver = true;
                timer.stop();
                // playAgainButton.setIcon(Icons.faceIcons[4]);
                playAgainButton.setIcon(game.icons.faceIcons[4]);
            }
            else {
                square.setState(1);
                numDugSquares++;
            }

            // numDugSquares = 0;
            // for (Square[] row : gridBackend) {
            //     for (Square s : row) {
            //         if (s.getState() == 1) {
            //             numDugSquares++;
            //         }
            //     }
            // }
            
            // check if all squares that are not bombs have been dug. if so, game ends in win
            if (numDugSquares == cols*rows - numBombs && !game.gameOver) {
                game.gameOver = true;
                flagBombs();
                // playAgainButton.setIcon(Icons.faceIcons[3]);
                playAgainButton.setIcon(game.icons.faceIcons[3]);
                game.updateBestTimes(timer.stop());
            }
        }
    }

    // called when square is right clicked. will flag the square if undug
    void rightClicked(Square square) {
        if (square.getState() == 0) {
            square.setState(2);
            bombCounter.decrement();
        }
        else if (square.getState() == 2) {
            square.setState(0);
            bombCounter.increment();
        }
    }

    // called when middle click is pressed on a square
    void middlePressed(Square square) {
        int[][] offsets = {{-1,-1},{-1, 0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};

        for (int[] offset : offsets) {
            int newrow = square.getRow() + offset[0];
            int newcol = square.getCol() + offset[1];
            if (newrow >= 0 && newrow < rows && newcol >= 0 && newcol < cols && gridBackend[newrow][newcol].getState() == 0) {
                gridBackend[newrow][newcol].setState(3);
            }
        }
    }

    // called when middle click is released from a square
    void middleReleased(Square square) {
        int[][] offsets = {{-1,-1},{-1, 0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};

        for (int[] offset : offsets) {
            int newrow = square.getRow() + offset[0];
            int newcol = square.getCol() + offset[1];
            if (newrow >= 0 && newrow < rows && newcol >= 0 && newcol < cols && gridBackend[newrow][newcol].getState() == 3) {
                gridBackend[newrow][newcol].setState(0);
            }
        }
    }

    // called when a square is middle clicked... this should dig all adjacent squares if proper number of flags are adjacent
    void middleClicked(Square square) {
        int[][] offsets = {{-1,-1},{-1, 0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        int numFlagged = 0;

        for (int[] offset : offsets) {
            int newrow = square.getRow() + offset[0];
            int newcol = square.getCol() + offset[1];
            if (newrow >= 0 && newrow < rows && newcol >= 0 && newcol < cols) {
                if (gridBackend[newrow][newcol].getState() == 2) {
                    numFlagged++;
                }
                else if (gridBackend[newrow][newcol].getState() == 3) {
                    gridBackend[newrow][newcol].setState(0);
                }
            }
        }

        if (numFlagged > 0 && numFlagged == square.getValue()) {
            for (int[] offset : offsets) {
                int newrow = square.getRow() + offset[0];
                int newcol = square.getCol() + offset[1];
                if (newrow >= 0 && newrow < rows && newcol >= 0 && newcol < cols && gridBackend[newrow][newcol].getState() == 0) {
                    leftClicked(gridBackend[newrow][newcol]);
                }
            }
        }
    }

    // recursive flood fill method opens up all squares in an empty area when empty square opened
    void floodFill(int row, int col) {
        int[][] offsets = {{-1,-1},{-1, 0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};

        for (int[] offset : offsets) {
            int newrow = row + offset[0];
            int newcol = col + offset[1];
            if (newrow >= 0 && newrow < rows && newcol >= 0 && newcol < cols && gridBackend[newrow][newcol].getState() != 1) {
                if (gridBackend[newrow][newcol].getState() == 2) {
                    bombCounter.increment();
                }
                gridBackend[newrow][newcol].setState(1);
                numDugSquares++;
                if (gridBackend[newrow][newcol].getValue() == 0) {
                    floodFill(newrow, newcol);
                }
            }
        }
    }

    // reveals all the bombs when game ends in loss
    void revealBombs() {
        for (Square[] row : gridBackend) {
            for (Square square : row) {
                if ((square.getState() == 0 || square.getState() == 3) && square.getValue() == -1) {
                    square.setState(1);
                }
                else if (square.getState() == 2 && square.getValue() != -1) {
                    square.setState(4);
                }
            }
        }
    }

    // flags all the remaining bombs when game ends in win
    void flagBombs() {
        for (Square[] row : gridBackend) {
            for (Square square : row) {
                if (square.getState() == 0) {
                    square.setState(2);
                    bombCounter.decrement();
                }
            }
        }
    }
}
