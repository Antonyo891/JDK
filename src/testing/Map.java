package testing;

import testing.logic.Game;
import testing.logic.GameLogik;
import testing.logic.Winner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class Map extends JPanel {
    private int panelWidth;
    private int panelHeight;
    private int cellHeight;
    private int cellWidth;
    private int sizeX;
    private int sizeY;
    private final char DOT_HUMAN = 'X';
    private final char DOT_AI = 'O';
    private final char DOT_EMPTY = '.';
    private Winner winner;
    private final int DOT_GAP = 5;
    private GameLogik gameLogik;
    private final String infoMessage = "Wrong move";

    private boolean viewInfoMessage;
    private final String BOT_WIN = "The bot won";
    private final String HUMAN_WIN = "The human won";
    private final String DRAW = "DRAW";
    private Game game = Game.NOT_EXIST;


    public Map() {
        setBackground(Color.CYAN);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
    }

    private void update(MouseEvent e) {
        if (gameLogik == null) return;
        int cellY = e.getX()/cellWidth;
        int cellX = e.getY()/cellHeight;
        System.out.printf("cellX: %d; cellY: %d\n", cellX,cellY);
        viewInfoMessage = false;
        if ((game==Game.NOT_EXIST)||(game==Game.END)) return;
        if (gameLogik.makeMove(cellX,cellY)) {
            winner = gameLogik.getWinner();
            game = Game.END;
        }
        if (gameLogik.isFalseHumanTurn()) viewInfoMessage = true;
        if (game == Game.START) game = Game.IN_PROGRESS;
        repaint();
    }

    void startNewGame(int mode, int sizeX, int sizeY, int winLength){
        System.out.printf("Mode: %d;\n sizeX: %d, sizeY; %d;\nwinLength: %d",
                mode,sizeX,sizeY,winLength);
        this.sizeX=sizeX;
        this.sizeY=sizeY;
        viewInfoMessage =false;
        gameLogik = new GameLogik(sizeX,sizeY,winLength);
        System.out.println(Arrays.toString(gameLogik.getField()[0]) + " from Map");
        game = Game.START;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g){
        panelWidth = getWidth();
        panelHeight = getHeight();
        if (game == Game.START) this.repaint(0,0,getWidth(),getHeight());
        if ((sizeY==0)||(sizeX==0)) return;
        cellHeight = panelHeight / sizeY;
        cellWidth = panelWidth / sizeX;
        g.setColor(Color.BLACK);

        for (int h = 0; h < sizeY ; h++) {
            int positionOnY = h* cellHeight;
            g.drawLine(0,positionOnY,panelWidth,positionOnY);
        }
        for (int w = 0; w < sizeX; w++) {
            int positionOnX = w*cellWidth;
            g.drawLine(positionOnX,0,positionOnX,panelHeight);
        }

        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                if (gameLogik.getField()[x][y]==DOT_EMPTY) continue;;
                if (gameLogik.getField()[x][y]==DOT_HUMAN){
                    g.setColor(Color.blue);
                } else if (gameLogik.getField()[x][y]==DOT_AI) {
                    g.setColor(Color.RED);
                    }
                g.fillOval(y * cellHeight + DOT_GAP,
                        x*cellWidth + DOT_GAP,
                        cellWidth - DOT_GAP*2,
                        cellHeight - DOT_GAP * 2);
            }
        }
        if (game == Game.END) showMessageGameOver(g);
        if (viewInfoMessage) showInfoMessage(g);
        repaint();
    }

    private void showInfoMessage(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(0,getHeight()-50,getWidth(),40);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times new roman", Font.BOLD,18));
        g.drawString(infoMessage,2,getHeight()-50/2);
        repaint();
    }

    private void showMessageGameOver(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(0,200,getWidth(),70);
        g.setColor(Color.GREEN);
        g.setFont(new Font("Times new roman", Font.BOLD,48));
        if (winner!=null) {
            switch (winner) {
                case Human -> g.drawString(HUMAN_WIN, 80, getHeight() / 2);
                case Bot -> g.drawString(BOT_WIN, 70, getHeight() / 2);
                case Draw -> g.drawString(DRAW, 70, getHeight() / 2);
            }
        }
    }

    public Game getGame() {
        return game;
    }
}
