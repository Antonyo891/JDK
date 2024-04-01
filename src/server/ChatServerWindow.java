package server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.server.ServerNotActiveException;

public class ChatServerWindow extends JFrame {
    private final int WINDOWS_WIDTH = 500;
    private final int WINDOWS_HEIGHT = 550;
    private final int WINDOWS_GAP = 50;

    private boolean isServerWorking = false;
    private JButton buttonStart;
    private JButton buttonStop;
    private JPanel panel;
    private JTextArea textArea;
    private FileWorker server;
    private StringBuilder messagesFromServer;
    private ChatClientWindow chatClientWindow;

    public ChatServerWindow(String title)
            throws HeadlessException, IOException {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(WINDOWS_GAP,WINDOWS_GAP,WINDOWS_WIDTH,WINDOWS_HEIGHT);
        chatClientWindow = new ChatClientWindow("Chat Client", this);
        server = new FileWorker(chatClientWindow);
        buttonStart = new JButton("START");
        buttonStop = new JButton("STOP");
        panel = new JPanel(new GridLayout(1,2));
        panel.add(buttonStart);
        panel.add(buttonStop);
        textArea = new JTextArea();
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    System.out.println("Server already working");
                    textArea.setText("Server already working");
                }
                else {
                    isServerWorking = true;
                    messagesFromServer = server.readMessagesFromServer();
                    System.out.println(messagesFromServer);
                    System.out.println("Server started");
                    textArea.setText("Server started");
                }
            }
        });
        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isServerWorking) {
                    System.out.println("Server stopped");
                    isServerWorking = false;
                    textArea.setText("Server stopped");
                }
                else {
                    System.out.println("Server already stopped");
                    textArea.setText("Server already stopped");
                }
            }
        });
        add(panel);
        add(textArea,BorderLayout.SOUTH);
        setVisible(true);

    }

    public void writeLog(StringBuilder logMessage) {
        server.writeLog(logMessage,this);
    }

    public StringBuilder getMessagesFromServer() {
        return messagesFromServer;
    }


    public boolean isServerWorking() {
        return isServerWorking;
    }
}
