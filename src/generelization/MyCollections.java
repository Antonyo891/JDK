package generelization;

import java.sql.Array;

public class MyCollections <T> {
    private T[] myCollection;
    Integer size;

    public MyCollections(T[] myCollection, Integer size) {
        this.myCollection = myCollection;
        this.size = size;
    }

    public MyCollections(Integer size ) {
        this((T[]) new Array [size],size);
    }

    public T[] getMyCollection() {
        return myCollection;
    }

    public void add(T t){
        T [] newArray = (T[]) new Array [size++];
        for (int i = 0; i < myCollection.length; i++) {
            newArray[i] = myCollection[i];
        }
        newArray[size-1] = t;
        myCollection = newArray;
    }
}
