package generelization.person;

import generelization.MyIterator;
import generelization.collection.MyCollections;
import generelization.person.Person;

public class Workplace<T extends Person> {
    private MyCollections<T> persons;
    private MyIterator<T> personsIterator;

    public Workplace(MyCollections<T> persons) {
        this.persons = persons;
    }

    public Workplace() {
        this.persons = new MyCollections<>(0);
    }

    public void addPerson(T person){
        persons.add(person);
    }
    public void getWork(){
        personsIterator = new MyIterator<>(persons);
        while (personsIterator.hasNext()){
            personsIterator.getNext().doWork();
        }
    }

    public MyCollections<T> getPersons() {
        return persons;
    }
}
