package testing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private final int WINDOW_HEIGHT = 230;
    private final int WINDOW_WIDTH = 400;
    private int mode = 0;
    private int fieldSizeOnX = 5;
    private int fieldSizeOnY = 5;
    private int winLengthLine = 4;
    private int winLengthLineMax = 4;
    JButton startNewGameButton;
    JPanel settings;
    JPanel buttonGroupPanel;
    JLabel label;
    JLabel fieldSizeLabel;
    JLabel winLengthLabel;
    ButtonGroup buttonGroup;
    JRadioButton onePlayer;
    JRadioButton twoPlayer;
    JSlider jSliderFieldSize;
    JSlider jSliderWinLength;

    public SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        buttonGroup = new ButtonGroup();
        onePlayer = new JRadioButton("Single player game mode");
        twoPlayer = new JRadioButton("Two player game mode");
        buttonGroup.add(onePlayer);
        buttonGroup.add(twoPlayer);
        buttonGroupPanel = new JPanel(new GridLayout(1,2));
        buttonGroupPanel.add(onePlayer);
        buttonGroupPanel.add(twoPlayer);
        startNewGameButton = new JButton("START NEW GAME");
        winLengthLabel = new JLabel("Win line length");
        label = new JLabel("Select the game mode");
        jSliderFieldSize = new JSlider(0,3,10,3);
        jSliderWinLength = new JSlider(0,3,10,3);
        fieldSizeLabel = new JLabel("Choice size of the field " + jSliderFieldSize.getValue());
        winLengthLabel = new JLabel("Win line length " + jSliderWinLength.getValue());
        jSliderFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                fieldSizeLabel.setText("Choice size of the field [" + jSliderFieldSize.getValue() + " x "
                        + jSliderFieldSize.getValue() + "]");
                winLengthLineMax = jSliderFieldSize.getValue();
                jSliderWinLength.setMaximum(winLengthLineMax);
                fieldSizeOnX = jSliderFieldSize.getValue();
                fieldSizeOnY = fieldSizeOnX;
            }
        });
        jSliderWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                winLengthLabel.setText("Win line length " + jSliderWinLength.getValue());
                winLengthLine = jSliderWinLength.getValue();
            }
        });
        settings = new JPanel(new GridLayout(7,1));
        settings.add(label);
        settings.add(buttonGroupPanel);
        settings.add(jSliderFieldSize);
        settings.add(fieldSizeLabel);
        settings.add(jSliderWinLength);
        settings.add(winLengthLabel);
        startNewGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                if (onePlayer.isSelected()) mode = 1;
                gameWindow.startNewGame(mode,fieldSizeOnX,
                        fieldSizeOnY, winLengthLine);
            }
        });
        add(startNewGameButton, BorderLayout.SOUTH);
        add(settings);
    }
}
