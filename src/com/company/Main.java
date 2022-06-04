package com.company;
import java.io.*;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String mess = in.nextLine();
        while (true) {
            if ("save".equals(mess)) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tomm.txt"))) {
                    Person tom = new Person("Tom", 18);
                    oos.writeObject(tom);
                    oos.writeInt(tom.age);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                System.out.println("OK");
                break;
            }
            if ("upp".equals(mess)) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tomm.txt"))) {
                    Person pp = (Person) ois.readObject();
                    pp.displayInfo();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                System.out.println("OK");
                break;
            }

        }

    }
}

class Person implements Serializable {
    String name;
    int age;
    Person(String name, int age){
        this.name=name;
        this.age=age;
    }
    public void displayInfo(){
        System.out.println("name "+name+" age "+age);
    }
}