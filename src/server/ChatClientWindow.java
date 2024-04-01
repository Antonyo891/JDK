package server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.server.ServerNotActiveException;

public class ChatClientWindow extends JFrame {
    private final int WINDOWS_WIDTH = 600;
    private final int WINDOWS_HEIGHT = 500;
    private final int WINDOWS_GAP = 100;

    private JTextField fieldLogin;
    private JTextField fieldPassword;
    private JTextField fieldServerIP;
    private JTextField fieldServersPort;
    private JTextField fieldMessageToSend;
    private  JTextArea areaViewMessage;
    private JButton connectingButton;
    private JButton sendMessageButton;
    private JPanel panelServer;
    private JPanel panelSend;
    StringBuilder messagesFromServer;
    StringBuilder newMessage;
    FileWorker fileWorker;

    ChatServerWindow server;

    public ChatClientWindow(String title, ChatServerWindow chatServerWindow)
            throws HeadlessException, IOException {
        super(title);
        this.server = chatServerWindow;
        setBackground(Color.blue);
        setBounds(WINDOWS_GAP,WINDOWS_GAP,WINDOWS_WIDTH,WINDOWS_HEIGHT);
        fileWorker = new FileWorker(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panelServer = new JPanel(new GridLayout(2,3, 2,2));
        panelSend = new JPanel();
        fieldLogin = new JTextField("LOGIN");
        fieldPassword = new JTextField("PASSWORD");
        fieldServerIP = new JTextField("ServerIP");
        fieldServersPort = new JTextField("ServersPort");
        fieldMessageToSend = new JTextField("New message");
        fieldMessageToSend.setColumns(45);

        areaViewMessage = new JTextArea();
        connectingButton = new JButton("Login");
        sendMessageButton = new JButton("Send");
        panelServer.add(fieldServerIP);
        panelServer.add(fieldServersPort);
        panelServer.add(fieldLogin);
        panelServer.add(fieldPassword);
        panelServer.add(connectingButton);
        panelSend.add(fieldMessageToSend,BorderLayout.CENTER);
        panelSend.add(sendMessageButton,BorderLayout.EAST);
        panelSend.setSize(getWidth(),50);

        add(panelServer,BorderLayout.NORTH);
        add(areaViewMessage);
        add(panelSend,BorderLayout.SOUTH);

        connectingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    loadMessage();
            }
        });
        sendMessageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        fieldMessageToSend.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        setVisible(true);


    }

    private void loadMessage() {
        if (server.isServerWorking()) {
            messagesFromServer = server.getMessagesFromServer();
            System.out.println(messagesFromServer);
            if (messagesFromServer != null) areaViewMessage.setText(messagesFromServer.toString());
        }
    }

    private void sendMessage() {
        newMessage = new StringBuilder(fieldMessageToSend.getText());
        System.out.println(fieldMessageToSend.getText());
        if (server.isServerWorking()) {
            if (fileWorker.writeMessage()) {
                System.out.println("message add");
                fieldMessageToSend.setText("");
            }
            else System.out.println("error");
        }
    }

    public StringBuilder getNewMessage() {
        return newMessage;
    }
}
