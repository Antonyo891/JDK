package generelization;

import generelization.person.*;

import java.util.Random;

public class SemThreeMain {
    public static void main(String[] args) {
//        Box <String, DataInputStream,Integer> box;
//        File file = new File("D:\\Программирование\\2023\\JavaCore\\JDK\\src\\server\\saves\\server.txt");
//        try (FileInputStream inputStream = new FileInputStream(file) ){
//            DataInputStream dataInputStream = new DataInputStream(inputStream);
//            box = new Box<>("Box", dataInputStream, 1);
//            box.getClassName();
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//        }
//        MyCollections<Integer> myCollections = new MyCollections<>(0);
//        myCollections.add(10);
//        myCollections.add(9);
//        myCollections.add(8);
//        myCollections.add(1111);
//        System.out.println(myCollections);
//        System.out.println(myCollections.delete(2));
//        System.out.println(myCollections.toString());
//        MyIterator<Integer> itterator = new MyIterator<>(myCollections);
//        while (myCollections.hasNext()){
//            System.out.println(myCollections.getNext());
//        }
        Workplace<Person> workplace = new Workplace<>();
        for (int i = 0; i < 8; i++) {
            if (new Random().nextInt(2)==0) workplace.addPerson(new Worker());
            else workplace.addPerson(new Slacker());
        }
        workplace.getWork();
        System.out.println("************************************");
        Club<Person> club = new Club<>(workplace.getPersons());
        club.getRest();
    }
}
