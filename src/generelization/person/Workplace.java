package generelization.person;

import generelization.collection.MyCollections;


public class Workplace<T extends Person> {
    private MyCollections<T> persons;
    public Workplace(MyCollections<T> persons) {
        this.persons = persons;
    }

    public Workplace() {
        this.persons = new MyCollections<>(0);
    }
    private class MyCollectionIterator<T>{
        int position = 0;
        MyCollections<T> collectionsForIterator;
        int size;
        public MyCollectionIterator(MyCollections<T> myCollections) {
            this.size = myCollections.getMyCollection().length;
            collectionsForIterator = myCollections;
        }

        public boolean hasNext(){
            return position < size;
        }
        public  T getNext(){
            if (this.hasNext()) {
                position++;
                return (T) collectionsForIterator.getMyCollection()[position-1];
            }
            position=0;
            return (T) collectionsForIterator.getMyCollection()[size-1];
        }
    }
    private MyCollectionIterator<T> personsIterator;

    public void addPerson(T person){
        persons.add(person);
    }
    public void getWork(){
        personsIterator = new MyCollectionIterator<T>(persons);
        while (this.personsIterator.hasNext()){
            this.personsIterator.getNext().doWork();
        }
    }

    public MyCollections<T> getPersons() {
        return persons;
    }
}
