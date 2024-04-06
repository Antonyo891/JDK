package generelization.person;

import generelization.collection.MyCollections;

public class Club <T extends Person> {
    private MyCollections<T> persons;
    private MyCollectionIterator<T> personsIterator;

    private class MyCollectionIterator<T>{
        int position = 0;
        int size;
        private MyCollections<T> myCollections;

        public MyCollectionIterator(MyCollections<T> myCollections) {
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

    public Club(MyCollections<T> persons) {
        this.persons = persons;
    }

    public Club() {

        this.persons = new MyCollections<>(0);
    }

    public void addPerson(T person){
        persons.add(person);
    }
    public void getRest(){
        personsIterator = new MyCollectionIterator<>(persons);
        while (personsIterator.hasNext()) {
            personsIterator.getNext().haveRest();
        }
    }

    public MyCollections<T> getPersons() {
        return persons;
    }
}
