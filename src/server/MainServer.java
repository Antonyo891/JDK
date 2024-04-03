package server;


import java.util.Arrays;

public class MainServer {
    public static void main(String[] args) {
        try {
            ChatServerWindow  chatServerWindow =  new ChatServerWindow("Chat Server");
        } catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
