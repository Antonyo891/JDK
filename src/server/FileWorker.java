package server;

import java.io.*;
import java.util.Arrays;

public class FileWorker {
    private ChatClientWindow chatClientWindow;
    private StringBuilder messagesFromServer;
    private StringBuilder newMessage;
    private final Boolean ADDITIONAL_WRITE_FILE = true;
    private final File serversMemory     = new File(
            "D:\\Программирование\\2023\\JavaCore\\JDK\\src\\server\\saves\\server.txt");
    private final File logFile     = new File(
            "D:\\Программирование\\2023\\JavaCore\\JDK\\src\\server\\saves\\serversLog.txt");

    public FileWorker(ChatClientWindow chatServerWindow) throws IOException {
        this.chatClientWindow = chatServerWindow;
        messagesFromServer = new StringBuilder();
        serversMemory.createNewFile();
        logFile.createNewFile();
    }

    public Boolean writeMessage(){
        try (FileWriter fileWriter = new FileWriter(serversMemory,ADDITIONAL_WRITE_FILE)) {
            fileWriter.write(chatClientWindow.getNewMessage() + "\n");
            fileWriter.flush();
            return true;
        } catch (IOException e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return false;
    }

    public StringBuilder readMessagesFromServer(){
        String str;
        messagesFromServer = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(serversMemory))) {
            while (!(str = bufferedReader.readLine()).isEmpty()){
                messagesFromServer.append(str);
                messagesFromServer.append("\n");
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        } catch (NullPointerException e){
            messagesFromServer.append("No messages");
        }
        return messagesFromServer;
    }

    public void writeLog(StringBuilder logMessage, ChatServerWindow chatServerWindow) {
        try (FileWriter fileWriter = new FileWriter(logFile,ADDITIONAL_WRITE_FILE)){
            fileWriter.write(chatServerWindow.getName() + "\n");
            fileWriter.write(logMessage.toString());
            fileWriter.flush();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
