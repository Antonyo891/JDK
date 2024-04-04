package generelization;

import java.io.*;

public class BoxMAin {
    public static void main(String[] args) {
        Box <String, DataInputStream,Integer> box;
        File file = new File("D:\\Программирование\\2023\\JavaCore\\JDK\\src\\server\\saves\\server.txt");
        try (FileInputStream inputStream = new FileInputStream(file) ){
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            box = new Box<>("Box", dataInputStream, 1);
            box.getClassName();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
