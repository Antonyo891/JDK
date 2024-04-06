package generelization.person;

import generelization.MyIterator;
import generelization.collection.MyCollections;

public class Club <T extends Person> {
    private MyCollections<T> persons;
    private MyIterator<T> personsIterator;

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
        this.personsIterator = new MyIterator<>(persons);
        while (personsIterator.hasNext()) {
            personsIterator.getNext().haveRest();
        }
    }

    public MyCollections<T> getPersons() {
        return persons;
    }
}
