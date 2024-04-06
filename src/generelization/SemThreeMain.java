package generelization;

import generelization.collection.MyCollections;
import generelization.compare.CompareArrays;

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

//        Workplace<Person> workplace = new Workplace<>();
//        for (int i = 0; i < 5; i++) {
//            if (new Random().nextInt(2)==0) workplace.addPerson(new Worker());
//            else workplace.addPerson(new Slacker());
//        }
//        workplace.getWork();
//        System.out.println("************************************");
//        Club<Person> club = new Club<>(workplace.getPersons());
//        club.getRest();

//        Calculator.sum(1,2.0);
//        Calculator.divide(1,2L);
//        Calculator.multiply(1,4.0);
//        Calculator.subtract(213,357);
//        Calculator.sum(1,-2.0);
//        Calculator.divide(1,-2L);
//        Calculator.multiply(-1L,4.0);
//        Calculator.subtract(213543554353543L,357);
        MyCollections<Integer> integerMyCollections = new MyCollections<>(10);
        MyCollections<Integer> integerMyCollections1 = new MyCollections<>(10);
        MyCollections<Integer> integerMyCollections2 = new MyCollections<>(10);
        MyCollections<Character> characterMyCollections = new MyCollections<>(10);
        MyCollections<Character> characterMyCollections1 = new MyCollections<>(10);
        for (int i = 0; i < 10; i++) {
            integerMyCollections1.setElement(i,i);
            integerMyCollections.setElement(i,i);
            integerMyCollections2.setElement(i+1,i);
            characterMyCollections.setElement((char) (i),i);
            characterMyCollections1.setElement((char) (i),i);
        }
        System.out.println(CompareArrays.compareArrays(integerMyCollections,integerMyCollections1));
        System.out.println(CompareArrays.compareArrays(integerMyCollections2,integerMyCollections1));
        System.out.println(CompareArrays.compareArrays(characterMyCollections,characterMyCollections1));




    }
}
