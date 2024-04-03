package server;

import java.io.*;
import java.util.Arrays;

public class ChatServer implements ServersListener{
    private final ChatServerWindow chatServerWindow;
    private StringBuilder messages;
    private final Boolean ADDITIONAL_WRITE_FILE = true;
    private final File serversMemory     = new File(
            "D:\\Программирование\\2023\\JavaCore\\JDK\\src\\server\\saves\\server.txt");

    public ChatServer(ChatServerWindow chatServerWindow) throws IOException {
        this.chatServerWindow = chatServerWindow;
        serversMemory.createNewFile();
    }

    @Override
    public void getMessagesFromServer() {
        String str;
        messages = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(serversMemory))) {
            while ((str = bufferedReader.readLine())!=null){
                messages.append(str);
                messages.append("\n");
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        } catch (NullPointerException e){
            messages.append("No messages");
        }
        chatServerWindow.setMessages(messages);
    }

    @Override
    public void sendMessage(String newMessage) {
        try (FileWriter fileWriter = new FileWriter(serversMemory,ADDITIONAL_WRITE_FILE)) {
            fileWriter.write(newMessage + "\n");
            fileWriter.flush();
        } catch (IOException e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
