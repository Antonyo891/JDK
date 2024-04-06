package generelization.collection;

import generelization.MyIterator;

import java.util.Arrays;

public class MyCollections <T>  {
    private T[] myCollection;
    private MyIterator<T> iterator;
    Integer size;
    Integer myCollectionSize;

    public MyCollections(T[] myCollection) {
        this.size = myCollection.length;
        myCollectionSize = size + 10;
        this.myCollection = Arrays.copyOf(myCollection,myCollectionSize);
        iterator = new MyIterator<>(this);
    }


    public MyCollections(Integer size) {
        this.size = size;
        myCollectionSize = size + 10;
        this.myCollection = (T[]) new Object[myCollectionSize];
        iterator = new MyIterator<>(this);
    }

    public T[] getMyCollection() {
        return Arrays.copyOfRange(myCollection,0,size);
    }

    public void add(T t,Integer position){
        if (myCollection!=null) {
            T[] endArray = Arrays.copyOfRange(myCollection, position, myCollectionSize);
            T[] beginArray = Arrays.copyOfRange(myCollection, 0, position);
            if (position >= size){
                if (myCollectionSize<=position) this.myCollectionSize +=position + 10;
                size = position + 1;
            } else if(size == myCollectionSize) {
                size++;
                myCollectionSize+=10;
            } else size++;
            this.myCollection = Arrays.copyOf(myCollection,myCollectionSize);
            for (int i = 0; i < size; i++) {
                if (i < position) { myCollection[i] = beginArray[i];}
                else if (i == position) {myCollection[i] = t;}
                else myCollection[i] = endArray[i - position - 1];
            }
            iterator = new MyIterator<>(this);
        }

    }

    public void add(T t){
        add(t,size);
    }

    public T delete(int position){
        if (position>=size) return null;
        size--;
        T[] endArray = Arrays.copyOfRange(myCollection, position+1, myCollectionSize);
        T[] beginArray = Arrays.copyOfRange(myCollection, 0, position);
        T result = myCollection[position];
        myCollection = (T[]) new Object[myCollectionSize];
        for (int i = 0; i <size ; i++) {
            if (i<position) myCollection[i] = beginArray[i];
            else myCollection[i] = endArray[i-position];
        }
        iterator = new MyIterator<>(this);
        return result;
    }
    public boolean hasNext(){
        return iterator.hasNext();
    }
    public  T getNext(){
        return iterator.getNext();
    }
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(myCollection,0, size));
    }



}
