// Neste exemplo o Iterator percorre e print um Array com 7 pessoas onde se declara apenas seus nomes e respectiva idade.
import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();

        // Preenchendo o ArrayList com nomes e idades
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 40));
        people.add(new Person("David", 22));
        people.add(new Person("Eve", 35));
        people.add(new Person("Frank", 28));
        people.add(new Person("Grace", 50));

        // Criando um Iterator para percorrer a lista
        Iterator<Person> iterator = people.iterator();

        // Usando o Iterator para imprimir nomes e idades
        while (iterator.hasNext()) {
            Person person = iterator.next();
            System.out.println("Nome: " + person.getName() + ", Idade: " + person.getAge());
        }
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}