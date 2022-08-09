package ss_7_Abstract_Class_Interface.ss_1_practice_java.Post1.Model;

import ss_7_Abstract_Class_Interface.ss_1_practice_java.Post1.Controller.Animal;
import ss_7_Abstract_Class_Interface.ss_1_practice_java.Post1.Controller.Edible;
import ss_7_Abstract_Class_Interface.ss_1_practice_java.Post1.Controller.Tiger;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            animal.makeSound();
        }
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            }
        }
    }
}
