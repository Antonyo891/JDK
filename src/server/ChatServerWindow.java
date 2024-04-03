package server;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ChatServerWindow extends JFrame{
    private final int WINDOWS_WIDTH = 500;
    private final int WINDOWS_HEIGHT = 550;
    private final int WINDOWS_GAP = 50;

    private Boolean isServerWorking = false;
    private JButton buttonStart;
    private JButton buttonStop;
    private JPanel panel;
    private JTextArea textArea;
    private ServersListener server;
    ChatClientWindow chatClientWindow;
    private StringBuilder messages;
    private String newMessage;

    public ChatServerWindow(String title)
            throws HeadlessException, IOException {
        super(title);
        server = new ChatServer(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(WINDOWS_GAP,WINDOWS_GAP,WINDOWS_WIDTH,WINDOWS_HEIGHT);
        chatClientWindow = new ChatClientWindow("Chat Client", this);
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
                    textArea.setText("Server already working");
                }
                else {
                    isServerWorking = true;
                    getMessagesFromServer();
                    textArea.setText("Server started");
                }
            }
        });
        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isServerWorking) {
                    isServerWorking = false;
                    textArea.setText("Server stopped");
                }
                else {
                    textArea.setText("Server already stopped");
                }
            }
        });
        add(panel);
        add(textArea,BorderLayout.SOUTH);
        setVisible(true);

    }

    public void getMessagesFromServer() {
        if (isServerWorking)
            server.getMessagesFromServer();
    }

    public StringBuilder getMessages() {
        return messages;
    }

    public void setMessages(StringBuilder messages) {
        this.messages = messages;
    }

    public void setNewMessage(String newMessage) {
        this.newMessage = newMessage;
    }

    public void sendMessage() {
        if (isServerWorking) {
            server.sendMessage(newMessage);
            chatClientWindow.setFieldMessageToSend("");
        }
    }
}
