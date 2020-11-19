import java.util.ArrayList;
import java.util.Collections;

public class Person implements Comparable<Person>{
    private String firstName;
    private String lastName;
    private int salary;
    private int id;

    public Person(int id, String name, String lastName, int salary) {
        this.firstName = name;
        this.lastName = lastName;
        this.salary = salary;
        this.id = id;
    }

    public String getFirstName () {
        return this.firstName;
    }

    public int getid() {
        return this.id;
    }
    public String getLastName() {
        return this.lastName;
    }

    public int getSalary() {
        return this.salary;
    }

    public String toString() {
        return "Person: [firstname:" + this.firstName + "; lastname:"+this.lastName + "; salary:" +salary +"\n";
    }

    public static void main(String[] args) {
        ArrayList<Person> personels = new ArrayList<Person>();
        personels.add(new Person(0,"joe", "smith", 120000));
        personels.add(new Person(1,"joe", "smith", 100000));
        personels.add(new Person(2,"joshua", "smith", 30000));
        personels.add(new Person(3,"jamie", "smith", 30000));
        personels.add(new Person(4,"james", "smith", 60000));
        personels.add(new Person(5,"joseph", "smith", 60000));

        Collections.sort(personels, Person::compareTo);
        System.out.println(personels);
       //i want to sort by salary
        //i want to sort by firstname
        //then i want to sort by salary and firstname


    }

    @Override
    public int compareTo(Person theother) {
        return this.id - theother.id;
        //this.id > theother.id , return >0
        //else if <, return some <0
        //else, return 0;
    }

}
