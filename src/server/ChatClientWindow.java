package server;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton disconnectingButton;
    private JButton sendMessageButton;
    private JPanel panelServer;
    private JPanel panelSend;
    private ChatServerWindow chatServerWindow;
    private Boolean isConnectingWithServer;
    private StringBuilder messages;
    private String messageInfo;

    public ChatClientWindow(String title, ChatServerWindow chatServerWindow)
            throws HeadlessException{
        super(title);
        this.chatServerWindow = chatServerWindow;
        isConnectingWithServer = false;
        setBackground(Color.blue);
        setBounds(WINDOWS_GAP,WINDOWS_GAP,WINDOWS_WIDTH,WINDOWS_HEIGHT);
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
        areaViewMessage.setEditable(false);
        areaViewMessage.setCaret(new DefaultCaret());
        JScrollPane scrollPane = new JScrollPane(areaViewMessage);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaViewMessage.setCaretPosition(areaViewMessage.getDocument().getLength());
        connectingButton = new JButton("Login");
        disconnectingButton = new JButton("Disconnect");
        sendMessageButton = new JButton("Send");
        panelServer.add(fieldServerIP);
        panelServer.add(fieldServersPort);
        panelServer.add(fieldLogin);
        panelServer.add(fieldPassword);
        panelServer.add(connectingButton);
        panelServer.add(disconnectingButton);
        panelSend.add(fieldMessageToSend,BorderLayout.CENTER);
        panelSend.add(sendMessageButton,BorderLayout.EAST);
        panelSend.setSize(getWidth(),50);

        add(panelServer,BorderLayout.NORTH);
        add(scrollPane);
        add(panelSend,BorderLayout.SOUTH);

        connectingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isConnectingWithServer){
                    isConnectingWithServer = true;
                    getMessagesFromServer();
                }
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
        disconnectingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isConnectingWithServer) {
                    messageInfo = "Disconnect\n";
                    areaViewMessage.setText(messageInfo);
                    areaViewMessage.append(chatServerWindow.getMessages().toString());
                    isConnectingWithServer = false;
                }
            }
        });
        setVisible(true);
    }

    public void getMessagesFromServer() {
        if (isConnectingWithServer) {
            chatServerWindow.getMessagesFromServer();
            if (chatServerWindow.getMessages()!= null)
                areaViewMessage.setText(chatServerWindow.getMessages().toString());
        } else {
            messageInfo = "NEED TO JOIN THE SERVER\n";
            areaViewMessage.setText(messageInfo);
            areaViewMessage.append(chatServerWindow.getMessages().toString());
        }
    }

    public void sendMessage() {
        if (isConnectingWithServer) {
            chatServerWindow.setNewMessage(fieldMessageToSend.getText());
            chatServerWindow.sendMessage();
            getMessagesFromServer();
        } else {
            messageInfo = "NEED TO JOIN THE SERVER\n";
            areaViewMessage.setText(messageInfo);
            areaViewMessage.append(chatServerWindow.getMessages().toString());
        }
    }

    public void setFieldMessageToSend(String text) {
        this.fieldMessageToSend.setText(text);
    }
}
