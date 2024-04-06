package generelization;

import generelization.collection.MyCollections;

public class MyIterator<T> {
    int position = 0;
    int size;
    private MyCollections<T> myCollections;

    public MyIterator(MyCollections<T> myCollections) {
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
