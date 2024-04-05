package generelization;

import java.util.Iterator;

public class MyItterator <T> {
    static int position = 0;
    static int size;
    private MyCollections<T> myCollections;

    public MyItterator(MyCollections<T> myCollections) {
        this.myCollections = myCollections;
        size = myCollections.getMyCollection().length;
    }

    public boolean hasNext(){
        return position < size;
    }
    public  T getNext(){
        if (this.hasNext()) {
            position++;
            return myCollections.getMyCollection()[position-1];
        }
        position=0;
        return myCollections.getMyCollection()[size-1];
    }

}
