package server;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;

public class MainServer {
    public static void main(String[] args) {
        StringBuilder logMessage = new StringBuilder();
        ChatServerWindow chatServerWindow;
        try {
           chatServerWindow =  new ChatServerWindow("Chat Server");
           while (chatServerWindow.isActive()) {
               if (!logMessage.isEmpty()) {
                   chatServerWindow.writeLog(logMessage);
                   System.out.println(logMessage);
               }
           }
        } catch (Exception e){
            logMessage.append(LocalDateTime.now().withNano(0));
            logMessage.append(e.getMessage());
            logMessage.append("\n");
            logMessage.append(Arrays.toString(e.getStackTrace()));
            System.out.println(logMessage);
        }
    }
}
