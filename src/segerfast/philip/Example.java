package segerfast.philip;

public class Example {

    public static void main(String[] args) {

        Human human1 = new Human("Alex", 19);
        Human human2 = new Human("Alice", 16);
        Human human3 = new Human("Kent", 34);
        Human human4 = new Human("Bobby", 54);
        Human human5 = new Human("Micke", 99);
        Human human6 = new Human("Terezza", 45);
        Human human7 = new Human("Leia", 36);

        human1.name = "kkkkkk";

    }
}

class Human {

    String name;
    int age;

    Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name;
    }
}





















