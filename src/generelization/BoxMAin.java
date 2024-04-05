package generelization;

public class BoxMAin {
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
        MyCollections<Integer> myCollections = new MyCollections<>(0);
        myCollections.add(10);
        myCollections.add(9);
        myCollections.add(8);
        myCollections.add(1111);
        System.out.println(myCollections);
        System.out.println(myCollections.delete(2));
        System.out.println(myCollections.toString());
        MyItterator<Integer> itterator = new MyItterator<>(myCollections);
        while (itterator.hasNext()){
            System.out.println(itterator.getNext());
        }
    }
}
