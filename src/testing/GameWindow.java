package testing;

import testing.logic.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    private static boolean WINDOW_VISIBILITY = true;
    private JButton btnStart = new JButton("New Game");
    private JButton btnExit = new JButton("Exit");
    Map map;
    SettingsWindow settings;

    public GameWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX,WINDOW_POSY);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);

        setTitle("TicTacToe");//name of Window
        setResizable(false);
        map = new Map();
        settings = new SettingsWindow(this);
        JPanel panBottom = new JPanel(new GridLayout(1,2));
        panBottom.add(btnStart);
        panBottom.add(btnExit);
        add(panBottom,BorderLayout.SOUTH);
        add(map);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(WINDOW_VISIBILITY);
            }

        });

        setVisible(WINDOW_VISIBILITY);


    }
    void startNewGame(int mode, int sizeX, int sizeY, int winLength){
        map.startNewGame(mode,sizeX,sizeY,winLength);
    }
}
