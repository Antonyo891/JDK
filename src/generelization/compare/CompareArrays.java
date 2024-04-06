package generelization.compare;
/*3. Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true,
 если они одинаковые, и false в противном случае. Массивы могут быть любого типа данных,
 но должны иметь одинаковую длину и содержать элементы одного типа.*/

import generelization.collection.MyCollections;

public class CompareArrays {
    public static <T> Boolean compareArrays(MyCollections<T> firstCollection,
                                            MyCollections<T> secondCollection){
        if ((secondCollection==null)||(firstCollection==null)||secondCollection.getMyCollection()==null||
        firstCollection.getMyCollection() == null) {
            System.out.println("Incorrect collection");
            return false;
        }
        if (firstCollection.getMyCollection().length!=secondCollection.getMyCollection().length)
            return false;
        for (int i = 0; i < firstCollection.getMyCollection().length; i++) {
            if (firstCollection.getMyCollection()[i]==null||secondCollection.getMyCollection()[i]==null){
                System.out.println("Incorrect collection");
                return false;
            }
            if(!firstCollection.getMyCollection()[i].equals(secondCollection.getMyCollection()[i]))
                return false;
        }
        return true;
    }
}
